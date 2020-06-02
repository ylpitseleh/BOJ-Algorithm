package SWTest_practice.Dynamic_Programming.팰린드롬_10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 질문의 개수가 100만개까지 있을 수 있어서 StringBuilder를 사용해야 함.
// 1~4 자리 = 2~3자리가 Palindrome일때 + if(arr[1] == arr[4])인 원리. 쉬움
public class yl_팰린드롬 {
	static int N, M;
	static int[] arr;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());
		for (int i=N-1; i>=0; i--) {
			for (int j=N-1; j>=i; j--) {
				if (i==j)
					dp[i][j] = 1;
				if (j-i == 1) { // 두 자리일 때 같아야 Palindrome
					if (arr[i] == arr[j])
						dp[i][j] = 1;
				}
				if (i+1 < N && j-1 >= 0) {
					if (dp[i+1][j-1] == 1 && arr[i] == arr[j])
						dp[i][j] = 1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st1.nextToken());
			int end = Integer.parseInt(st1.nextToken());
			sb.append(dp[start-1][end-1]+"\n");
		}
		System.out.println(sb);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
