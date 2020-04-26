package SWTest_basic.Dynamic_Programming.포도주_시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 반례
6
1000
900
2
1
800
700
*/
/*
 * OOX dp[i-1]
 * OXO dp[i-2] + arr[i]
 * XOO dp[i-3] + arr[i-1] + arr[i] -> 이 경우를 생각 못 했음
 * 점화식만 생각해내면 되는데 이게 어려움. 결국 배꼈당.
 */
public class 다시_풀기yl_포도주_시식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());

		dp[0] = arr[0];
		if (n >= 2)
			dp[1] = arr[1] + dp[0];
		if (n >= 3) // (1, 2), (2, 3), (1, 3)
			dp[2] = Math.max(dp[1], Math.max(arr[1], dp[0]) + arr[2]);
		
		for (int i = 3; i < n; i++)
			dp[i] = Math.max(Math.max(dp[i-1], dp[i-2]+arr[i]), dp[i-3]+arr[i-1]+arr[i]);
		/*
		for (int i=0; i<n; i++) {
			System.out.print(dp[i]+" ");
		}
		*/
		System.out.println(dp[n-1]);
		

	}

}
