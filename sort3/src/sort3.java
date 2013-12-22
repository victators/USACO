/*
ID: vxsj.fu1
LANG: JAVA
PROG: sort3
 */

import java.io.*;
import java.util.*;

public class sort3 {
	
	int[] seq;
	int[] ord;
	Pair[] chng;
	
	boolean processTrip (Pair[] p)
	{
		boolean a = false;
		boolean b = false;
		int markA = 0;
		int markB = 0;
		for (int i = 0; i < p.length; i++)
		{
			if (a == false) {
				if (p[i].x == 1 && p[i].y == 2) {
					a = true;
					markA = i;
				}
			}
			if (b == false) {
				if (p[i].x == 2 && p[i].y == 1) {
					b = true;
					markB = i;
				}
			}
			if (a == true && b == true)
			{
				int temp = p[markA].y;
				p[markA].y = p[markB].y;
				p[markB].y = temp;
				return true;
			}
		}
		boolean c = false;
		boolean d = false;
		int markC = 0;
		int markD = 0;
		for (int i = 0; i < p.length; i++)
		{
			if (c == false) {
				if (p[i].x == 2 && p[i].y == 3) {
					c = true;
					markC = i;
				}
			}
			if (d == false) {
				if (p[i].x == 3 && p[i].y == 2) {
					d = true;
					markD = i;
				}
			}
			if (c == true && d == true)
			{
				int temp = p[markC].y;
				p[markC].y = p[markD].y;
				p[markD].y = temp;
				return true;
			}
		}
		boolean e = false;
		boolean f = false;
		int markE = 0;
		int markF = 0;
		for (int i = 0; i < p.length; i++)
		{
			if (e == false) {
				if (p[i].x == 1 && p[i].y == 3) {
					e = true;
					markE = i;
				}
			}
			if (f == false) {
				if (p[i].x == 3 && p[i].y == 1) {
					f = true;
					markF = i;
				}
			}
			if (e == true && f == true)
			{
				int temp = p[markE].y;
				p[markE].y = p[markF].y;
				p[markF].y = temp;
				return true;
			}
		}
		return false;
	}
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"sort3.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		seq = new int[num];
		ord = new int[num];
		chng = new Pair[num];
		for (int i = 0; i < num; i++)
		{
			chng[i] = new Pair(0,0);
		}
		int index = 0;
		for (int i = 0; i < num; i++)
		{
			st = new StringTokenizer(f.readLine());
			seq[i] = Integer.parseInt(st.nextToken());
			ord[i] = seq[i];
		}
		Arrays.sort(ord);
		for (int j = 0; j < num; j++)
		{
			if (ord[j] != seq[j])
			{
				chng[index] = new Pair(seq[j], ord[j]);
				index++;
			}
		}
		int count = 0;
		while (processTrip(chng) == true)
		{
			count++;
		}
		int x = 0;
		for (int i = 0; i < num; i++)
		{
			if (chng[i].x != chng[i].y)
			{
				x++;
			}
		}
		out.println(count + 2*x/3);
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		sort3 prog = new sort3();
		prog.run();
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
}

