package game;
import java.awt.Color;
import java.awt.Graphics;

public class Bomb extends BulletLinear
{
	int count;
	
	public Bomb(int width, int height, double x, double y, double r, int power, Color color, double dx, double dy, Monster monsta)
	{
		super(width, height, x, y, r, power, color, dx, dy);
		count = 0;
	}

	public void move()
	{
		super.move();
		count++;
	}
	
	public void draw(Graphics dbg)
	{
		if (count % 16 < 8)
		{
			dbg.setColor(Color.WHITE);
			dbg.fillOval((int) (x - r), (int) (y - r), (int) (r * 2), (int) (r * 2));
			dbg.setColor(color);
			double c = .75;
			dbg.fillOval((int) (x - r * c), (int) (y - r * c), (int) (r * 2 * c), (int) (r * 2 * c));
		}
		else
		{
			dbg.setColor(color);
			dbg.fillOval((int) (x - r), (int) (y - r), (int) (r * 2), (int) (r * 2));
			dbg.setColor(Color.WHITE);
			double c = .75;
			dbg.fillOval((int) (x - r * c), (int) (y - r * c), (int) (r * 2 * c), (int) (r * 2 * c));

		}
	}
}
