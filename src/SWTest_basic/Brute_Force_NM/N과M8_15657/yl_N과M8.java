package SWTest_basic.Brute_Force_NM.N과M8_15657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_N과M8 {
	static int N;
	static int M;
	static int arr[];
	static boolean visited[];
	static int ans[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //N개의 자연수 중
		M = Integer.parseInt(st.nextToken()); //M개를 고른 수열
		//고른 수열은 오름차순이어야 한다.
		arr = new int[N];
		ans = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st1.nextToken());
		Arrays.sort(arr);
		visited = new boolean[N];
		recursive(0);
	}
	
	public static void recursive(int depth) {
		if (depth == M) {
			for (int i=0; i<M; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
			return ;
		}
		
		for (int i=0; i<N; i++) {
			visited[i] = true;
			ans[depth] = arr[i];
			if (depth == 0 || (depth > 0 && ans[depth-1] <= ans[depth]))
				recursive(depth + 1);
			visited[i] = false;
		}
	}
}
