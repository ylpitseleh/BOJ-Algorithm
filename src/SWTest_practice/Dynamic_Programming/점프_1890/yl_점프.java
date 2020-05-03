package SWTest_practice.Dynamic_Programming.점프_1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_점프 {
	static int N;
	static int[][] map;
	static long[][] dp;
	/* 내가 원래 작성한 점화식
	 * 
	 * 1) dp[i+map[i][j]][j] += 1;
	 * 4
	 * 1 1 9 9
	 * 1 1 1 9
	 * 9 9 1 9
	 * 9 9 1 0 일 때 원래 답은 2 인데 1이 나옴.
	 * 
	 * 2) dp[i+map[i][j]][j] = Math.max(dp[i][j], dp[i+map[i][j]][j] + 1);
	 * 이건 왜 안 되는지 모르겠음 흐엉.
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new long[N][N];
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 이렇게 안 하고 dp[0][0] = 1 한 다음에 이중 for문 안에서 if (dp[i][j] == 0) continue ; 해도 됨.
		if (map[0][0] < N) {
			dp[map[0][0]][0] += 1;
			dp[0][map[0][0]] += 1;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i+map[i][j] < N) {
					if (dp[i][j] > 0 && map[i][j] != 0) 
						dp[i+map[i][j]][j] += dp[i][j]; 
				}
				if (j+map[i][j] < N) {
					if (dp[i][j] > 0 && map[i][j] != 0)
						dp[i][j+map[i][j]] += dp[i][j];
				}			
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
		
		
		
	}

}
