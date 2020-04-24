package Dynamic_Programming.카드_구매하기2_16194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_카드_구매하기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //구매하려는 카드의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cards[] = new int[N+1];
		int dp[] = new int[N+1];
		for (int i=1; i<=N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
			dp[i] = cards[i];
		}
		
		for (int i=2; i<=N; i++) {
			for (int j=1; j<i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + cards[j]);
			}
		}
		System.out.println(dp[N]);
	}

}
