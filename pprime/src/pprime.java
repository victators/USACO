/*
ID: vxsj.fu1
LANG: JAVA
PROG: pprime
 */
import java.io.*;
import java.util.*;

public class pprime {

	int[] pals = new int [10000];
	int low;
	int high;
	int index = 0;
	
	boolean isPrime(int p)
	{
		for (int i = 2; i <= Math.sqrt(p); i++)
		{
			if(p%i == 0)
			{
				return false;
			}
		}
		return true;
	}
	
	void palGen ()
	{
		for (int i = 5; i < 10; i++)
		{
			int pal = i;
			if (pal < low)
			{
				continue;
			}
			if (pal > high)
			{
				continue;
			}
			pals[index] = pal;
			index++;
		}
		if ( low <= 11 && high >= 11)
		{	
			pals[index] = 11;
			index++;
		}
		for (int i = 1; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				int pal = 100*i + 10*j + i;
				if (pal < low)
				{
					continue;
				}
				if (pal > high)
				{
					continue;
				}
				pals[index] = pal;
				index++;
			}
		}
		for (int i = 1; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < 10; k++)
				{	
					int pal = 10000*i + 1000*j + 100*k + 10*j + i;
					if (pal < low)
					{
						continue;
					}
					if (pal > high)
					{
						continue;
					}
					pals[index] = pal;
					index++;
				}
			}
		}
		for (int i = 1; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				for (int k = 0; k < 10; k++)
				{	
					for (int l = 0; l < 10; l++)
					{
						int pal = 1000000*i + 100000*j + 10000*k + 1000*l + 100*k + 10*j + i;
						if (pal < low)
						{
							continue;
						}
						if (pal > high)
						{
							continue;
						}
						pals[index] = pal;
						index++;
					}
				}
			}
		}
	}

	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"pprime.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int lowerBound = Integer.parseInt(st.nextToken());
		int upperBound = Integer.parseInt(st.nextToken());
		low = lowerBound;
		high = upperBound;
		palGen();
		for (int i = 0; i < pals.length; i++)
		{
			if (pals[i] == 0)
			{
				break;
			}
			if (isPrime(pals[i]))
			{	
				out.println(pals[i]);
			}
		}
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		pprime prog = new pprime();
		prog.run();
	}
}

