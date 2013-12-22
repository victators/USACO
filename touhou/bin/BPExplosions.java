package game;
import java.awt.Color;
import java.util.ArrayList;


public class BPExplosions extends BulletPattern
{
	protected int numCircle;
	protected double offset;
	protected double bulletSpeed;
	protected double bulletRadius;
	protected Color color;
	protected int explodeTime;
	protected int explodeNum;
	protected Monster monsta;

	public BPExplosions(Player playa, Monster monsta, int numCircle, int numBullets, double bulletSpeed, double bulletRadius, Color color, int betweenDelay, int finalDelay, int explodeTime, int explodeNum)
	{
		super(playa, monsta, betweenDelay, finalDelay, numBullets);
		this.numCircle = numCircle;
		this.numBullets = numBullets;
		this.bulletSpeed = bulletSpeed;
		this.bulletRadius = bulletRadius;
		this.explodeTime = explodeTime;
		this.explodeNum = explodeNum;
		this.color = color;
		this.monsta = monsta;
	}

	public ArrayList<Bullet> bullets()
	{
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		int index = turn/(1+betweenDelay);
		for (int i = 0; i < numCircle; i++)
		{
			double angle = 2 * Math.PI * i / numCircle + offset;
			bullets.add(new BulletExploding(width, height, monsta.getX(), monsta.getY(), bulletRadius, 1, color, bulletSpeed * Math.cos(angle), bulletSpeed * Math.sin(angle), explodeTime, explodeNum, monsta));
		}
		offset += 2 * Math.PI / (numCircle * numBullets);
		return bullets;
	}

	public void refresh() 
	{
		offset = Math.random()*Math.PI*2;
	}

}
