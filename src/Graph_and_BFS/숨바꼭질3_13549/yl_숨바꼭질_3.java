package Graph_and_BFS.숨바꼭질3_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * -1, 1, 2 중 2가 우선순위가 달라서 원래는 BFS로 풀면 안 되는 문제.
 * 다익스트라로 풀어야 한다는데...뭔지 찾아보기 귀찮아
 * https://chosh95.tistory.com/44?category=835071
 * 여기선 분명 if문 조건을 (dist[nx] > dist[x] + 1)로 줬는데
 * 이럴때 2가 안 들어갈텐데 정답이 나온다. 기묘하다...
 * dx배열 순서를 2, -1, 1로 주면 90%대에서 틀렸다고 나온다.
 */
//1 32일때 0이 나와야 한다. 1 100일때 3이 나와야 한다.
public class yl_숨바꼭질_3 {
	static int N, K;
	static int map[];
	static int dx[] = {-1, 1, 2};
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //수빈이 위치
		K = Integer.parseInt(st.nextToken()); //동생 위치
		map = new int[100001];
		Arrays.fill(map, Integer.MAX_VALUE);
		bfs(N);
		System.out.println(map[K]);
	}
	
	public static void bfs(int x) {
		q.offer(x);
		map[x] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == K)
				break ;
			for(int i=0; i<3; i++) {
				int nx = 0;
				if (i == 0 || i == 1)
					nx = cur + dx[i];
				if (i == 2)
					nx = cur * dx[i];
				if (nx < 0 || nx > 100000)
					continue;
				if (map[nx] > map[cur]) {
					if (i == 2)
						map[nx] = map[cur];
					else
						map[nx] = map[cur] + 1;
					q.add(nx);
				}
			}
		}
	}
}
