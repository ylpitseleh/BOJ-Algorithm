package ETC.로봇_청소기_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 나중에 시뮬레이션 연습 하고 다시 풀기
public class yl_로봇_청소기 {
	static int map[][];
	static int dy[] = {1, 0, -1, 0};
	static int dx[] = {0, 1, 0, -1};
	static Queue<Pos> q = new LinkedList<>();
	static class Pos{
		int y;
		int x;
		Pos (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st1.nextToken());
		int c = Integer.parseInt(st1.nextToken());
		int d = Integer.parseInt(st1.nextToken());
		
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		
		q.add(new Pos(r, c));
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
			}
		}
	}

}
