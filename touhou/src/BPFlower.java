package game;
import java.awt.*;
import java.util.*;

public class BPFlower extends BulletPattern
{
	protected int numCircle;
	protected double offset;
	protected double bulletSpeed;
	protected double bulletRadius;
	protected Color color;
	protected double magnitude;
	protected boolean clockwise;
	protected double dsx;
	protected double dsy;
	
	public BPFlower(Player playa, Monster monsta, int numCircle, int numBullets, double bulletSpeed, double bulletRadius, Color color, int betweenDelay, int finalDelay, double magnitude, boolean clockwise, double dsx, double dsy)
	{
		super(playa, monsta, betweenDelay, finalDelay, numBullets);
		this.numCircle = numCircle;
		this.numBullets = numBullets;
		this.bulletSpeed = bulletSpeed;
		this.bulletRadius = bulletRadius;
		this.color = color;
		this.magnitude = magnitude;
		this.clockwise = clockwise;
		this.dsx = dsx;
		this.dsy = dsy;
	}

	public ArrayList<Bullet> bullets()
	{
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		for (int i = 0; i < numCircle; i++)
		{
			double angle = 2 * Math.PI * i / numCircle + offset;
			bullets.add(new BulletSpiral(width, height, monsta.getX(), monsta.getY(), monsta.getX()+50*Math.cos(angle), monsta.getY()+50*Math.sin(angle), bulletRadius, 1, color, bulletSpeed, magnitude, clockwise, dsx, dsy));
		}
		offset += 2 * Math.PI / (numCircle * numBullets);
		return bullets;
	}

	public void refresh() {
		offset = Math.random()*Math.PI*2;
	}

}


