package Dynamic_Programming._1로_만들기_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class yl_1로_만들기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] = new int[1000001];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		for(int i=4; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			if(i%2==0)
				dp[i] = Math.min(dp[i], dp[i/2]+1);
			if(i%3==0)
				dp[i] = Math.min(dp[i], dp[i/3]+1);
		}
		System.out.println(dp[N]);
	}
}
