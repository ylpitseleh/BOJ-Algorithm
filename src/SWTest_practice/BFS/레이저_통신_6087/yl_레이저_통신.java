package SWTest_practice.BFS.레이저_통신_6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


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
		
		int startY = -1, startX = -1, endY = 0, endX = 0;
		for(int i=0; i<H; i++) {
			String s = br.readLine();
			for(int j=0; j<W; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j]=='C') {
					if (startY == -1) { // 처음 나오는 'C'
						startY = i;
						startX = j;
					}
					else { // 두 번째 나온 'C'
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
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				// 첫 번째 핵심 로직 - while문 : visited[ny][nx]부터 현재 방향(dy[i], dx[i])으로 쭉 다 더해줌.
				while (ny >= 0 && ny < H && nx >= 0 && nx < W) {
					if (map[ny][nx] == '*') // 벽이면 continue가 아니라 break로 멈춰야 함.
						break ;
					if (visited[ny][nx] == 0) { //map[ny][nx] == '.' or 'C'일 때
						visited[ny][nx] = visited[p.y][p.x] + 1;
						q.add(new Pos(ny, nx));
					}
					ny += dy[i]; // 두 번째 핵심 로직 -> 직선으로 쭉 다 더해줌.
					nx += dx[i];
				}
			}
		}
		
		
		for (int k=0; k<H; k++) {
			for (int j=0; j<W; j++) {
				System.out.print(visited[k][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println(visited[endY][endX] - 2);
	}

}
