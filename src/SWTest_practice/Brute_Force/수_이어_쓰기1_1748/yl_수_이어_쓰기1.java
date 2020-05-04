package SWTest_practice.Brute_Force.수_이어_쓰기1_1748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//cnt += (int)(Math.log10(i)+1); 자릿수를 이렇게도 구할 수 있군.
//StringBuilder 사용 -> 메모리 초과.
public class yl_수_이어_쓰기1 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int ans = 0;
		int len = 10;
		
		for (int i=1; i<=N; i++) {
			if (i == len) { // 10, 100, 1000, 10000, ...
				cnt++;
				len *= 10;
			}
			ans += cnt;
		}
		
		System.out.println(ans);
	}

}
