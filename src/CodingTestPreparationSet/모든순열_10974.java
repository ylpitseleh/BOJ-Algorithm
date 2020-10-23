package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 모든순열_10974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		for (int i=0; i<N; i++)
			arr[i] = i+1;
		boolean visited[] = new boolean[N];
		int[] answer = new int[N];
		dfs(0, answer, arr, visited);

	}
	
	private static void dfs(int depth, int[] answer, int[] arr, boolean[] visited) {
		if (depth == arr.length) {
			for (int i=0; i<answer.length; i++) {
				System.out.print(answer[i]+" ");
			}
			System.out.println();
		}
		
		for (int i=0; i<arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				answer[depth] = arr[i];
				dfs (depth+1, answer, arr, visited);
				visited[i] = false;
			}
		}
	}

}
