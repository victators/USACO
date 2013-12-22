package game;
import java.awt.*;
import java.util.*;

public abstract class BulletPattern
{
	protected int turn;
	protected int max;
	protected int width;
	protected int height;
	protected Player playa;
	protected Monster monsta;
	protected int betweenDelay;
	protected int finalDelay;
	protected int numBullets;

	public BulletPattern(Player playa, Monster monsta, int betweenDelay, int finalDelay, int numBullets)
	{
		this.width = monsta.getWidth();
		this.height = monsta.getHeight();
		this.playa = playa;
		this.monsta = monsta;
		this.betweenDelay = betweenDelay;
		this.finalDelay = finalDelay;
		this.numBullets = numBullets;
		max = (1+betweenDelay)*numBullets+finalDelay;
		turn = 0;
		refresh();
	}

	public boolean isOver()
	{
		if (turn < max)
			return false;
		turn = 0;
		refresh();
		return true;
	}

	public ArrayList<Bullet> getBullets()
	{
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		if (turn >= (1+betweenDelay)*numBullets || turn % (1+betweenDelay) != 0)
		{
			turn++;
			return bullets;
		}
		bullets = bullets();
		turn++;
		return bullets;
	}
	public abstract ArrayList<Bullet> bullets();
	
	public abstract void refresh();
}
