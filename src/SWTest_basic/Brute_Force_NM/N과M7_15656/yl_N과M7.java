package SWTest_basic.Brute_Force_NM.N과M7_15656;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//시간초과 해결 위해 String 대신 StringBuilder 활용
//System.out.print 대신 BufferedWriter 사용
public class yl_N과M7 {
	static int N;
	static int M;
	static int arr[];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 자연수 중
		M = Integer.parseInt(st.nextToken()); // M개를 고른 수열
		// 고른 수열은 오름차순이어야 한다.
		sb = new StringBuilder();
		arr = new int[N + 1];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++)
			arr[i] = Integer.parseInt(st1.nextToken());
		Arrays.sort(arr);
		
		recursive(0, "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}

	public static void recursive(int depth, String str) {
		if (depth == M)
			sb.append(str.trim() + "\n");
		else
			for (int i = 1; i <= N; i++)
				recursive(depth + 1, str + " " + arr[i]);
	}
}
