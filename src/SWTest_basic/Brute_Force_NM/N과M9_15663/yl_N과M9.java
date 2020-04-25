package SWTest_basic.Brute_Force_NM.N과M9_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이해 잘 안됨
public class yl_N과M9 {
	static int N;
	static int M;
	static int arr[];
	static boolean visited[];
	static int ans[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 자연수 중
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
		// 고른 수열은 오름차순이어야 한다.
		arr = new int[N];
		ans = new int[M];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st1.nextToken());
		Arrays.sort(arr);
		visited = new boolean[N];
		recursive(0);
	}

	public static void recursive(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		int before = -1;
		for (int i = 0; i < N; i++) {
			if (visited[i])
				continue;
			if (i == 0 || before != arr[i]) { //추가된 부분
				before = arr[i]; //추가된 부분
				visited[i] = true;
				ans[depth] = arr[i];
				recursive(depth + 1);
				visited[i] = false;
			}
		}

	}

}
