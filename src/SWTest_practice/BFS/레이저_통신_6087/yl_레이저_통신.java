package SWTest_practice.BFS.레이저_통신_6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// while문, 같은 방향으로 모두 더해주는 것만 생각해내면 쉽다.

public class yl_레이저_통신 {
	static class Pos {
		int y;
		int x;
		Pos (int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	static Queue<Pos> q = new LinkedList<>();
	static int H, W;
	static char[][] map;
	static int[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		visited = new int[H][W];
		
		int startY = -1, startX = -1;
		int endY = 0, endX = 0;
		for (int i=0; i<H; i++) {
			String s = br.readLine();
			for (int j=0; j<W; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'C') {
					if (startY == -1 && startX == -1) {
						startY = i;
						startX = j;
					}
					else {
						endY = i;
						endX = j;
					}
				}
			}
		}
		q.add(new Pos(startY, startX));
		visited[startY][startX] = 1;
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			if (p.y == endY && p.x == endX)
				break ;
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				while (ny >= 0 && ny < H && nx >= 0 && nx < W) {
					if (map[ny][nx] == '*')
						break ;
					if (visited[ny][nx] == 0) {
						q.add(new Pos(ny, nx));
						visited[ny][nx] = visited[p.y][p.x] + 1;
					}
					ny += dy[i]; // 직선으로 쭉 다 더해줌. 이걸 생각해내는게 중요. 
					nx += dx[i];
				}
			}
		}
		
		/*
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
		*/
		System.out.println(visited[endY][endX] - 2);
	}

}
