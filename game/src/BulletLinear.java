
import java.awt.*;

public class BulletLinear extends Bullet
{
	protected double dx;
	protected double dy;

	public BulletLinear(int width, int height, double x, double y, double r, int power, Color color, double dx, double dy)
	{
		super(width, height, x, y, r, power, color);
		this.dx = dx;
		this.dy = dy;
	}

	public void move()
	{
		x += dx;
		y += dy;
	}

}

