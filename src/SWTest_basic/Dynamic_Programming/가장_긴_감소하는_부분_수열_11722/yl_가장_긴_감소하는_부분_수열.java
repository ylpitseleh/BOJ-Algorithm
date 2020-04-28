package SWTest_basic.Dynamic_Programming.가장_긴_감소하는_부분_수열_11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분 수열에서 부등호 방향만 바꾸면 끝
public class yl_가장_긴_감소하는_부분_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] =  new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		for (int i=1; i<N; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] < arr[j])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
		}
		
		int max = dp[0];
		for (int i=1; i<N; i++) {
			max = Math.max(dp[i], max);
		}
		
		//for (int i=0; i<N; i++)
			//System.out.print(dp[i]+" ");
		
		System.out.println(max);
		
	}
}
