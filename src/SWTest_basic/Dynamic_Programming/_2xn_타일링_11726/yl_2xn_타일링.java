package SWTest_basic.Dynamic_Programming._2xn_타일링_11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// d[n-2]의 사각형 오른쪽에 누워진 직사각형 2개가 붙음
// d[n-1]의 사각형 오른쪽에 세워진 직사각형 1개가 붙음
public class yl_2xn_타일링 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		for (int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		System.out.println(dp[n]);
	}

}
