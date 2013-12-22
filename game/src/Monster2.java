
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Monster2 extends Monster
{
	public Monster2(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
		r = 85;
		x = width / 2;
		y = height / 4;
		maxhp = 1000;
		hp = maxhp;
		try 
	    {                
	    	img = ImageIO.read(new File("monster2.gif"));
	    } catch (IOException ex) {}
		imgHeight = img.getHeight(null);
		imgWidth = img.getWidth(null);
	}

	public void moveMonster()
	{
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new     BPCircle(playa, this, 7, 2, 2, 40, Color.BLUE, 40, 15));
		bps.add(new     BPSpiral(playa, this, 14, 28, 3.5, 25, Color.RED, 4, 15));		
	}

}