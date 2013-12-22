
import java.awt.*;
import java.util.*;

public class MonsterX extends Monster
{
	public MonsterX(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
	}

	public void moveMonster()
	{
		x = (int)(Math.random()*width);
		y = (int)(Math.random()*height);
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new       BPRain(playa, this, 25, 1, 8, 12, Color.RED, 0, 0));
		bps.add(new     BPCircle(playa, this, 15, 1, 6, 30, Color.BLUE, 0, 0));
	}
	
	public void draw(Graphics dbg)
	{
		for (Bullet b : bullets)
			b.draw(dbg);
	}
	
	

}