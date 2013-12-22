/*
ID: vxsj.fu1
LANG: JAVA
PROG: dinner
*/

import java.io.*;
import java.util.*;

class dinner {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("dinner.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dinner.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());    // second integer
    int[] abscissas = new int[i1];
    int[] ordinates = new int[i1];
    for (int i = 0; i < i1; i++) {
		st = new StringTokenizer(f.readLine());
		if (st.hasMoreTokens()) {
			abscissas[i] = Integer.parseInt(st.nextToken());
			ordinates[i] = Integer.parseInt(st.nextToken());
		}
	}
    for (int i = 0; i< i2; i++) 
    {
    	st = new StringTokenizer(f.readLine());
    	if (st.hasMoreTokens()) {
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			double minDist = Integer.MAX_VALUE;
			int mark = 0;
			for (int x = 0; x < i1; x++) 
			{
				if (minDist > Math.sqrt((abscissas[x]-temp1)*(abscissas[x]-temp1) + (ordinates[x]-temp2)*(ordinates[x]-temp2)))
				{
					minDist = Math.sqrt((abscissas[x]-temp1)*(abscissas[x]-temp1) + (ordinates[x]-temp2)*(ordinates[x]-temp2));
					mark = x;
				}
			}
			abscissas[mark] = 1000001;
			ordinates[mark] = 1000001;
		}
    }
    
    for (int i = 0; i < i1; i++) {
    	if (abscissas[i] != 1000001)
    	{
    		
    		System.out.println(i+1);
    		
    	}
    }
    out.close();                                  // close the output file
    System.exit(0);                              // don't omit this!
  }
}
