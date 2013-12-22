/*
ID: vxsj.fu1
LANG: JAVA
PROG: umbrella
 */

import java.io.*;
import java.util.*;

public class umbrella {
	long[] best;
	int[] cow;
	int[] umb;
	int inf = 10000000;

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("umbrella.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"umbrella.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int umbs = Integer.parseInt(st.nextToken());
		best = new long[cows];
		cow = new int[cows];
		umb = new int[umbs];
		for (int i = 0; i < cows; i++) {
			st = new StringTokenizer(f.readLine());
			cow[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cow);
		for (int j = 0; j < umbs; j++) {
			st = new StringTokenizer(f.readLine());
			umb[j] = Integer.parseInt(st.nextToken());
		}
		int smooth = umb[umbs - 1];
		for (int i = umb.length - 1; i >= 0; i--) {
			if (umb[i] > smooth) {
				umb[i] = smooth;
			}
			if (umb[i] < smooth) {
				smooth = umb[i];
			}
		}
		for (int i = 0; i < cows; i++) {
			best[i] = umb[cow[i] - cow[0]];
			for (int k = 1; k <= i; k++) {
				if (best[k - 1] + umb[cow[i] - cow[k]] < best[i]) {
					best[i] = best[k - 1] + umb[cow[i] - cow[k]];
				}
			}
		}
		out.println(best[cows - 1]);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		umbrella prog = new umbrella();
		prog.run();
	}
}
