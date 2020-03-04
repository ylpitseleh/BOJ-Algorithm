package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class yl_단지번호붙이기 {
	static int N, cnt;
	static int map[][];
	static boolean visited[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	//단지가 몇 개 생성될지 모르니까 ArrayList사용
	static ArrayList al = new ArrayList();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					dfs(i, j);
					al.add(cnt);
				}
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					cnt++;
					dfs(nx, ny);
				}
			}
		}
	}
}
