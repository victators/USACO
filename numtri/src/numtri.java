/*
ID: vxsj.fu1
LANG: JAVA
PROG: numtri
 */

import java.io.*;
import java.util.*;

public class numtri {
	
	int[][] dp, tree;
	int sum (int row, int col)
	{
		if (row >= tree.length)
		{
			return 0;
		}
		if (dp[row][col] != -1)
		{
			return dp[row][col];
		}
		int ho = 0;
		ho = Math.max(ho, sum(row+1, col));
		ho = Math.max(ho, sum(row+1, col+1));
		dp[row][col] = ho + tree[row][col];
		return dp[row][col];
	}

	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"numtri.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int i1 = Integer.parseInt(st.nextToken());
		tree = new int[i1][i1];
		dp = new int[i1][i1];
		for (int i = 0; i < i1; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j <= i; j++)
			{
				tree[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		out.println(sum(0, 0));
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		numtri prog = new numtri();
		prog.run();
	}
}
