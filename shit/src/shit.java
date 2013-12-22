/*
ID: vxsj.fu1
LANG: JAVA
PROG: shit
 */

import java.io.*;
import java.util.*;

class shit {
	public static void main(String[] args) throws IOException {

		String fileName = "shit.in";
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
		"shit.out")));
		double sum = 0;
		while (scan.hasNext()) {
			String one = scan.nextLine().trim();
//			int mark = one.lastIndexOf(".");
//			int j = mark - 1;
//			while (one.charAt(j) == '0' || one.charAt(j) == '1'
//					|| one.charAt(j) == '2' || one.charAt(j) == '3'
//					|| one.charAt(j) == '4' || one.charAt(j) == '5'
//					|| one.charAt(j) == '6' || one.charAt(j) == '7'
//						|| one.charAt(j) == '8' || one.charAt(j) == '9')
//			{
//				j--;
//			}
//			sum += Double.parseDouble(one.substring(j));
//			System.out.println(one.substring(j));
			String[] hax = one.split(" ", 0);
			sum += Double.parseDouble(hax[hax.length - 1]);
			out.println(hax[hax.length - 1]);
		}
		out.println("The total is: " +sum);
		out.close(); // close the output file
		System.exit(0); // don't omit this!

	}


}
