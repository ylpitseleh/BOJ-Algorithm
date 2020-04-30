package SWTest_basic.Dynamic_Programming.연속합2_13398;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//아예 로직을 떠올릴 엄두도 안 나서 그냥 답 봄
//dp[i-1][0] + arr[i]이랑  dp[i-1][1] + arr[i]이걸 따로 저장하는게 무슨 의미인지 모르겠다.
public class yl_연속합2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+2];
		int dp[][] =  new int[N+2][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=2; i<=N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//dp[][0]에는 연속합 문제와 같은 배열 넣기
		//dp[][1]에는 하나 빼고 카운트할 때 배열 넣기
		int max = Integer.MIN_VALUE;
		for(int i=2; i<=N+1; i++) {
			//현재 원소까지 더한걸로 할 지 아니면 arr[i]로 새로 시작할지 
			//dp[i][0] : 0번 건너뛴 i까지의 최대 연속합 = (i-1까지의 최대 연속합 + A[i])값과 A[i]값 중 큰 값
			dp[i][0] = Math.max(arr[i], dp[i-1][0] + arr[i]);
			//dp[i][1] : 1번 건너뛴 i까지의 최대 연속합 = (i-1을 건너뛴 i까지의 최대 연속합)값과 (i-1을 안건너뛴 i까지의 최대 연속합)값 중 큰 값
			dp[i][1] = Math.max(dp[i-2][0] + arr[i], dp[i-1][1] + arr[i]);
			//System.out.println(dp[i-2][0] + arr[i]);
			//System.out.println(dp[i-1][1] + arr[i]);
			max = Math.max(Math.max(max, dp[i][0]), dp[i][1]);
			//System.out.println();
		}
		
		//for(int i=0; i<N; i++)
			//System.out.print(dp[i]+" ");
		
		System.out.println(max);
		
	
		
	}

}
