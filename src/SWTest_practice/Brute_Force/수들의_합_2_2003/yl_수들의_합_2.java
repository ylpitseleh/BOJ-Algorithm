package SWTest_practice.Brute_Force.수들의_합_2_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_수들의_합_2 {
	static int N, M;
	static int arr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		int answer = 0;
		int start = 0;
		int end = 0;
		while (start < N) {
			int sum = 0;
			end = start;
			
			while (end < N) {
				sum += arr[end];
				if (sum == M)
					answer++;
				if (sum > M)
					break ;
				end++;
			}
			start++;
		}
		
		System.out.println(answer);
	}

}
