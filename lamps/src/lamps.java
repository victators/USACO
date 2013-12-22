/*
ID: vxsj.fu1
LANG: JAVA
PROG: lamps
 */

import java.io.*;
import java.util.*;

public class lamps {

	int[] end;
	int[] l;
	int numLamps;
	int count = 0;
	ArrayList<String>[] arr;
	String[] sol;
	
	void reset (int[] list)
	{
		for (int i = 0; i < numLamps; i++)
		{
			list[i] = 1;
		}
	}
	
	void process (String i)
	{
		for (int j = 0; j < 4; j++)
		{
			if (i.charAt(j) == '1')
			{
				push(j+1);
			}
		}
	}
	
	boolean isValid()
	{
		for (int i = 0; i < numLamps; i++)
		{
			if (end[i] == 41 && l[i] == 0)
			{
				return false;
			}
			else if (end[i] == 3 && l[i] == 1)
			{
				return false;
			}
		}
		return true;
	}
	
	void push(int i) {
		if (i == 1) {
			for (int j = 0; j < numLamps; j++) {
				if (l[j] == 1) {
					l[j] = 0;
				} else if (l[j] == 0) {
					l[j] = 1;
				}
			}
		} else if (i == 2) {
			for (int j = 0; j < numLamps; j += 2) {
				if (l[j] == 1) {
					l[j] = 0;
				} else if (l[j] == 0) {
					l[j] = 1;
				}
			}
		} else if (i == 3) {
			for (int j = 1; j < numLamps; j += 2) {
				if (l[j] == 1) {
					l[j] = 0;
				} else if (l[j] == 0) {
					l[j] = 1;
				}
			}
		} else if (i == 4) {
			for (int j = 0; j < numLamps; j += 3) {
				if (l[j] == 1) {
					l[j] = 0;
				} else if (l[j] == 0) {
					l[j] = 1;
				}
			}
		}
	}

	void run() throws IOException {

		BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"lamps.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int lamps = Integer.parseInt(st.nextToken());
		end = new int[lamps];
		l = new int[lamps];
		sol = new String[100];
		for (int i = 0; i < sol.length; i++)
		{
			sol[i] = "0";
		}
		numLamps = lamps;
		for (int i = 0; i < lamps; i++) {
			l[i] = 1;
		}
		st = new StringTokenizer(f.readLine());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		for (int j = 0; j < lamps; j++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == -1) {
				break;
			}
			end[temp-1] = 41;
		}
		st = new StringTokenizer(f.readLine());
		for (int j = 0; j < lamps; j++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == -1) {
				break;
			}
			end[temp - 1] = 3;
		}
		arr = new ArrayList[5];
		arr[0] = new ArrayList<String>(1);
		arr[1] = new ArrayList<String>(4);
		arr[2] = new ArrayList<String>(6);
		arr[3] = new ArrayList<String>(4);
		arr[4] = new ArrayList<String>(1);
		arr[0].add("0000");
		arr[1].add("0001");
		arr[1].add("0010");
		arr[1].add("0100");
		arr[1].add("1000");
		arr[2].add("0011");
		arr[2].add("0101");
		arr[2].add("0110");
		arr[2].add("1001");
		arr[2].add("1010");
		arr[2].add("1100");
		arr[3].add("0111");
		arr[3].add("1011");
		arr[3].add("1101");
		arr[3].add("1110");
		arr[4].add("1111");
		if (c < 4)
		{
			for (int i = c%2; i <= c; i+=2)
			{
				for (int k = 0; k < arr[i].size(); k++)
				{
					process(arr[i].get(k));
					if (isValid())
					{
						String s = "";
						for (int j = 0; j < numLamps; j++)
						{
							s += l[j];
						}
						sol[count] = s;
						count++;
					}
					reset(l);
				}
			}
		}
		else
		{
			for (int i = c%2; i <= 4; i+=2)
			{
				for (int k = 0; k < arr[i].size(); k++)
				{
					process(arr[i].get(k));
					if (isValid())
					{
						String s = "";
						for (int j = 0; j < numLamps; j++)
						{
							s += l[j];
						}
						sol[count] = s;
						count++;
					}
					reset(l);
				}
			}
		}
		boolean printed = false;
		Arrays.sort(sol);
		for (int i = 0; i < sol.length; i++)
		{
			if (!(sol[i].equals("0")))
			{	
				printed = true;
				out.println(sol[i]);
			}
		}
		if (!printed)
		{
			out.println("IMPOSSIBLE");
		}
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		lamps prog = new lamps();
		prog.run();
	}
}
