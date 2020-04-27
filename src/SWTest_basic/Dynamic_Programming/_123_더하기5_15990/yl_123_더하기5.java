package SWTest_basic.Dynamic_Programming._123_더하기5_15990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 숫자가 연속이 되지 않게 
 * ex) i-3은 뒤에 3이 붙으면 3이 연속이되므로 1, 2로 끝나는 것만 더해주고
 * i-2는 1, 3으로 끝나는 것 더해주고
 * i-1는 2, 3으로 끝나는 것 더해줌
 * dp를 이차원 배열로 만드는 것만 떠올리면 쉬움.
 */
public class yl_123_더하기5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		final int mod = 1000000009;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long[][] dp = new long[1000001][3+1];
		for (int x=0; x<T; x++) {
			int n = Integer.parseInt(br.readLine());
			dp[1][1] = 1;
			dp[2][2] = 1;
			dp[3][1] = dp[3][2] = dp[3][3] = 1;
			for (int i=4; i<=n; i++) {
				dp[i][1] = (long)((dp[i-1][2] + dp[i-1][3]) % mod);
				dp[i][2] = (long)((dp[i-2][1] + dp[i-2][3]) % mod);
				dp[i][3] = (long)((dp[i-3][1] + dp[i-3][2]) % mod);
			}
			/*
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=3; j++) {
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}
			*/
			long sum = 0;
			sum = dp[n][1] + dp[n][2] + dp[n][3];
			
			System.out.println(sum % mod);
		}
	}
}
