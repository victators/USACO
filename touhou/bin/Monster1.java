package game;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Monster1 extends Monster
{
	public Monster1(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
		r = 85;
		x = width / 2;
		y = height / 4;
		maxhp = 1000;
		hp = maxhp;
		try 
	    {                
	    	img = ImageIO.read(new File("monster1.gif"));
	    } catch (IOException ex) {}
		imgHeight = img.getHeight(null);
		imgWidth = img.getWidth(null);
	}

	public void moveMonster()
	{
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new     BPCircle(playa, this, 6, 2, 1.5, 35, Color.BLUE, 50, 20));
		bps.add(new     BPSpiral(playa, this, 12, 24, 3, 22, Color.RED, 5, 20));		
	}

}