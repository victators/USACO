/*
ID: vxsj.fu1
LANG: JAVA
PROG: landscape
 */

import java.io.*;
import java.util.*;

public class landscape {
	int mem[][];
	int n;
	int costadd, costsub, costmove;
	int dif[];

	int dp(int i, int remain) { // state is mem[i][remain + 1005]
		if (mem[i][remain + 1005] != -1)
			return mem[i][remain + 1005];

		int inc = costmove * Math.abs(remain); // always add the amount of cost
												// needed to move dirt to here
		int ans;
		if (i == n) {
			if (remain == 0)
				ans = 0;
			if (remain > 0)
				ans = costsub * remain;
			else
				ans = costadd * -remain;
		} else {
			int cur = dif[i];
			if (cur == 0) {
				ans = dp(i + 1, remain);
			} else if (cur < 0) { // too little
				cur = -cur;

				ans = 1 << 29;
				for (int add = 0; add <= cur; add++) {
					ans = Math.min(ans, dp(i + 1, remain - (cur - add)) + add
							* costadd);
				}
			} else { // too much
				ans = 1 << 29;
				for (int sub = 0; sub <= cur; sub++) {
					ans = Math.min(ans, dp(i + 1, remain + (cur - sub)) + sub
							* costsub);
				}
			}
		}
		return mem[i][remain + 1005] = ans + inc;
	}

	void run() throws Exception {
		mem = new int[110][2010];
		for (int[] arr : mem) {
			Arrays.fill(arr, -1);
		}

		n = nextInt();
		costadd = nextInt();
		costsub = nextInt();
		costmove = nextInt();
		dif = new int[n];

		for (int i = 0; i < n; i++) {
			int a = nextInt();
			int b = nextInt();
			dif[i] = a - b;
		}

		out.println(dp(0, 0));

		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new landscape("landscape.in", "landscape.out").run();
	}

	BufferedReader in;
	PrintStream out;
	StringTokenizer st;

	landscape() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = System.out;
	}

	landscape(String is, String os) throws Exception {
		in = new BufferedReader(new FileReader(new File(is)));
		out = new PrintStream(new File(os));
	}

	int nextInt() throws Exception {
		return Integer.parseInt(next());
	}

	String next() throws Exception {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
}
