package SWTest_basic.Graph_and_BFS.연결_요소의_개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 3 1
 * 1 2 일 때 왜 2가 나와야하는지 모르겠다..
 */
// 그냥 간선으로 이어지지 않은 독립된 정점은 하나의 간선이라고 취급하나보다.
public class yl_연결_요소의_개수 {
	static int N, M, cnt = 0;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		int a, b;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		//2차원배열로 arr[i][j] == 1일때를 찾으면 단독으로 있는 정점이 호출되지 않음.
		for(int i=1; i<=N; i++) {
			if(visited[i] == false) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void dfs(int idx) {
		visited[idx] = true;

		for (int i = 1; i <= N; i++) {
			if (arr[idx][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

}
