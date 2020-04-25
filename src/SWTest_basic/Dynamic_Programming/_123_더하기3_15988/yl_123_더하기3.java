package SWTest_basic.Dynamic_Programming._123_더하기3_15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yl_123_더하기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[1000001];
		for (int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int j=4; j<=n; j++) {
				dp[j] = (long)(dp[j-1] + dp[j-2] + dp[j-3]) % 1000000009;
			}
			System.out.println(dp[n]);
		}
	}

}
