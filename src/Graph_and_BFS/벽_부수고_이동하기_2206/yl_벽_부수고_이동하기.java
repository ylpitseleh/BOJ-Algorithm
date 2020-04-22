package Graph_and_BFS.벽_부수고_이동하기_2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://kim6394.tistory.com/201
//이해 안 됨
public class yl_벽_부수고_이동하기 {
	static int N, M, ans;
	static int[][] map, visited;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static Queue<Pos> q = new LinkedList<>();

	static class Pos {
		int y;
		int x;
		int dis; // 이동 거리
		int destroy; // 부수기 여부(0, 1). 공사 횟수???? 뭔솔

		public Pos(int y, int x, int dis, int destroy) {
			this.y = y;
			this.x = x;
			this.dis = dis;
			this.destroy = destroy;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE; // visited 무한대로 초기화
			}
		}
		ans = Integer.MAX_VALUE;
		bfs(0, 0);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	public static void bfs(int y, int x) {
		q.add(new Pos(y, x, 1, 0)); // y좌표, x좌표, 이동 거리, 부수기 여부
		visited[y][x] = 0;

		while (!q.isEmpty()) {
			Pos p = q.poll();

			if (p.y == N - 1 && p.x == M - 1) { // 도착지점 만나면 종료
				ans = p.dis;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(ny<0 || nx<0 || ny>=N || nx>=M)
					continue;
				
				//visited 배열의 값은 공사 횟수를 나타내므로,
				//만약 다음에 나온 공사횟수 값이 기존에 갖고 있던 값보다 작거나 같으면 큐에 추가 안 하고 넘어가도 된다.
				if (visited[ny][nx] <= p.destroy)
					continue;
				
				//System.out.println(p.destroy);
				// 0일 때
				if (map[ny][nx] == 0) {
					
					visited[ny][nx] = p.destroy;
					q.add(new Pos(ny, nx, p.dis + 1, p.destroy));
				}
				// 1일 때
				//벽이기 때문에 공사횟수가 0일 때만 진행할 수 있다.
				else {
					// 벽을 안 부수었을 때
					if (p.destroy == 0) {
						System.out.println("벽 안부수었을때: "+p.y+" "+p.x);
						visited[ny][nx] = p.destroy + 1;
						q.add(new Pos(ny, nx, p.dis + 1, p.destroy + 1));
					}
				}

			}
		}
	}

}
