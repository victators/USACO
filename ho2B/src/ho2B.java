/*
ID: vxsj.fu1
LANG: JAVA
PROG: ho2B
 */

import java.io.*;
import java.util.*;

public class ho2B {
	int[][] dp;
	int[][] parent;
	int[][] gr;
	
	int countTwos (int a)
	{
		int i = 0;
		while (a%2 == 0)
		{
			i++;
			a/=2;
			if (a== 0)
			{
				break;
			}
		}
		return i;
	}
	
	int countFives (int a)
	{
		int i = 0;
		while (a%5 == 0)
		{
			i++;
			a/=5;
			if (a== 0)
			{
				break;
			}
		}
		return i;
	}
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ho2B.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ho2B.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				gr[i][j] = i*n + j+1;
			}
		}
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				
			}
		}
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		ho2B prog = new ho2B();
		prog.run();
	}
}

