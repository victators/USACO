/*
ID: vxsj.fu1
LANG: JAVA
PROG: planting
 */

import java.io.*;
import java.util.*;

public class planting {

	long[] c = new long[2501];
	rect[] r = new rect[10001];

	int intersect(rect a, rect b, rect[] out) {
		if (b.x2 < a.x1 || b.x1 >= a.x2)
			return 0;
		if (b.y2 < a.y1 || b.y1 >= a.y2)
			return 0;
		rect t;
		if (b.x1 <= a.x1 && b.x2 >= a.x2 && b.y1 <= a.y1 && b.y2 >= a.y2)
			return -1;
		int nout = 0;
		if (b.x1 >= a.x1) {
			t = a;
			t.x2 = b.x1;
			if (t.x1 != t.x2)
				out[nout++] = t;
			a.x1 = b.x1;
		}
		if (b.x2 < a.x2) {
			t = a;
			t.x1 = b.x2;
			if (t.x1 != t.x2)
				out[nout++] = t;
			a.x2 = b.x2;
		}
		if (b.y1 >= a.y1) {
			t = a;
			t.y2 = b.y1;
			if (t.y1 != t.y2)
				out[nout++] = t;
			a.y1 = b.y1;
		}
		if (b.y2 < a.y2) {
			t = a;
			t.y1 = b.y2;
			if (t.y1 != t.y2)
				out[nout++] = t;
			a.y2 = b.y2;
		}
		return nout;
	}

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("planting.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"planting.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		r[0].c = 1;
		r[0].x1 = -200000000;
		r[0].y1 = -200000000;
		r[0].x2 = 200000000;
		r[0].y2 = 200000000;
		rect[] t = new rect[4];
		int i, j, rr = 1;
		for (i = 0; i < n; i++) {
			int tmp;
			st = new StringTokenizer(f.readLine());
			r[rr].x1 = Integer.parseInt(st.nextToken());
			r[rr].y1 = Integer.parseInt(st.nextToken());
			r[rr].x2 = Integer.parseInt(st.nextToken());
			r[rr].y2 = Integer.parseInt(st.nextToken());
			r[rr].c = 2;

			if (r[rr].x1 > r[rr].x2) {
				tmp = r[rr].x1;
				r[rr].x1 = r[rr].x2;
				r[rr].x2 = tmp;
			}
			if (r[rr].y1 > r[rr].y2) {
				tmp = r[rr].y1;
				r[rr].y1 = r[rr].y2;
				r[rr].y2 = tmp;
			}

			int nr = rr;
			rect curr = r[rr++];
			for (j = 0; j < nr; j++) {
				int p = intersect(r[j], curr, t);
				if (p == 0)
					continue;
				if (n == -1) {
					memmove(r + j, r + j + 1, sizeof(rect) * (rr - j - 1));
					j--;
					rr--;
					nr--;
					continue;
				}
				r[j] = t[--n];
				for (; n-- > 0;)
					r[rr++] = t[n];
			}
		}
		for (i = 0; i < rr; i++)
			c[r[i].c] += (long) (r[i].x2 - r[i].x1) * (r[i].y2 - r[i].y1);
		System.out.println(c[2]);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		planting prog = new planting();
		prog.run();
	}

	class rect implements Comparable<rect> {
		int c, x1, y1, x2, y2;

		rect(int c_, int x1_, int y1_, int x2_, int y2_) {
			c = c_;
			x1 = x1_;
			y1 = y1_;
			x2 = x2_;
			y2 = y2_;
		}

		@Override
		public int compareTo(rect o) {
			if (c != o.c)
				return c < o.c ? -1 : 1;
			if (x1 != o.x1)
				return x1 < o.x1 ? -1 : 1;
			if (x2 != o.x2)
				return x2 < o.x2 ? -1 : 1;
			if (y1 != o.y1)
				return y1 < o.y1 ? -1 : 1;
			if (y2 != o.y2)
				return y2 < o.y2 ? -1 : 1;
			return 0;
		}
	}
}
