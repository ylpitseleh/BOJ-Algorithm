package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class notepad {
	static int w, h, ans = 0;
	static int map[][];
	static boolean visited[][];
	static int dy[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dx[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			visited = new boolean[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && map[i][j] == 1) {
						ans++;
						dfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int j = 0; j < 8; j++) {
			int ny = y + dy[j];
			int nx = x + dx[j];
			
			if (ny < 0 || ny >= h || nx < 0 || nx >= w)
				continue;
			if (!visited[ny][nx] && map[ny][nx] == 1) {
				dfs(ny, nx);
			}
		}
	}
}
