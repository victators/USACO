
import java.awt.Color;

public class BulletSpiral extends Bullet
{
	protected double speed;
	protected double magnitude;
	protected double centerX;
	protected double centerY;
	protected boolean clockwise;
	protected double shiftx;
	protected double shifty;
	protected double dsx;
	protected double dsy;
	
	public BulletSpiral(int width, int height, double centerX, double centerY, double x, double y, double r, int power, Color color, double speed, double magnitude, boolean clockwise, double dsx, double dsy)
	{
		super(width, height, x, y, r, power, color);
		this.centerX = centerX;
		this.centerY = centerY;
		this.speed = speed;
		this.magnitude = magnitude;
		this.clockwise = clockwise;
		shiftx = 0;
		shifty = 0;
		this.dsx = dsx;
		this.dsy = dsy;
	}

	public void move()
	{
		x -= shiftx;
		y -= shifty;
		double[] a = ZFunctions.rotate(x, y, centerX, centerY, Math.toRadians(10*(clockwise?1:-1)));
		double[] b = ZFunctions.scale(a[0], a[1], centerX, centerY, magnitude);
		double dx = b[0] - x;
		double dy = b[1] - y;
		double s = Math.sqrt(dx*dx+dy*dy);
		dx *= speed/s;
		dy *= speed/s;
		x += dx;
		y += dy;
		shiftx += dsx;
		shifty += dsy;
		x += shiftx;
		y += shifty;
	}

}

