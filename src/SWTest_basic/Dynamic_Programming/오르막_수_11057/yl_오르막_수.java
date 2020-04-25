package SWTest_basic.Dynamic_Programming.오르막_수_11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 쉬운 계단 수와 비슷한 문제. 
// dp를 2차원 배열로 만드는 것만 생각해내면 금방 풀 수 있음.
public class yl_오르막_수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		final int mod = 10007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[][] = new int[N+1][10];
		
		for (int i=0; i<=9; i++)
			dp[1][i] = 1;
		
		for (int i=2; i<=N; i++) {
			for (int j=0; j<=9; j++) {
				//ex)j = 0이면 00, 01, 02, .., 09 = 10개
				//ex)j = 1이면 11, 12, 13, .., 19 = 9개
				for (int k=0; k<=j; k++) { 
					dp[i][j] += (dp[i-1][k] % 10007);
				}
			}
		}

		long sum = 0;
		for (int i=0; i<=9; i++) {
			//System.out.print(dp[N][i]+" ");
			sum += dp[N][i];
		}
		System.out.println(sum % 10007);
	}

}
