package SWTest_basic.Dynamic_Programming.제곱수의_합_1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 난이도가 있지만 그렇다고 못 풀건 아님.
public class 다시풀기_yl_제곱수의_합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int dp[] =  new int[N + 1];

		dp[1] = 1;
		for (int i=2; i<=N; i++) {
			dp[i] = i;
			for (int j=1; j<=(int)Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
				//dp[i] = Math.min(dp[i], dp[i - j*j] + dp[j*j]);
				//원래 +1 대신 +dp[j*j]라고 썼는데 1이 맞음. 왜냐면 dp[제곱수]는 어차피 1이니까.
				//+dp[j*j]하면 제곱근일때 1인게 저장이 안 됨.
			}
		}
		
		for (int i=1; i<=N; i++)
			System.out.print(dp[i]+" ");
		System.out.println(dp[N]);

	}

}
