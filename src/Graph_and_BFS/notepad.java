package Graph_and_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 6%에서 메모리초과가 나서 배열을 적게 사용해야 하나 했는데 오히려 visited 배열을 추가해서 큐를 줄이는게 답이었다.
public class notepad {
	static int N, M, cnt = 0;
	static char[][] map;
	static int[][] water;
	static int[][] move;
	static int[][] visited;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static Queue<Pos> q = new LinkedList<>();

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		water = new int[N][M];
		move = new int[N][M];
		visited = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String s = br.readLine();
			for (int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'D' || map[i][j] == 'X')
					water[i][j] = -1;
			}
		}
		
		//D: 비버의 굴, S: 고슴이 위치, .: 비어있음, *: 물이 차있음, X: 돌 
		//물 채우기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(map[i][j] == '*') {
					cnt++; //*이 여러군데에서 시작되는 경우를 위해 visited가 boolean이 아닌 cnt보다 작아야 하는 조건이 있어야 함
					bfsWater(i, j);
				}
			}
		}
		
		System.out.println("물 채우기 ----------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(water[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------");
		
		//visited 배열 초기화
		for (int i=0; i<N; i++)
			Arrays.fill(visited[i], 0);
		//고슴도치 움직이기
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(map[i][j] == 'S')
					bfsMove(i, j);
			}
		}
		/*System.out.println();
		System.out.println("고슴도치 이동 경로 -------");
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(move[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------");*/
		
	}

	public static void bfsWater(int y, int x) {
		q.add(new Pos(y, x));
		visited[y][x]++;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue ;
				if (visited[ny][nx] <= cnt  && (map[ny][nx] == 'S' || map[ny][nx] == '.')) {
					if (water[ny][nx] == 0)
						water[ny][nx] = water[p.y][p.x] + 1;
					else if (water[ny][nx] > 0)
						water[ny][nx] = Math.min(water[p.y][p.x] + 1, water[ny][nx]);
					q.add(new Pos(ny, nx));
					visited[ny][nx]++;
				}
			}
		}
	}
	
	public static void bfsMove (int y, int x) {
		q.add(new Pos(y, x));
		visited[y][x] = 1;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for (int i=0; i<4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue ;
				if (visited[ny][nx] != 0)
					continue ;
				if (water[ny][nx] > move[p.y][p.x] + 1 || water[ny][nx] == 0) {
					move[ny][nx] = move[p.y][p.x] + 1;
					q.add(new Pos(ny, nx));
					visited[ny][nx] = 1;
				}
				if (map[ny][nx] == 'D') {
					// move[ny][nx]를 출력하면 0임. map에 D가 들어간 자리여서 water[ny][nx]가 0이기 때문  
					System.out.println(move[p.y][p.x] + 1);
					return ;
				}
			}
		}
		System.out.println("KAKTUS");
	}

}
