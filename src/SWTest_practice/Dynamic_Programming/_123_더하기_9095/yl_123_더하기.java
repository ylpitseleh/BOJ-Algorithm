package SWTest_practice.Dynamic_Programming._123_더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yl_123_더하기 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int dp[] = new int[11];
		for (int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			dp[0] = 1;
			dp[1] = 2;
			dp[2] = 4;
			for (int i=3; i<n; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			System.out.println(dp[n-1]);
		}
	}

}
