package Dynamic_Programming._2xn_타일링2_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 일일히 그려봐서 규칙을 찾는 방법밖에 없는 것 같은데.. 솔직히 이런 문제가 중요한지 잘 모르겠음.
public class yl_2xn_타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 3;
		for(int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
		}
		System.out.println(dp[n]);
	}
}
