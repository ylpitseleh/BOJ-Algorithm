import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DFS.백트래킹. 6603 로또와 친구 문제

//n개의 원소들로 이루어진 집합의 부분 집합 개수 = 2^n-1
public class yl_부분수열의_합 {
	static int N;
	static int S;
	static int ans;
	static int[] arr;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		ans = 0;
		solve(0, 0);
		if(S==0) //0일 경우 공집합도 들어가므로 빼주기
			ans--;
		System.out.println(ans);
	}
	
	public static void solve(int start, int depth) {
		if (depth > N) {
			return;
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (visited[i] == 1) {
				sum += arr[i];
			}
		}
		if (sum == S) {
			ans++;
		}
		for (int i = start; i < N; i++) {
			visited[i] = 1;
			solve(i + 1, depth + 1);
			visited[i] = 0;
		}
	}

}
