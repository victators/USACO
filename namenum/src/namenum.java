/*
ID: vxsj.fu1
LANG: JAVA
PROG: namenum
 */

import java.io.*;
import java.util.StringTokenizer;

public class namenum {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"namenum.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		String key = (st.nextToken()); // first integer
		BufferedReader vampire = new BufferedReader(new FileReader("dict.txt"));
		boolean none = false;
		for (int j = 0; j < 4617; j++) {
			StringTokenizer cheese = new StringTokenizer(vampire.readLine());
			if (cheese.hasMoreTokens()) {
				String temp = cheese.nextToken();
				String decode = "";
				for (int i = 0; i < temp.length(); i++) {
					if (temp.charAt(i) == 'A' || temp.charAt(i) == 'B'
							|| temp.charAt(i) == 'C') {
						decode += 2;
					} else if (temp.charAt(i) == 'D' || temp.charAt(i) == 'E'
							|| temp.charAt(i) == 'F') {
						decode += 3;
					} else if (temp.charAt(i) == 'G' || temp.charAt(i) == 'H'
							|| temp.charAt(i) == 'I') {
						decode += 4;
					} else if (temp.charAt(i) == 'J' || temp.charAt(i) == 'K'
							|| temp.charAt(i) == 'L') {
						decode += 5;
					} else if (temp.charAt(i) == 'M' || temp.charAt(i) == 'N'
							|| temp.charAt(i) == 'O') {
						decode += 6;
					} else if (temp.charAt(i) == 'P' || temp.charAt(i) == 'R'
							|| temp.charAt(i) == 'S') {
						decode += 7;
					} else if (temp.charAt(i) == 'T' || temp.charAt(i) == 'U'
							|| temp.charAt(i) == 'V') {
						decode += 8;
					} else {
						decode += 9;
					}
				}
				if (decode.equals(key)) {
				out.println(temp);
				none = true;
			}
		}
		}
		if (none == false)
		{
			out.println("NONE");
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}