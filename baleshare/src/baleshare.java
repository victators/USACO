/*
ID: vxsj.fu1
LANG: JAVA
PROG: baleshare
 */

import java.io.*;
import java.util.*;

public class baleshare {
	
	boolean[][] jeff = new boolean[1010][1010];
	boolean[][] jeff2 = new boolean[1010][1010];
	int[] hay;
	
	int min (int a, int b)
	{
		if (a > b)
			return b;
		return a;
	}
	
	int max (int a, int b)
	{
		if (a > b)
			return a;
		return b;
	}
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("baleshare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"baleshare.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int bales = Integer.parseInt(st.nextToken());
		hay = new int[bales];
		for (int i = 0; i < 1010; i++)
		{
			for (int j = 0; j < 1010; j++)
			{
				jeff[i][j] = false;
				jeff2[i][j] = false;
			}
		}
		jeff[0][0] = true;
		int sum = 0;
		for (int x = 0; x < bales; x++)
		{
			st = new StringTokenizer(f.readLine());
			hay[x] = Integer.parseInt(st.nextToken());
			sum += hay[x];
		}
		for (int x = 0; x < bales; x++)
		{
			for (int i = 0; i < 1010; i++)
			{
				for (int j = 0; j < 1010; j++)
				{
					jeff2[i][j] = false;
				}
			}
			for (int i = 0; i < 1010; i++)
			{
				for (int j = 0; j < 1010; j++)
				{
					if (i >= hay[x])
					{
						jeff2[i][j] |= jeff[i-hay[x]][j];
					}
					if (j >= hay[x])
					{
						jeff2[i][j] |= jeff[i][j-hay[x]];
					}
				}
			}
			for (int i = 0; i < 1010; i++)
			{
				for (int j = 0; j < 1010; j++)
				{
					jeff[i][j] |= jeff2[i][j];
				}
			}
		}
		int answer = 10000000;
		for (int i = 0; i < 1010; i++)
		{
			for (int j = 0; j < 1010; j++)
			{
				if (jeff[i][j])
				{
					answer = min(answer, max(i, max(j, sum-i-j)));
				}
			}
		}
		out.println(answer);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		baleshare prog = new baleshare();
		prog.run();
	}
}

