package SWTest_practice.Brute_Force.구슬_탈출_2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 미완성. 뭔가 될듯한데 안 된다. 풀이는 4차원 배열을 만들어야 한다고 하는데 꼭 그렇게 해야하나..?
public class yl_구슬_탈출_2 {
	static int h, w;
	static int answer = -1;
	static char[][] map;
	static int[][] move;
	static Queue<Pos> rQ = new LinkedList<Pos>();
	static Queue<Pos> bQ = new LinkedList<Pos>();

	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static int redY = 0, redX = 0;
	static int blueY = 0, blueX = 0;
	static int holeY = 0, holeX = 0;
	static int rLocY, rLocX, bLocY, bLocX;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		move = new int[h][w];
		map = new char[h][w];
		for (int i = 0; i < h; i++) {
			String s = br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					redY = i;
					redX = j;
				}
				if (map[i][j] == 'O') {
					holeY = i;
					holeX = j;
				}
				if (map[i][j] == 'B') {
					blueY = i;
					blueX = j;
				}
			}
		}
		rLocY = redY;
		rLocX = redX;

		bLocY = blueY;
		bLocX = blueX;
		bfs();
	}

	public static void bfs() {
		initialize();
		rQ.add(new Pos(redY, redX));
		bQ.add(new Pos(blueY, blueX));
		move[redY][redX] = 0;

		while (!rQ.isEmpty()) {
			Pos pR = rQ.poll();
			Pos pB = bQ.poll();
			
			if (pR.y == holeY && pR.x == holeX) {
				answer = move[holeY][holeX];
				if (answer > 10)
					answer = -1;
				System.out.println(answer);
				break;
			}
			if (pB.y == holeY && pB.x == holeX) {
				System.out.println("-1");
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				// 빨간 구슬 이동
				int rny = pR.y + dy[i];
				int rnx = pR.x + dx[i];
				
				while (rny >= 0 && rny < h && rnx >= 0 && rnx < w) {
					if (map[rny][rnx] == '#' || map[rny][rnx] == 'B')
						break;
					if (move[rny][rnx] == Integer.MAX_VALUE) {
						rQ.add(new Pos(rny, rnx));
						move[rny][rnx] = move[pR.y][pR.x] + 1;
					}
					rny += dy[i];
					rnx += dx[i];

					rLocY = rny - dy[i];
					rLocX = rnx - dx[i];
				}
				if (map[rLocY][rLocX] != '#' && map[rLocY][rLocX] != 'B') {
					map[rLocY][rLocX] = 'R';
					map[redY][redX] = '.';
					redY = rLocY;
					redX = rLocX;
				}


				// 파란 구슬 이동
				int bny = pB.y + dy[i];
				int bnx = pB.x + dx[i];

				while (bny >= 0 && bny < h && bnx >= 0 && bnx < w) {
					if (map[bny][bnx] == '#' || map[bny][bnx] == 'R')
						break;
					// if (move[bny][bnx] == Integer.MAX_VALUE) {
					// move[bny][bnx] = move[pB.y][pB.x] + 1;
					// }
					bny += dy[i];
					bnx += dx[i];

					bLocY = bny - dy[i];
					bLocX = bnx - dx[i];
				}
				bQ.add(new Pos(bLocY, bLocX));
				if (map[bLocY][bLocX] != '#' && map[bLocY][bLocX] != 'R') {
					map[bLocY][bLocX] = 'B';
					map[blueY][blueX] = '.';
					blueY = bLocY;
					blueX = bLocX;
				}
				// }

				if (dy[i]==1 && dx[i]==0) {
					System.out.println("아래");
				}
				if (dy[i]==-1 && dx[i]==0) {
					System.out.println("위");
				}
				if (dy[i]==0 && dx[i]==1) {
					System.out.println("오른쪽");
				}
				if (dy[i]==0 && dx[i]==-1) {
					System.out.println("왼쪽");
				}
				//System.out.println(rLocY + " " + rLocX + " " + bLocY + " " + bLocX);
				System.out.println(rny + " " + rnx + " " + bny + " " + bnx);
				for (int k = 0; k < h; k++) {
					for (int j = 0; j < w; j++) {
						System.out.print(map[k][j]);
						// System.out.printf("%10d ", map[k][j]);
					}
					System.out.println();
				}
				System.out.println();

			}
		}

	}

	public static void initialize() {
		for (int i = 0; i < h; i++)
			Arrays.fill(move[i], Integer.MAX_VALUE);
	}
}
