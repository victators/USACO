
import java.awt.Color;
import java.util.ArrayList;


public class BPMissile extends BulletPattern
{
	protected int numCircle;
	protected double offset;
	protected double bulletSpeed;
	protected double bulletAcceleration;
	protected double bulletRadius;
	protected Color color;

	public BPMissile(Player playa, Monster monsta, int numBullets, double bulletSpeed, double bulletRadius, double bulletAcceleration, Color color, int betweenDelay, int finalDelay) 
	{
		super(playa, monsta, betweenDelay, finalDelay, numBullets);
		
		this.numBullets = numBullets;
		this.bulletSpeed = bulletSpeed;
		this.bulletAcceleration = bulletAcceleration;
		this.bulletRadius = bulletRadius;
		this.color = color;
	}

	public ArrayList<Bullet> bullets() 
	{
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (playa == null)
		{
			
			//System.out.println("playa is null");
			return bullets;
		}
		bullets.add(new BulletAccelerating(width, height, monsta.getX(), monsta.getY(), bulletRadius, bulletSpeed, 1, color, playa.getX(), playa.getY(), bulletAcceleration));
		return bullets;
	}

	public void refresh() 
	{
		
	}

}
