/*
ID: vxsj.fu1
LANG: JAVA
PROG: friday
 */

import java.io.*;
import java.util.*;

class friday {
	
	private static boolean isLeap(int year)
	{
		if (year % 100 == 0)
		{
			if (year % 400 == 0)
			{
				return true;
			}
			return false;
		}
		else if (year % 4 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int[] week = new int[7];
		int[] notPrecomputing = {3,0,3,2,3,2,3,3,2,3,2,3};
		int yearCount = 1900;
		int rebecca = 6;
		for (int i = 0; i < 12*i1; i++)
		{
			int increment = notPrecomputing[i%12];
			if (i % 12 == 0 && i > 0)
			{
				yearCount++;
				
			}
			if (i % 12 == 1)
			{
				if (isLeap(yearCount) == true)
				{
					increment++;
				}
			}
			week[(rebecca + 1)%7]++;
			rebecca += increment;
			
		}
		for (int j = 0; j < 6; j ++)
		{
			out.print(week[j] + " ");
		}
		out.println(week[6]);
		out.close();                                  // close the output file
	    System.exit(0);                              // don't omit this!
	}
	
}
