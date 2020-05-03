package SWTest_practice.BFS.퍼즐_1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class yl_퍼즐 {
	static int map[][];
	static boolean visited[];
	static Queue<Pos> q = new LinkedList<Pos>();
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[3][3];
		for (int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			map[i][2] = Integer.parseInt(st.nextToken());
		}
	
		visited = new boolean[9]; // 1 ~ 8
		
		// 0 자리에 숫자 하나씩 다 넣어보면 되는건가?
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (map[i][j] == 0)
					bfs(i, j);
			}
		}
	}
	
	public static void bfs(int y, int x) {
		q.add(new Pos(y, x));
		
		while (!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int X=1; X<=8; X++) {
				if (!visited[x]) {
					for (int i=0; i<3; i++) {
						for (int j=0; j<3; j++) {
							if (map[i][j] == X) {
								// 원래 0인 곳 X로 변경
								map[p.y][p.x] = map[i][j];
								System.out.println(p.y+" "+p.x+" , "+map[p.y][p.x]);
								System.out.println("map[i][j] : "+map[i][j]);
								// 원래 X 자리 0으로 변경
								map[i][j] = 0;
								q.add(new Pos(i, j));
								visited[map[i][j]] = true;
							}
							
							for (int k=0; k<3; k++) {
								for (int l=0; l<3; l++) {
									System.out.print(map[k][l]+" ");
								}
								System.out.println();
							}
							System.out.println();
							
						}
					}
					
					
				}
				
			}
			
			
		}
	}

}
