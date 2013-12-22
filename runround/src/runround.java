/*
ID: vxsj.fu1
LANG: JAVA
PROG: runround
 */

import java.io.*;
import java.util.*;

public class runround {

	ArrayList<Integer> list = new ArrayList<Integer>();
	int val;
	int qq = 0;
	int p;
	boolean carry = false;
	PrintWriter out;

	int digits(int i) {
		for (int j = 8; j >= 0; j--) {
			if (i / (int) (Math.pow(10, j) + 0.5) > 0) {
				return j + 1;
			}
		}
		return 0;
	}

	boolean validNum(int i) {
		p = digits(qq);
		int temp = qq;
		for (int j = p - 1; j >= 0; j--) {
			if (i == temp / (int) (Math.pow(10, j) + 0.5)) {
				return false;
			}
			temp %= (int) (Math.pow(10, j) + 0.5);
		}
		return true;
	}

	boolean running(ArrayList<Integer> l) {
		int length = l.size();
		int x = l.get(0) % length;

		int temp = 0;
		for (int i = 0; i < length - 1; i++) {
			temp = x;
			if (l.get((x + l.get(x)) % length) == 0) {
				return false;
			}
			x += l.get(x);
			x %= length;
			l.set(temp, 0);
		}
		if (x == 0) {
			l.clear();
			return true;
		}
		l.clear();
		return false;
	}

	void nextNum(int l) {
		if (l == digits(val)) {
			if (qq > val) {
				int t = qq;
				int q = digits(val);
				for (int i = q - 1; i >= 0; i--) {
					list.add(t / (int) (Math.pow(10, i) + 0.5));
					t %= (int) (Math.pow(10, i) + 0.5);
				}
				if (running(list)) {
					System.out.println(qq);
					out.close();
					System.exit(0);
				}
				list.clear();
				return;
			}
			return;
		}
		for (int i = 1; i <= 9; i++) {
			if (validNum(i)) {
				qq = qq * 10 + i;
				nextNum(l + 1);
				qq = (qq - i) / 10;
			}
		}
		return;
	}

	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		out = new PrintWriter(
				new BufferedWriter(new FileWriter("runround.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		val = n;
		qq = val / (int) (Math.pow(10, digits(val) - 1) + 0.5);
		nextNum(1);
		if (carry == false) {
			val = (int) (Math.pow(10, digits(val)) + 0.5);
			qq = 1;
			nextNum(1);
		}
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		runround prog = new runround();
		prog.run();
	}
}