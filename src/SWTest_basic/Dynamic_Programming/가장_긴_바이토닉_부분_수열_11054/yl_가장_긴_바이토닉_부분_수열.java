package SWTest_basic.Dynamic_Programming.가장_긴_바이토닉_부분_수열_11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//앞에서부터 긴 수열을 구하고, 뒤에서부터 같은 방식으로 구한 다음, 둘 값을 더해서 가장 큰 값에서 -1
//이것만 생각해내면 쉬운데 못 생각해냈음 ^_^
public class yl_가장_긴_바이토닉_부분_수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int dp1[] =  new int[N];
		int dp2[] =  new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp1[i] = 1;
			dp2[i] = 1;
		}
		
		for (int i=1; i<N; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j])
					dp1[i] = Math.max(dp1[i], dp1[j] + 1);
			}
		}
		
		for (int i=N-2; i>=0; i--) {
			for (int j=N-1; j>i; j--) {
				if (arr[i] > arr[j])
					dp2[i] = Math.max(dp2[i], dp2[j] + 1);
			}
		}
		
		int max = 0;
		for (int i=0; i<N; i++)
			max = Math.max(max, dp1[i] + dp2[i] - 1);
		
		System.out.println(max);
		
	}
}
