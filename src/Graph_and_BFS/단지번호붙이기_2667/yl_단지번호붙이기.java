package Graph_and_BFS.단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class yl_단지번호붙이기 {
	static int N, ans;
	static int map[][];
	static boolean visited[][];
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	//단지가 몇 개 생성될지 모르니까 ArrayList사용
	static ArrayList al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
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

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					ans = 1;
					dfs(i, j);
					al.add(ans);
				}
			}
		}

		Collections.sort(al);
		System.out.println(al.size());
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

	public static void dfs(int y, int x) {
		visited[y][x] = true;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 4; j++) {
				int ny = y + dy[j];
				int nx = x + dx[j];

				if (ny < 0 || ny >= N || nx < 0 || nx >= N)
					continue;
				if (!visited[ny][nx] && map[ny][nx] == 1) {
					ans++;
					dfs(ny, nx);
				}
			}
		}
	}
}
