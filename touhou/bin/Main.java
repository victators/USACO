package game;
import java.awt.*;		
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.*;
import sun.audio.*;

public class Main extends JFrame implements WindowListener
{
	private static int DEFAULT_FPS = 80;
	private GamePanel gp;
	private int pWidth, pHeight;

	public Main(long period)
	{
		super("Game");
		pack();
		setResizable(false);
		calcSizes();
		setResizable(true);

		Container c = getContentPane();
		gp = new GamePanel(period, pWidth, pHeight);
		c.add(gp, "Center");
		pack();

		addWindowListener(this);

		addComponentListener(new ComponentAdapter()
		{
			public void componentMoved(ComponentEvent e)
			{
				setLocation(0, 0);
			}
		});

		setResizable(false);
		setVisible(true);
	}

	private void calcSizes()
	{
		GraphicsConfiguration gc = getGraphicsConfiguration();
		Rectangle screenRect = gc.getBounds();

		Toolkit tk = Toolkit.getDefaultToolkit();
		Insets desktopInsets = tk.getScreenInsets(gc);

		Insets frameInsets = getInsets(); 

		pWidth = screenRect.width - (desktopInsets.left + desktopInsets.right) - (frameInsets.left + frameInsets.right)+12;
		pHeight = screenRect.height - (desktopInsets.top + desktopInsets.bottom) - (frameInsets.top + frameInsets.bottom)+12;

	}

	@SuppressWarnings("restriction")
	public static void music()
	{
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;

        ContinuousAudioDataStream loop = null;

        try
        {
            InputStream test = new FileInputStream("music.wav");
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
            //MD = BGM.getData();
            //loop = new ContinuousAudioDataStream(MD);

        }
        catch(Exception e){
            System.out.print(e);
        }
        MGP.start(loop);

	}
	
	// ----------------------------------------- main ----------------------------------------- //
	public static void main(String args[])
	{
		music();
		int fps = DEFAULT_FPS;
		long period = (long) 1000.0 / fps;
		new Main(period * 1000000L); // convert ms to nanosecs
	}

	// -------------------------------- WindowListener methods -------------------------------- //
	public void windowActivated(WindowEvent arg0) { gp.resumeGame(); }
	public void windowDeiconified(WindowEvent arg0) { gp.resumeGame(); }
	public void windowDeactivated(WindowEvent arg0) { gp.pauseGame(); }
	public void windowIconified(WindowEvent arg0) { gp.pauseGame(); }
	public void windowClosing(WindowEvent arg0) { gp.stopGame(); }
	public void windowOpened(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}
}

