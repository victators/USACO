package game;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Monster3 extends Monster
{
	public Monster3(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
		r = 85;
		x = width / 2;
		y = height / 4;
		maxhp = 1000;
		hp = maxhp;
		try 
	    {                
	    	img = ImageIO.read(new File("monster3.gif"));
	    } catch (IOException ex) {}
		imgHeight = img.getHeight(null);
		imgWidth = img.getWidth(null);
	}

	public void moveMonster()
	{
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new     BPCircle(playa, this, 8, 2, 2.5, 45, Color.BLUE, 15, 10));
		bps.add(new     BPSpiral(playa, this, 16, 32, 4, 26, Color.RED, 3, 10));
		bps.add(new     BPMissile(playa, this, 3, 2, 25, 1.015, Color.ORANGE, 40, 10));
	}

}