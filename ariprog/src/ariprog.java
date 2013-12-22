/*
ID: vxsj.fu1
LANG: JAVA
PROG: ariprog
 */

import java.io.*;
import java.util.*;

public class ariprog {

	void run() throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ariprog.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		int i2 = Integer.parseInt(st.nextToken());
		boolean[] hobag = new boolean[2 * i2 * i2 + 1];
		for (int i = 0; i <= i2; i++) {
			int t = i * i;
			for (int j = 0; j <= i2; j++) {
				hobag[t + j * j] = true;
			}
		}
		int arrayList[] = new int[30000];
		int index = 0;
		for (int i = 0; i < hobag.length; i++) {
			if (hobag[i]) {
				arrayList[index++] = i;
			}
		}
		boolean printed = false;
		for (int j = 1; j <= (2 * i2 * i2 + 1) / (i1 - 1); j++) {
			for (int i = 0; i < index; i++) {
				int a = arrayList[i];
				int b = a + (i1 - 1) * j;
				if (b >= hobag.length || hobag[b] == false) {
					continue;
				}
				for (int k = 1; k < i1; k++) {
					if (hobag[arrayList[i] + k*j] == false) {
						break;
					}
					if (k == i1 - 1) {
						out.println(a + " " + j);
						printed = true;
					}
				}
			}
		}
		if (printed != true) {
			out.println("NONE");
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static void main(String[] args) throws IOException {
		ariprog prog = new ariprog();
		prog.run();
	}
}