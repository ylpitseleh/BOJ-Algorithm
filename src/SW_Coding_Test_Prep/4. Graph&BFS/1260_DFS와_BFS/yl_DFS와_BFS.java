package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yl_DFS와_BFS {
	static int N, M, V, ans = 0;
	static int map[][];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //정점의 개수
		M = Integer.parseInt(st.nextToken()); //간선의 개수
		V = Integer.parseInt(st.nextToken()); //탐색을 시작할 정점의 번호
		map = new int[N+1][N+1];
		visited = new boolean[N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		dfs(V);
		Arrays.fill(visited, false);
		System.out.println();
		bfs(V);
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;
		System.out.print(idx+" ");
		
		for(int i=1; i<=N; i++) {
			if (!visited[i] && map[idx][i] == 1)
				dfs(i);
		}
	}
	
	public static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(idx);
		visited[idx] = true;
		
		while (!q.isEmpty()) {
			idx = q.poll();
			System.out.print(idx+" ");
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && map[idx][i] == 1) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
