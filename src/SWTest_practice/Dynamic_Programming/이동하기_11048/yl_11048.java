package SWTest_practice.Dynamic_Programming.이동하기_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_11048 {
	static int N, M;
	static int[][] map;
	static int[][] maxCandy;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		maxCandy = new int[N][M];
		for (int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		
		maxCandy[0][0] = map[0][0];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (j == 0 && i > 0)
					maxCandy[i][j] = maxCandy[i-1][j] + map[i][j];
				else if (i == 0 && j > 0)
					maxCandy[i][j] = maxCandy[i][j-1] + map[i][j];
				else if (i > 0 && j > 0)
					maxCandy[i][j] = Math.max(Math.max(maxCandy[i-1][j], maxCandy[i][j-1]), maxCandy[i-1][j-1]) + map[i][j];
			}
		}
		/*
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(maxCandy[i][j]+" ");
			}
			System.out.println();
		}
		*/
		System.out.println(maxCandy[N-1][M-1]);
		
	}

}
