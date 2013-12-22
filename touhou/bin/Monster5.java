package game;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Monster5 extends Monster
{
	public Monster5(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
		r = 85;
		x = width / 2;
		y = height / 4;
		maxhp = 10000;
		hp = maxhp;
		try 
	    {                
	    	img = ImageIO.read(new File("monster5.gif"));
	    } catch (IOException ex) {}
		imgHeight = img.getHeight(null);
		imgWidth = img.getWidth(null);
	}

	public void moveMonster()
	{
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new     BPCircle(playa, this, 25, 8, 1.5, 18, Color.RED, 15, 40));
		bps.add(new    BPMissile(playa, this, 4, 2, 20, 1.01, Color.YELLOW, 5, 0));
		bps.add(new BPExplosions(playa, this, 5, 13, 2.2, 28, Color.MAGENTA, 20, 20, 150, 5));
		bps.add(new       BPRain(playa, this, 10, 3, 2, 12, Color.GREEN, 15, 0));	
		bps.add(new     BPFlower(playa, this, 5, 1, 1.8, 15, Color.BLUE, 0, 5, 1.05, true, 0 , 1));
		bps.add(new  BPCrossfire(playa, this, 4, 2, 4, 10, Color.GRAY, 5, 20));

	}

}