/*
ID: vxsj.fu1
LANG: JAVA
PROG: calfflac
 */

import java.io.*;



public class calfflac {
	
	private static int isOddPalindrome (char[] ho, int start, int usedRange)
	{
		int temp = 0;
		for (int i = 0; i < 1000; i++)
		{
			if (start - i < 0 || start + i >= usedRange)
			{
				temp = i;
				break;
			}
			if (!(ho[start-i] == ho[start+i]))
			{
				temp = i;
				break;
			}
		}
		return 2*temp-1;
	}
	
	private static int isEvenPalindrome (char[] ho, int start, int usedRange)
	{
		int temp = 0;
		for (int i = 0; i < 1000; i++)
		{
			if (start - i < 0 || start + i + 1 >= usedRange)
			{
				temp = i;
				break;
			}
			if (!(ho[start-i]== ho[start+i+1]))
			{
				temp = i;
				break;
			}
		}
		return 2*temp;
	}


	public static void main(String[] args) throws IOException {
		// Use BufferedReader rather than RandomAccessFile; it's much faster
		BufferedReader f = new BufferedReader(new FileReader("calfflac.in"));
		// input file name goes above
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"calfflac.out")));
		String next; 
		StringBuffer muscle = new StringBuffer();
		while ((next=f.readLine())!= null)
		{	
			muscle.append(next + "\n");
		}
		String s = muscle.toString().trim();
		char[] ho = new char[s.length()];
		char[] bag = new char[s.length()];
		int[] pos = new int[s.length()];
		int count = 0;
		for (int i = 0; i < s.length(); i++)
		{
			ho[i] = s.charAt(i);
			
			if(Character.isLetter(s.charAt(i)))
			{
				bag[count] = Character.toLowerCase(s.charAt(i));
				pos[count] = i;
				
				count++;
				
			}
			
		}
		
		int max = 0;
		int maxIndexOdd = 0;
		int maxIndexEven = 0;
		int o;
		int e;
		
		for (int i = 0; i < count; i++)
		{
			o = isOddPalindrome(bag, i, count);
			e = isEvenPalindrome(bag, i, count);
			if(o > max)
			{
				max = o;
				maxIndexOdd = i;
			}
			if(e > max)
			{
				max = e;
				maxIndexEven = i;
			}
			if (max == 2000)
			{
				maxIndexEven = i;
				break;
			}
		}
		out.println(max);
		if (maxIndexOdd > maxIndexEven)
		{	
			for (int i = pos[maxIndexOdd - max/2]; i <= pos[maxIndexOdd + max/2]; i++)
			{
				out.print(ho[i]);
			}
		}
		else 
		{
			for (int i = pos[maxIndexEven - max/2+1]; i <= pos[maxIndexEven + max/2]; i++)
			{
				out.print(ho[i]);
			}
		}
		out.println();

		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}

