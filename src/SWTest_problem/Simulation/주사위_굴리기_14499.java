package SWTest_problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위_굴리기_14499 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지도의 세로 크기
		int M = Integer.parseInt(st.nextToken()); // 지도의 가로 크기
		int x = Integer.parseInt(st.nextToken()); // 주사위 놓은 곳 y
		int y = Integer.parseInt(st.nextToken()); // 주사위 놓은 곳 x
		int K = Integer.parseInt(st.nextToken()); // 명령의 개수
		
		int map[][] = new int[N][M];
		for (int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		// 명령. 동 1, 서 2, 북 3, 남 4
		int order[] = new int[K];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i=0; i<K; i++) {
			order[i] = Integer.parseInt(st2.nextToken());
		}
		
		
	}

}
