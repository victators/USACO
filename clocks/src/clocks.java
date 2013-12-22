/*
ID: vxsj.fu1
LANG: JAVA
PROG: clocks
 */

import java.io.*;
import java.util.*;

public class clocks {
	
String min = "999999999999999999999999999";
public boolean midnightHour (int[][] reflectionEternal)
{
	for (int i = 0; i < reflectionEternal.length; i++)
	{
		for (int j = 0; j < reflectionEternal[i].length; j++)
		{
			if(reflectionEternal[i][j] != 12)
			{
				return false;
			}
		}
	}
	return true;
}
public int[][] copy (int[][] coldplay)
{
	int[][] copy = new int[coldplay.length][coldplay[0].length];
	for (int i = 0; i < coldplay.length; i++) {
		for (int j = 0; j < coldplay[0].length; j++) {
			copy[i][j] = coldplay[i][j];
		}
	}
	return copy;
}

public int[][] bigMove(int[][]coldplay, int a, int b, int c, int d, int e, int f, int g, int h, int i)
{
	int[][] copy = new int[coldplay.length][coldplay[0].length];
	for (int k = 0; k < coldplay.length; k++) {
		for (int j = 0; j < coldplay[0].length; j++) {
			copy[k][j] = coldplay[k][j];
		}
	}
	for(int p1 = 0; p1 < a; p1++)
	{
		move(copy, 1);
	}
	for(int p2 = 0; p2 < b; p2++)
	{
		move(copy, 2);
	}
	for(int p3 = 0; p3 < c; p3++)
	{
		move(copy, 3);
	}
	for(int p4 = 0; p4 < d; p4++)
	{
		move(copy, 4);
	}
	for(int p5 = 0; p5 < e; p5++)
	{
		move(copy, 5);
	}
	for(int p6 = 0; p6 < f; p6++)
	{
		move(copy, 6);
	}
	for(int p7 = 0; p7 < g; p7++)
	{
		move(copy, 7);
	}
	for(int p8 = 0; p8 < h; p8++)
	{
		move(copy, 8);
	}
	for(int p9 = 0; p9 < i; p9++)
	{
		move(copy, 9);
	}
	return copy;
}

public void move(int[][] coldplay, int p)
{
	if (p==1)
	{	
	int x = 0;
	int y = 0;
	for (int i = 0; i < 4; i++)
	{
		if(coldplay[x][y] == 12)
		{
			coldplay[x][y] = 3;
		}
		else	
		{
			coldplay[x][y] += 3;
		}
		
		if (i >= 1)
		{
			x = 1;
		}
		if (i%2 == 0)
		{
			y = 1;
		}
		else
		{
			y = 0;
		}
	}
	}
	if (p==2)
	{
	for (int i = 0; i < 3; i++)
	{
		if (coldplay[0][i] == 12)
		{
			coldplay[0][i] = 3;
		}
		else
		{
			coldplay[0][i] +=3;
		}
		
	}
	}

	if (p==3)
	{
	int x = 0;
	int y = 1;
	for (int i = 0; i < 4; i++)
	{
		if(coldplay[x][y] == 12)
		{
			coldplay[x][y] = 3;
		}
		else
		{
			coldplay[x][y] +=3;
		}
		if (i >= 1)
		{
			x = 1;
		}
		if (i%2 == 0)
		{
			y = 2;
		}
		else
		{
			y = 1;
		}
	}
	}
	if (p==4)
	{	
	for (int i = 0; i < 3; i++)
	{
		if (coldplay[i][0] == 12)
		{
			coldplay[i][0] = 3;
		}
		else
		{
			coldplay[i][0] +=3;
		}
		
	}
	}

	if(p==5)
	{
	for (int i = 0; i < 3; i++)
	{
		if (coldplay[i][1] == 12)
		{
			coldplay[i][1] = 3;
		}
		else
		{
			coldplay[i][1] +=3;
		}
		
	}
	for (int i = 0; i < 3; i++)
	{
		if (i == 1)
		{
			continue;
		}
		if (coldplay[1][i] == 12)
			coldplay[1][i] = 3;
		else
			coldplay[1][i] +=3;
		
	}
	}
	if (p==6)
	{
	for (int i = 0; i < 3; i++)
	{
		if (coldplay[i][2] == 12)
		{
			coldplay[i][2] = 3;
		}
		else
		{
			coldplay[i][2] +=3;
		}
		
	}
	}
	if(p==7)
	{
	int x = 1;
	int y = 0;
	for (int i = 0; i < 4; i++)
	{
		if(coldplay[x][y] == 12)
		{
			coldplay[x][y] = 3;
		}
		else
		{
			coldplay[x][y] += 3;
		}
		
		if (i >= 1)
		{
			x = 2;
		}
		if (i%2 == 0)
		{
			y = 1;
		}
		else
		{
			y = 0;
		}
	}
	}
	if(p==8)
	{
	for (int i = 0; i < 3; i++)
	{
		if (coldplay[2][i] == 12)
		{
			coldplay[2][i] = 3;
		}
		else
		{
			coldplay[2][i] +=3;
		}
		
	}
	}
	if(p==9)
	{
	int x = 1;
	int y = 1;
	for (int i = 0; i < 4; i++)
	{
		if(coldplay[x][y] == 12)
		{
			coldplay[x][y] = 3;
		}
		else
		{
			coldplay[x][y] += 3;
		}
		
		if (i >= 1)
		{
			x = 2;
		}
		if (i%2 == 0)
		{
			y = 2;
		}
		else
		{
			y = 1;
		}
	}
	}
	
}

void run() 
{
	// Use BufferedReader rather than RandomAccessFile; it's much faster
	BufferedReader f = null;
	try {
		f = new BufferedReader(new FileReader("clocks.in"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// input file name goes above
	PrintWriter out = null;
	try {
		out = new PrintWriter(new BufferedWriter(new FileWriter(
				"clocks.out")));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// Use StringTokenizer vs. readLine/split -- lots faster
	StringTokenizer st = null;
	// Get line, break into tokens
	int[][] clocks = new int[3][3];
	for (int i = 0; i < 3; i++) {
		try {
			st = new StringTokenizer(f.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clocks[i][0] = Integer.parseInt(st.nextToken());
		clocks[i][1] = Integer.parseInt(st.nextToken());
		clocks[i][2] = Integer.parseInt(st.nextToken());
	}
	for (int i1=0; i1 <4; i1++)
	{
		for (int i2=0; i2 <4; i2++)
		{
			for (int i3=0; i3 <4; i3++)
			{
				for (int i4=0; i4 <4; i4++)
				{
					for (int i5=0; i5 <4; i5++)
					{
						for (int i6=0; i6 <4; i6++)
						{
							for (int i7=0; i7 <4; i7++)
							{
								for (int i8=0; i8 <4; i8++)
								{
									for (int i9=0; i9 <4; i9++)
									{
										
										if(midnightHour(bigMove(clocks,i1,i2,i3,i4,i5,i6,i7,i8,i9)))
										{
											String s = "";
											for(int p = 0; p < i1; p++)
											{
												s += 1;
											}
											for(int p = 0; p < i2; p++)
											{
												s += 2;
											}
											for(int p = 0; p < i3; p++)
											{
												s += 3;
											}
											for(int p = 0; p < i4; p++)
											{
												s += 4;
											}
											for(int p = 0; p < i5; p++)
											{
												s += 5;
											}
											for(int p = 0; p < i6; p++)
											{
												s += 6;
											}
											for(int p = 0; p < i7; p++)
											{
												s += 7;
											}
											for(int p = 0; p < i8; p++)
											{
												s += 8;
											}
											for(int p = 0; p < i9; p++)
											{
												s += 9;
											}
											if (s.length() > min.length())
											{
												continue;
											}
											if (Double.parseDouble(s) < Double.parseDouble(min))
											{
												min = s;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	for (int i = 0; i < min.length() -1; i++)
	{	
		System.out.print(min.charAt(i) + " ");
	}
	System.out.println(min.charAt(min.length()-1));
	out.close(); // close the output file
	System.exit(0); // don't omit this!
}
public static void main(String[] args) throws IOException {
		
		clocks prog = new clocks();
		prog.run();
		
	}
}