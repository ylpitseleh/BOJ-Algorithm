package SWTest_practice.Brute_Force.부분합_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_부분합 {
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
		int len = Integer.MAX_VALUE;
		
		int start = 0;
		int end = 0;
		while (start < N) {
			int sum = 0;
			end = start;
			
			while (end < N) {
				sum += arr[end];
				if (sum >= M) {
					len = end - start;
					answer = Math.min(answer, len);
					break ;
				}
				end++;
			}
			start++;
		}
		
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		else
			answer++;
		System.out.println(answer);
		
		/*
		int min = Integer.MAX_VALUE;
        int s = -1;
        int e = 0;
        int sum = value[0];
        while(true) {
            if(sum >= S) {
                min = Math.min(min, e - s);
                s++;
                if(s >= N) break;
                sum -= value[s];
            } else {
                e++;
                if(e >= N) break;
                sum += value[e];
            }
        }

        if (min == Integer.MAX_VALUE) min = 0;
        bw.write(Integer.toString(min));
        bw.flush();
        bw.close(); 
		 */
	}

}
