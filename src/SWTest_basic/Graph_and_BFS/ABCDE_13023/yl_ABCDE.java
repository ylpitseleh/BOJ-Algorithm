package SWTest_basic.Graph_and_BFS.ABCDE_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//백트래킹 인접리스트 버전
//백트래킹인지 dfs인지 문제만 보고 알 수 있나?
public class yl_ABCDE {
	static int N, M, res = 0;
	static ArrayList<Integer>[] al;
	static boolean visited[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //사람의 수
		M = Integer.parseInt(st.nextToken()); //친구 관계의 수
		al = new ArrayList[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++)
			al[i] = new ArrayList<Integer>();
		int a, b;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			al[a].add(b);
			al[b].add(a);
		}
		for(int i=0; i<M; i++) {
			dfs(i, 0);
			if (res == 1)
				break ;
		}
		System.out.println(res);
		
		
	}
	public static void dfs(int idx, int cnt) {
		if (cnt == 4) {
			res = 1;
			return ;
		}
		
		visited[idx] = true;
		for(int i=0; i<al[idx].size(); i++) {
			int j = al[idx].get(i);
			if (!visited[j])
				dfs(j, cnt + 1);
		}
		visited[idx] = false;
	}

}
