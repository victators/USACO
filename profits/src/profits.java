/*
ID: vxsj.fu1
LANG: JAVA
PROG: profits
 */

import java.io.*;
import java.util.*;

class profits {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("profits.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"profits.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int [] conSums = new int [i1];
		int sum = 0;
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				sum += Integer.parseInt(st.nextToken());
					conSums[i] = sum;
			}
		}
		int [] sortSums = new int [(i1*i1 + i1)/2];
		for (int i = 0; i < i1; i++)
		{
			sortSums[i] = conSums[i];
		}
		int k = i1;
		for (int i = 0; i < i1; i++)
		{
			for (int j = 0; j < i; j++)
			{
				sortSums[k] = conSums[i]-conSums[j];
				k++;
			}
		}
		Arrays.sort(sortSums);
		out.println(sortSums[(i1*i1 + i1)/2 -1]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
