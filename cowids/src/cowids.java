/*
ID: vxsj.fu1
LANG: JAVA
PROG: cowids
 */
 
import java.io.*;
import java.util.*;
 
public class cowids {
        
        int[][] ho = new int[5000][15];
 
        int choose(int n, int k) {
                if (n >= 5000)
                {
                        return n;
                }
                else if (ho[n][k] == -1) {
                        if (k == 0)
                        {
                                ho[n][k] = 1;
                                return 1;
                        }
                        else if (k == 1)
                        {       
                                ho[n][k] = n;
                                return n;
                        }
                        else if (n == k)
                        {
                                ho[n][k] = 1;
                                return 1;
                        }
                        else
                                ho[n][k] = choose(n - 1, k) + choose(n - 1, k - 1);
                        return ho[n][k];
                } 
                else {
                        return ho[n][k];
                }
        }
 
        void carry(int[] d1) {
                for (int i = 0; i < d1.length; i++) {
                        if (i == d1.length - 1) {
                                d1[i]++;
                                continue;
                        }
                        if (d1[i] + 1 >= d1[i + 1]) {
                                d1[i] = i;
                        } else {
                                d1[i]++;
                                break;
                        }
                }
        }
 
        void run() throws IOException {
                BufferedReader f = new BufferedReader(new FileReader("cowids.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                                "cowids.out")));
                StringTokenizer st = new StringTokenizer(f.readLine());
                for (int i = 0; i < ho.length; i++)
                {
                        for (int j = 0; j < ho[i].length; j++)
                        {
                                ho[i][j]= -1;
                        }
                }
                int index = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());
                if (k == 1)
                {
                        out.print('1');
                        for (int i = 1; i < index; i++)
                        {
                                out.print('0');
                        }
                        out.print('\n');
                        out.close();
                        System.exit(0);
                }
                int x = k;
                while (choose(x, k) < index) {
                        x++;
                }
                index -= choose(x - 1, k);
                int[] d = new int[k - 1];
                for (int i = 0; i < d.length; i++) {
                        d[i] = i;
                }
                for (int i = 0; i < index - 1; i++) {
                        carry(d);
                }
                boolean[] b = new boolean[x];
                for (int i = 0; i < d.length; i++) {
                        b[x - 1 - d[i]] = true;
                }
                out.print('1');
                for (int i = 1; i < x; i++) {
                        if (b[i])
                                out.print('1');
                        else
                                out.print('0');
                }
                out.print('\n');
                out.close();
                System.exit(0);
        }
 
        public static void main(String[] args) throws IOException {
                cowids prog = new cowids();
                prog.run();
        }
}