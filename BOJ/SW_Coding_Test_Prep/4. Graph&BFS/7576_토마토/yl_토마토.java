package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * BFS가 넓이 우선 탐색이어서 낮은 level을 먼저 탐색하는 형태를 취하기때문에
 * 반복이 줄어든다고 한다. DFS로 풀기엔 부적절한 문제.
 */
//visited 조건을 없애버리면 되는구나,,
//아니 왜 처음부터 싹 다 큐에 쳐넣냐
//처음부터 큐에 1인것 모두 쳐넣는 이유 : 큐는 FIFO니까 먼저 넣으면 먼저 나옴.
//1이 여러군데 있을때 같이 시작할 수 있음.(카운트가 여러군데에서 같이 올라갈 수 있음)
public class yl_토마토 {
	static int M, N;
	static int map[][];
	static int dy[] = {-1, 1, 0, 0};
	static int dx[] = {0, 0, -1, 1};
	static Queue<Pos> q = new LinkedList<>();
	static class Pos {
		int y;
		int x;

		Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int flag = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					flag = 0;
				}
			}
		}
		if(flag==1) { //익을 토마토가 없으면 먼저 끝내버리고 bfs 시작한다.
			System.out.println(0);
			return;
		}
		//본격 로직
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (map[i][j] == 1) {
					//1인거 먼저 다 큐에 쳐넣는다. 이유는 상단에.
					q.offer(new Pos(i, j));
				}
			}
		}
		//BFS를 다른 메소드로 나누면 복잡해지기만 함.
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
					if (map[ny][nx] == 0) {
						q.offer(new Pos(ny, nx));
						map[ny][nx] = map[p.y][p.x] + 1;
					}
				}
			}
		}
		
		boolean zeroFlag = false;
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if (map[i][j] == 0) 
					zeroFlag = true;
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		if (zeroFlag)
			System.out.println(-1);
		else
			System.out.println(max - 1);
	}
	

}
