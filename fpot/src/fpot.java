/*
ID: vxsj.fu1
LANG: JAVA
PROG: fpot
 */

/*
ID: vxsj.fu1
LANG: JAVA
PROG: fpot
 */

import java.io.*;
import java.util.*;

class fpot {

	Pair pos[];
	int left;
	int right;
	int drops;
	int dist;
	TreeSet <Pair> t;
	
	boolean works (int w)
	{
		t = new TreeSet<Pair>();
		t.clear();
		left = 0;
		right = 0;
		while (left < pos.length)
		{
			while (right < pos.length && pos[right].x <= pos[left].x + w)
			{
				t.add(pos[right]);
				right++;
			}
			if (t.last().y - t.first().y >= dist)
			{
				return true;
			}
			t.remove(pos[left]);
			left++;
		}
		return false;
	}

	void run() throws Exception {
		drops = nextInt();
		dist = nextInt();
		pos = new Pair [drops];
		for (int i = 0; i < drops; i++)
		{
			int tempX = nextInt();
			int tempY = nextInt();
			pos[i] = new Pair(tempX, tempY);
		}
		PairComparator c = new PairComparator();
		Arrays.sort(pos, c);
		int low = 0;
		int high = 1000001;
		while (low + 1 < high)
		{
			int mid = (low + high - 1)/2;
			if (works(mid))
			{
				high = mid + 1;
			}
			else
			{
				low = mid + 1;
			}
		}

		out.println(low);
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new fpot("fpot.in", "fpot.out").run();
	}

	BufferedReader in;
	PrintStream out;
	StringTokenizer st;

	fpot() throws Exception {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = System.out;
	}

	fpot(String is, String os) throws Exception {
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
		if(a.x!=b.x)
            return a.x < b.x?-1:1;
		if(a.y!=b.y)
            return a.y < b.y?-1:1;
		return 0;
	}
}