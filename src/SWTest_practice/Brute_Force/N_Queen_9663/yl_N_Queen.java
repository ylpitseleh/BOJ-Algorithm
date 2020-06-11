package SWTest_practice.Brute_Force.N_Queen_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 모든 행에 퀸을 놓는 방법의 수, 가로·세로·대각선과 일치하면 안 됨
// 답 안보고 풀라면 못 풀지 않을까? 내 머리로는 배열을 2차원으로 잡아버릴듯
public class yl_N_Queen {
	static int N;
	static int cnt = 0; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 각 행에는 하나의 열에만 퀸이 놓여질 수 있다.
		// 1열부터 N열까지 돌면서 가능한 경우를 확인
		for (int i=1; i<=N; i++) {
			int[] row = new int[N+1];
			// 1행 i열에 퀸을 놓았다. 퀸을 놓은 위치를 저장. 
			row[1] = i;
			dfs(row, 1);
		}
		System.out.println(cnt);
	}
	
	public static void dfs(int[] row, int rowIdx) {
		if (rowIdx == N)  {
			cnt++;
		}
		else {
			for (int col=1; col<=N; col++) {
				row[rowIdx+1] = col;
				if (isPossible(row, rowIdx+1)) {
					dfs(row, rowIdx+1);
				}
			}
		}
	}
	
	public static boolean isPossible(int[] row, int rowIdx) {
		// 현재 row행 위에 지금까지 둔 것과 비교
		for (int i=1; i<rowIdx; i++) {
			// i행과 row행의 열 값이 같으면 퀸을 놓을 수 없다.
			if (row[i] == row[rowIdx]) 
				return false;
			// i행과 row행의 열 값이 대각선에 위치하는 절대값이면 안 된다.
			if (Math.abs(i-rowIdx) == Math.abs(row[i] - row[rowIdx])) 
				return false;
		}
		return true;
	}

}
