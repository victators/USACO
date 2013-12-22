/*
ID: vxsj.fu1
LANG: JAVA
PROG: mathprac
 */

import java.io.*;
import java.util.*;

class mathprac {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("mathprac.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"mathprac.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken()); // second integer
		double godlyLogarithm = Math.log10(2);
		
		
		for (int i = i1 + 1; i <= 62; i++)
		{
			if ((int) ((long)Math.pow( 2, i)/ Math.pow(10,(int)(i*godlyLogarithm))) == i2)
			{
				out.println(i);
				break;
			}
			else if (i == 62)
			{
				out.println(0);
			}
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
}
}