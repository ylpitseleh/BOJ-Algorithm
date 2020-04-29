package SWTest_basic.Dynamic_Programming.합분해_2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://mizzo-dev.tistory.com/entry/baekjoon2225
//문제가 깔끔하게 안 떨어져서 삽질을 많이 해야함. 썩 좋은 문제인지는 모르겠음.
public class yl_합분해 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int dp[][] = new int[201][201];
		
		// K == 1이면 무조건 dp는 1
		for (int i=1; i<=N; i++)
			dp[i][1] = 1;
		// N == 1이면 무조건 dp는 N
		for (int i=1; i<=K; i++)
			dp[1][i] = i;
		
		for (int i=2; i<=N; i++) {
			for (int j=2; j<=K; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
