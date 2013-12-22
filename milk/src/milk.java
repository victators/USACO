/*
ID: vxsj.fu1
LANG: JAVA
PROG: milk
 */

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class milk {
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken()); // first integer
		int[] price = new int[i2];
		int[] quantity = new int [i2];
		Map<Integer, Integer> pairs = new TreeMap<Integer,Integer>();
		for (int i = 0; i < i2; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				price[i] = Integer.parseInt(st.nextToken());
				quantity[i] = Integer.parseInt(st.nextToken());
			}
			if (!pairs.containsKey(price[i]))
			{	
				pairs.put(price[i], i);
			}
			else
			{
				quantity[pairs.get(price[i])] += quantity[i];
			}
		}
		Arrays.sort(price);
		int milkCount = 0;
		int milkCost = 0;
		int counter = 0;
		while (milkCount < i1)
		{
			while (quantity[pairs.get(price[counter])] == 0)
			{
				counter++;
			}
			milkCost += price[counter];
			quantity[pairs.get(price[counter])] --;
			milkCount += 1;
		}
		out.println(milkCost);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
