package Brute_Force_NM.N과M2_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_N과M2 {
	static int N;
	static int M;
	static int arr[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //1부터 N까지 자연수 중
		M = Integer.parseInt(st.nextToken()); //중복없이 M개
		arr = new int[M];
		visited = new boolean[N+1];
		dfs(0);
	}
	
	public static void dfs(int depth) {
		if (depth == M) {
			for(int i=0; i<M; i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			return ;
		}
		for(int i=1; i<=N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			arr[depth] = i;
			//N과 M1에서 추가된 부분. 오름차순이 아닐 경우 실행되지 않음
			if (depth == 0 || (depth > 0 && arr[depth-1] < arr[depth]))
				dfs(depth+1);
			visited[i] = false;
		}
	}

}
