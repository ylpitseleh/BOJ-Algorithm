package SWTest_basic.Dynamic_Programming.가장_큰_증가_부분_수열_11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 가장 긴 증가하는 부분수열 친구. 그거 풀면 이건 쉽게 품.
public class yl_가장_큰_증가_부분_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i])
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
			}
		}
		
		//for (int i=0; i<N; i++)
			//System.out.print(dp[i]+" ");
		
		int max = 0;
		for (int i=0; i<N; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max);
		
	}

}
