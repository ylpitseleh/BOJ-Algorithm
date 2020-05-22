package SWTest_practice.BFS.열쇠_9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class yl_열쇠 {
	static Queue<Pos> q = new LinkedList<>();
	static int T, h, w, ans;
	static char[][] map;
	static boolean[][] visited;
	static Set<Character> key;
	static Set<Pos> door;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static class Pos{
        int y;
        int x;
        Pos(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			visited = new boolean[h+2][w+2];
			key = new HashSet<>();
			door = new HashSet<>();
			ans = 0;
			for (int i = 1; i < h+1; i++) {
				String s = br.readLine();
				for (int j = 1; j < w+1; j++) {
					// 위쪽, 왼쪽 한 칸씩 공백만들기
					map[i][j] = s.charAt(j-1);
				}
			}
			String s = br.readLine();
			for (int i=0; i<s.length(); i++) {
				key.add(s.charAt(i));
			}
			
			for (int i=0; i<h+2; i++) {
				for (int j=0; j<w+2; j++) {
					if (i==0 || i==h+1 || j==0 || j==w+1)
						map[i][j] = '.';
				}
			}
			/*
			for (int i=0; i<h+2; i++) {
				for (int j=0; j<w+2; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			*/
			q.add(new Pos(0, 0));
			visited[0][0] = true;
			while (!q.isEmpty()) {
				Pos p = q.poll();
				//outloof:
					for (int i=0; i<4; i++) {
						int ny = p.y + dy[i];
						int nx = p.x + dx[i];
						
						if (ny < 0 || ny > h+1 || nx < 0 || nx > w+1)
							continue ;
						if (visited[ny][nx])
							continue ;
						if (map[ny][nx] == '*')
							continue ;
						if (map[ny][nx] >= 'A' && map[ny][nx] <= 'Z') {
							//key가 있는지 확인
							boolean hasKey = false;
							for (char c : key) {
								if (map[ny][nx] == Character.toUpperCase(c)) {
									hasKey = true;
									break ;
								}
							}
							if (!hasKey) {
								//key가 없는 경우 나중에  key를 발견할 경우를 대비해서 현재 지점(ny, nx) set에 넣어줌.
								door.add(new Pos(ny, nx));
								continue ;
							}
						}
						else if (map[ny][nx] >= 'a' && map[ny][nx] <= 'z') {
							key.add(map[ny][nx]);
							// key가 없어서 열지 못했던 지점 중에 일치하는게 있나 찾아봄
							for (Pos pp : door) {
								if (Character.toLowerCase(map[pp.y][pp.x]) == map[ny][nx]) {
									if (visited[pp.y][pp.x])
										continue ;
									visited[pp.y][pp.x] = true;
									q.add(new Pos(pp.y, pp.x));
								}
							}
						}
						else if (map[ny][nx] == '$')
							ans++;
						visited[ny][nx] = true;
						q.add(new Pos(ny, nx));
					}
			}
			System.out.println(ans);
		}
	}

}
