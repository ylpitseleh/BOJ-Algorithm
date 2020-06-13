package SWTest_practice.Brute_Force.알파벳_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 30분만에 해결. 기본 백트래킹 인듯
public class yl_알파벳 {
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static char map[][];
	static boolean visited[][];
	static boolean alphabet[];
	static int h, w;
	static int maxDepth = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new char[h][w];
		visited = new boolean[h][w];
		alphabet = new boolean[26];
		for (int i=0; i<h; i++) {
			String s = br.readLine();
			for (int j=0; j<w; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		visited[0][0] = true;
		alphabet[map[0][0]-'A'] = true;
		dfs(0, 0, 1);
		
		System.out.println(maxDepth);
	}
	
	public static void dfs(int y, int x, int depth) {
		maxDepth = Integer.max(depth, maxDepth);
		
		for (int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny >= 0 && ny < h && nx >= 0 && nx < w) {
				if (visited[ny][nx] == false && alphabet[map[ny][nx]-'A'] == false) {
					visited[ny][nx] = true;
					alphabet[map[ny][nx]-'A'] = true;
					dfs(ny, nx, depth+1);
					// 탐색을 한 후에 원래 값으로 되돌려줌. 
					visited[ny][nx] = false;
					alphabet[map[ny][nx]-'A'] = false;
				}
			}
		}
	}

}
