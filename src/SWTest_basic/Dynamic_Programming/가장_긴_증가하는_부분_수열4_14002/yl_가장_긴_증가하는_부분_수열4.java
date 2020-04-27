package SWTest_basic.Dynamic_Programming.가장_긴_증가하는_부분_수열4_14002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/* 
 * 가장 긴 증가하는 부분수열 문제에서 답 다 구한다음에 
 * max에서 dp값이 1씩 작아지는걸 ans배열에 넣어서
 * ans 배열 일일이 출력해줌. 그닥 중요한 문제는 아닌것같음.
 * 다른 사람 풀이를 봐도 최장 길이 구한 다음에 역추적 해가면서 일치하는 값들을 stack에 넣어서 한 번에 출력해줌.
*/
public class yl_가장_긴_증가하는_부분_수열4 {

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
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		for (int i=0; i<N; i++) {
			if (max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		int ans[] = new int[max]; //4
		ans[max-1] = arr[maxIdx];
		int tmp = arr[maxIdx];
		int tmp1 = maxIdx;
		int cnt = max-2;
		for (int i=maxIdx-1; i>=0; i--) {
			if (tmp > arr[i] && dp[i] == dp[tmp1]-1) {
				tmp = arr[i];
				tmp1 = i;
				ans[cnt] = arr[i];
				cnt--;
			}
		}
		
		System.out.println(max);
		for (int i=0; i<max; i++) {
			System.out.print(ans[i]+" ");
		}
		//for (int i=0; i<N; i++) {
			//System.out.print(dp[i]+" ");
		//}
	}

}
