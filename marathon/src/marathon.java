/*
ID: vxsj.fu1
LANG: JAVA
PROG: marathon
 */

import java.io.*;
import java.util.*;

class marathon {
	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"marathon.out")));
		// Use StringTokenizer vs. readLine/split -- lots faster
		StringTokenizer st = new StringTokenizer(f.readLine());
		// Get line, break into tokens
		int i1 = Integer.parseInt(st.nextToken()); // first integer
		int[][] marathonIndex = new int[i1][3];
		int[][] raceResults = new int[i1][3];
		for (int i = 0; i < i1; i++) {
			st = new StringTokenizer(f.readLine());
			if (st.hasMoreTokens()) {
				marathonIndex[i][0] = Integer.parseInt(st.nextToken());
				marathonIndex[i][1] = Integer.parseInt(st.nextToken());
				marathonIndex[i][2] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < i1; j++) {
			int minTime = 0;

			for (int i = 0; i < i1; i++) {

				if (marathonIndex[i][0] < marathonIndex[minTime][0]) {
					minTime = i;

				} else if (marathonIndex[i][0] == marathonIndex[minTime][0]) {
					if (marathonIndex[i][1] < marathonIndex[minTime][1]) {
						minTime = i;

					} else if (marathonIndex[i][1] == marathonIndex[minTime][1]) {
						if (marathonIndex[i][2] < marathonIndex[minTime][2]) {
							minTime = i;

						}
					}
				}

			}
			raceResults[j][0] = marathonIndex[minTime][0];
			raceResults[j][1] = marathonIndex[minTime][1];
			raceResults[j][2] = marathonIndex[minTime][2];
			marathonIndex[minTime][0] = 100;
			marathonIndex[minTime][1] = 60;
			marathonIndex[minTime][2] = 60;

		}

		for (int r = 0; r < i1; r++) {

			out.print(raceResults[r][0] + " ");
			out.print(raceResults[r][1] + " ");
			out.println(raceResults[r][2]);

		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!

	}
}