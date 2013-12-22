/*
ID: vxsj.fu1
LANG: JAVA
PROG: milk2
 */

import java.io.*;
import java.util.StringTokenizer;

public class milk2 {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk2.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		boolean[] flood = new boolean[1000000];
		int min = 1000000;
		int max = 0;
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				int temp1 = Integer.parseInt(st.nextToken());
				if (min > temp1) {
					min = temp1;
				}
				int temp2 = Integer.parseInt(st.nextToken());
				if (max < temp2) {
					max = temp2;
				}
				for (int j = temp1; j < temp2; j++) {
					flood[j] = true;
				}
			}
		}
		int maxTrueCount = 0;
		int dynamicTrueCount = 0;
		int maxFalseCount = 0;
		int dynamicFalseCount = 0;
		for (int k = min; k <= max; k++) {
			if (flood[k] == true) {
				dynamicTrueCount++;
				if (dynamicFalseCount > maxFalseCount) {
					maxFalseCount = dynamicFalseCount;
				}
				dynamicFalseCount = 0;
			} else {
				dynamicFalseCount++;
				if (dynamicTrueCount > maxTrueCount) {
					maxTrueCount = dynamicTrueCount;
				}
				dynamicTrueCount = 0;
			}

		}
		out.print(maxTrueCount + " ");
		out.println(maxFalseCount);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}


