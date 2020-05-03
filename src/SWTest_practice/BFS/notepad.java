package SWTest_practice.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class notepad {
	static Queue<Integer> q = new LinkedList<>();
	static int T, A, B;
	static int[] map;
	static char[] how;
	static int[] from;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			map = new int[10001];
			how = new char[10001];
			from = new int[10001];
			visited = new boolean[10001];
			
			q.add(A);
			visited[A] = true;
			from[A] = -1;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				//D
				int nx = cur * 2;
				if(nx>9999)
					nx %= 10000;
				if(visited[nx]==false) {
					q.add(nx);
					visited[nx] = true;
					map[nx] = map[cur] + 1;
					from[nx] = cur;
					how[nx] = 'D';
				}
				//S
				nx = cur - 1;
				if(nx==-1)
					nx = 9999;
				if(visited[nx]==false) {
					q.add(nx);
					visited[nx] = true;
					map[nx] = map[cur] + 1;
					from[nx] = cur;
					how[nx] = 'S';
				}
				
				//L
				nx = (cur%1000)*10 + cur/1000; 
				if(visited[nx]==false) {
					q.add(nx);
					visited[nx] = true;
					map[nx] = map[cur] + 1;
					from[nx] = cur;
					how[nx] = 'L';
				}
				
				//R
				nx = (cur/10) + 1000*(cur%10);
				if(visited[nx]==false) {
					q.add(nx);
					visited[nx] = true;
					map[nx] = map[cur] + 1;
					from[nx] = cur;
					how[nx] = 'R';
				}
				
			}
			StringBuilder ans = new StringBuilder();
			while(B!=A) { //중요
				ans.append(how[B]);
				B = from[B];
			}
			System.out.println(ans.reverse());
		}
		
	}
	
}
