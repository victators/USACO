/*
ID: vxsj.fu1
LANG: JAVA
PROG: nocows
 */

import java.io.*;
import java.util.*;

public class nocows {

	int[][] tree;

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"nocows.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int nodeCount = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		tree = new int[nodeCount + 1][h + 1];
		tree[1][1] = 1;
		tree[3][2] = 1;
		for (int i = 3; i <= nodeCount; i += 2) {
			for (int j = 2; j <= h; j++) {
				if (i == (int) (Math.pow(2, j) + 0.5) - 1) {
					tree[i][j] = 1;
				} else if (i > (int) (Math.pow(2, j) + 0.5) - 1) {
					tree[i][j] = 0;
				} else {
					for (int p = i - 2; p >= 2 * j - 3; p -= 2) {

						for (int q = 1; q <= (i - p) / 2; q++) {
							if (p < (i - 1) / 2 && q == j - 1) {
								break;
							} else if (q > j - 1) {
								break;
							} else if (p == i - p - 1 && j - 1 == q) {
								tree[i][j] += tree[p][j - 1]
										* (tree[i - p - 1][q]);
								tree[i][j] %= 9901;

							} else {
								tree[i][j] += 2 * tree[p][j - 1]
										* tree[i - p - 1][q];
								tree[i][j] %= 9901;
							}
						}
					}
				}
			}
		}
		out.println(tree[nodeCount][h]);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		nocows prog = new nocows();
		prog.run();
	}
}
