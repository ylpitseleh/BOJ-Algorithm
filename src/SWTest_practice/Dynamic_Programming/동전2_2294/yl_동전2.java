package SWTest_practice.Dynamic_Programming.동전2_2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 전형적인 쉬운 dp문제
public class yl_동전2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coins[] = new int[n+1];
		for (int i=1; i<=n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int dp[] = new int[k+1];

		for (int i=1; i<=k; i++) {
			dp[i] = 100001;
			for (int j=1; j<=n; j++) {
				if (i == coins[j])
					dp[i] = 1;
			}
			for (int j=1; j<=i/2; j++) {
				dp[i] = Math.min(dp[j]+dp[i-j], dp[i]);
			}
		}
		
		//for (int i=1; i<=k; i++) {
			//System.out.println(i+" : "+dp[i]);
		//}
		if (dp[k] == 100001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
		
	}

}
