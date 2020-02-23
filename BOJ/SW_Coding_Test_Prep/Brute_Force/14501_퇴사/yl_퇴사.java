import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_퇴사 {
//https://zoonvivor.tistory.com/148
//나중에 꼭 꼭 다시 풀어보기. 중요하고 꽤 어려운 dp개념
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] time = new int[N + 1];
		int[] price = new int[N + 1];
		//마지막 날 arr범위 초과할 수 있으므로 최대로 잡음.
		int[] dp = new int[N + 10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=0; i<=N; i++) {
			//이전까지의 최대 수입을 비교해서 최대 수입을 현재에도 저장해준다.
			dp[i] = Math.max(dp[i], max);
			//이전에 저장된 최대 수익 vs 이번 움직임으로 생긴 최대 수익
			dp[time[i]+i] = Math.max(dp[time[i]+i], price[i]+dp[i]);
			max = Math.max(max, dp[i]);
		}
		
		for(int i=0; i<=N; i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println(max);
		
	}

}
