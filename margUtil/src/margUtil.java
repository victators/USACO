/*
ID: vxsj.fu1
LANG: JAVA
PROG: umbrella
 */

import java.io.*;
import java.util.*;

public class margUtil {
	int w = 1000;
	int k = 1;
	double c = 4;
	double sum = 0;

	void run() throws IOException {
		while(k <= 10000)
		{
			sum += (Math.log(w + Math.pow(2, k-1) - c)- Math.log(w))/Math.pow(2, k);
			k++;
			System.out.println(sum);
		}
		System.out.println(sum);
	}

	public static void main(String[] args) throws IOException {
		margUtil prog = new margUtil();
		prog.run();
	}
}


	

