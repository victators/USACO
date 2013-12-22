/*
ID: vxsj.fu1
LANG: JAVA
PROG: preface
 */

import java.io.*;
import java.util.*;

public class preface {

	char[] letters = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
	int[] count = { 0, 0, 0, 0, 0, 0, 0 };
	int[] roman = { 1, 5, 10, 50, 100, 500, 1000 };

	void process(int i) {
		if (i >= roman[6]) {
			count[6] += i / roman[6];
			i %= roman[6];
		}
		for (int j = 2; j >= 0; j--) {
			if (i >= roman[2 * j]) {
				if (i / roman[2 * j] < 4) {
					count[2 * j] += i / roman[2 * j];
				} else if (i / roman[2 * j] == 4) {
					count[2 * j]++;
					count[2 * j + 1]++;
				} else if (i / roman[2 * j] >= 5 && i / roman[2 * j] < 9) {
					count[2 * j + 1]++;
					count[2 * j] += i / roman[2 * j] - 5;
				} else if (i / roman[2 * j] == 9) {
					count[2 * j]++;
					count[2 * j + 2]++;
				}
				i %= roman[2 * j];
			}
		}
	}

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"preface.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int pgNum = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= pgNum; i++) {
			process(i);
		}
		for (int i = 0; i < 7; i++) {
			if (count[i] > 0) {
				out.println(letters[i] + " " + count[i]);
			}
		}
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		preface prog = new preface();
		prog.run();
	}
}
