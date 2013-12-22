package game;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.*;
import javax.imageio.ImageIO;

public class BulletPlayer extends BulletLinear
{
	private Image[] images;
	private int state;
	private int imgWidth;
	private int imgHeight;
	private static int imgDelay = 1;

	public BulletPlayer(int width, int height, double x, double y, double r, int power, Color color, double dx, double dy)
	{
		super(width, height, x, y, r, power, color, dx, dy);
		images = new Image[4];
		state = 0;

		for (int i = 0; i < images.length; i++)
		{
			images[i] = null;
			try
			{
				images[i] = ImageIO.read(new File("bullet.png"));
			}
			catch (IOException ex)
			{
			}
		}
		imgHeight = images[0].getHeight(null);
		imgWidth = images[0].getWidth(null);
	}

	public void move()
	{
		state++;
		if (state >= 4 * imgDelay)
			state = 0;
		super.move();
	}

	public void draw(Graphics g)
	{
		Image image = images[state/imgDelay];
		
		double angle = Math.PI - Math.atan2(dx, dy);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform trans = new AffineTransform();
		trans.setToIdentity();
		trans.translate(x, y);
		trans.rotate( angle );
		trans.scale(1,1);
		trans.translate(-imgWidth/2, -imgHeight/2);
		g2d.drawImage(image, trans, null);
		
//		g.drawImage(images[state / imgDelay], (int) (x - imgWidth/2), (int) (y - imgHeight/2), imgWidth, imgHeight, null);
		//super.draw(g);
	}
}
