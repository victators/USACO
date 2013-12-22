/*
ID: vxsj.fu1
LANG: JAVA
PROG: prefix
 */

import java.io.*;
import java.util.*;

public class prefix {

	boolean[] dp;

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"prefix.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		Set<String> l = new HashSet<String>();
		for (int i = 0; i < 200; i++) {
			if (st.countTokens() == 0) {
				st = new StringTokenizer(f.readLine());
			}
			String temp = st.nextToken();
			if (temp.equals(".")) {
				break;
			}
			l.add(temp);

		}
		String next;
		StringBuffer muscle = new StringBuffer();
		while ((next = f.readLine()) != null) {
			if (next.equals(".")) {
				continue;
			}
			muscle.append(next);
		}
		String s = muscle.toString().trim();
		dp = new boolean[200001];
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < i + 10; j++) {
				if (j >= s.length()) {
					break;
				}
				if (l.contains(s.substring(i, j + 1))) {

					if (i == 0) {
						dp[j] = true;
					} else {
						if (dp[j] == true) {
							continue;
						}
						dp[j] = dp[i - 1];
					}
				}
			}
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] == true) {
				max = i + 1;
			}
		}
		out.println(max);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		prefix prog = new prefix();
		prog.run();
	}
}
