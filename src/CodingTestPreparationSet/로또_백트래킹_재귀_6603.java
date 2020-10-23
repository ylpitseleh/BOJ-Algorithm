package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또_백트래킹_재귀_6603 {
	static int N;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0)
				break;
			arr = new int[N];
			visited = new boolean[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println();
		}
	}
	
	private static void dfs (int depth, int idx) {
		if (depth == 6) {
			for (int i=0; i<N; i++) {
				if (visited[i])
					System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
		for (int i=idx; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(depth + 1, i);
				visited[i] = false;
			}
		}
	}

}
