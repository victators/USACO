package game;
import java.awt.Color;
import java.awt.Graphics;


public class BGLine extends BGObject
{
	private double x;
	private double y;
	private double slope;
	private double dx;
	private Color color;
	
	public BGLine(int width, int height, double x, double y, double slope, double dx, Color color)
	{
		super(width, height);
		this.x = x;
		this.y = y;
		this.slope = slope;
		this.dx = dx;
		this.color = color;
	}

	public void draw(Graphics g)
	{
		g.setColor(color);
		g.drawLine((int)(x-y/slope), 0, (int)(x+(height-y)/slope), height);
		
	}

	public void move()
	{
		x += dx;
		if (x-y/slope < 0 && x+(height-y)/slope < 0)
			x = width;
		if (x-y/slope > width && x+(height-y)/slope > width)
			x = 0;

	}

}
