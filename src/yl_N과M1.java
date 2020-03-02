import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//arr를 출력 용도로 사용함
//재귀가 잘 이해가 안 감
public class yl_N과M1 {
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
			
		/*	System.out.print("depth : "+depth+" / ");
			for (int j=1; j<N+1; j++)
				System.out.print(visited[j]+" ");
			System.out.println();*/
			
			dfs(depth+1);
			visited[i] = false;
		}
	}

}
