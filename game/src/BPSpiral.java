
import java.awt.Color;
import java.util.ArrayList;


public class BPSpiral extends BulletPattern
{
	protected int numCircle;
	protected double offset;
	protected double bulletSpeed;
	protected double bulletRadius;
	protected Color color;
	protected int betweenDelay;

	public BPSpiral(Player playa, Monster monsta, int numCircle, int numBullets, double bulletSpeed, double bulletRadius, Color color, int betweenDelay, int finalDelay) {
		super(playa, monsta, betweenDelay, finalDelay, numBullets);
		this.numCircle = numCircle;
		this.numBullets = numBullets;
		this.bulletSpeed = bulletSpeed;
		this.bulletRadius = bulletRadius;
		this.color = color;
		this.betweenDelay = betweenDelay;
	}

	public ArrayList<Bullet> bullets() 
	{
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();

		if (turn >= (1+betweenDelay)*numBullets || turn % (1+betweenDelay) != 0)
		{
			turn++;
			return bullets;
		}
		int index = turn/(1+betweenDelay);
		double angle = 2 * Math.PI * index / numCircle + offset;
		bullets.add(new BulletLinear(width, height, monsta.getX(), monsta.getY(), bulletRadius, 1, color, bulletSpeed * Math.cos(angle), bulletSpeed * Math.sin(angle)));
		turn++;
		return bullets;
	}

	public void refresh() {
		offset = Math.random()*Math.PI*2;
	}

}
