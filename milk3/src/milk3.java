/*
ID: vxsj.fu1
LANG: JAVA
PROG: milk3
 */

import java.io.*;
import java.util.*;

public class milk3 {
	
	boolean[] visited = new boolean[21*21*21];
	TreeSet<Integer> solutions = new TreeSet<Integer>();
	
	int[] pour (int[] tres, int capa, int give, int receive)
	{
		int[] copy = new int[3];
		for (int i = 0; i < 3; i++)
		{
			copy[i] = tres[i];
		}
		if (copy[receive] == capa)
		{	
			return copy;
		}
		if (copy[give] == 0)
		{
			return copy;
		}
		if (copy[receive] + copy[give] <= capa)
		{
			copy[receive] += copy[give];
			copy[give] = 0;
			return copy;
		}
		else
		{
			int temp = copy[receive];
			copy[receive] = capa;
			copy[give] -= capa - temp;
			return copy;
		}
	}
	
	void recur (int[] three, int capaA, int capaB, int capaC)
	{
		int index = 21*21*three[0] + 21*three[1] + three[2];
		if (visited[index] == true)
		{
			return;
		}
		else
		{
			visited[index] = true;
			if (three[0] == 0)
			{
				solutions.add(three[2]);
			}
			recur(pour(three, capaA, 1, 0), capaA, capaB, capaC);
			recur(pour(three, capaA, 2, 0), capaA, capaB, capaC);
			recur(pour(three, capaB, 0, 1), capaA, capaB, capaC);
			recur(pour(three, capaB, 2, 1), capaA, capaB, capaC);
			recur(pour(three, capaC, 0, 2), capaA, capaB, capaC);
			recur(pour(three, capaC, 1, 2), capaA, capaB, capaC);
		}
	}
	
	void run() throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"milk3.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] init = new int[3];
		init[0] = 0;
		init[1] = 0;
		init[2] = C;
		recur(init, A, B, C);
		int[] sols = new int[solutions.size()];
		int count = 0;
		for (Integer i : solutions) {
			sols[count] = i;
			count++;
		}
		Arrays.sort(sols);
		for (int i = 0; i < sols.length - 1; i++) {
			out.print(sols[i] + " ");
		}
		out.println(sols[sols.length - 1]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	public static void main(String[] args) throws IOException {
		milk3 prog = new milk3();
		prog.run();
	}
}
