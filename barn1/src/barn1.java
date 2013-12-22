/*
ID: vxsj.fu1
LANG: JAVA
PROG: barn1
 */

import java.io.*;
import java.util.*;

public class barn1 {

	private static int greedyIndex(boolean[] stallMap1) {
		int minFalseCount = stallMap1.length;
		int falseCount = 0;
		int index = 0;
		for (int i = 1; i < stallMap1.length - 1; i++) {
			if (stallMap1[i] == false) {
				falseCount++;
				if (stallMap1[i + 1] == true) {
					if (falseCount < minFalseCount) {
						minFalseCount = falseCount;
						index = i;
					}

				}

			} else {
				falseCount = 0;
			}

		}
		return index;
	}

	private static int greedyCount(boolean[] stallMap1) {
		int minFalseCount = stallMap1.length;
		int falseCount = 0;
		int index = 0;
		for (int i = 1; i < stallMap1.length - 1; i++) {
			if (stallMap1[i] == false) {
				falseCount++;
				if (stallMap1[i + 1] == true) {
					if (falseCount < minFalseCount) {
						minFalseCount = falseCount;
						index = i;
					}

				}

			} else {
				falseCount = 0;
			}

		}
		return minFalseCount;
	}
	
	private static int trueBlockCount(boolean[] stallMap1) {
		int trueBlockCount = 0;
		for (int i = 0; i < stallMap1.length - 1; i++) {
			if (stallMap1[i] == true) {
				if (stallMap1[i + 1] == false) {
					trueBlockCount++;
					}
			} 
		}
		return trueBlockCount + 1;
	}

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"barn1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int m = Integer.parseInt(st.nextToken()); // first integer
		int s = Integer.parseInt(st.nextToken()); // first integer
		int c = Integer.parseInt(st.nextToken()); // first integer
		int start = 201;
		int end = 0;
		boolean[] covered = new boolean[s + 1];
		for (int i = 0; i < c; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				int temp = Integer.parseInt(st.nextToken());
				covered[temp] = true;
				if (start > temp) {
					start = temp;
				}
				if (end < temp) {
					end = temp;
				}
			}
		}
		boolean[] stallMap = new boolean[end - start + 1];
		for (int i = start; i <= end; i++) {
			stallMap[i - start] = covered[i];

		}
		int tbc = trueBlockCount(stallMap);
		for (int j = 0; j < tbc - m; j++) {
			int temp1 = greedyIndex(stallMap);
			int temp2 = greedyCount(stallMap);
			for (int i = temp1; i > temp1 - temp2; i--) {
				stallMap[i] = true;
			}
		}
		
		int stallCount = 0;
		for (int i = 0; i < stallMap.length; i++) {
			if (stallMap[i] == true) {
				stallCount++;
			}
//			System.out.print(i + 3 + " ");
//			System.out.println(stallMap[i]);
		}

		out.println(stallCount);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
