/*
ID: vxsj.fu1
LANG: JAVA
PROG: maze1
 */

import java.io.*;
import java.util.*;

public class maze1 {

	int[][] map;
	ArrayList<Integer>[] graph;

	int b2(int i) {
		int bit = 0;
		for (int j = 3; j >= 0; j--) {
			int delta = (i / (int) Math.pow(2, j)) * (int) Math.pow(10, j);
			if (delta == 0) {
				continue;
			}
			bit += delta;
			i -= (int) Math.pow(2, j);
		}
		return bit;
	}

	boolean checkEast(int a, int b) {
		if ((a % 1000) / 100 == 0 && b % 1 == 0) {
			return true;
		}
		return false;
	}

	boolean checkSouth(int a, int b) {
		if (a / 1000 == 0 && (b % 100) / 10 == 0) {
			return true;
		}
		return false;
	}

	int min(int a, int b) {
		if (a < b) {
			return a;
		}
		return b;
	}

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"maze1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		String strLine;
		int[] exit = new int[2];
		int exitC = 0;
		int i1 = 0;
		while ((strLine = f.readLine()) != null) {
			if (i1 == 0) {
				for (int j = 0; j < w; j++) {
					if (strLine.charAt(2 * j + 1) == '-') {
						map[i1][j] += 2;
					} else {
						exit[exitC] = w * j + i1;
						exitC++;
					}
				}
			} else if (i1 == 2 * h) {
				for (int j = 0; j < w; j++) {
					if (strLine.charAt(2 * j + 1) == '-') {
						map[h - 1][j] += 8;
					} else {
						exit[exitC] = w * (h - 1) + j;
						exitC++;
					}
				}
			} else if (i1 % 2 == 0) {
				for (int j = 0; j < w; j++) {
					if (strLine.charAt(2 * j + 1) == '-') {
						map[i1 / 2 - 1][j] += 8;
						map[i1 / 2][j] += 2;
					}
				}
			} else {
				if (strLine.charAt(0) == ' ') {
					exit[exitC] = i1 / 2 * w;
					exitC++;
				} else {
					map[i1 / 2][0] += 1;
				}
				for (int j = 1; j <= w - 1; j++) {
					if (strLine.charAt(2 * j) == '|') {
						map[i1 / 2][j - 1] += 4;
						map[i1 / 2][j] += 1;
					}
				}
				if (strLine.charAt(2 * w) == ' ') {
					exit[exitC] = i1 / 2 * w + w - 1;
					exitC++;
				} else {
					map[i1 / 2][w - 1] += 4;
				}
			}
			i1++;
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = b2(map[i][j]);
			}
		}
		graph = new ArrayList[w * h];
		for (int p = 0; p < w * h; p++) {
			graph[p] = new ArrayList<Integer>();
		}
		for (int j = 0; j < w; j++) {
			for (int p = 0; p < h; p++) {
				if (j + 1 != w && checkEast(map[p][j], map[p][j + 1])) {
					graph[w * p + j].add(w * p + j + 1);
					graph[w * p + j + 1].add(w * p + j);
				}
				if (p + 1 != h && checkSouth(map[p][j], map[p + 1][j])) {
					graph[w * p + j].add(w * p + w + j);
					graph[w * p + w + j].add(w * p + j);
				}
			}
		}
//		for (int i = 0; i < w * h; i++) {
//			System.out.print(i + ": ");
//			for (int j = 0; j < graph[i].size(); j++) {
//				System.out.print(graph[i].get(j) + " ");
//			}
//			System.out.println();
//		}
		int[] dist = new int[w * h], prev = new int[w * h];
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(exit[0]);
		prev[exit[0]]=-2;
		dist[exit[0]]=0;
		int a = 0;
		while(!q.isEmpty())
		{
			a=q.poll();
			for(int b:graph[a])
			{
				if(prev[b]==-1)
				{
					prev[b]=a;
					dist[b]=dist[a]+1;
					q.add(b);
				}
			}
		}
		int x = dist[a];
		int[] dist1 = new int[w * h], prev1 = new int[w * h];
		LinkedList<Integer> q1 = new LinkedList<Integer>();
		q1.add(exit[1]);
		prev1[exit[1]]=-2;
		dist1[exit[1]]=0;
		a = 0;
		while(!q1.isEmpty())
		{
			a=q1.poll();
			for(int b:graph[a])
			{
				if(prev1[b]==-1)
				{
					prev1[b]=a;
					dist1[b]=dist1[a]+1;
					q1.add(b);
				}
			}
		}
		int y = dist1[a];

		System.out.println(y);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		maze1 prog = new maze1();
		prog.run();
	}
}
