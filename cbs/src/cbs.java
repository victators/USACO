/*
ID: vxsj.fu1
LANG: JAVA
PROG: cbs
 */

import java.io.*;
import java.util.*;

public class cbs {
	
	String[] s;
	
	boolean isBal(String s)
	{
		Stack q = new Stack();
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				q.push(s.charAt(i));
			}
			else
			{
				if (q.isEmpty())
				{
					return false;
				}
				q.pop();
			}
		}
		if (q.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("7.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"cbs.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		Integer i1 = Integer.parseInt(st.nextToken());
		Integer i2 = Integer.parseInt(st.nextToken());
		s= new String[i1];
		for (int i = 0; i < i1; i++)
		{
			st = new StringTokenizer(f.readLine());
			s[i] = st.nextToken();
		}
		int count = 0;
		
		for (int i = 0; i < i2; i++)
		{
			for (int j = i+2; j <= i2; j+= 2)
			{
				for (int k = 0; k < i1; k++)
				{
					if(isBal(s[k].substring(i,j)))
					{
						if (k == i1-1)
						{
							count++;
						}
						continue;
					}
					break;
				}
			}
		}
		System.out.println(count);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		cbs prog = new cbs();
		prog.run();
	}
}
