
import java.awt.*;
import java.util.*;

public class BPRain extends BulletPattern
{
	protected int numCircle;
	protected double offset;
	protected double bulletSpeed;
	protected double bulletRadius;
	protected Color color;

	public BPRain(Player playa, Monster monsta, int numCircle, int numBullets, double bulletSpeed, double bulletRadius, Color color, int betweenDelay, int finalDelay)
	{
		super(playa, monsta, betweenDelay, finalDelay, numBullets);
		this.numCircle = numCircle;
		this.numBullets = numBullets;
		this.bulletSpeed = bulletSpeed;
		this.bulletRadius = bulletRadius;
		this.color = color;
	}

	public ArrayList<Bullet> bullets()
	{
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		for (int i = 0; i < numCircle; i++)
		{
			int x = (int) (bulletRadius + (width-2*bulletRadius)*Math.random());
			bullets.add(new BulletLinear(width, height, x, (int) bulletRadius, bulletRadius*(Math.random()*0.5+0.75), 1, color, Math.random()*4-2, bulletSpeed*(Math.random()*1.5+0.5)));
		}		
		return bullets;
	}

	public void refresh()
	{		
	}
}


