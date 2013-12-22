/*
ID: vxsj.fu1
LANG: JAVA
PROG: photo
 */

import java.io.*;
import java.util.*;

public class photo {
	
	int numCows;
	Map<Integer, Integer> [] ho;
	
	void run() throws IOException {
		
		BufferedReader f = new BufferedReader(new FileReader("photo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"photo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		numCows = Integer.parseInt(st.nextToken());
		Integer [] cows = new Integer [numCows];
		ho = new Map[5];
		for (int i = 0; i < 5; i++)
		{
			ho[i] = new HashMap<Integer,Integer>(numCows);
			for (int j = 0; j < numCows; j++)
			{
				st = new StringTokenizer(f.readLine());
				Integer temp = Integer.parseInt(st.nextToken());
				ho[i].put(temp, j);
				if (i == 0)
				{
					cows[j] = temp;
				}
			}
		}
		Sorter s = new Sorter(); 
		Arrays.sort(cows, s);
		for (int i = 0; i < numCows; i++)
		{
			out.println(cows[i]);
		}
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		photo prog = new photo();
		prog.run();
	}
	
	class Sorter implements Comparator<Integer>
	{
		@Override
		public int compare(Integer a, Integer b) {
			int temp = 0;
			for (int i = 0; i < ho.length; i++)
			{
				if(ho[i].get(a) < ho[i].get(b))
				{
					temp++;
				}
			}
			if (temp >= 3)
			{
				return -1;
			}
			return 1;
		}
	}
}




