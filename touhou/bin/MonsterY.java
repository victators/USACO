package game;
import java.awt.*;
import java.util.*;

public class MonsterY extends Monster
{
	public MonsterY(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
	}

	public void moveMonster()
	{
		x = width/2;
		y = height/2;
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new     BPFlower(playa, this, 31, 1, 3, 20, Color.BLACK, 0, 30, 1.1, true, 0 , 0));
	}
	
	public void draw(Graphics dbg)
	{
		for (Bullet b : bullets)
			b.draw(dbg);
	}
	
	

}