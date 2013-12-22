/*
ID: vxsj.fu1
LANG: JAVA
PROG: frac1
 */

import java.io.*;
import java.util.*;

public class frac1 {
	
	Map<Double, Integer> frac;
	double[] arr;
	int gcd (int a, int b)
	{
		if (b== 0)
		{
			return a;
		}
		else
		{
			return gcd(b,a%b);
		}
	}
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"frac1.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int num = Integer.parseInt(st.nextToken());
		frac = new HashMap<Double, Integer>(num*(num+1)*(2*num + 1)/6);
		arr = new double[num*(num+1)*(2*num + 1)/6];
		int index = 0;
		for (int j = 1; j <= num; j++) {
			for (int i = 1; i < j; i++) {
				if (gcd(i, j) != 1) {
					
					continue;
				} else {
					
					double temp = (double) i / j;
					frac.put(temp, j);
					arr[index] = temp;
					index++;
				}
			}
		}
		Arrays.sort(arr);
		int mark = 0;
		if (mark < arr.length)
		{
			while (arr[mark] == 0)
			{
				mark++;
				if (mark == arr.length)
				{
					break;
				}
			}
		}
		out.println(0 + "/" + 1);
		for (int i = 0; i < index; i++)
		{
			out.println((int)(frac.get(arr[i+ mark])*arr[i+mark]+ 0.5)+ "/" + frac.get(arr[i+ mark]));
		}
		out.println(1 + "/" + 1);
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		frac1 prog = new frac1();
		prog.run();
	}
}

