package Graph_and_BFS.탈출_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 아이디어 떠올리기가 힘듦.
 */
public class yl_탈출 {
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static int R, C;
	static char[][] map;
	static int[][] move;
	static int[][] water;
	static boolean[][] visited;
	static int dy[] = { -1, 1, 0, 0 };
	static int dx[] = { 0, 0, -1, 1 };
	static Queue<Pos> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		move = new int[R][C];
		water = new int[R][C];
		visited= new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='D' || map[i][j]=='X')
					water[i][j] = -1;
			}
		}
		//물 채우기
		int cnt = 0;
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == '*')
					bfsWater(i, j);
				ResetVisited();
			}
		}
		ResetVisited();
		//고슴도치 움직이기
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					bfsMove(i, j);
				}
			}
		}
	
	}
	public static void bfsWater(int y, int x) {
		q.offer(new Pos(y, x));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
					if ((map[ny][nx] == '.' || map[ny][nx] == 'S') && !visited[ny][nx]) {
						if(water[ny][nx] == 0)
							water[ny][nx] = water[p.y][p.x] + 1;
						else if(water[ny][nx] > 0) { 
							water[ny][nx] = Math.min(water[p.y][p.x] + 1, water[ny][nx]);
						}
						q.offer(new Pos(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		
		}
	}
	public static void bfsMove(int y, int x) {
		q.offer(new Pos(y, x));
		visited[y][x] = true;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny >= 0 && ny < R && nx >= 0 && nx < C && !visited[ny][nx]) {
					if (water[ny][nx] == 0 || water[ny][nx] > move[p.y][p.x] + 1) {
						move[ny][nx] = move[p.y][p.x] + 1;
						q.offer(new Pos(ny, nx));
						visited[ny][nx] = true;
					}
					if (map[ny][nx] == 'D') {
						System.out.println(move[p.y][p.x] + 1);
						return ;
					}
				}
			}
		}
		System.out.println("KAKTUS");
	}
	
	public static void ResetVisited() {
		for(int i=0; i<R; i++) {
			Arrays.fill(visited[i], false);
		}
	}
}
