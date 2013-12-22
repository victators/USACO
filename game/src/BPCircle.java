
import java.awt.*;
import java.util.*;

public class BPCircle extends BulletPattern
{
	protected int numCircle;
	protected double offset;
	protected double bulletSpeed;
	protected double bulletRadius;
	protected Color color;

	public BPCircle(Player playa, Monster monsta, int numCircle, int numBullets, double bulletSpeed, double bulletRadius, Color color, int betweenDelay, int finalDelay)
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
			double angle = 2 * Math.PI * i / numCircle + offset;
			bullets.add(new BulletLinear(width, height, monsta.getX(), monsta.getY(), bulletRadius, 1, color, bulletSpeed * Math.cos(angle), bulletSpeed * Math.sin(angle)));
		}
		offset += 2 * Math.PI / (numCircle * numBullets);
		return bullets;
	}

	public void refresh() {
		offset = Math.random()*Math.PI*2;
	}

}


