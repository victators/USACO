package game;
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Monster0 extends Monster
{
	public Monster0(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
		r = 85;
		x = width / 2;
		y = height / 4;
		maxhp = 1000;
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
	}

}