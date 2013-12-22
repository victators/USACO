/*
ID: vxsj.fu1
LANG: JAVA
PROG: commas
 */

import java.io.*;
import java.util.*;

class commas {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("commas.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"commas.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		Integer i2 = (Integer) (i1);
		String badNum = i2.toString();
		int trioDug = badNum.length() / 3;
		String[] dugtrio = new String[trioDug];

		for (int i = 0; i < trioDug; i++) {
			int start = badNum.length() - 3 * (i + 1);
			int end = start + 3;
			dugtrio[i] = badNum.substring(start, end);

		}
		out.print(badNum.substring(0, badNum.length() % 3));
		String bigKahuna = "";
		for (int j = trioDug - 1; j >= 0; j--) {
			bigKahuna += "," + dugtrio[j];

		}
		if (badNum.length() % 3 == 0) {
			out.println(bigKahuna.substring(1));
		} else {
			out.println(bigKahuna);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
