
import java.awt.Color;
import java.awt.Graphics;


public class BGPolygon extends BGObject
{
	
	private double x;
	private double y;
	private int n;
	private double maxlength;
	private double length;
	private double dlength;
	private double theta;
	private double dtheta;
	private Color color;
	
	public BGPolygon(int width, int height, int n, double maxlength, double dlength, double dtheta, Color color)
	{
		super(width, height);
		this.n = n;
		this.maxlength = maxlength;
		this.dlength = dlength;
		this.dtheta = dtheta;
		x = maxlength + Math.random()*(width-2*maxlength);
		y = maxlength + Math.random()*(height-2*maxlength);
		theta = Math.random()*2*Math.PI;
		this.color = color;
	}

	@Override
	public void draw(Graphics g)
	{
		g.setColor(color);
		double x1 = x + length*Math.sin(theta);
		double y1 = y + length*Math.cos(theta);
		for (int i = 1; i < n; i++)
		{
			double x2 = x + length*Math.sin(theta + 2*Math.PI*i/n);
			double y2 = y + length*Math.cos(theta + 2*Math.PI*i/n);
			g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
			x1 = x2;
			y1 = y2;
		}
		g.drawLine((int)x1, (int)y1, (int)(x + length*Math.sin(theta)), (int)(y + length*Math.cos(theta)));
	}

	@Override
	public void move()
	{
		length += dlength;
		theta += dtheta;
		if (length >= maxlength || length < 0)
			dlength *= -1;
		if (length < 0)
		{
			x = maxlength + Math.random()*(width-2*maxlength);
			y = maxlength + Math.random()*(height-2*maxlength);
			length += dlength;
		}
	}

}
