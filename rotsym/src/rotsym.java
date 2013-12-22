/*
ID: vxsj.fu1
LANG: JAVA
PROG: rotsym
 */

// received help from wkyjyy1's solution from USACO October 2009 Contest for heat wave

import java.io.*;
import java.util.*;

class rotsym {
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("rotsym.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"rotsym.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		
		int[] abscissas = new int[i1];
		int[] ordinates = new int[i1];
		int[] mdptX = new int[i1*(i1-1)/2];
		int[] mdptY = new int[i1*(i1-1)/2];
		long[] john = new long[i1*(i1-1)/2];
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				int t1 = Integer.parseInt(st.nextToken());
				int t2 = Integer.parseInt(st.nextToken());
				abscissas[i] = t1;
				ordinates[i] = t2;
			}
		}
		for (int j = 0; j < i1; j++)
		{
			for (int k = j - 1; k >= 0; k--)
			{
				mdptX[j*(j+1)/2 - k - 1] =  (abscissas[j] + abscissas[k]);
				mdptY[j*(j+1)/2 - k - 1] =  (ordinates[j] + ordinates[k]);
				john[j*(j+1)/2 - k - 1] = (long) (1000000000*mdptX[j*(j+1)/2 - k - 1] + mdptY[j*(j+1)/2 - k - 1]);

			}
		}
		Arrays.sort(john);
		int mark = 1;
		long count = 0;
		for (int p = 0; p < i1*(i1-1)/2 - 1; p++)
		{
			if (john[p] == john [p+1])
			{
				while(john[p] == john[p+1])
				{
					p = p+1;
					mark++;
				}
				count += mark*(mark-1)/2;
				mark = 1;
			}
		}
		out.println(count);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}

