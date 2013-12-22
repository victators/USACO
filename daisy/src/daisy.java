/*
ID: vxsj.fu1
LANG: JAVA
PROG: daisy
 */

import java.io.*;
import java.util.*;

class daisy {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("daisy.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"daisy.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken()); // second integer
		int[] abscissas = new int[i2];
		int[] ordinates = new int[i2];
		int[] cowTracker = new int[i1];
		for (int i = 0; i < i1; i++) {
			cowTracker[i] = i + 1;
		}
		for (int i = 0; i < i2; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				abscissas[i] = Integer.parseInt(st.nextToken());
				ordinates[i] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < i2; i++) {
			if (abscissas[i] == 1) {
				cowTracker[ordinates[i] - 1] = 0;
			} else if (ordinates[i] == 1) {
				cowTracker[abscissas[i] - 1] = 0;
			}

		}
		for (int i = 0; i < i1; i++) {
			if (cowTracker[i] > 1) {
				out.println(cowTracker[i]);
			}
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}