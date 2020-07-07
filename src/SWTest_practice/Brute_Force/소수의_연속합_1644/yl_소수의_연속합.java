package SWTest_practice.Brute_Force.소수의_연속합_1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
끝 인덱스를 증가시킨다는 것은 합이 증가된다는 의미이다.
시작 인덱스를 증가시킨다는 것은 합이 감소된다는 의미이다.

나레기 이거 왜 못푸냐 왜 1중포문으로 해결을 못하니...
 */
public class yl_소수의_연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean arr[] = new boolean[N+1];
		arr[0] = arr[1] = false;
		for (int i=2; i<=N; i++)
			arr[i] = true;
		
		for (int i=2; i*i<=N; i++) {
			for (int j=i*i; j<=N; j+=i) {
				arr[j] = false;
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<=N; i++) {
			if (arr[i] == true)
				al.add(i);
		}
		System.out.println(al);
		
		int n = al.size();
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = 0;
		while (start < n) {
			if (sum < N && end < n) {
				sum += al.get(end);
				end++;
				System.out.println(start+" "+end);
				continue ;
			}
			if (sum == N)
				ans++;
			sum -= al.get(start);
			start++;
		}
		
		System.out.println(ans);
		
	}

}
