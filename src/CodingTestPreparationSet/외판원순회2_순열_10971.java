package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2_순열_10971 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] visited = new boolean[N];
		for (int i=0; i<N; i++) { // 모든 노드에서 출발할 수 있다. 
			int[] answer = new int[N];
			permu(0, i, i, answer, arr, visited);
			//System.out.println();
		}
		System.out.println(min);
	}
	
	static int min = Integer.MAX_VALUE;
	private static void permu(int depth, int startIdx, int befIdx, int[] answer, int[][] arr, boolean[] visited) {
		if  (depth == answer.length && befIdx == startIdx) { // 마지막 인덱스가 시작 인덱스가 아닌 경우 같은곳 다시 반복하는 현상 발생 (채점 10%에서 틀림)
			int sum = 0;
			for (int i=0; i<answer.length; i++) {
				//System.out.print(answer[i]+" ");
				sum += answer[i];
			}
			//System.out.println();
			min = Math.min(min, sum);
		}
		
		for (int i=0; i<answer.length; i++) {
			if (!visited[befIdx] && arr[befIdx][i] > 0) { // visited[befIdx]로 안 하고 visited[i]로 할 시 arr[0][1] 방문했다가 다시 arr[1][0] 방문하게 됨. 
				visited[befIdx] = true;
				answer[depth] = arr[befIdx][i];
				permu (depth+1, startIdx, i, answer, arr, visited);
				visited[befIdx] = false;
			}
		}
		
	}

}
