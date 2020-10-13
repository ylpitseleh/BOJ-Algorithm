package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 소요 시간: 10분
 * ★☆☆☆☆, Cheating : X
 * 쉬운 투포인터 문제.
 */
public class 부분합_1806 {
	static long N, M;
	static long arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[(int) N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		int answer = Integer.MAX_VALUE;
		
		int start = 0;
		int end = 0;
		while (start < N) {
			int sum = 0;
			end = start;
			
			while (end < N) {
				sum += arr[end];
				if (sum >= M) {
					System.out.println(start+" "+end);
					if (answer > end - start + 1)
						answer = end - start + 1;
					break ;
				}
				end++;
			}
			start++;
		}
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		
		System.out.println(answer);
	}
}
