package game;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable
{

	private static final int NO_DELAYS_PER_YIELD = 16;
	private static int MAX_FRAME_SKIPS = 5;
	private int pWidth, pHeight;

	private long gameStartTime;

	private Thread animator;
	private volatile boolean running = false;
	private volatile boolean isPaused = false;
	private volatile boolean ready = false;

	private long period;

	private Player playa;
	private Monster monsta;

	private volatile boolean gameOver = false;
	private Font font;
	private FontMetrics metrics;

	private Graphics dbg;
	private Image dbImage = null;
	private Image background;
	
	private Monster monstaX;
	private Monster monstaY;
	
	private BGObject[] bgobjects;
	
	public GamePanel(long period, int w, int h)
	{
		start(period,w,h);
	}
	
	private void start(long period, int w, int h)
	{
		this.period = period;
		pWidth = w;
		pHeight = h;
		setBackground(Color.white);
		setPreferredSize(new Dimension(pWidth, pHeight));
		setFocusable(true);
		requestFocus();
		readyForTermination();

		playa = new Player(pWidth, pHeight);
		monsta = new Monster5(pWidth, pHeight);
		monsta.setPlayer(playa);
		playa.setMonster(monsta);
		gameOver = false;

		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				playa.press(e);
			}

			public void keyReleased(KeyEvent e)
			{
				playa.release(e);
			}
		});

		font = new Font("SansSerif", Font.BOLD, 120);
		metrics = this.getFontMetrics(font);
		
		try 
	    {                
	    	background = ImageIO.read(new File("Background.jpg"));
	    } catch (IOException ex) {}
	    
	    monstaX = null;
	    monstaY = null;
	    
	    bgobjects = new BGObject[15];	
	    for (int i = 0; i < 5; i++)
	    {
	    	bgobjects[i] = new BGLine(w, h, w*i/4+Math.random()*200-100, h/2, -1, 1, Color.GREEN);
	    	bgobjects[i+5] = new BGLine(w, h, w*i/4+Math.random()*200-100, h/2, -1, -1, Color.GREEN);
	    }
	    for (int i = 10; i < 15; i++)
	    {
	    	bgobjects[i] = new BGPolygon(w, h, 3+(int)(3*Math.random()), 50+(int)(100*Math.random()), 0.25+0.75*Math.random(), 0.01+(0.03*Math.random()), Color.GREEN);
	    }
	}

	private void readyForTermination()
	{
		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				int keyCode = e.getKeyCode();
				if ((keyCode == KeyEvent.VK_ESCAPE))
				{
					running = false;
				}
			}
		});
	}

	public void addNotify()
	{
		super.addNotify();
		startGame();
	}

	private void startGame()
	{
		if (animator == null || !running)
		{
			animator = new Thread(this);
			animator.start();
		}
	}

	public void resumeGame()
	{
		isPaused = false;
	}

	public void pauseGame()
	{
		isPaused = true;
	}

	public void stopGame()
	{
		running = false;
		System.exit(0);
	}

	public void run()
	{
		while (true)
		{
			getClass();
			start(period, pWidth, pHeight);
			ready = true;
			addKeyListener(new KeyAdapter()
			{
				public void keyPressed(KeyEvent e)
				{
					int keyCode = e.getKeyCode();
					if ((keyCode == KeyEvent.VK_ENTER))
					{
						ready = true;
					}
				}
			});
	
			long beforeTime, afterTime, timeDiff, sleepTime;
			long overSleepTime = 0L;
			int noDelays = 0;
			long excess = 0L;
			running = true;
	
			while (!ready)
			{
				startScreen();
			}
	
			gameStartTime = System.nanoTime();
			beforeTime = gameStartTime;
	
			while (running)
			{
				gameUpdate();
				gameRender();
				paintScreen();
	
				afterTime = System.nanoTime();
				timeDiff = afterTime - beforeTime;
				sleepTime = (period - timeDiff) - overSleepTime;
	
				if (sleepTime > 0)
				{
					try
					{
						Thread.sleep(sleepTime / 1000000L);
					}
					catch (InterruptedException ex)
					{
					}
					overSleepTime = (System.nanoTime() - afterTime) - sleepTime;
				}
				else
				{
					excess -= sleepTime;
					overSleepTime = 0L;
					if (++noDelays >= NO_DELAYS_PER_YIELD)
					{
						Thread.yield();
						noDelays = 0;
					}
				}
	
				beforeTime = System.nanoTime();
	
				int skips = 0;
				while ((excess > period) && (skips < MAX_FRAME_SKIPS))
				{
					excess -= period;
					gameUpdate();
					skips++;
				}
			}
		}
	}

	private void startScreen()
	{
		dbImage = createImage(pWidth, pHeight);
		dbg = dbImage.getGraphics();
		drawBackground(dbg);
		String msg = "PROJECT TOUHOU";
		int x = (pWidth - metrics.stringWidth(msg)) / 2;
		int y = (pHeight - metrics.getHeight()) / 2;
		dbg.setColor(Color.red);
		dbg.setFont(font);
		dbg.drawString(msg, x, y);
		paintScreen();
	}

	private void drawBackground(Graphics g)
	{
		//g.drawImage(background, 0, 0, pWidth, pHeight, null);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, pWidth, pHeight);
		for (int i = 0; i < bgobjects.length; i++)
		{
			bgobjects[i].move();
			bgobjects[i].draw(g);
		}
		
	}
	
	private void gameOverMessage(Graphics g)
	{
		drawBackground(g);

		if (playa.isAlive())
		{
			if (monstaX == null)
			{
				monstaX = new MonsterX(pWidth, pHeight);
				monstaX.makeBPs();
			}
			monstaX.move();
			monstaX.draw(g);
			
			String msg = "YOU WIN";
			g.setColor(Color.GREEN);
			int x = (pWidth - metrics.stringWidth(msg)) / 2;
			int y = (pHeight - metrics.getHeight()) / 2;
			g.setColor(new Color((int)(255*Math.random()),(int)(255*Math.random()),(int)(255*Math.random())));
			g.setFont(font);
			g.drawString(msg, x, y);
		}
		else
		{
			if (monstaY == null)
			{
				monstaY = new MonsterY(pWidth, pHeight);
				monstaY.makeBPs();
			}
			monstaY.move();
			monstaY.draw(g);
			
			String msg = "YOU LOSE";
			g.setColor(Color.GREEN);
			int x = (pWidth - metrics.stringWidth(msg)) / 2;
			int y = (pHeight - metrics.getHeight()) / 2;
			g.setColor(Color.red);
			g.setFont(font);
			g.drawString(msg, x, y);

		}
	}

	private void gameUpdate()
	{
		if (!isPaused && !gameOver)
		{
			playa.move();
			monsta.move();
			if (!monsta.isAlive() || !playa.isAlive())
				gameOver = true;
		}
	}

	private void gameRender()
	{
		if (dbImage == null)
		{
			dbImage = createImage(pWidth, pHeight);
			dbg = dbImage.getGraphics();
		}

		drawBackground(dbg);
		dbg.setFont(font);

		playa.draw(dbg);
		monsta.draw(dbg);

		if (gameOver)
			gameOverMessage(dbg);
	}

	private void paintScreen()
	{
		try
		{
			Graphics g = getGraphics();
			if ((g != null) && (dbImage != null))
				g.drawImage(dbImage, 0, 0, null);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}
		catch (Exception e)
		{
			System.out.println("Graphics error: " + e);
		}
	}

}
