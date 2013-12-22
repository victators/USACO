/*
ID: vxsj.fu1
LANG: JAVA
PROG: money
 */

import java.io.*;
import java.util.*;

public class money {

	int[] vals;
	long[][] ways;

	int maxxC(int n) {
		for (int i = 0; i < vals.length; i++) {
			if (n < vals[i]) {
				return i - 1;
			}
		}
		return vals.length - 1;
	}

	int min(int a, int b) {
		if (a > b) {
			return b;
		}
		return a;
	}

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("money.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"money.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int c = Integer.parseInt(st.nextToken());
		vals = new int[c + 1];
		int v = Integer.parseInt(st.nextToken());
		ways = new long[v + 1][c + 1];
		st = new StringTokenizer(f.readLine());
		for (int i = 1; i <= c; i++) {
			if (st.countTokens() == 0) {
				st = new StringTokenizer(f.readLine());
			}
			String temp = st.nextToken();
			if (temp == null) {
				break;
			}
			vals[i] = Integer.parseInt(temp);
		}
		Arrays.sort(vals);
		for (int i = 0; i <= c; i++) {
			ways[0][i] = 1;
		}
		for (int i = 1; i <= v; i++) {
			for (int j = 1; j <= c; j++) {
				if (i < vals[j]) {
					continue;
				} else if (i >= 2 * vals[j]) {
					ways[i][j] = ways[i][j - 1]
							+ ways[i - vals[j]][min(j, maxxC(i - vals[j]))];
				} else {
					ways[i][j] = ways[i][j - 1]
							+ ways[i - vals[j]][min(j - 1, maxxC(i - vals[j]))];
				}
			}
		}
		long max = 0;
		if (ways[v][c] == 0) {
			for (int i = 1; i <= c; i++) {
				if (ways[v][i] > max) {
					max = ways[v][i];
				}
			}
			ways[v][c] = max;
		}
		out.println(ways[v][c]);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		money prog = new money();
		prog.run();
	}
}
