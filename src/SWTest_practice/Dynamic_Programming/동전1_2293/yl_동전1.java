package SWTest_practice.Dynamic_Programming.동전1_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 123더하기4랑 친구 문제. 2차원배열 + 오름차순으로 넣는거 생각만 하면 안 어려움.
public class yl_동전1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int coins[] = new int[n+1];
		for (int i=1; i<=n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int dp[][] = new int[k+1][n+1];
		
		for (int i=1; i<=k; i++) {
			for (int j=1; j<=n; j++) {
				if (i == coins[j])
					dp[i][j] = 1;
				if (i - coins[j] > 0) {
					int sum = 0;
					for (int l=1; l<=j; l++) {
						sum += dp[i-coins[j]][l];
					}
					dp[i][j] = sum;
				}
			}
		}
		int sum = 0;
		for (int i=1; i<=n; i++) {
			sum += dp[k][i];
		}
		System.out.println(sum);
		/*
		for (int i=1; i<=k; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		*/
	}

}
