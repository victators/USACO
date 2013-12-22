/*
ID: vxsj.fu1
LANG: JAVA
PROG: ttwo
 */

import java.io.*;
import java.util.*;

public class ttwo {
	
	int[][] sq = new int [10][10];
	int fLoc = 0;
	int cLoc = 0;
	int fDir = 0;
	int cDir = 0;
	
	boolean canMove(int loc, int dir)
	{
		int row = loc/10;
		int col = loc%10;
		if(dir == 0)
		{
			if (row == 0 || sq[row-1][col] == 1)
			{
				return false;
			}
		}
		else if (dir == 90)
		{
			if (col == 9 || sq[row][col+1] == 1)
			{
				return false;
			}
		}
		else if (dir == 180)
		{
			if (row == 9 || sq[row+1][col] == 1)
			{
				return false;
			}
		}
		else if (dir == 270)
		{
			if (col == 0 || sq[row][col-1] == 1)
			{
				return false;
			}
		}
		return true;
	}
	
	void move()
	{
		if (canMove(fLoc, fDir))
		{
			if (fDir == 0)
			{
				fLoc -= 10;
			}
			else if(fDir == 90)
			{
				fLoc += 1;
			}
			else if (fDir == 180)
			{
				fLoc += 10;
			}
			else if (fDir == 270)
			{
				fLoc -= 1;
			}
		}
		else
		{
			fDir += 90;
			fDir %= 360;
		}
		if (canMove(cLoc, cDir))
		{
			if (cDir == 0)
			{
				cLoc -= 10;
			}
			else if(cDir == 90)
			{
				cLoc += 1;
			}
			else if (cDir == 180)
			{
				cLoc += 10;
			}
			else if (cDir == 270)
			{
				cLoc -= 1;
			}
		}
		else
		{
			cDir += 90;
			cDir %= 360;
		}
	}
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ttwo.out")));
		StringTokenizer st;
		int min = 0;
		for (int i = 0; i < 10; i++)
		{
			st = new StringTokenizer(f.readLine());
			String s = st.nextToken();
			for (int j = 0; j < 10; j++)
			{
				if (s.charAt(j) == '*')
				{
					sq[i][j] = 1;
				}
				else if (s.charAt(j) == '.')
				{
					sq[i][j] = 0;
				}
				else if (s.charAt(j) == 'F')
				{
					fLoc = 10*i + j;
					sq[i][j] = 0;
				}
				else
				{
					cLoc = 10*i + j;
					sq[i][j] = 0;
				}
			}
		}
		while (fLoc != cLoc)
		{
			move();
			min++;
			if (min == 160000)
			{
				out.println(0);
				out.close();
				System.exit(0);
			}
		}
		out.println(min);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		ttwo prog = new ttwo();
		prog.run();
	}
}

