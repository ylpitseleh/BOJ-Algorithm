package SWTest_practice.Brute_Force.맞춰봐_1248;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// sum 처리하는 부분, System.exit(0) 모르면 시간초과남.
public class yl_맞춰봐 {
	static int N;
	static char arr[][];
	static int a[];
	static int[] sumArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int n = N*(N+1)/2;
		arr = new char[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = st.nextToken();
		int idx = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (i <= j) {
					arr[i][j] = s.charAt(idx);
					idx++;
				}
			}
		}
		/*
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		a = new int[N];
		sumArr = new int[N]; //0부터 index까지의 합 넣는 배열
		dfs(0);
	}
	public static void dfs(int depth) {
		if (depth == N) {
			for (int i=0; i<depth; i++)
				System.out.print(a[i]+" ");
			System.exit(0); // 강제로 JVM 종료
		}
		
		int sign = 1; // +일 때
		if (arr[depth][depth] == '-') // -일 때
			sign = -1;
		if (arr[depth][depth] == '0') // 0일 때
			sign = 0;
		
		for (int i=1; i<=10; i++) {
			if (sign == -1) 
				a[depth] = -1 * i;
			else if (sign == 0)
				a[depth] = 0;
			else if (sign == 1){	
				a[depth] = i;
			}
			
			if (depth != 0) { 
				sumArr[depth] = a[depth] + sumArr[depth-1];
			}
			else {
				sumArr[0] = a[0];
			}
			
			if (check(depth))
				dfs(depth + 1);
		}
		
	}
	
	public static boolean check(int depth) {
		for (int i=0; i<=depth; i++) {
			int sum = 0;
			if (i==0)
				sum = sumArr[depth];
			else
				sum = sumArr[depth] - sumArr[i-1]; //이 부분 핵심
			// i부터 depth까지 합을 알고싶으면 sumArr[depth] - sumArr[i-1] 하면 됨.(1~3까지 합 알고싶으면 전체 0부터3까지 - 0일 때 인 원리)
			if (arr[i][depth] == '+') {
				if (sum <= 0)
					return false;
			}
			else if (arr[i][depth] == '-') {
				if (sum >= 0)
					return false;
			}
			else if (arr[i][depth] == '0') {
				if (sum != 0)
					return false;
			}
		}
		
		// 밑에는 시간초과 난 코드 
		/*
		for (int i=0; i<=depth; i++) {
			for (int j=0; j<=depth; j++) {
				if (i <= j) {
					int sum = 0;
					for (int k=i; k<=j; k++)
						sum += a[k];
					if (arr[i][j] == '+') {
						if (sum <= 0) {
							return false;
						}
					}
					else if (arr[i][j] == '-') {
						if (sum >= 0) {
							return false;
						}
					}
					else if (arr[i][j] == '0') {
						if (sum != 0) {
							return false;
						}
					}
				}
			}
		}
		*/
		return true;
	}

}
