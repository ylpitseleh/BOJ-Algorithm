package SWTest_practice.Dynamic_Programming.파일_합치기_11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// https://heedipro.tistory.com/265
public class yl_파일_합치기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int K = Integer.parseInt(br.readLine());
			int dp[] = new int[K];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<K; i++)
				dp[i] = Integer.parseInt(st.nextToken());
			
			
				
		}
	}

}
