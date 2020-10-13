package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 소요 시간: 15분
 * ★☆☆☆☆, Cheating : X
 * 쉬운 투포인터 문제.
 */
public class 수_고르기_2230 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int answer = Integer.MAX_VALUE;
		int n1 = 0;
		int n2 = 0;
		while (n1 < N) {
			n2 = n1;
			while (n2 < N) {
				if (arr[n2]-arr[n1] >= M) {
					answer = Math.min(arr[n2] - arr[n1], answer);
					break ;
				}
				n2++;
			}
			n1++;
		}
		
		System.out.println(answer);

	}

}
