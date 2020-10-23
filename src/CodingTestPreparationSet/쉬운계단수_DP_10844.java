package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 쉬운계단수_DP_10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[][] = new long[N][10];
		long mod = 1000000000;
		for (int i=1; i<10; i++) {
			dp[0][i] = 1;
		}
		
		for (int i=0; i<N-1; i++) {
			for (int j=0; j<10; j++) {
				if (j-1 >= 0)
					dp[i+1][j-1] += dp[i][j] % mod;
				if (j+1 < 10)
					dp[i+1][j+1] += dp[i][j] % mod;
			}
		}
		
		long answer = 0;
		for (int i=0; i<10; i++) {
			answer += dp[N-1][i];
		}
		System.out.println(answer % mod);
		for (int i=0; i<N; i++) {
			for (int j=0; j<10; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
