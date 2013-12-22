/*
ID: vxsj.fu1
LANG: JAVA
PROG: nocows
 */

import java.io.*;
import java.util.*;

public class nocows2 {
	
	int N,K,c;
	int[][] smalltrees = new int[101][202];
	int[][] table = new int[101][202];
	int MOD = 9901;
	
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("nocows2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"nocows2.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
	    table[1][1]=1;
	    for (int i=2;i<=K;i++) {
	        for (int j=1;j<=N;j+=2)
	            for (int k=1;k<=j-1-k;k+=2) {
	                if (k!=j-1-k) c=2; else c=1;    
	                table[i][j]+=c*(
	                        smalltrees[i-2][k]*table[i-1][j-1-k]  
	                        +table[i-1][k]*smalltrees[i-2][j-1-k]  
	                        +table[i-1][k]*table[i-1][j-1-k]);
//	                table[i][j]%=MOD;
	            }
	        for (int k=0;k<=N;k++) {         
	            smalltrees[i-1][k]+=table[i-1][k]+smalltrees[i-2][k]; 
//	            smalltrees[i-1][k]%=MOD;        
	        }
	    }
	    System.out.println(table[6][21]);
		out.close(); 
		System.exit(0); 
	}
	
	public static void main(String[] args) throws IOException {
		nocows2 prog = new nocows2();
		prog.run();
	}
}