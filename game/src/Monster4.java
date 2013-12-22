
import java.awt.*;
import java.io.*;
import java.util.*;

import javax.imageio.ImageIO;

public class Monster4 extends Monster
{
	public Monster4(int pWidth, int pHeight)
	{
		super(pWidth, pHeight);
		r = 85;
		x = width / 2;
		y = height / 4;
		maxhp = 1000;
		hp = maxhp;
		try 
	    {                
	    	img = ImageIO.read(new File("monster4.gif"));
	    } catch (IOException ex) {}
		imgHeight = img.getHeight(null);
		imgWidth = img.getWidth(null);
	}

	public void moveMonster()
	{
	}

	public void makeBPs() {
		bps = new ArrayList<BulletPattern>();
		bps.add(new     BPCircle(playa, this, 9, 2, 3, 50, Color.BLUE, 15, 5));
		bps.add(new     BPSpiral(playa, this, 18, 36, 4.5, 28, Color.RED, 2, 5));
		bps.add(new     BPMissile(playa, this, 4, 2, 30, 1.020, Color.ORANGE, 30, 5));		
	}

}