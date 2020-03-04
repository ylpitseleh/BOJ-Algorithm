package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_섬의_개수 {
	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int dy[] = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int dx[] = {0, 0, -1, 1, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				return ;
			map = new int[h][w];
			visited = new boolean[h][w];
			for(int i=0; i<h; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st1.nextToken());
				}
			}
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}

	}
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0; i<8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
				if(map[ny][nx] == 1 && !visited[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}

}
