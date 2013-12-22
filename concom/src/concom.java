/*
ID: vxsj.fu1
LANG: JAVA
PROG: concom
 */

import java.io.*;
import java.util.*;

public class concom {

	ArrayList<Integer>[] arr;
	int[][] table = new int[101][101];

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("concom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"concom.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int trips = Integer.parseInt(st.nextToken());
		arr = new ArrayList[101];
		for (int i = 1; i <= 100; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < trips; i++) {
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if (a == b) {
				continue;
			}
			if (p > 50) {
				arr[a].add(b);
			}
			table[a][b] = p;
		}
		int[] sum = new int[101];
		for (int i = 1; i <= 100; i++) {
			if (arr[i].size() == 0) {
				continue;
			}
			for (int k = 0; k < arr[i].size(); k++) {
				for (int j = 1; j <= 100; j++) {
					if (i == j) {
						continue;
					}
					if (arr[arr[i].get(k)].contains(j)) {
						if (!arr[i].contains(j)) {
							arr[i].add(j);
						}
						table[i][j] = 100;
					} else {
						sum[j] = table[i][j];
						sum[j] += table[arr[i].get(k)][j];
						if (sum[j] > 50) {
							if (!arr[i].contains(j)) {
								arr[i].add(j);
							}
						}
						table[i][j] = sum[j];
					}
				}
			}
			for (int p = 1; p <= 100; p++) {
				sum[p] = 0;
			}
		}
		for (int i = 1; i <= 100; i++) {
			if (arr[i].size() == 0) {
				continue;
			}
			Collections.sort(arr[i]);
			for (int j = 0; j < arr[i].size(); j++) {
				System.out.println(i + " " + arr[i].get(j));
			}
		}
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		concom prog = new concom();
		prog.run();
	}
}
