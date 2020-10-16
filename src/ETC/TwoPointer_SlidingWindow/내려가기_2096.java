package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기_2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] maxArr = new int[N][3];
		int[][] minArr = new int[N][3];
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if (i == 0) {
					maxArr[i][j] = minArr[i][j] = arr[i][j];
					continue ;
				}
				if (j == 0) {
					maxArr[i][j] = Math.max(maxArr[i-1][0], maxArr[i-1][1]) + arr[i][j];
					minArr[i][j] = Math.min(minArr[i-1][0], minArr[i-1][1]) + arr[i][j];
				}
				else if (j == 1) {
					maxArr[i][j] = Math.max(Math.max(maxArr[i-1][0], maxArr[i-1][1]), maxArr[i-1][2]) + arr[i][j];
					minArr[i][j] = Math.min(Math.min(minArr[i-1][0], minArr[i-1][1]), minArr[i-1][2]) + arr[i][j];
				}
				else {
					maxArr[i][j] = Math.max(maxArr[i-1][1], maxArr[i-1][2]) + arr[i][j];
					minArr[i][j] = Math.min(minArr[i-1][1], minArr[i-1][2]) + arr[i][j];
				}
			}
		}
		
		int maxAns = Math.max(Math.max(maxArr[N-1][0], maxArr[N-1][1]), maxArr[N-1][2]);
		int minAns = Math.min(Math.min(minArr[N-1][0], minArr[N-1][1]), minArr[N-1][2]);
		System.out.println(maxAns+" "+minAns);
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(maxArr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i=0; i<N; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(minArr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
