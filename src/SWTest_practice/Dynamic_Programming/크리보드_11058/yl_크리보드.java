package SWTest_practice.Dynamic_Programming.크리보드_11058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 좀 이상하게 푼 것 같은데 맞았다.
 * dp[11]인 경우 Math.max(dp[3] * 7, dp[4] * 6, dp[5] * 5, dp[6] * 4...)이길래 그냥 그렇게 짜줌. 
 */
public class yl_크리보드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long dp[] = new long[100+1];
		for (int i=1; i<=6; i++)
			dp[i] = i;
		for (int i=7; i<=N; i++) {
			for (int j=2; j<=i-2; j++) {
				dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
			}
		}
		
		//for (int i=1; i<=11; i++)
			//System.out.print(dp[i]+" ");
		
		System.out.println(dp[N]);
	}

}
