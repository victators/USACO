/*
ID: vxsj.fu1
LANG: JAVA
PROG: transform
 */

import java.io.*;
import java.util.StringTokenizer;

public class transform {
	
	private static boolean trans1 (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[j][size - 1 - i])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans2 (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[size - 1 - i][size - 1 - j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans3 (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[size - 1 - j][i])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans4 (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[i][size - 1 - j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans5a (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[size - 1 - j][size - 1 - i])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans5b (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[size - 1 - i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans5c (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[j][i])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean trans6 (char[][] object, char[][] image, int size)
	{
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				if (object[i][j] != image[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"transform.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		char[][] obj = new char[i1][i1];
		char[][] img = new char[i1][i1];
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				String temp = st.nextToken();
				for (int j = 0; j < i1; j++) {
					obj[i][j] = temp.charAt(j);
				}
			}
		}
		for (int p = 0; p < i1; p++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				String temp = st.nextToken();
				for (int q = 0; q < i1; q++) {
					img[p][q] = temp.charAt(q);
				}
			}
		}
		int trans = 0;
		if (trans1(obj, img, i1) == true)
		{
			trans = 1;
		}
		else if( trans2(obj, img, i1) == true)
		{
			trans = 2;
		}
		else if( trans3(obj, img, i1) == true)
		{
			trans = 3;
		}
		else if( trans4(obj, img, i1) == true)
		{
			trans = 4;
		}
		else if( trans5a(obj, img, i1) == true)
		{
			trans = 5;
		}
		else if( trans5b(obj, img, i1) == true)
		{
			trans = 5;
		}
		else if( trans5c(obj, img, i1) == true)
		{
			trans = 5;
		}
		else if( trans6(obj, img, i1) == true)
		{
			trans = 6;
		}
		else
		{
			trans = 7;
		}
		out.println(trans);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}


