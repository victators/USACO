/*
ID: vxsj.fu1
LANG: JAVA
PROG: zerosum
 */

import java.io.*;
import java.util.*;

public class zerosum {

	int[] arr;
	int n;

	int b3(int i) {
		int bit = 0;
		for (int j = n - 1; j >= 0; j--) {
			int delta = (i / (int) Math.pow(3, j));
			if (delta == 0) {
				continue;
			}
			bit += delta * (int) Math.pow(10, j);
			i -= delta * (int) Math.pow(3, j);
		}
		return bit;
	}

	int access(int b, int j) {
		b %= (int) Math.pow(10, n - j);
		return b / (int) Math.pow(10, n - j - 1);
	}

	boolean process(int[] r) {
		int sum = 0;
		int delta = 0;
		boolean blank = false;
		int expo = 1;
		for (int i = r.length - 1; i >= 1; i--) {
			if (blank && i == 1) {
				if (r[i] == 0) {
					sum += Math.pow(10, expo) + delta - 1;
					break;
				}

			}
			if (!blank && i == 1) {
				if (r[i] == 0) {
					sum += 11;
					break;
				}
			}
			if (blank) {
				if (r[i] == 0) {
					delta += i * (int) Math.pow(10, expo);
					expo++;
				}
				if (r[i] == 1) {
					sum += delta;
					expo = 1;
					blank = false;
				}
				if (r[i] == 2) {
					sum -= delta;
					expo = 1;
					blank = false;
				}
			} else {
				if (r[i] == 0) {
					delta = i * (int) Math.pow(10, expo) + i + 1;
					expo++;
					blank = true;
				}
				if (r[i] == 1) {
					sum += i + 1;

				}
				if (r[i] == 2) {
					sum -= i + 1;
				}
			}
		}
		if (sum == -1) {
			return true;
		}
		return false;
	}

	void run() throws IOException {

		BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"zerosum.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i = 0; i < (int) Math.pow(3, n - 1); i++) {
			for (int j = 1; j <= n - 1; j++) {
				arr[j] = access(b3(i), j);
			}
			if (process(arr)) {
				for (int k = 1; k < arr.length; k++) {
					out.print(k);
					if (arr[k] == 0) {
						out.print(" ");
					}
					if (arr[k] == 1) {
						out.print("+");
					}
					if (arr[k] == 2) {
						out.print("-");
					}
				}
				out.println(arr.length);
			}
			for (int k = 0; k < arr.length; k++) {
				arr[k] = 0;
			}
		}
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		zerosum prog = new zerosum();
		prog.run();
	}
}
