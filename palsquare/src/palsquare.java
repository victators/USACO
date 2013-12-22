/*
ID: vxsj.fu1
LANG: JAVA
PROG: palsquare
 */

import java.io.*;
import java.util.StringTokenizer;

public class palsquare {
	
	private static String baseRep(int k, int b)
	{
		String[] conv = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J"};
		String s = "";
		String reverse = "";
		while ( k >= b )
		{
			s+= conv[k%b];
			k = k/b;
		}
		s+= conv[k%b];
		for (int i = 1; i <= s.length(); i++)
		{
			reverse += s.charAt(s.length() - i);
		}
		return reverse;
	}
	
	private static boolean isPalindrome (String k)
	{
		String s = "";
		s += k;
		String reverse = "";
		for (int i = 1; i <= s.length(); i++)
		{
			reverse += s.charAt(s.length() - i);
		}
		if (s.equals(reverse))
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"palsquare.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= 300; i++) {
			if (isPalindrome(baseRep(i * i, i1))) {
				System.out.print(baseRep(i, i1) + " ");
				System.out.println(baseRep(i * i, i1));
			}
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}