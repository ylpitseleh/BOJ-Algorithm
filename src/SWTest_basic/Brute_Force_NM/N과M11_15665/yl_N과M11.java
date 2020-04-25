package SWTest_basic.Brute_Force_NM.N과M11_15665;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_N과M11 {
	static int N;
	static int M;
	static int arr[];
	static boolean visited[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 자연수 중
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
		// 같은 수를 여러 번 골라도 된다.
		sb = new StringBuilder();
		arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st1.nextToken());
		Arrays.sort(arr);
		visited = new boolean[N];
		
		recursive(0, "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}

	public static void recursive(int depth, String str) {
		if (depth == M) {
			sb.append(str.trim() + "\n");
			return;
		}
		int before = -1;
		for (int i = 0; i < N; i++) {
			if (i == 0 || before != arr[i]) {
				before = arr[i];
				visited[i] = true;
				recursive(depth + 1, str + " " + arr[i]);
				visited[i] = false;
			}
		}
	}

}
