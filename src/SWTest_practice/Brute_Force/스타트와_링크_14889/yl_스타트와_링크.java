package SWTest_practice.Brute_Force.스타트와_링크_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_스타트와_링크 {
	static int N, min = Integer.MAX_VALUE;
	static boolean visited[];
	static int arr[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N+1];
		dfs(0, 0);
		System.out.println(min);
	}
	
	public static void dfs(int start, int depth) {
		if (depth == N/2) {
			int len = N/2;
			// 원래는 dfs 매개변수에 String을 추가해서 여기서 String으로 다뤘었는데 계속 20%에서 틀렸다고 나와서
			// 아마도 모든 배열 인덱스를 1부터 N까지로 줘서 String 인덱스에서 오류나는 것 같아서 배열로 바꿈.
			int[] a = new int[len+1];
			int[] b = new int[len+1];
			// 이렇게 하는걸 생각해내는게 중요. 굳이 String으로 따로 안 담아줘도 visited이용해서 만들 수 있음.
			int aIdx = 1;
			int bIdx = 1;
			for (int i=1; i<=N; i++) {
				if (visited[i])
					a[aIdx++] = i;
				else
					b[bIdx++] = i;
			}
			int aSum = 0;
			for (int i=1; i<=len; i++) {
				for (int j=i+1; j<=len; j++) {
					aSum += arr[a[i]][a[j]];
					aSum += arr[a[j]][a[i]];
				}
			}
			int bSum = 0;
			for (int i=1; i<=len; i++) {
				for (int j=i+1; j<=len; j++) {
					bSum += arr[b[i]][b[j]];
					bSum += arr[b[j]][b[i]];
				}
			}
			if (Math.abs(aSum - bSum) < min)
				min = Math.abs(aSum - bSum);
			
			return ;
		}
		
		for (int i=start+1; i<=N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, depth + 1);
				visited[i] = false;
			}
		}
		
	}

}
