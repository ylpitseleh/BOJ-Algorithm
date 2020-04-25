package SWTest_basic.Dynamic_Programming._123_더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// ex)n이 4일 경우, dp[4] = dp[1]에 3 더한 것 + dp[2]에 2 더한 것 + dp[3] 에 1 더한 것 이라서 그냥 세 개 더해주면 됨.
public class yl_123_더하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			int dp[] = new int[11];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			for (int j=4; j<=n; j++) {
				dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
			}
			System.out.println(dp[n]);
		}
	}

}
