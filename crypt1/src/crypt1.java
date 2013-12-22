/*
ID: vxsj.fu1
LANG: JAVA
PROG: crypt1
 */

import java.io.*;
import java.util.*;

public class crypt1 {
	
	public static boolean contains(int[] set, int digit)
	{
		for (int i = 0; i < set.length; i++)
		{
			if(set[i] == digit)
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkValid (int[] set, int threeDigit, int twoDigit)
	{
		int digit1 = twoDigit/10;
		int digit2 = twoDigit%10;
		int part1 = threeDigit*digit1;
		int part2 = threeDigit*digit2;
		if (part1 >= 1000 || part2 >= 1000)
		{
			return false;
		}
		int k = 100;
		int p1 = part1;
		int p2 = part2;
		for (int i = 3; i >0 ; i-- )
		{
			int digit = p1/k;
			if (!(contains(set, digit)))
			{	
				return false;
			}
			p1 %= k;
			k /= 10;
		}
		k = 100;
		for (int i = 3; i > 0 ; i-- )
		{
			int digit = p2/k;
			if (!(contains(set, digit)))
			{	
				return false;
			}
			p2 %= k;
			k /= 10;
		}
		if (10*part1 + part2 >= 10000)
		{
			return false;
		}
		int x = 1000;
		int p = 10*part1 + part2;
		for (int i = 4; i > 0; i--)
		{
			int digit = p/x;
			if (!(contains(set, digit)))
			{	
				return false;
			}
			p %= x;
			x /= 10;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"crypt1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken());
		int[] set = new int[i1];
		Arrays.sort(set);
		st = new StringTokenizer(f.readLine());
		for (int i = 0; i < i1; i++)
		{
			set[i] = Integer.parseInt(st.nextToken());
		}
		int[] threeDigit = new int[i1*i1*i1];
		int[] twoDigit = new int [i1*i1];
		int count = 0;
		int count2 = 0;
		for (int p = 0; p < i1; p++)
		{
			for (int q = 0; q < i1; q++)
			{
				twoDigit[count] = 10*set[p] + set[q];
				
				for (int r = 0; r < i1; r++)
				{
					threeDigit[count2] = 10*twoDigit[count] + set[r];
					
					count2++;
				}
				count++;
			}
		}
		int valid = 0;
		for (int a = 0; a < threeDigit.length; a++)
		{
			for (int b = 0; b <twoDigit.length; b++)
			{
				if(checkValid(set,threeDigit[a], twoDigit[b] ) == true)
				{
					valid++;
				}
			}
		}
		out.println(valid);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
}
}
