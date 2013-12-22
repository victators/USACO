/*
ID: vxsj.fu1
LANG: JAVA
PROG: lineup
 */

import java.io.*;
import java.util.*;

public class lineup {
	
	public static boolean isValid(Pair[] cow, ArrayList<Long> milk, long start, long end)
	{
		for (int i = 0; i < milk.size(); i++)
		{
			int index = i;
			for (long j = start; j <= end; j++)
			{	
				if (milk.get(index) == cow[(int)j].y)
				{
					break;
				}
				if (j == end)
				{
					return false;
				}
			}
		}
		return true;
	}
	
	public static long getDistance (long a, long b)
	{
		return Math.abs(a-b);
	}
	
	public static Pair getNeighbor (Pair[] cow, long dist, long start)
	{
		for (int i = (int)start; i < cow.length; i++)
		{
			for (int j = i+1; j < cow.length; j++)
			if (getDistance(cow[i].x, cow[j].x) == dist)
			{
				return new Pair(i,j);
			}
		}
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("lineup.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"lineup.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());;
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken());
		Pair[] moo = new Pair[i1];
		TreeSet<Long> udder = new TreeSet<Long>();
		ArrayList<Long> copy = new ArrayList<Long>();
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			long tempX = Long.parseLong(st.nextToken());
			long tempY = Long.parseLong(st.nextToken());
			
			moo[i] = new Pair(tempX,tempY);
			udder.add(tempY);
		}
		Arrays.sort(moo);
		for (Long l : udder)
		{
			copy.add(l);		
		}
		if (copy.size() == 1)
		{
			PairComparator c = new PairComparator();
			Arrays.sort(moo, c);
			out.println(moo[0].x);
			out.close(); // close the output file
			System.exit(0); // don't omit this!
		}
		long startMark = 0;
		for (long distX = 1; distX < 1000000000; distX++)
		{
			startMark = 0;
			while (getNeighbor(moo, distX, startMark) != null)
			{
				Pair p = new Pair(getNeighbor(moo, distX, startMark).x, getNeighbor(moo, distX, startMark).y);
//				System.out.println(p.x + " " + p.y);
//				System.out.println(isValid(moo, copy, p.x, p.y));
				if (isValid(moo, copy, p.x, p.y))
				{
					
					System.out.println(Math.abs(moo[(int) p.x].x - moo[(int)p.y].x));
					out.close(); // close the output file
					System.exit(0); // don't omit this!
				}
				startMark = getNeighbor(moo, distX, startMark).x + 1;
//				System.out.println(startMark);
			}
			
		}
//		System.out.println(getDistance(moo[0].x, moo[2].x));
//		if(getNeighbor(moo, 3, 0) ==  null)
//		{
//			System.out.println("FUCK");
//		}
//		else
//		{
//			System.out.println(getNeighbor(moo, 3, 0).x + " " + getNeighbor(moo, 3, 0).y);  
//		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}


class Pair implements Comparable<Pair>
{
	long x,y;
	Pair(long x_,long y_)
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