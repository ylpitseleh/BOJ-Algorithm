package Dynamic_Programming;

import java.util.Scanner;

public class notepad {
	
	public static void main(String[] args) {
		final int mod = 1000000000;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[][] dp = new long[n+1][10];
		
		for(int i=1; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0)
					dp[i][0] = dp[i-1][1];
				else if(j==9)
					dp[i][9] = dp[i-1][8];
				else
					dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1]) % mod;
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=9; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println("\n");
		}
		long ans=0;
		for(int i=0; i<=9; i++) {
			ans += dp[n][i];
		}
		System.out.println(ans % mod);

	}

}
