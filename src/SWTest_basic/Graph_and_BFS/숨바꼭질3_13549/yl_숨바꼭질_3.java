package SWTest_basic.Graph_and_BFS.숨바꼭질3_13549;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 다익스트라 알고리즘 : 다이나믹 프로그래밍을 활용한 대표적인 최단 경로 탐색 알고리즘
 * 기본 로직 - 첫 정점을 기준으로 연결되어 있는 정점들을 추가해가며, 최단 거리를 갱신하는 것.
 * 		   정점을 잇기 전까지는 시작점을 제외한 정점들은 모두 무한대 값을 가짐.
 * 최소 값을 찾기 위해 bfs 하기 전에 Arrays.fill(map, 100009) 했음.
 */
public class yl_숨바꼭질_3 {
	static int N, K;
	static int map[];
	static Queue<Integer> q = new LinkedList<>();
	static int dx[] = {1, -1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[110000];
		Arrays.fill(map, 100009);
		bfs(N);
		System.out.println(map[K]);
	}
	
	public static void bfs (int start) {
		q.add(start);
		map[N] = 0;
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K)
				break ;
			for (int i=0; i<3; i++) {
				int nx = x + dx[i];
				if (i == 2)
					nx = x * dx[i];
				if (nx < 0 || nx >= 110000 || nx == N)
					continue ;
				if (map[nx] <= map[x])
					continue ;
				if (i == 2) 
					map[nx] = map[x];
				else 
					map[nx] = map[x] + 1;
				
				q.add(nx);
			}
		}
	}

}
