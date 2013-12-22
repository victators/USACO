/*
ID: vxsj.fu1
LANG: JAVA
PROG: beads
 */

import java.io.*;
import java.util.StringTokenizer;

public class beads {
	
	private static int rightCount(String str)
	{
		if (str.charAt(0) == 'w')
		{	
		int count1 = 1;
		int i = 1;
		char init1 = 'r';
		while (i < str.length() && (str.charAt(i) == init1 || str.charAt(i) == 'w'))
		{
			count1++;
			i++;
		}
		int count2 = 1;
		int j = 1;
		char init2 = 'b';
		while (j < str.length() && (str.charAt(j) == init2 || str.charAt(j) == 'w'))
		{
			count2++;
			j++;
		}
		return Math.max(count1, count2);
		}
		else
		{
			int count = 1;
			int i = 1;
			char init = str.charAt(0);
			while (i < str.length() && (str.charAt(i) == init || str.charAt(i) == 'w'))
			{
				count++;
				i++;
			}
			return count;
		}
	}
	
	private static int leftCount (String str)
	{
		if (str.charAt(str.length() - 1) == 'w') {
			int length = str.length();
			int count1 = 1;
			int i = 2;
			char init1 = 'r';
			while (i < str.length() + 1
					&& (str.charAt(length - i) == init1 || str.charAt(length
							- i) == 'w')) {
				count1++;
				i++;
			}
			int count2 = 1;
			int j = 2;
			char init2 = 'b';
			while (j < str.length() + 1
					&& (str.charAt(length - j) == init2 || str.charAt(length
							- j) == 'w')) {
				count2++;
				j++;
			}
			int count = Math.max(count1, count2);
			if (count == length) {
				return 0;
			}
			return count;
		}
		else
		{
			int length = str.length();
			int count = 1;
			int i = 2;
			char init = str.charAt(length - 1);
			while (i < str.length() + 1 && (str.charAt(length - i) == init || str.charAt(length - i) == 'w'))
			{
				count++;
				i++;
			}
			if (count == length) {
				return 0;
			}
			return count;
		}
	}
	
	private static String cycle (String str, int x)
	{
		String str1 = str.substring(x);
		String str2 = str.substring(0, x);
		return str1 + str2;
	}
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		st = new StringTokenizer(f.readLine());
		String str = st.nextToken();
		int[] counts = new int[i1];
		int max = 0;
		for (int i = 0; i < i1; i++)
		{
			counts[i] = rightCount(cycle(str, i)) + leftCount(cycle(str, i));
			if (counts[i] > max)
			{
				max = counts[i];
			}
			
		}
		if (max > str.length())
		{
			max = str.length();
		}
		out.println(max);
		out.close();                                  // close the output file
	    System.exit(0);                              // don't omit this!
	}
	
}


