package Graph_and_BFS.숨바꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yl_숨바꼭질 {
	static int N, K;
	static Queue<Integer> q = new LinkedList<>();
	static int arr[];
	static int dx[] = {-1, 1, 2};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //수빈이가 있는 위치
		K = Integer.parseInt(st.nextToken()); //동생이 있는 위치
		arr = new int[110001];
		Arrays.fill(arr, Integer.MAX_VALUE);
		bfs(N);
		System.out.print(arr[K]);
	}
	
	public static void bfs(int n) {
		q.offer(n);
		arr[n] = 0;
		
		while (!q.isEmpty()) {
			int num = q.poll();
			if (num == K)
				break ;
			for(int i=0; i<3; i++) {
				int nx = num + dx[i];
				if (i == 2)
					nx = num * dx[i];
				
				if (nx >= 0 && nx <= 110000 
						&& arr[nx] > arr[num] + 1) {
					//arr[nx] > arr[num] + 1 을 map[nx] == 0로 바꿔도 됨.
					q.add(nx);
					arr[nx] = arr[num] + 1;
				}
			}
		}
	}
}
