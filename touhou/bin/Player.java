package game;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class Player
{

	private int width;
	private int height;
	private double x;
	private double y;
	private static int dx;
	private static int dy;
	private boolean[] keysDown;
	private TreeMap<Integer, Integer> arrowKeys;
	private boolean isFiring;
	private ArrayList<Bullet> bullets;
	private int count;
	private Monster monsta;
	private boolean isAlive;
	private int firePower;
	private int state;
	private Image[] images;
	private int imgHeight;
    private int imgWidth;
    private boolean shiftDown;
    private int numBombs;
	private int bombCount;
	private ArrayList<Bomb> bombs;	
    
	private static double r = 5;
	private static int speed = 6;
	private static int bulletspeed = 30;
	private static int bulletpower = 1;
	private static Color bulletcolor = Color.BLUE;
	private static int upKey = 38;
	private static int rightKey = 39;
	private static int downKey = 40;
	private static int leftKey = 37;
	private static int firingKey = 90;
	private static int bulletDelay = 3;
	private static int imgDelay = 10;

	public Player(int pWidth, int pHeight)
	{
		width = pWidth;
		height = pHeight;
		x = width / 2;
		y = height *9/10;
		dx = 0;
		dy = 0;
		firePower = 0;
		state = 0;
		isFiring = false;
		count = 0;
		isAlive = true;
		bullets = new ArrayList<Bullet>();
		keysDown = new boolean[4];
		Arrays.fill(keysDown, false);
		setKeys();
		images = new Image[9];
		for (int i = 0; i < images.length; i++)
		{
			images[i] = null;
			try 
		    {                
		    	images[i] = ImageIO.read(new File("ship"+i+".gif"));
		    } catch (IOException ex) {}
		}
		imgHeight = images[0].getHeight(null);
		imgWidth = images[0].getWidth(null);
		shiftDown = false;
		numBombs = 3;
		bombCount = 0;
		bombs = new ArrayList<Bomb>();
	}

	public void setKeys()
	{
		arrowKeys = new TreeMap<Integer, Integer>();
		arrowKeys.put(upKey, 0);
		arrowKeys.put(rightKey, 1);
		arrowKeys.put(downKey, 2);
		arrowKeys.put(leftKey, 3);
	}

	public void setMonster(Monster monsta)
	{
		this.monsta = monsta;
	}

	public void press(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if (keyCode == 16)
			shiftDown = true;
		if (keyCode == 88 && numBombs > 0 && bombCount == 0)
		{
			bombCount = 1;
			numBombs--;
		}
		if (keyCode == firingKey)
		{
			isFiring = true;
			return;
		}
		if (!arrowKeys.containsKey((Integer) keyCode))
			return;
		int index = arrowKeys.get((Integer) keyCode);
		if (keysDown[index] == false)
		{
			keysDown[index] = true;
			dy = index == 0 ? -speed : dy; // up
			dy = index == 2 ? speed : dy; // down
			dx = index == 1 ? speed : dx; // right
			dx = index == 3 ? -speed : dx; // left
			if (index == 0)
				state = imgDelay;
			if (index == 2)
				state = 0;
			if (index == 1)
				state = imgDelay*7;
			if (index == 3)
				state = imgDelay*5;
		}
	}

	public void release(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if (keyCode == 16)
			shiftDown = false;
		if (keyCode == firingKey)
		{
			isFiring = false;
			return;
		}
		if (!arrowKeys.containsKey((Integer) keyCode))
			return;
		int index = arrowKeys.get((Integer) keyCode);
		if (keysDown[index])
		{
			keysDown[index] = false;
			if (index == 0)
				dy = keysDown[2]? speed : 0;
			if (index == 2)
				dy = keysDown[0]? -speed : 0;
			if (index == 1)
				dx = keysDown[3]? -speed : 0;
			if (index == 3)
				dx = keysDown[1]? speed : 0;
			
			state = 0;
			if (keysDown[1])
				state = imgDelay*7;
			if (keysDown[3])
				state = imgDelay*5;
			if (keysDown[0])
				state = imgDelay;
		}

	}

	public void draw(Graphics dbg)
	{
		Image img = images[state/imgDelay];
	
//		dbg.drawImage(img, (int)(x-imgWidth/2), (int)(y-imgHeight/2), imgWidth, imgHeight, null);
		
		Graphics2D g2d = (Graphics2D)dbg;
		AffineTransform trans = new AffineTransform();
		trans.setToIdentity();
		trans.translate(x, y);
		trans.rotate( Math.toRadians(0) );
		trans.scale(1,1);
		trans.translate(-imgWidth/2, -imgHeight/2);
		g2d.drawImage(img, trans, null);
		
		dbg.setColor(Color.GREEN);
		dbg.fillOval((int) (x - r), (int) (y - r), (int) (r * 2), (int) (r * 2));
		
		for (Bullet b : bombs)
			b.draw(dbg);
		for (Bullet b : bullets)
			b.draw(dbg);
		
		int r1 = 30;
		for (int i = 0; i < numBombs; i++)
		{
			int x1 = width - 3 * i * r1 - r1 - 10;
			int y1 = height - r1 - 10;
			dbg.setColor(Color.WHITE);
			dbg.fillOval(x1 - r1, y1 - r1, 2*r1, 2*r1);
			double c = .75;
			dbg.setColor(Color.BLACK);
			dbg.fillOval((int) (x1 - r1 * c), (int) (y1 - r1 * c), (int) (r1 * 2 * c), (int) (r1 * 2 * c));
		}
	}

	public void move()
	{
		x += shiftDown?dx/3:dx;
		y += shiftDown?dy/3:dy;
		x = (x - r < 0) ? r : x;
		x = (x + r > width) ? width - r : x;
		y = (y - r < 0) ? r : y;
		y = (y + r > height) ? height - r : y;

		if (bombCount > 0)
		{
			if (bombCount++ == 1)
			{
				int num = 17;
				if (shiftDown)
				{
					for (int i = 0; i < num*7; i++)
					{
						double angle = 2*Math.PI*Math.random();
						int randomX = (int) (width*Math.random());
						int randomY = (int) (height*Math.random());
						bombs.add(new Bomb(width, height, randomX, randomY, 40, 2, Color.BLACK, 10 * Math.cos(angle), 10 * Math.sin(angle), monsta));
					}
				}
				else
				{
					for (int i = 0; i < num; i++)
					{
						double angle = 2 * Math.PI * i / num + 3*Math.PI/2;
						bombs.add(new Bomb(width, height, x, y, 70, 10, Color.BLACK, 4 * Math.cos(angle), 4 * Math.sin(angle), monsta));
					}
				}
			}
			if (bombCount >= 2)
				bombCount = 0;
		}
		
		if (count >= bulletDelay && isFiring)
		{
			fire();
			count = 0;
		}
		else
			count++;

		for (int i = 0; i < bombs.size(); i++)
		{
			Bullet b = bombs.get(i);
			b.move();
			if (b.collide(monsta.getX(), monsta.getY(), monsta.getR()))
			{
				bombs.remove(i--);
				monsta.hit(b.getPower());
			}
			if (b.offScreen())
				bombs.remove(i--);
		}
		
		for (int i = 0; i < bullets.size(); i++)
		{
			Bullet b = bullets.get(i);
			b.move();
			if (b.collide(monsta.getX(), monsta.getY(), monsta.getR()))
			{
				bullets.remove(i--);
				monsta.hit(b.getPower());
			}
			else if (b.offScreen())
				bullets.remove(i--);
		}
		
		state++;
		state = (state==(imgDelay-1))?1:state;
		state = (state==(imgDelay*5-1))?imgDelay:state;
		state = (state==(imgDelay*7-1))?imgDelay*7-2:state;
		state = (state==(imgDelay*9-1))?imgDelay*9-2:state;
	}

	public void fire()
	{
		bullets.add(new BulletPlayer(width, height, x + 15, y, 10, bulletpower, bulletcolor, 0, -bulletspeed));
		bullets.add(new BulletPlayer(width, height, x - 15, y, 10, bulletpower, bulletcolor, 0, -bulletspeed));
		if (shiftDown)
		{
			bullets.add(new BulletPlayer(width, height, x + 30, y, 10, bulletpower, bulletcolor, 0, -bulletspeed));
			bullets.add(new BulletPlayer(width, height, x - 30, y, 10, bulletpower, bulletcolor, 0, -bulletspeed));
		}
		else
		{
			bullets.add(new BulletPlayer(width, height, x + 30, y, 10, bulletpower, bulletcolor, 6, -bulletspeed+3));
			bullets.add(new BulletPlayer(width, height, x - 30, y, 10, bulletpower, bulletcolor, -6, -bulletspeed+3));
		}
	}

	public void hit()
	{
		isAlive = false;
	}
	
	public int getHeight(){return height;}
	public int getWidth(){return width;}
	public double getX(){return x;}
	public double getY(){return y;}
	public double getR(){return r;}
	public boolean isAlive(){return isAlive;}

	public ArrayList<Bomb> getBombs()
	{
		return bombs;
	}
}
