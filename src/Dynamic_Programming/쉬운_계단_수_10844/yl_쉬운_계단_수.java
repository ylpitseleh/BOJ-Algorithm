package Dynamic_Programming.쉬운_계단_수_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 배열에 넣을 때 1000000000로 안나눠줬고, 답 출력할때 long형을 안 써서 틀렸었다. 로직은 맞았음 
public class yl_쉬운_계단_수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		final int mod = 1000000000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N+1][10];
		for (int i=1; i<=9; i++)
			dp[1][i] = 1;
		
		  for (int i=1; i<N; i++) {
			for (int j=0; j<=9; j++) {
				if (j == 0)
					dp[i+1][1] += (dp[i][0] % mod);
				else if (j == 9)
					dp[i+1][8] += (dp[i][9] % mod);
				else {
					dp[i+1][j-1] += (dp[i][j] % mod);
					dp[i+1][j+1] += (dp[i][j] % mod);
				}
			}
		}
		
		/*
		 * 위에는 내가 짠거 이건 내가 짠 것 보다 보기 좋은 코드.
		 * mod를 왜 else에만 해줘도 되는지 모르겠다.  
		 * for (int i=2; i<=N; i++) {
			for (int j=0; j<=9; j++) {
				if (j == 0) {
					dp[i][0] = dp[i-1][1];
				}
				else if (j == 9) {
					dp[i][9] = dp[i-1][8];
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
				}
			}
		}*/
		
		/*for (int i=0; i<=9; i++) {
			System.out.print(dp[N][i]+" ");
		}*/
		
		long sum = 0;
		for (int i=0; i<=9; i++) {
			sum += dp[N][i];
		}
		System.out.println(sum % mod);
	}

}
