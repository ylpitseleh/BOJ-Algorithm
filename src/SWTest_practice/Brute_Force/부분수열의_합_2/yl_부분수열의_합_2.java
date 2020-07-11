package SWTest_practice.Brute_Force.부분수열의_합_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_부분수열의_합_2 {
	static int N, M;
	static int arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		Arrays.sort(arr);
		
		int start = 0, end = 0;
		int sum = 0;
		int ans = 0;
		boolean addFlag = false; // M = 0, sum = 0일때 문제 해결 위함
		while (start < N) {
			if ((sum < M && end < N) || addFlag == false) {
				sum += arr[end];
				System.out.println(start+" "+end+" "+sum);
				end++;
				addFlag = true;
				continue ;
			}
			//System.out.println(start+" "+end+" "+sum);
			if (sum == M && addFlag == true)
				ans++;
			System.out.println(start+" "+end+" "+sum);
			sum -= arr[start];
			start++;
			addFlag = true;
		}
		System.out.println(ans);

	}

}
