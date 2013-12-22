
import java.awt.*;
import java.util.ArrayList;

public abstract class Monster
{
	protected double x;
	protected double y;
	protected double r;
	protected int width;
	protected int height;
	protected int maxhp;
	protected int hp;
	protected Player playa;
	protected ArrayList<Bullet> bullets;
	protected BulletPattern bp;
	protected ArrayList<BulletPattern> bps;
	protected Image img;
	protected int imgHeight;
    protected int imgWidth;

	public Monster(int pWidth, int pHeight)
	{
		width = pWidth;
		height = pHeight;
		bullets = new ArrayList<Bullet>();
	}

	public void move()
	{
		moveMonster();
		fire();
		moveBullets();
	}

	public abstract void moveMonster();
	public abstract void makeBPs();
	
	public void fire()
	{
		if (bp == null || bp.isOver())
		{
			if (bps.size() > 0)
				bp = bps.get((int) (Math.random() * bps.size()));
			else
				bp = null;
		}
		else
		{
			bullets.addAll(bp.getBullets());
		}
	}

	public void moveBullets()
	{
		for (int i = 0; i < bullets.size(); i++)
		{
			Bullet b = bullets.get(i);
			boolean bombed = false;
			if (playa != null)
			{
				ArrayList<Bomb> bombs = playa.getBombs();
				for (int j = 0; j < bombs.size(); j++)
				{
					if (bombs.get(j).collide(b.getX(), b.getY(), b.getR()))
						bombed = true;
				}
			}
			if (bombed)
				bullets.remove(i--);
			else
			{
				b.move();
				if (playa != null && b.collide(playa.getX(), playa.getY(), playa.getR()))
				{
					bullets.remove(i--);
					playa.hit();
				}
				else if (b.offScreen())
				{
					bullets.remove(i--);
				}
			}
		}
	}
	
	public void addBullet(Bullet b)
	{
		bullets.add(b);
	}
	
	public void removeBullet(Bullet b)
	{
		bullets.remove(b);
	}

	public void setPlayer(Player playa)
	{
		this.playa = playa;
		makeBPs();
	}

	public void draw(Graphics dbg)
	{
		if (isAlive())
		{
			dbg.setColor(Color.RED);
			dbg.fillRect(0, 0, width, 15);
			dbg.setColor(Color.GREEN);
			dbg.fillRect(0, 0, width*hp/maxhp, 15);
			dbg.drawImage(img, (int)(x-imgWidth/2), (int)(y-imgHeight/2), imgWidth, imgHeight, null);
			for (Bullet b : bullets)
				b.draw(dbg);
		}
	}

	public void hit(int bulletpower)
	{
		hp -= bulletpower;
	}

	public double getX(){return x;}
	public double getY(){return y;}
	public double getR(){return r;}
	public int getHp(){return hp;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public boolean isAlive(){return hp>0;}

}
