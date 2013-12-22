/*
ID: vxsj.fu1
LANG: JAVA
PROG: bookclub
 */

import java.io.*;
import java.util.*;

class bookclub {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("bookclub.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"bookclub.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken()); // second integer
		int i3 = Integer.parseInt(st.nextToken()); // third integer
		int[][] cows = new int[i1][i2];
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				for (int j = 0; j < i2; j++) {
					cows[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		}
		int[] abscissas = new int[i3];
		int[] ordinates = new int[i3];
		for (int i = 0; i < i3; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				abscissas[i] = Integer.parseInt(st.nextToken());
				ordinates[i] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] cowCounter = new boolean[i1][i2];
		for (int y = 0; y < i3; y++) {
			for (int x = 0; x < i1; x++) {
				if (cows[x][abscissas[y] - 1] == ordinates[y]) {
					cowCounter[x][abscissas[y] - 1] = true;

				}
			}
		}
		int count = 0;
		int[] mark = new int[i1];
		for (int m = 0; m < i1; m++) {
			for (int n = 0; n < i2; n++) {
				if (cowCounter[m][n] == true) {
					mark[m]++;
				}
			}
		}
		for (int p = 0; p < i1; p++) {
			if (mark[p] == i3) {
				count++;
			}
		}
		System.out.println(count);

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}

