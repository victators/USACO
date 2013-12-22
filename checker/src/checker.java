/*
ID: vxsj.fu1
LANG: JAVA
PROG: checker
 */

import java.io.*;
import java.util.*;

public class checker {
	
	int max = 13;
	boolean[] colValid = new boolean [max];
	boolean[] diagValid = new boolean [4*max-3];
	int[] goodStuff = new int[1];
	int[]marks = new int[max];
	int count = 0;
	int three = 0;
	int legit = 0;
	PrintWriter out;
	void placeQueen(int row) 
	{   
		if (row == max) 
		{
			if (three >= 3)
			{
				count++;
				if (max%2 == 0)
				{	
					if (marks[0] == max/2  + 1)
					{
						out.println((count-1)*2);
						out.close(); 
						System.exit(0); 
					}
				}
				else
				{
					if (marks[0] == max/2  + 1)
					{
						if (legit == 0)
						{	
							goodStuff[legit] = (count-1)*2;
							legit++;
							count = 0;
						}
					}
					if (marks[0] == max/2 + 2)
					{
						out.println(count + goodStuff[legit-1]);
						out.close(); 
						System.exit(0); 
					}
				}
				return; 
			}
			else
			{	
				for (int i = 0; i < max-1; i++)
				{
					out.print(marks[i] + " ");
				}
				out.println(marks[max-1]);
				count++;
				three++;
				return; 
			}
		}
	    for (int col = 0; col < max; col++)  
	    {
	    	if (colValid[col] && diagValid[-row+max+col-1] && diagValid[row + col + 2*max -2]) 
	        {
	        	colValid[col] = false;
	        	diagValid[-row+max+col-1] = false;
	        	diagValid[row + col + 2*max -2] = false;
	        	marks[row] = col + 1;
	        	placeQueen(row+1);
	        	marks[row] = 0;
	        	colValid[col] = true;
	        	diagValid[-row+max+col-1] = true;
	        	diagValid[row + col + 2*max -2] = true;
	        }
	    }
	}
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("checker.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter(
				"checker.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int i1 = Integer.parseInt(st.nextToken());
		max = i1;
		Arrays.fill(colValid, true);
		Arrays.fill(diagValid, true);
		placeQueen(0);
		out.println(count);
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		checker prog = new checker();
		prog.run();
	}
}

