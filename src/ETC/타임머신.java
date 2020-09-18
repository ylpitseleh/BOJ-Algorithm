package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 브랜디 코테 3번 풀으려면 벨만 포드 알고리즘 써야해서 연습 하려고 푼 문제.
 * 나중에 다시 풀어보기.
 * 푸는데 3시간 소요 우왕 실화냐 ㅋㅋ
 */
public class 타임머신 {
	static class Bus {
		int start, end, weight;
		Bus (int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	static int N, M;
	static long dist[];
	static Bus busArr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
		
		dist = new long[N+1]; // 최단거리[1번->2번, 1번->3번,.., 1번->N번]
		
		// 시작점에서 각 정점으로 가는 최단 거리 저장 배열 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		busArr = new Bus[M];
		for (int i=0; i<M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st1.nextToken());
			int end = Integer.parseInt(st1.nextToken());
			int weight = Integer.parseInt(st1.nextToken()); // -10000 <= c <= 10000
			busArr[i] = new Bus(start, end, weight);
		}
		
		if (bellmanFord()) {
			for (int i=2; i<=N; i++)
				if (dist[i] == Integer.MAX_VALUE) // 도시로 가는 경로가 없다면
					System.out.println("-1");
				else
					System.out.println(dist[i]);
		}
		else { // 시간을 무한히 되돌릴 수 있다면
			System.out.println("-1");
		}
		for (int i=1; i<=N; i++)
			System.out.print(dist[i]+" ");
		
		System.out.println();
		

	}
	// 벨만 포드 알고리즘 (음의 cycle이 있다면 false, 없다면 true)
	private static boolean bellmanFord() {
		dist[1] = 0; // 시작점은 최단거리 0 (1에서 1 가는건 당연히 0)
		// 최단 경로라는 말은 같은 정점을 두 번 이상 지날 일이 없기 때문에 가능한 최단 경로의 '간선' 개수는 많아봤자 V-1개이다. ex) O-O-O
		for (int i=0; i<N-1; i++) { // V-1번 수행 (1, 2, 3,.., N-1), 모든 간선에 대해 relaxation을 수행
			for (int j=0; j<M; j++) {
				Bus b = busArr[j]; // input 배열
				// 더 작은 최단거리가 있는 경우 갱신
				if (dist[b.start] != Integer.MAX_VALUE && dist[b.end] > dist[b.start] + b.weight) {
					dist[b.end] = dist[b.start] + b.weight;
				}
			}
		}
		// 음의 cycle이 있으면 false 
		// 갱신되는게 있다면 음수 cycle이 있다는 뜻
		for (int i=0; i<M; i++) {
			Bus b = busArr[i]; // input 배열 
			if (dist[b.start] != Integer.MAX_VALUE && dist[b.end] > dist[b.start] + b.weight)
				return false;
		}
		
		return true;
	}

}
