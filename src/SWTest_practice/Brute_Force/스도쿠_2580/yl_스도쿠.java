package SWTest_practice.Brute_Force.스도쿠_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
// 진자 왜이렇게 어렵냐. 공부의욕 저하. 못 품
public class yl_스도쿠 {
	static int map[][];
	static int bY;
	static int bX;
	static class Pos {
		int y;
		int x;
		Pos (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		int tmp = 0;
		for (int i=1; i<=9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1; j<=9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=1; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				if (map[i][j] == 0) {
					dfs(i, j);
				}
			}
		}

	}
	public static void dfs(int y, int x) {
		getBoundary(y, x);
		// 가로, 세로, 같은 Boundary 비교해서 안 나온 숫자만 추리기
		boolean unused[] = new boolean[9];
		unused = findNumUnused(y, x);
		
		for (int i=0; i<9; i++) {
			if (!unused[i]) {
				unused[i] = true;
				// dfs()
				unused[i] = false;
			}
		}
	}
	
	public static boolean[] findNumUnused(int y, int x) {
		// Boundary 안에서 체크
		boolean check1[] = new boolean[9];
		for (int i=bY-2; i<=bY; i++) {
			for (int j=bX-2; j<=bX; j++) {
				if (map[i][j] != 0)
					check1[map[i][j]-1] = true;
			}
		}
		// 가로 체크
		boolean check2[] = new boolean[9];
		for (int i=1; i<=9; i++) {
			if (map[y][i] != 0)
				check2[map[y][i]-1] = true;
		}
		// 세로 체크
		boolean check3[] = new boolean[9];
		for (int i=1; i<=9; i++) {
			if (map[i][x] != 0)
				check3[map[i][x]-1] = true;
		}
		// 체크하면서 나오지 않은 숫자 리턴
		boolean unused[] = new boolean[9];
		for (int i=0; i<9; i++) {
			if (!(check1[i] == false && check2[i] == false && check3[i] == false)) {
				unused[i] = true;
			}
		}
		return unused;
	}
	
	public static void getBoundary(int y, int x) {
		/*
		 * 1 2 3
		 * 4 5 6
		 * 7 8 9 중 어디 속하는지
		 */
		bY = y;
		bX = x;
		if (y % 3 == 1)
			bY = y + 2;
		if (x % 3 == 1)
			bX = x + 2;
		
		if (y % 3 == 2)
			bY = y + 1;
		if (x % 3 == 2)
			bX = x + 1;
	}

}
