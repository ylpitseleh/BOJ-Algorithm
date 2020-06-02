package SWTest_practice.BFS.탈옥_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class yl_탈옥 {
	//static Queue q = new LinkedList<Pos>();
	
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static char map[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			for (int i=1; i<h+1; i++) {
				String s = br.readLine();
				for (int j=1; j<w+1; j++) {
					map[i][j] = s.charAt(j-1);
				}
			}
			for (int i=0; i<h+2; i++) {
				for (int j=0; j<w+2; j++) {
					if (i==0 || i==h+1 || j==0 || j==w+1)
						map[i][j] = '.';
				}
			}
			
			
			
			
			
		}
			

	}

}
