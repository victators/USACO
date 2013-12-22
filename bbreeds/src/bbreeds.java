/*
ID: vxsj.fu1
LANG: JAVA
PROG: bbreeds
 */

import java.io.*;
import java.util.*;

public class bbreeds {
	
	int[][]dp = new int[1000][1000];
	char[] str = new char[1000];
	String s;
	
	int cnt(int index, int nestG, int nestH) 
	{
		if (index == s.length()) 
			return (nestG == 0 && nestH == 0) ? 1 : 0;
		if (nestG < 0 || nestH < 0) 
			return 0;
		if (dp[index][nestG] != -1) 
			return dp[index][nestG]%2012;
		else {
			dp[index][nestG] = 0;
			if(str[index] == '(')
			{
				cnt(index+1,nestG+1,nestH);
				dp[index][nestG] += cnt(index + 1, nestG +1, nestH);
				cnt(index+1,nestG,nestH+1);
				dp[index][nestG] += cnt(index + 1, nestG, nestH+1);
			}
			else
			{
				cnt(index+1,nestG-1,nestH);
				dp[index][nestG] += cnt(index + 1, nestG - 1, nestH);
				cnt(index+1,nestG,nestH-1);
				dp[index][nestG] += cnt(index + 1, nestG, nestH-1);
			}
			return dp[index][nestG]%2012;
		}	
	}
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("bbreeds.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"bbreeds.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		s = st.nextToken();
		int k = s.length();
		for (int i = 0; i < k; i++)
		{
			str[i] = s.charAt(i);
		}
		for (int i = 0; i < k; i++)
		{
			for (int j = 0; j < k; j++)
			{
				dp[i][j] = -1;
			}
		}
		System.out.println(cnt(0,0,0));
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		bbreeds prog = new bbreeds();
		prog.run();
	}
}