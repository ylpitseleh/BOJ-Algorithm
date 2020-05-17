package SWTest_practice.BFS.점프_게임_15558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * while안에서 count를 증가시키면 안 된다. 
 * 예를 들어 3초일 때 방문하게 되는 칸이 여럿일 수 있는데, 
 * 매 루프마다 count를 증가시키면 3초에 해당하는 방문을 처리하는 동안 
 * count는 3, 4, 5로 증가해버린다.
 * 
 * BFS의 기본 = 방문 체크(visited)
 * 방문 체크 안 했다가 메모리 초과 나서 추가해줌.
 */
public class yl_점프_게임 {
	static Queue q = new LinkedList<>();
	static class Pos {
		char c; // 'L', 'R'
		int loc; // index
		int sec; // sec
		Pos (char c, int loc, int sec){
			this.c = c;
			this.loc = loc;
			this.sec = sec;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int left[] = new int[N];
		int right[] = new int[N];
		boolean visited[][] = new boolean[2][N];
		
		String s = br.readLine();
		for (int i=0; i<N; i++) {
			left[i] = s.charAt(i)-'0';
		}
		s = br.readLine();
		for (int i=0; i<N; i++) {
			right[i] = s.charAt(i)-'0';
		}
		
		int dx[] = {-1, 1, k};
		// i+1, i-1, 다른 줄 i+k
		q.add(new Pos('L', 0, 0));
		while (!q.isEmpty()) {
			Pos p = (Pos) q.poll();
			
			for (int i=0; i<3; i++) {
				int nx = p.loc + dx[i];
				char nc = p.c;
				if (i == 2) {
					nx = p.loc + dx[i];
					if (p.c == 'L')
						nc = 'R';
					else
						nc = 'L';
				}
				if (nx < 0)
					continue ;
				if (nx <= p.sec)
					continue ;
				
				
				if (nx >= N) {
					System.out.println(1);
					return ;
				}
				if (nc == 'L')
					if (visited[0][nx])
						continue;
				if (nc == 'R')
					if (visited[1][nx])
						continue;
				
				if (nc == 'L') {
					if (left[nx] == 0)
						continue ;
				}
				else {
					if (right[nx] == 0)
						continue ;
				}
				q.add(new Pos(nc, nx, p.sec + 1));
				if (nc == 'L')
					visited[0][nx] = true;
				else
					visited[1][nx] = true;
			}
			
		}
		System.out.println(0);
	}

}
