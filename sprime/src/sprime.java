/*
ID: vxsj.fu1
LANG: JAVA
PROG: sprime
 */

import java.io.*;
import java.util.*;


public class sprime {
	
	int index = 0;
	int[] ribs = new int[1000];
	int start = 0;
	int end = 1;
	
	boolean isPrime(int p)
	{
		if ( p ==1)
			return false;
		for (int i = 2; i <= Math.sqrt(p); i++)
		{
			if(p%i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	void primeRib()
	{
		for (int i = start; i < end; i++)
		{
			for (int j = 0; j < 10; j++)
			{	
				int num = ribs[i]*10 + j;
				if (num > 100000000)
				{
					return;
				}
				if(isPrime(num))
				{
					ribs[index] = num;
					index++;
				}
			}
			start = end;
			end = index;
		}
	}
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"sprime.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int i1 = Integer.parseInt(st.nextToken());
		primeRib();
		for(int i = 0; i < ribs.length; i++)
		{
			if (ribs[i] > Math.pow(10, i1-1) && ribs[i] < Math.pow(10,i1))
			{
				out.println(ribs[i]);
			}
		}
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		sprime prog = new sprime();
		prog.run();
	}
}
