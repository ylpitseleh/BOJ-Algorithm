import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_N과M5 {
	static int N;
	static int M;
	static int arr[];
	static boolean visited[];
	static int ans[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //N개의 자연수 중
		M = Integer.parseInt(st.nextToken()); //M개를 고른 수열
		arr = new int[N];
		ans = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st1.nextToken());
		Arrays.sort(arr);
		visited = new boolean[N];
		recursive(0);
	}
	
	public static void recursive(int depth)
	{
		if (depth == M)
		{
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for(int i=0; i<N; i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			ans[depth] = arr[i]; 
			recursive(depth + 1);
			visited[i] = false;
		}
	}

}
