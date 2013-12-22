package game;
import java.awt.*;
import java.util.*;

public class BPCrossfire extends BulletPattern
{
	protected int numCircle;
	protected boolean left;
	protected double bulletSpeed;
	protected double bulletRadius;
	protected Color color;

	public BPCrossfire(Player playa, Monster monsta, int numCircle, int numBullets, double bulletSpeed, double bulletRadius, Color color, int betweenDelay, int finalDelay)
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
		int x = (int) (left?bulletRadius:width-bulletRadius);
		int y = (int) (Math.random()*height)/3;
		double angle = -Math.atan2(playa.getX()-x, playa.getY()-y)+Math.PI/2;
		for (int i = 0; i < numCircle; i++)
		{
			double speed = bulletSpeed*(i+1)/(numCircle*3) + 2*bulletSpeed/3;
			bullets.add(new BulletLinear(width, height, x, y, bulletRadius, 1, color, speed * Math.cos(angle), speed * Math.sin(angle)));
		}
		left = !left;
		return bullets;
	}

	public void refresh() {
		left = Math.random()<0.5;
	}

}


