package SWTest_basic.Dynamic_Programming.이친수_2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yl_이친수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dp = new long[N+2];
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<=N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
