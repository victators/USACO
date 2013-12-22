/*
ID: vxsj.fu1
LANG: JAVA
PROG: pageant
 */

import java.io.*;
import java.util.*;
public class pageant {
	
	public static int lakeCount(boolean[][] boo)
	{
		TreeSet<Integer> cellCnts = new TreeSet<Integer>();
		for (int i = 0; i < boo.length; i++)
		{
			for (int j = 0; j < boo[i].length; j++)
			{
				cellCnts.add(lakeSize(boo, i, j));
			}
		}
		int count = 0; 
		for (Integer i: cellCnts)
		{
			count++;
			
		}
		return count;
	}
	
	public static int lakeSize(boolean[][] boo, int row, int col)
	{
		int c = 1;
		boo[row][col] = false;
		if (row < boo.length && col + 1 < boo[0].length && boo[row][col+1])
		{
			c += lakeSize(boo, row, col + 1);
		}
		if (row + 1 < boo.length && col< boo[0].length && boo[row+1][col])
		{
			c += lakeSize(boo, row + 1, col);
		}
		if (row - 1 < boo.length && row > 0 && col < boo[0].length && boo[row-1][col])
		{
			c += lakeSize(boo, row - 1, col);
		}
		if (row < boo.length && col > 0 && col - 1 < boo[0].length && boo[row][col-1])
		{
			c += lakeSize(boo, row, col - 1);
		}
		return c;
	}
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("pageant.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"pageant.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken());
		int i2 = Integer.parseInt(st.nextToken());
		boolean[][] cowHide = new boolean[i1][i2];
		char[][] isuckatCS = new char [i1][i2];
		String next; 
		StringBuffer muscle = new StringBuffer();
		while ((next=f.readLine())!= null)
		{	
			muscle.append(next);
		}
		for (int i = 0; i < i1; i ++)
		{

			for (int j = 0; j < i2; j++)
			{
				isuckatCS[i][j] = muscle.charAt(i*i2 + j);
				if (isuckatCS[i][j] == '.')
				{
					cowHide[i][j] = false;
				}
				if (isuckatCS[i][j] == 'X')
				{
					cowHide[i][j] = true;
				}
			}
		}
	
		System.out.println(lakeCount(cowHide));
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
