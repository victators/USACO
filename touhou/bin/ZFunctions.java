package game;

public class ZFunctions
{
	public static double[] rotate(double x, double y, double centerX, double centerY, double angle)
	{
		y *= -1;
		centerY *= -1;
		double[] a = new double[2];
		a[0] = (x-centerX)*Math.cos(angle)-(y-centerY)*Math.sin(angle)+centerX;
		a[1] = -1 * ((x-centerX)*Math.sin(angle)+(y-centerY)*Math.cos(angle)+centerY);
		return a;
	}
	
	public static double[] scale(double x, double y, double centerX, double centerY, double magnitude)
	{
		double[] a = new double[2];
		a[0] = (x-centerX)*magnitude + centerX;
		a[1] = (y-centerY)*magnitude + centerY;
		return a;
	}
}
