package SWTest_basic.Brute_Force_NM.N과M1_15649;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_n과m1 {
	static int N;
	static int M;
	static boolean[] visited;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //1부터 N까지 자연수 중
		M = Integer.parseInt(st.nextToken()); //중복없이 M개
		visited = new boolean[N+1];
		arr = new int[M]; //정답 넣어줄 배열
		dfs(0);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return ;
		}
		for(int i=1; i<=N; i++) {
			if (visited[i]) //이미 방문했으면 건너뛴다.
				continue;
			visited[i] = true; //방문하지 않았으면 방문했다고 바꿔줌.
			arr[depth] = i;
			dfs(depth+1);
			visited[i] = false;
		}
	}

}
