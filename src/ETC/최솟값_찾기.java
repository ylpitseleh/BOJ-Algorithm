package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최솟값_찾기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		
		for (int i=0; i<N; i++) {
			for (int j=Math.max(i-L+1, 0); j<=i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		int[] answer = new int[N];
		
		Queue<Integer> q = new LinkedList<>();
		
		int min = Integer.MAX_VALUE;
		int i = 0;
		while (true) {
			System.out.println(q);
			System.out.println();
			
			if (i < L) {
				q.add(arr[i]);
				min = Math.min(min, arr[i]);
				answer[i] = min;
			}
			if (i >= L) {
				int qPoll = q.poll(); // 맨 앞 빼기
				//if (min == qP)
				if (i == N)
					break ;
				q.add(arr[i]);
				min = Math.min(min, arr[i]);
				answer[i] = min;
			}
			i++;
		}
		
		for (int j=0; j<N; j++)
			System.out.print(answer[j]+" ");
	}

}
