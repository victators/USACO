/*
ID: vxsj.fu1
LANG: JAVA
PROG: climb
 */

import java.io.*;
import java.util.*;

public class climb {

	int[] u;
	int[] d;
	int sum = 0;
	
	int min(int a, int b) {
		if (a > b)
			return b;
		return a;
	}

	int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("climb.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"climb.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		u = new int[num];
		d = new int[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(f.readLine());
			u[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(u);
		Arrays.sort(d);
		sum = min(u[0], d[0]);
		for (int i = 0; i < num; i++) {
			sum += max(u[i], d[i]);
		}
		out.println(sum);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		climb prog = new climb();
		prog.run();
	}
}
