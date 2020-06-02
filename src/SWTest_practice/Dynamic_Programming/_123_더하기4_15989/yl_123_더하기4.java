package SWTest_practice.Dynamic_Programming._123_더하기4_15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 2차원배열로 푸는것 + 오름차순인 것만 생각해냈으면 됐는데 다른 규칙이 있을 줄 알고 삽질했다.
public class yl_123_더하기4 {
	static int T;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		int dp[][] = new int[10001][4]; // n개 x 1로 끝나는 경우의 수, 2로 끝나는 경우의 수, 3으로 끝나는 경우의 수
		
		dp[1][1]=1;
        dp[1][2]=0;
        dp[1][3]=0;
        
        dp[2][1]=1;
        dp[2][2]=1;
        dp[2][3]=0;
        
        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;
        
        for(int i=4; i<=10000; i++) {
            dp[i][1] = dp[i-1][1]; // 1, 11, 111, 1111...
            dp[i][2] = dp[i-2][1]+dp[i-2][2]; // 오름차순이므로 n보다 2작은 것의 1로 끝나는 것, 2로 끝나는 것에 뒤에 2를 더하면 n임
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3]; // 오름차순이므로 n보다 3작은 것의 1로 끝나는 것, 2로 끝나는 것, 3으로 끝나는 것에 3을 더하면 n임 
        }
        
        StringBuilder sb = new StringBuilder();
		for (int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			int sum = dp[n][1] + dp[n][2] + dp[n][3];
			sb.append(sum + "\n");
		}
		System.out.println(sb);
	}

}
