/*
ID: vxsj.fu1
LANG: JAVA
PROG: ride
 */


import java.io.*;
import java.util.*;

class ride {

	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		String i1 = st.nextToken(); // first string
		st = new StringTokenizer(f.readLine());
		String i2 = st.nextToken(); // second string
		int product1 = 1;
		int product2 = 1;

	
		for (int i = 0; i < i1.length(); i++) {
			Character temp = i1.charAt(i);
			product1 *= (temp.hashCode() - 64);
		}
		for (int j = 0; j < i2.length(); j++) {
			Character temp = i2.charAt(j);
			product2 *= (temp.hashCode() - 64);
		}
		
		System.out.println(product2);
		if (product1 % 47 == product2 % 47) {
			out.println("GO");
		} else {
			out.println("STAY");
		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
