/*
ID: vxsj.fu1
LANG: JAVA
PROG: holstein
 */

import java.io.*;
import java.util.*;

public class holstein {

	int[] target;
	int[][] grid;
	int[] curr;
	int row;
	int col;
	int minScoops;
	ArrayList<Integer> list, bestL;
	
	void recur (int i)
	{
		if (i == row)
		{
			if(list.size() >= minScoops)
			{
				return;
			}
			for (int j = 0; j < col; j++)
			{	
				if (curr[j] < target[j])
				{
					return;
				}
			}
			bestL = new ArrayList(list);
			minScoops = list.size();
			return;
		}
		list.add(i);
		for (int j = 0; j < col; j++)
		{
			curr[j] += grid[i][j];
		}
		recur(i+1);
		list.remove(list.size()-1);
		for (int j = 0; j < col; j++)
		{
			curr[j] -= grid[i][j];
		}
		recur(i+1);
	}
	
	void run() throws IOException {

		BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"holstein.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		col = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		target = new int[col];
		curr = new int[col];
		list = new ArrayList<Integer>();
		bestL = new ArrayList<Integer>();
		for (int i = 0; i < col; i++)
		{
			target[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(f.readLine());
		row = Integer.parseInt(st.nextToken());
		grid = new int[row][col];
		for (int i = 0; i < row; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < col; j++)
			{
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		minScoops = 16;
		recur(0);
		out.print(minScoops);
		for (int i = 0; i < bestL.size(); i++)
		{
			out.print(" " + (bestL.get(i)+ 1));
		}
		out.println();
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		holstein prog = new holstein();
		prog.run();
	}
}
