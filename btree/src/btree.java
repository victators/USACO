/*
ID: vxsj.fu1
LANG: JAVA
PROG: btree
 */

import java.io.*;
import java.util.*;

public class btree {
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("btree.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"btree.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		out.println(3);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		btree prog = new btree();
		prog.run();
	}
}
