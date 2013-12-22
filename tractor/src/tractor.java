/*
ID: vxsj.fu1
LANG: JAVA
PROG: tractor
 */

import java.io.*;
import java.util.*;

class tractor {
	public static final int movex[] = { -1, 0, 1, 0 };
	public static final int movey[] = { 0, -1, 0, 1 };

	boolean hasbale[][];
	int mind[][];

	boolean inside(Pair p) {
		return p.x >= 0 && p.x < 1010 && p.y >= 0 && p.y < 1010;
	}

	void run() throws Exception {
		hasbale = new boolean[1010][1010];
		mind = new int[1010][1010];
		for (int[] arr : mind) {
			Arrays.fill(arr, 999999);
		}

		int n = nextInt();
		int startx = nextInt();
		int starty = nextInt();

		for (int i = 0; i < n; i++) {
			int x = nextInt();
			int y = nextInt();
			hasbale[x][y] = true;
		}

		Deque<Pair> list = new LinkedList<Pair>();
		mind[startx][starty] = 0;
		list.addLast(new Pair(startx, starty));

		while (!list.isEmpty()) {
			Pair cur = list.getFirst();
			int curd = mind[cur.x][cur.y];
			list.removeFirst();

			for (int i = 0; i < 4; i++) {
				Pair nxt = new Pair(cur.x + movex[i], cur.y + movey[i]);
				if (inside(nxt)) {
					if (mind[nxt.x][nxt.y] == 999999) {
						if (hasbale[nxt.x][nxt.y]) {
							mind[nxt.x][nxt.y] = curd + 1;
							list.addLast(nxt);
						} else {
							mind[nxt.x][nxt.y] = curd;
							list.addFirst(nxt);
						}
					}
				}
			}
		}

		out.println(mind[0][0]);

		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new tractor("tractor.in", "tractor.out").run();
	}

	BufferedReader in;
	PrintStream out;
	StringTokenizer st;

	tractor() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = System.out;
	}

	tractor(String is, String os) throws Exception {
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

class Pair {
	int x, y;

	Pair(int X, int Y) {
		x = X;
		y = Y;
	}
}
