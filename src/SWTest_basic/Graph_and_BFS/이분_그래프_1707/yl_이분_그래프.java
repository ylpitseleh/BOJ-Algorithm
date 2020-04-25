package SWTest_basic.Graph_and_BFS.이분_그래프_1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//인접 행렬로 풀었더니 12%에서 메모리 초과.
//인접리스트 사용해야 한다.
/*
 * 인접 행렬: 그래프에 간선이 많이 존재하는 밀집 그래프일때 사용
 * 인접 리스트: 그래프에 간선이 적게 존재하는 희소 그래프일때 사용
 * 이렇게 적혀있긴 한데 밀집과 희소의 기준은...?
 */
public class yl_이분_그래프 {
	static int K, V, E;
	static ArrayList<Integer>[] a;
	static int colors[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수
			colors = new int[V + 1];
			a = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				a[i] = new ArrayList<Integer>();
			}
			int u, v;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				u = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				a[u].add(v);
				a[v].add(u);
			}
			// colors
			// 0: not visited, 1: red, 2: blue
			for (int i = 1; i <= V; i++) {
				if (colors[i] == 0) {
					colors[i] = 1;
					dfs(i);
				}
			}
			//모든 간선에 대해 색갈이 서로 다른지
			boolean ok = true;
			for (int i = 1; i <= V; i++) {
				for (int j : a[i]) {
					if (colors[i] == colors[j]) { //같으면 이분 그래프가 아니다.
						ok = false;
					}
				}
			}
			
			if (ok)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static void dfs(int idx) {
		for (int y : a[idx]) {
			if (colors[y] == 0) {
				if (colors[idx] == 1)
					colors[y] = 2;
				else if (colors[idx] == 2)
					colors[y] = 1;
				dfs(y);
			}
		}
	}

}
