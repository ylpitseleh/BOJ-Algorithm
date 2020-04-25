package SWTest_basic.Graph_and_BFS.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yl_숨바꼭질 {
	static int N, K;
	static int map[];
	static int dx[] = { -1, 1, 2 };
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //수빈 위치
		K = Integer.parseInt(st.nextToken()); //동생 위치
		map = new int[110001];
		bfs(N);
		System.out.println(map[K]);

	}

	public static void bfs(int N) {
		q.offer(N);

		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K)
				return ;
			for (int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				if (i == 2)
					nx = x * dx[i];

				if (nx < 0 || nx >= 110001)
					continue;
				//먼저 들어간게 먼저 나오는 큐의 특성 때문에 굳이 map[nx] > map[x] + 1로 비교 안 해줘도 됨.
				//원래 if(map[nx] == 0 || map[nx] > map[x] + 1) 해서 틀렸음.
				if (map[nx] == 0) {
					map[nx] = map[x] + 1;
					q.offer(nx);
				}
			}
		}
	}
}
