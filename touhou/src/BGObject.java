package game;
import java.awt.Graphics;


public abstract class BGObject
{
	protected int width;
	protected int height;
	public BGObject(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	public abstract void move();
	public abstract void draw(Graphics g);
	
}
