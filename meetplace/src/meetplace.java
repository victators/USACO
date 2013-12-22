/*
ID: vxsj.fu1
LANG: JAVA
PROG: meetplace
 */

import java.io.*;
import java.util.*;

class meetplace {
	
	private static int commonAncestor (int[] a, int x, int y)
	{
		int xDepth = 1;
		int yDepth = 1;
		int resetX = x;
		int resetY = y;
		if (x == y)
		{
			return x;
		}
		else
		{
			while (a[x] != 1)
			{
				x = a[x];
				xDepth++;
			}
			while (a[y] != 1)
			{
				y = a[y];
				yDepth++;
			}
			x = resetX;
			y = resetY;
			if (yDepth > xDepth)
			{
				for (int i = 0; i < yDepth - xDepth; i++)
				{
					y = a[y];
				}
			}
			else
			{
				for (int i = 0; i < xDepth - yDepth; i++)
				{
					x = a[x];
				}
			}
			
			while (x!= y)
			{
				x = a[x];
				y = a[y];
			}
			return x;
		}
	}

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("meetplace.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"meetplace.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken()); // second integer
		int[] array = new int[i1+1];
		array[1] = 1;
		for (int i = 2; i < i1+1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				array[i] = temp;
			}
		}
		
		for (int j = 0; j < i2; j++)
		{
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				int t1 = Integer.parseInt(st.nextToken());
				int t2 = Integer.parseInt(st.nextToken());
				out.println(commonAncestor(array, t1,t2));
			}
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	
	

}
