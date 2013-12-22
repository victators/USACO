/*
ID: vxsj.fu1
LANG: JAVA
PROG: badrand
 */

import java.io.*;
import java.util.*;

class badrand {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("badrand.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"badrand.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		ArrayList squares = new ArrayList<Integer>(10000);
		int mark = 0;
		i1 = middleSquare(i1);
		while (i1 > 0)
		{
			if (squares.contains(i1))
			{
				squares.add(i1);
				squares.set(squares.indexOf(i1), 10000);
				mark = i1;
				i1 = 0;
			}
			else
			{
				squares.add(i1);
				i1 = middleSquare(i1);
			}
		}
		squares.add(10000);
		squares.add(0);
		out.println(squares.indexOf(mark)+ 1);
		out.close(); // close the output file
		System.exit(0); // don't omit this!

	}

	public static int middleSquare(int random) {
		random %= 1000;
		int a = random / 100;
		random %= 100;
		int b = random / 10;
		int middle = 10 * a + b;
		return middle * middle;
	}

}
