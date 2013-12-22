/*
ID: vxsj.fu1
LANG: JAVA
PROG: hamming
 */

import java.io.*;
import java.util.*;

public class hamming {
	
	ArrayList<Integer> set;
	int bitL;
	
	int b2(int i) {
		int bit = 0;
		for (int j = bitL; j >= 0; j--) {
			int delta = (i / (int) Math.pow(2, j)) * (int) Math.pow(10, j);
			if (delta == 0) {
				continue;
			}
			bit += delta;
			i -= (int) Math.pow(2, j);
		}
		return bit;
	}
	
	int countOnes(int i)
	{
		int count = 0; 
		int num = (int) Math.pow(10, bitL-1);
		for (int j = 0; j < bitL; j++)
		{
			if(i/num == 1)
			{
				count++;
			}
			i %= num;
			num /= 10;
		}
		return count;
	}
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"hamming.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		set = new ArrayList<Integer>();
		bitL = b;
		set.add(0);
		for (int i = 1; i < (int)(Math.pow(2, b) + 0.5); i++)
		{
			if(set.size() == n)
			{
				break;
			}
			for (int j = 0; j < set.size(); j++)
			{
				if(countOnes(b2(i^set.get(j))) < d)
				{
					break;
				}
				if (j == set.size() - 1)
				{
					set.add(i);
				}
			}
		}
		for (int i = 1; i < set.size(); i++)
		{
			if (i%10 == 0)
			{
				out.println(set.get(i-1));
			}
			else
			{	
				out.print(set.get(i-1) + " ");
			}
		}
		out.println(set.get(set.size()-1));
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		hamming prog = new hamming();
		prog.run();
	}
}

