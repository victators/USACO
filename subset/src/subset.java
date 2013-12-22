/*
ID: vxsj.fu1
LANG: JAVA
PROG: subset
 */

import java.io.*;
import java.util.*;

public class subset {
	
	long[][] ways;
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"subset.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		int l = num*(num+1)/2;
		ways = new long[l+1][l+1];
		if (l %2 == 1)
		{
			out.println(0);
			out.close();
			System.exit(0);
		}
		for(int i = 0; i <= num; i++)
		{
			ways[0][i] = 0;
			ways[i][0] = 1;
		}
		for (int i = 1; i <= num; i++)
		{
			for (int j = 1; j <= i*(i+1)/2; j++)
			{
				if (j < i)
				{
					ways[i][j] = ways[i-1][j];
					continue;
				}
				ways[i][j] = ways[i-1][j] + ways[i-1][j-i];
			}
		}
		out.println(ways[num][l/2]/2);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		subset prog = new subset();
		prog.run();
	}
}
