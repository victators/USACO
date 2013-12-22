
import java.awt.*;

public abstract class Bullet
{
	protected int width;
	protected int height;
	protected double x;
	protected double y;
	protected double r;
	protected int power;
	protected Color color;

	public Bullet(int width, int height, double x, double y, double r, int power, Color color)
	{
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.r = r;
		this.power = power;
		this.color = color;
	}

	public abstract void move();

	public void draw(Graphics dbg)
	{
		dbg.setColor(color);
		dbg.fillOval((int) (x - r), (int) (y - r), (int) (r * 2), (int) (r * 2));
		dbg.setColor(Color.WHITE);
		double c = .75;
		dbg.fillOval((int) (x - r * c), (int) (y - r * c), (int) (r * 2 * c), (int) (r * 2 * c));
	}

	public boolean collide(double x, double y, double r)
	{
		return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2)) <= this.r + r;
	}

	public boolean offScreen()
	{
		return (x + r < 0 || x - r > width || y + r < 0 || y - r > height);
	}

	public int getPower(){return power;}
	public double getX(){return x;}
	public double getY(){return y;}
	public double getR(){return r;}
}
