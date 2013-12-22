/*
ID: vxsj.fu1
LANG: JAVA
PROG: tilechng
 */

import java.io.*;
import java.util.*;

public class tilechng {
	
	int inf = 1000000000;
	
	int[][] best;
	int[] areas;
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("I.3"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"tilechng.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		best = new int[m+1][n+1];
		areas = new int [m+1];
		for (int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(f.readLine());
			areas[i] = Integer.parseInt(st.nextToken());
		}
		for (int j= 1; j <= m; j++)
		{
			best[j][0] = inf;
		}
		for (int j = 1; j <= n; j++)
		{
			for (int i = 0; i <= m; i++)
			{
				best[i][j] = inf;
				for (int k = 1; k*k <= i; k++ )
				{
					if ((areas[j]-k)*(areas[j]-k)+ best[i-k*k][j-1] < best[i][j] )
					{
						best[i][j] = (areas[j]-k)*(areas[j]-k)+ best[i-k*k][j-1];
						System.out.println(i+ " " + j + " " + best[i][j]);
					}
				}
			}
		}
		if (best[m][n] == inf)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(best[m][n]);
		}
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		tilechng prog = new tilechng();
		prog.run();
	}
}
