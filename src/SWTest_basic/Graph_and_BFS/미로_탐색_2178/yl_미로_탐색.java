package SWTest_basic.Graph_and_BFS.미로_탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* 
 * 최단경로 = BFS
 * Class : 객체를 만들어 내기 위한 설계도 혹은 틀. 연관되어 있는 변수와 메서드의 집합
 * Object(객체) : 소프트웨어 세계에 구현할 대상. 클래스에 선언된 모양 그대로 생성된 실체
 */
public class yl_미로_탐색 {
	static int N, M; 
	static int map[][];
	static boolean visited[][];
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static Queue<Pos> q = new LinkedList<Pos>();
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		bfs(0, 0);
		System.out.println(map[N-1][M-1]);
	}

	public static void bfs(int y, int x) {
		visited[y][x] = true;
		q.add(new Pos(y, x));

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int j = 0; j < 4; j++) {
				int ny = p.y + dy[j];
				int nx = p.x + dx[j];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (!visited[ny][nx] && map[ny][nx] == 1) {
					map[ny][nx] = map[p.y][p.x] + 1;
					q.add(new Pos(ny, nx));
				}
			}
		}
	}
}
