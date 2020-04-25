package SWTest_basic.Brute_Force_NM.N과M4_15652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_N과M4 {
	static int N;
	static int M;
	static int arr[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //1부터 N까지 자연수 중
		M = Integer.parseInt(st.nextToken()); //중복없이 M개
		//같은 수를 여러 번 골라도 된다. 고른 수열은 비내림차순이어야 한다.
		arr = new int[M];
		visited = new boolean[N+1];
		recursive(0);
	}
	
	public static void recursive(int depth)
	{
		if (depth == M)
		{
			for(int i=0; i<M; i++)
				System.out.print(arr[i]+" ");
			System.out.println();
			return ;
		}
		for(int i=1; i<=N; i++) {
			visited[i] = true;
			arr[depth] = i;
			if (depth == 0 || (depth >= 1 && arr[depth-1] <= i))
				recursive(depth + 1);
			visited[i] = false;
		}
		
	}
	
}
