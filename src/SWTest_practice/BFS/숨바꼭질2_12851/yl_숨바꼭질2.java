package SWTest_practice.BFS.숨바꼭질2_12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 1 4일 때 답은 2
 * (1+1)*2, (1*2)*2 두 가지 경우가 있음.
 * 원래 이 경우 생각 안 하고 단순히 map[N-1], map[N+1], map[N/2] == map[N]-1이면 각각 cnt++해줬다가
 * cnt배열 만드는걸로 수정해서 어렵지 않게 품. 
 * 다만 N==K일 때 0, 1은 따로 처리해줘야 함.
 */
public class yl_숨바꼭질2 {
	static int dx[] = {-1, 1, 2};
	static Queue q = new LinkedList<>();
	static int map[] = new int[110001];
	static int cnt[] = new int[110001];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수빈 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치

		if (N==K) {
			System.out.println(0);
			System.out.println(1);
			return ;
		}
		
		Arrays.fill(map, Integer.MAX_VALUE);
		
		q.add(N);
		map[N] = 0;
		while (!q.isEmpty()) {
			int n = (int) q.poll();
			
			if (n == K)
				break ;
			
			for (int i=0; i<3; i++) {
				int nx = n + dx[i];
				if (i == 2)
					nx = n * dx[i];
				
				if (nx < 0 || nx >= map.length)
					continue ;
				//if (map[nx] != 0)
					//continue ;
				if (map[nx] >= map[n] + 1) {
					q.add(nx);
					map[nx] = map[n] + 1;
					cnt[nx]++;
				}
			}
		}
			
		//for (int i=N; i<=K; i++)
			//System.out.print(cnt[i]+" ");
		
		System.out.println(map[K]);
		System.out.println(cnt[K]);
		
	}

}
