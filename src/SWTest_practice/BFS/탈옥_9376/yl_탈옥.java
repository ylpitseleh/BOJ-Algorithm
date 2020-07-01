package SWTest_practice.BFS.탈옥_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * https://stack07142.tistory.com/145 -> 아이디어 참고
 * https://shinyou1024.tistory.com/48 -> 소스 참고
 * 아이디어만 있으면 충분히 구현할 수 있는 수준인데 아이디어가 문제임 이걸 어떻게 생각해 내... 
 * 죽었다 깨어나도 못 생각해내지 이건
 */
public class yl_탈옥 {
	static int h, w;
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static char map[][];
	static class Pos {
		int y;
		int x;
		int door;
		
		Pos (int y, int x, int door) {
			this.y = y;
			this.x = x;
			this.door = door;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			ArrayList<Pos> al = new ArrayList<Pos>();
			// 상근이부터 시작하는 경우
			al.add(new Pos(0, 0, 0));
			for (int i=1; i<h+1; i++) {
				String s = br.readLine();
				for (int j=1; j<w+1; j++) {
					map[i][j] = s.charAt(j-1);
					// 죄수 1, 2부터 시작하는 경우
					if (map[i][j] == '$')
						al.add(new Pos(i, j, 0));
				}
			}
			for (int i=0; i<h+2; i++) {
				for (int j=0; j<w+2; j++) {
					if (i==0 || i==h+1 || j==0 || j==w+1)
						map[i][j] = '.';
				}
			}
			
			int[][] minDoor1 = bfs(al.get(0));
			int[][] minDoor2 = bfs(al.get(1));
			int[][] minDoor3 = bfs(al.get(2));
			
			// 여기서 왜 sum 중에 최소값이 답인지 이해가 안 감.
			int sum = 0;
			int ans = Integer.MAX_VALUE;
			int res[][] = new int[h+2][w+2];
			for (int i=0; i<h+2; i++) {
				for (int j=0; j<w+2; j++) {
					if (map[i][j] == '*')
						continue ;
					sum = minDoor1[i][j] + minDoor2[i][j] + minDoor3[i][j];
					// 문이면 상근, 죄수1, 죄수2가 각 한 번씩 총 3번 지나간거니까 -2 해줘야 함.
					if (map[i][j] == '#')
						sum -= 2;
					ans = Math.min(ans, sum);
					res[i][j] = sum;
				}
			}
			
			System.out.println(ans);
		}

	}
	public static int[][] bfs (Pos start) {
		int minDoor[][] = new int[h+2][w+2];
		Queue<Pos> q = new LinkedList<Pos>();
		
		minDoor = fillArray(minDoor, -1);
		q.add(start);
		minDoor[start.y][start.x] = 0;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				int ndoor = p.door;
				
				if (ny < 0 || ny >= h+2 || nx < 0 || nx >= w+2)
					continue ;
				if (map[ny][nx] == '*')
					continue ;
				if (map[ny][nx] == '#')
					ndoor++;
				if (minDoor[ny][nx] == -1 || minDoor[ny][nx] > ndoor) {
					q.add(new Pos(ny, nx, ndoor));
					minDoor[ny][nx] = ndoor;
				}
			}
		}
		return minDoor;
	}
	
	public static int[][] fillArray(int[][] arr, int value) {
		for (int i=0; i<h+2; i++) {
			for (int j=0; j<w+2; j++) {
				arr[i][j] = value;
			}
		}
		return arr;
	}
}
