package game;
import java.awt.*;
import java.util.*;


public class BulletExploding extends Bullet
{
	protected double dx;
	protected double dy;
	protected int counter;
	protected int explodeTime;
	protected int explodeNum;
	protected ArrayList<Bullet> bullets;
	protected Monster monsta;
	
	public BulletExploding(int width, int height, double x, double y, double r, int power, Color color, double dx, double dy, int explodeTime, int explodeNum, Monster monsta)
	{
		super(width, height, x, y, r, power, color);
		this.dx = dx;
		this.dy = dy;
		this.explodeTime = explodeTime;
		this.explodeNum = explodeNum;
		counter = 0;
		bullets = new ArrayList<Bullet>();
		bullets.add(this);
		this.monsta = monsta;
	}

	public void move()
	{
		if (counter++ < explodeTime)
		{
			x += dx;
			y += dy;
		}
		else
		{
			monsta.removeBullet(this);
			double offset = Math.random() * 2 * Math.PI;
			double bulletSpeed = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
			bulletSpeed *= 0.5;
			 
			for (int i = 0; i < explodeNum; i++)
			{
				double angle = 2 * Math.PI * i / explodeNum + offset;
				monsta.addBullet(new BulletLinear(width, height, x, y, r * 0.5, 1, color, bulletSpeed * Math.cos(angle), bulletSpeed * Math.sin(angle)));
			}
			
		}
	}
	
	public void draw(Graphics dbg)
	{
		for (Bullet bullet : bullets)
		{
			dbg.setColor(color);
			dbg.fillOval((int) (bullet.getX() - bullet.getR()), (int) (bullet.getY() - bullet.getR()), (int) (bullet.getR() * 2), (int) (bullet.getR() * 2));
			dbg.setColor(Color.WHITE);
			double c = .75;
			dbg.fillOval((int) (bullet.getX() - bullet.getR() * c), (int) (bullet.getY() - bullet.getR() * c), (int) (bullet.getR() * 2 * c), (int) (bullet.getR() * 2 * c));
		}
	}
	
	public boolean collide(double x, double y, double r)
	{
		for (Bullet bullet : bullets)
		{
			if (Math.sqrt(Math.pow(bullet.getX() - x, 2) + Math.pow(bullet.getY() - y, 2)) <= bullet.getR() + r)
				return true;
		}
		return false;
	}
}
