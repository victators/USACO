/*
ID: vxsj.fu1

LANG: JAVA
PROG: packrec
 */

import java.io.*;
import java.util.*;

public class packrec {

	public static int max(int a, int b) {
		if (a > b) {
			return a;
		}
		else
		{	
			return b;
		}
	}

	public static int max(int a, int b, int c) {
		int x = max(a, b);
		return max(x, c);
	}

	public static int max(int a, int b, int c, int d) {
		int x = max(a, b);
		int y = max(x, c);
		return max(d, y);
	}

	public static Pair arr1(Pair[] pairs) {
		int length = pairs[0].x + pairs[1].x + pairs[2].x + pairs[3].x;
		int height = max(pairs[0].y, pairs[1].y, pairs[2].y, pairs[3].y);
		int area = height * length;
		return new Pair(area, area / max(height, length));
	}

	public static Pair arr2(Pair[] pairs) {
		int length = max(pairs[0].x + pairs[1].x + pairs[2].x, pairs[3].x);
		int height = max(pairs[0].y, pairs[1].y, pairs[2].y) + pairs[3].y;
		int area = height * length;
		return new Pair(area, area / max(height, length));
	}

	public static Pair arr3(Pair[] pairs) {
		int length = max(pairs[0].x + pairs[1].x, pairs[2].x) + pairs[3].x;
		int height = max(pairs[0].y + pairs[2].y, pairs[1].y + pairs[2].y,
				pairs[3].y);
		int area = height * length;
		return new Pair(area, area / max(height, length));
	}

	public static Pair arr4(Pair[] pairs) {
		int length = pairs[0].x + max(pairs[1].x, pairs[2].x) + pairs[3].x;
		int height = max(pairs[0].y, pairs[1].y + pairs[2].y, pairs[3].y);
		int area = height * length;
		return new Pair(area, area / max(height, length));
	}

	public static Pair arr5(Pair[] pairs) {
		int length = max(pairs[0].x, pairs[1].x) + pairs[2].x + pairs[3].x;
		int height = max(pairs[0].y + pairs[1].y, pairs[2].y, pairs[3].y);
		int area = height * length;
		return new Pair(area, area / max(height, length));
	}

