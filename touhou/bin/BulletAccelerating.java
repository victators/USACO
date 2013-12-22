package game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class BulletAccelerating extends Bullet
{
	private double dx;
	private double dy;
	private double factor;
	private int imgWidth;
	private int imgHeight;
	private Image image;
	
	public BulletAccelerating(int width, int height, double x, double y, double r, int power, Color color, double dx, double dy, double factor)
	{
		super(width, height, x, y, r, power, color);
		this.dx = dx;
		this.dy = dy;
		this.factor = factor;
		try
		{
			image = ImageIO.read(new File("yelloworb.png"));
		}
		catch (IOException ex)
		{
		}
		imgWidth = image.getWidth(null);
		imgHeight = image.getHeight(null);
	}
	
	public BulletAccelerating(int width, int height, double x, double y, double r, double speed, int power, Color color, double targetx, double targety, double factor)
	{
		super(width, height, x, y, r, power, color);
		this.factor = factor;
		double angle = -Math.atan2(targetx-x, targety-y)+Math.PI/2;
		this.dx = speed*Math.cos(angle);
		this.dy = speed*Math.sin(angle);
		try
		{
			image = ImageIO.read(new File("yelloworb.png"));
		}
		catch (IOException ex)
		{
		}
		imgWidth = image.getWidth(null);
		imgHeight = image.getHeight(null);
	}

	public void move()
	{
		x += dx;
		y += dy;
		dx *= factor;
		dy *= factor;
	}
	
	public void draw(Graphics g)
	{		

		double angle = Math.PI - Math.atan2(dx, dy);
		Graphics2D g2d = (Graphics2D)g;
		AffineTransform trans = new AffineTransform();
		trans.setToIdentity();
		trans.translate(x, y);
		trans.rotate( angle );
		trans.scale(2*r/imgWidth,2*r/imgHeight);
		trans.translate(-imgWidth/2, -imgHeight/2);
		g2d.drawImage(image, trans, null);
		
		//g.drawImage(image, (int) (x - imgWidth/2), (int) (y - imgHeight/2), imgWidth, imgHeight, null);

	}
}
