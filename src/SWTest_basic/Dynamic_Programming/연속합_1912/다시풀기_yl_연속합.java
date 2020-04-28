package SWTest_basic.Dynamic_Programming.연속합_1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 이렇게 쉬운거였다니...
public class 다시풀기_yl_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] =  new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int max = arr[0];
		for(int i=1; i<N; i++) {
			//현재 원소까지 더한걸로 할 지 아니면 arr[i]로 새로 시작할지 
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
			max = Math.max(max, dp[i]);
		}
		
		for(int i=0; i<N; i++)
			System.out.print(dp[i]+" ");
		
		System.out.println(max);
		
	}

}
