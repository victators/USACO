/*
ID: vxsj.fu1
LANG: JAVA
PROG: gift1
 */

import java.io.*;
import java.util.*;

class gift1 {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		Map<String, Integer> bank = new HashMap<String, Integer>();
		String[] names = new String[i1];
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				String str = st.nextToken();
				bank.put(str, 0);

				names[i] = str;

			}
		}
		for (int j = 0; j < i1; j++) {
			st = new StringTokenizer(f.readLine());
			String temp = st.nextToken();
			int b = 0;
			for (int a = 0; a < i1; a++) {
				if (names[a].equals(temp)) {
					b = a;
					break;
				}
			}
			st = new StringTokenizer(f.readLine());
			int commerce = Integer.parseInt(st.nextToken());
			int associates = Integer.parseInt(st.nextToken());
			if (associates == 0) {
				bank.put(names[b], bank.get(names[b]) + commerce);
			} else {
				bank.put(names[b], bank.get(names[b]) + commerce % associates
						- commerce);
				for (int p = 0; p < associates; p++) {
					st = new StringTokenizer(f.readLine());
					String str = st.nextToken();
					bank.put(str, bank.get(str) + commerce / associates);
				}
			}
		}
		for (int q = 0; q < i1; q++) {
			out.println(names[q] + " " + bank.get(names[q]));
		}
		out.close();                                  // close the output file
	    System.exit(0);                              // don't omit this!
	}
}
