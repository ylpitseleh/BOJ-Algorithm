package SWTest_practice.BFS.탈옥_9376;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yl_탈옥 {
	static Queue q = new LinkedList<Pos>();
	static class Pos {
		int y;
		int x;
		Pos (int y, int x) {
			this.y = y;
			this.x = x;
			
		}
	}
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static char map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			for (int i=0; i<h; i++) {
				String s = br.readLine();
				for (int j=0; j<w; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			// 테두리에 있는 문(#)이나 빈 공간(.)에서 시작해서 죄수($) 찾아가는 걸로 해야할 듯?
			for (int i=0; i<h; i++) {
				for (int j=0; j<w; j++) {
					if ((i == 0 || j == 0 || i == h-1 || j == w-1) 
							&& (map[i][j] == '.' || map[i][j] == '#'))
						q.add(new Pos(i, j));
				}
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			Pos p = (Pos) q.poll();
			
			if (map[p.y][p.x] == '$') {
				cnt++;
				map[p.y][p.x] = '.';
			}
			if (cnt == 2)
				break ;
			
			
		}

	}

}
