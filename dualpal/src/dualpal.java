/*
ID: vxsj.fu1
LANG: JAVA
PROG: dualpal
 */

import java.io.*;
import java.util.StringTokenizer;

public class dualpal {
	
	private static String baseRep(int k, int b)
	{
		
		String s = "";
		String reverse = "";
		while ( k >= b )
		{
			s+= k%b;
			k = k/b;
		}
		s+= k%b;
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
	
	private static boolean dualPalindrome (int k)
	{
		int count = 0;
		for (int i = 2; i <= 10; i++) {
			if (isPalindrome(baseRep(k, i))) {
				count++;
			}
			if (count == 2) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"dualpal.out")));
		// Use SringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int i2 = Integer.parseInt(st.nextToken());
		int count = 0;
		while (count < i1)
		{
			if (dualPalindrome(i2 + 1) == true)
			{
				out.println(i2 + 1);
				i2++;
				count++;
			}
			else
			{
				i2++;
			}
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}