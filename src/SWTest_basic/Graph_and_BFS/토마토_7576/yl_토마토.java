package SWTest_basic.Graph_and_BFS.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS가 넓이 우선 탐색이어서 낮은 level을 먼저 탐색하는 형태를 취하기때문에
 * 반복이 줄어든다고 한다. DFS로 풀기엔 부적절한 문제.
 */
//처음부터 큐에 1인것 모두 쳐넣는 이유 : 큐는 FIFO니까 먼저 넣으면 먼저 나옴.
//1이 여러군데 있을때 같이 시작할 수 있음.(카운트가 여러군데에서 같이 올라갈 수 있음)
public class yl_토마토 {
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
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 1) {
					visited[i][j] = true;
					q.offer(new Pos(i, j));
				}
			}
		}
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int j = 0; j < 4; j++) {
				int ny = p.y + dy[j];
				int nx = p.x + dx[j];

				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (map[ny][nx] == 0) {
					map[ny][nx] = map[p.y][p.x] + 1;
					q.offer(new Pos(ny, nx));
				}
			}
		}
		
		int zeroFlag = 0;
		int max = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 0)
					zeroFlag = 1;
				max = Math.max(max, map[i][j]);
			}
		}
		if (zeroFlag == 1)
			System.out.println("-1");
		else
			System.out.println(max - 1);
		
	}
	
}
