/*
ID: vxsj.fu1
LANG: JAVA
PROG: castle
 */

import java.io.*;
import java.util.*;

public class castle {

	int[][] map;
	
	ArrayList<Integer>[] graph;
	ArrayList<Integer>[] walls;
	int compCount;
	int[] comps;
	int[] rSizes;
	int locMax;
	
	void floodFill(int index) {
		int numVisited = 41;
		while (numVisited != 0) {
			rSizes[index] = numVisited;
			numVisited = 0;
			for (int i = 0; i < graph.length; i++) {
				if (comps[i] == -2) {
					numVisited++;
					comps[i] = index;
					for (Integer j : graph[i]) {
						if (comps[j] == 0) {
							comps[j] = -2;
						}
					}
					i = 0;
				}
			}
			if (numVisited > locMax) {
				locMax = numVisited;
			}
		}
	}

	void findComponent() {
		compCount = 0;
		locMax = 0;
		for (int i = 0; i < graph.length; i++) {
			comps[i] = 0;
		}
		for (int i = 0; i < graph.length; i++) {
			if (comps[i] == 0) {
				compCount++;
				comps[i] = -2;
				floodFill(compCount);
			}
		}
	}
	
	void getARoom(int r1, int r2)
	{
		if (comps[r1] == comps[r2] )
		{
			return;
		}
		else
		{	
			locMax = rSizes[comps[r1]] + rSizes[comps[r2]];
		}
	}
	
	int b2(int i) {
		int bit = 0;
		for (int j = 3; j >= 0; j--) {
			int delta = (i / (int) Math.pow(2, j)) * (int) Math.pow(10, j);
			if (delta == 0) {
				continue;
			}
			bit += delta;
			i -= (int) Math.pow(2, j);
		}
		return bit;
	}

	boolean checkEast(int a, int b) {
		if ((a % 1000) / 100 == 0 && b % 1 == 0) {
			return true;
		}
		return false;
	}

	boolean checkSouth(int a, int b) {
		if (a / 1000 == 0 && (b % 100) / 10 == 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	void run() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"castle.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		map = new int[x][y];
		boolean fun = true;
		for (int j = 0; j < y; j++) {
			st = new StringTokenizer(f.readLine());
			for (int i = 0; i < x; i++) {
				map[i][j] = b2(Integer.parseInt(st.nextToken()));
				if (map[i][j] != 1111)
				{
					fun = false;
				}
			}
		}
		graph = new ArrayList[x * y];
		walls = new ArrayList[x * y];
		for (int i = 0; i < x * y; i++) {
			graph[i] = new ArrayList<Integer>();
			walls[i] = new ArrayList<Integer>();
		}
		comps = new int[x * y];
		rSizes = new int[x*y+1];
		
		for (int j = 0; j < y; j++) {
			for (int i = 0; i < x; i++) {
				if (i + 1 != x && checkEast(map[i][j], map[i + 1][j])) {
					graph[x * j + i].add(x * j + i + 1);
					graph[x * j + i + 1].add(x * j + i);
				} else if (i + 1 != x && !checkEast(map[i][j], map[i + 1][j])) {
					walls[x * j + i].add(x * j + i + 1);
					walls[x * j + i + 1].add(x * j + i);
				}
				if (j + 1 != y && checkSouth(map[i][j], map[i][j + 1])) {
					graph[x * j + i].add(x * j + x + i);
					graph[x * j + x + i].add(x * j + i);
				} else if (j + 1 != y && !checkSouth(map[i][j], map[i][j + 1])) {
					walls[x * j + i].add(x * j + x + i);
					walls[x * j + x + i].add(x * j + i);
				}
			}
		}
		findComponent();
		out.println(compCount);
		out.println(locMax);
		int maxMax = 0;
		int maxX = 0;
		int minY = 0;
		char letter = 0;
		for (int i = 0; i < x * y; i++) {
			for (int j = 0; j < walls[i].size(); j++) {
				graph[i].add(walls[i].get(j));
				graph[walls[i].get(j)].add(i);
				getARoom(i, walls[i].get(j));
				
				if (maxMax == locMax) {
					if (minY == i % x + 1) {
						if (maxX == i / x + 1) {
							letter = 'N';
						} else if (maxX < i / x + 1) {
							maxX = i / x + 1;
							if (Math.abs(i - walls[i].get(j)) == x) {
								letter = 'N';
							}
							if (Math.abs(i - walls[i].get(j)) == 1) {
								letter = 'E';
							}
						}
					} else if (minY > i % x + 1) {
						maxX = i / x + 1;
						minY = i % x + 1;
						if (Math.abs(i - walls[i].get(j)) == x) {
							letter = 'N';
						}
						if (Math.abs(i - walls[i].get(j)) == 1) {
							letter = 'E';
						}
					}
				} else if (maxMax < locMax) {
					maxMax = locMax;
					maxX = i / x + 1;
					minY = i % x + 1;
					if (Math.abs(i - walls[i].get(j)) == x) {
						letter = 'N';
					}
					if (Math.abs(i - walls[i].get(j)) == 1) {
						letter = 'E';
					}
				}
				graph[i].remove(graph[i].size()-1);
				graph[walls[i].get(j)].remove(graph[walls[i].get(j)].size()-1);
			}
		}
		out.println(maxMax);
		out.println(maxX + " " + minY + " " + letter);
		out.close();
		System.exit(0);
	}

	public static void main(String[] args) throws IOException {
		castle prog = new castle();
		prog.run();
	}
}
