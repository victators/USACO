import java.io.*; // always import these
import java.util.*;

public class bfs
{
	/*
	input:
	nodenum edgenum startnode endnode
	a1 b1
	a2 b2
	...
	a(edgenum) b(edgenum)
	
	output:
	length
	a1 a2 a3 ... a(length+1)
	
	sample input:
	8 9 1 8
	1 2
	2 3
	3 4
	2 4
	4 5
	4 6
	6 7
	6 8
	7 8
	
	sample output:
	4
	something
	
	*/
	void run()
	{
		Scanner scan = new Scanner(System.in);
		int n,m;
		n=scan.nextInt();
		m=scan.nextInt();
		
		ArrayList<Integer>[] adj=new ArrayList[n]; // screw the warning
		for(int i=0;i<adj.length;i++)
			adj[i]=new ArrayList<Integer>();
		int[] dist=new int[n],prev=new int[n];
		for(int i=0;i<prev.length;i++)
			prev[i]=-1;
		
		int s,e;
		s=scan.nextInt()-1;
		e=scan.nextInt()-1;
		
		for(int i=0;i<m;i++)
		{
			int a,b;
			a=scan.nextInt()-1;
			b=scan.nextInt()-1;
			adj[a].add(b);
			adj[b].add(a);
		}
		
		LinkedList<Integer> q=new LinkedList<Integer>();
		q.add(s);
		prev[s]=-2;
		dist[s]=0;
		while(!q.isEmpty())
		{
			int a=q.poll();
			for(int b:adj[a])
			{
				if(prev[b]==-1)
				{
					prev[b]=a;
					dist[b]=dist[a]+1;
					q.add(b);
				}
			}
		}
		
		if(prev[e]==-1)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(dist[e]);
			trace(s,e,prev);
			System.out.println();
		}
	}
	void trace(int s,int c,int[] prev)
	{
		if(prev[c]==-1 || s==c)
		{
			System.out.print(c+1);
		}
		else
		{
			trace(s,prev[c],prev);
			System.out.print(' ');
			System.out.print(c+1);
		}
	}
	
	public static void main(String args[])
	{
		bfs prog=new bfs();
		prog.run();
	}
}

