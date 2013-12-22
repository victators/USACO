/*
ID: vxsj.fu1
LANG: JAVA
PROG: delivery
 */

import java.io.*;
import java.util.*;

public class delivery {
	
	int[] x;
	int[] y;
	
	int getDistance(int x1, int y1, int x2, int y2)
	{
		return Math.abs(x1-y1) + Math.abs(x2-y2);
	}
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("delivery.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"delivery.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		x = new int[num];
		y = new int[num];
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(f.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		int t = 0;
		for (int i = 0; i < num-1; i++)
		{
			t += getDistance(x[i],y[i], x[i+1], y[i+1]);
		}
		t += getDistance(x[num-1],y[num-1],x[0],y[0]);
		out.println(t+2);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		delivery prog = new delivery();
		prog.run();
	}
}

