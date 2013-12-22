/*
ID: vxsj.fu1
LANG: JAVA
PROG: line
*/

import java.io.*;
import java.util.*;

class line {
	 
	 
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("line.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("line.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
    StringTokenizer st = new StringTokenizer(f.readLine());
						  // Get line, break into tokens
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());    // second integer
    
    int[][] pmt = new int[factorial(i1)][i1];
    int count = 2;
    for (int i = 0; i < i1; i++)
    {
    	pmt[0][i] = i+1;
    	pmt[1][i] = i+1;
    }
    
    pmt[1][i1 - 1] = i1 - 1;
    pmt[1][i1 - 2] = i1;
    
    for (count = 2; count < factorial(i1); count ++)
    {	
    	while (fallingBlock(pmt, count, i1) < i1)
    	{	
    	for (int i = 0; i < i1 - fallingBlock(pmt, count, i1) - 1; i++)
    	{
    		pmt[count][i] = pmt[count-1][i];
    	}
    	int cheese = pmt[count][i1 - fallingBlock(pmt, count, i1) - 1];
    	int magic = magicNum(pmt, count, i1, i1 - fallingBlock(pmt, count, i1) - 1, cheese);
    	pmt[count][i1 - fallingBlock(pmt, count, i1) - 1] = pmt[count][magic];
    	pmt[count][magic] = cheese;
    	int [] temp = new int [fallingBlock(pmt, count, i1)];
    	int index = 0;
    	for (int j = i1 - fallingBlock(pmt, count, i1); j < i1; j++)
    	{
    		temp[index] = findMin(pmt, count, i1, j);
    		pmt[count][j] = temp[index];
    		index ++;
    	}
    	}
    }
    System.out.println(fallingBlock(pmt, count, i1));
    Character one = 'P';
    Character two = 'Q';
    Object trash;
    for (int m = 1; m <= i2; m++ )
    {
    	st = new StringTokenizer(f.readLine());
    	if (st.hasMoreTokens())
    	{
    		if (st.nextToken().equals(one.toString()))
    		{
    			trash = st.nextToken();
    			for (int i = 0; i < i1; i++)
    			{	
    			System.out.println(pmt[Integer.parseInt(st.nextToken())-1][i]);
    			}
    		}
    		else
    		{
    			trash = st.nextToken();
    			System.out.println(0);
    		}
    	}
    }
    
    out.close();                                  // close the output file
    System.exit(0);                              // don't omit this!
  }
  
  private static int factorial (int n)
  {
	  int num = 1;
	  for (int i = 1; i <= n; i++)
	  {
		  num *= i;
	  }
	  return num;
  }
  
  private static int fallingBlock( int[][] data, int row, int length)
  {
	int n = 1;
	while (data[row-1][length - n] < data[row][length - n - 1])
	{
		n++;
		if (n == length)
		{
			return n;
		}
	}
	return n;
  }
  
  private static int findMin (int [][] data, int row, int length, int start)
  {
	  int min = 21;
	  for (int i = start - 1; i < length; i++)
	  {
		  if (data[row-1][i] < min)
		  {
			  min = data[row-1][i];
		  }
	  }
	  return min;
  }
  
  private static int magicNum (int [][] data, int row, int length, int start, int num)
  {
	  for (int j = 1; j <= length - num; j++)
	  {  
	  for (int i = start - 1; i < length; i++)
	  {
		  if (data[row-1][i] == num + j)
		  {
			 return i;
		  }
	  }
	  }
	  return -1;
  }
  
  
}