	public static Pair arr6(Pair[] pairs) {
		int length = 1000000;
		if (pairs[2].y > pairs[0].y + pairs[1].y) {
			length = max(pairs[3].x, pairs[2].x + max(pairs[0].x, pairs[1].x));
		}
		if (pairs[2].y > pairs[1].y && pairs[2].y < pairs[0].y + pairs[1].y) {
			length = max(pairs[0].x+ pairs[3].x,  pairs[2].x + max(pairs[0].x, pairs[1].x));
		}
		if (pairs[1].y > pairs[2].y && pairs[1].y < pairs[2].y + pairs[3].y) {
			length = max(pairs[3].x + pairs[0].x, pairs[1].x
					+ max(pairs[3].x, pairs[2].x));
		}
		if (pairs[1].y > pairs[2].y + pairs[3].y) {
			length = max(pairs[0].x, pairs[1].x + max(pairs[3].x, pairs[2].x));
		}
		if (pairs[1].y == pairs[2].y) {
			length = max(pairs[3].x + pairs[0].x, pairs[1].x + pairs[2].x);
		}
		int height = max(pairs[0].y + pairs[1].y, pairs[3].y + pairs[2].y);
		int area = height * length;
		return new Pair(area, area / max(height, length));

	}

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("packrec.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"packrec.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st;
		// Get line, break into tokens
		Pair[] rect = new Pair[4];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(f.readLine());
			int tempX = Integer.parseInt(st.nextToken());
			int tempY = Integer.parseInt(st.nextToken());
			rect[i] = new Pair(tempX, tempY);

		}
		ArrayList<Pair[]> perms = new ArrayList<Pair[]>();
		perms.add(0, new Pair[] { rect[0], rect[1], rect[2], rect[3] });
		perms.add(1, new Pair[] { rect[0], rect[1], rect[3], rect[2] });
		perms.add(2, new Pair[] { rect[0], rect[2], rect[1], rect[3] });
		perms.add(3, new Pair[] { rect[0], rect[2], rect[3], rect[1] });
		perms.add(4, new Pair[] { rect[0], rect[3], rect[1], rect[2] });
		perms.add(5, new Pair[] { rect[0], rect[3], rect[2], rect[1] });
		perms.add(6, new Pair[] { rect[1], rect[0], rect[2], rect[3] });
		perms.add(7, new Pair[] { rect[1], rect[0], rect[3], rect[2] });
		perms.add(8, new Pair[] { rect[1], rect[2], rect[0], rect[3] });
		perms.add(9, new Pair[] { rect[1], rect[2], rect[3], rect[0] });
		perms.add(10, new Pair[] { rect[1], rect[3], rect[0], rect[2] });
		perms.add(11, new Pair[] { rect[1], rect[3], rect[2], rect[0] });
		perms.add(12, new Pair[] { rect[2], rect[0], rect[1], rect[3] });
		perms.add(13, new Pair[] { rect[2], rect[0], rect[3], rect[1] });
		perms.add(14, new Pair[] { rect[2], rect[1], rect[0], rect[3] });
		perms.add(15, new Pair[] { rect[2], rect[1], rect[3], rect[0] });
		perms.add(16, new Pair[] { rect[2], rect[3], rect[0], rect[1] });
		perms.add(17, new Pair[] { rect[2], rect[3], rect[1], rect[0] });
		perms.add(18, new Pair[] { rect[3], rect[0], rect[1], rect[2] });
		perms.add(19, new Pair[] { rect[3], rect[0], rect[2], rect[1] });
		perms.add(20, new Pair[] { rect[3], rect[1], rect[0], rect[2] });
		perms.add(21, new Pair[] { rect[3], rect[1], rect[2], rect[0] });
		perms.add(22, new Pair[] { rect[3], rect[2], rect[0], rect[1] });
		perms.add(23, new Pair[] { rect[3], rect[2], rect[1], rect[0] });
		Pair[] tempArr = new Pair[6];
		ArrayList<Pair> minArr = new ArrayList<Pair>();
		Pair minPair = new Pair(10000, 200);
		minArr.add(minPair);
		for (int d1 = 0; d1 <= 1; d1++) {
			for (int d2 = 0; d2 <= 1; d2++) {
				for (int d3 = 0; d3 <= 1; d3++) {
					for (int d4 = 0; d4 <= 1; d4++) {
						for (int i = 0; i < 24; i++) {

							Pair x1 = new Pair(perms.get(i)[0].x,
									perms.get(i)[0].y);
							if (d1 > 0) {
								x1 = new Pair(x1.y, x1.x);
							}
							Pair x2 = new Pair(perms.get(i)[1].x,
									perms.get(i)[1].y);
							if (d2 > 0) {
								x2 = new Pair(x2.y, x2.x);
							}
							Pair x3 = new Pair(perms.get(i)[2].x,
									perms.get(i)[2].y);
							if (d3 > 0) {
								x3 = new Pair(x3.y, x3.x);
							}
							Pair x4 = new Pair(perms.get(i)[3].x,
									perms.get(i)[3].y);
							if (d4 > 0) {
								x4 = new Pair(x4.y, x4.x);
							}
							tempArr[0] = arr1(new Pair[] {x1,x2,x3,x4});
							tempArr[1] = arr2(new Pair[] {x1,x2,x3,x4});
							tempArr[2] = arr3(new Pair[] {x1,x2,x3,x4});
							tempArr[3] = arr4(new Pair[] {x1,x2,x3,x4});
							tempArr[4] = arr5(new Pair[] {x1,x2,x3,x4});
							tempArr[5] = arr6(new Pair[] {x1,x2,x3,x4});
							Arrays.sort(tempArr);
							Pair p = tempArr[0];
							if (p.x < minPair.x) {
								minPair.x = p.x;
								minArr.clear();
								minArr.add(p);
								int c = 1;
								while (tempArr[c].x == tempArr[c - 1].x) {
									if (!(minArr.contains(tempArr[c]))) {
										minArr.add(tempArr[c]);
									}
									c++;
								}
							} else if (tempArr[0].x == minPair.x) {
								if (!(minArr.contains(p))) {

									minArr.add(p);
									int c = 1;
									while (tempArr[c].x == tempArr[c - 1].x) {
										if (!(minArr.contains(tempArr[0]))) {
											minArr.add(tempArr[c]);
										}
										c++;
									}
								}
							}
						}
					}
				}
			}
		}
		TreeSet<Pair> johnny = new TreeSet<Pair>();
		for (int k = 0; k < minArr.size(); k++) {
			johnny.add(minArr.get(k));
		}
		PairComparator c = new PairComparator();
		Pair[] minArea = new Pair[johnny.size()];
		int count = 0;
		for (Pair p: johnny) {
			minArea[count] = p;
			count++;
		}
		Arrays.sort(minArea, c);
		out.println(minArea[0].x);
		for (Pair q : minArea) {
			out.println(q.y + " " + minArea[0].x / q.y);
		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
class Pair implements Comparable<Pair>
{
	int x,y;
	Pair(int x_,int y_)
	{
		x=x_;
		y=y_;
	}
	
	
	
	public Pair() {
		// TODO Auto-generated constructor stub
	}



	public int compareTo(Pair o)
	{
		if(x!=o.x)
            return x < o.x?-1:1;
		if(y!=o.y)
            return y < o.y?-1:1;
		return 0;
	}
	
	
}

class PairComparator implements Comparator<Pair>
{

	@Override
	public int compare(Pair a, Pair b) {
		if(a.y!=b.y)
            return a.y < b.y?-1:1;
		if(a.x!=b.x)
            return a.x < b.x?-1:1;
		return 0;
	}
	
}

