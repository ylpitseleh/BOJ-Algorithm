package Brute_Force.테트로미노_14500;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DFS인듯 이중포문으로 푼 문제. 노가다일뿐 문제는 쉬움.
public class yl_테트로미노 {
	static boolean[] visited;
	static int[][] arr;
	static int N, M;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+3][M+3];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());
			}
		}
		max = 0;
		for(int i=0; i<N; i++) {
			dfs(arr, visited, i);				
		}
		System.out.println(max);
	}
	static int sumArr[] = new int[19];
	public static void dfs(int[][]arr, boolean[] check, int v) {
		int end_flag = 1;
		for(int i=0; i<N; i++) {
			if (!check[i])
				end_flag = 0;
		}
		if (end_flag == 1)
			return ;
		check[v] = true;
		
		for(int i=0; i<M; i++) {
			sumArr[0] = arr[v][i] + arr[v][i+1] + arr[v][i+2] + arr[v][i+3];//ㅡ
			sumArr[1] = arr[v][i] + arr[v+1][i] + arr[v+2][i] + arr[v+3][i];//ㅣ
			
			sumArr[2] = arr[v][i] + arr[v][i+1] + arr[v+1][i] + arr[v+1][i+1];//ㅁ
			
			sumArr[3] = arr[v][i] + arr[v+1][i] + arr[v+2][i] + arr[v+2][i+1];//세로 3칸ㄴ
			sumArr[4] = arr[v+1][i] + arr[v+1][i+1] + arr[v+1][i+2] + arr[v][i+2]; // ㄴ | 뒤집기
			sumArr[5] = arr[v][i] + arr[v][i+1] + arr[v+1][i+1] + arr[v+2][i+1]; // 세로 3칸ㄱ
			sumArr[6] = arr[v][i] + arr[v][i+1] + arr[v][i+2] + arr[v+1][i]; // ㄱ | 뒤집기
			sumArr[7] = arr[v][i+1] + arr[v+1][i+1] + arr[v+2][i+1] + arr[v+2][i]; //ㅢ
			sumArr[8] = arr[v][i] + arr[v+1][i] + arr[v+1][i+1] + arr[v+1][i+2]; // ㄴ
			sumArr[9] = arr[v][i] + arr[v][i+1] + arr[v+1][i] + arr[v+2][i]; // | ㄱ
			sumArr[10] = arr[v][i] + arr[v][i+1] + arr[v][i+2] + arr[v+1][i+2]; //ㄱ
			
			sumArr[11] = arr[v][i] + arr[v+1][i] + arr[v+1][i+1] + arr[v+2][i+1];
			sumArr[12] = arr[v][i+1] + arr[v][i+2] + arr[v+1][i] + arr[v+1][i+1];
			sumArr[13] = arr[v][i+1] + arr[v+1][i] + arr[v+1][i+1] + arr[v+2][i];
			sumArr[14] = arr[v][i] + arr[v][i+1] + arr[v+1][i+1] + arr[v+1][i+2];
			
			sumArr[15] = arr[v][i] + arr[v][i+1] + arr[v][i+2] + arr[v+1][i+1]; //ㅜ
			sumArr[16] = arr[v][i+1] + arr[v+1][i] + arr[v+1][i+1] + arr[v+2][i+1]; //ㅓ
			sumArr[17] = arr[v][i+1] + arr[v+1][i] + arr[v+1][i+1] + arr[v+1][i+2]; //ㅗ
			sumArr[18] = arr[v][i] + arr[v+1][i] + arr[v+2][i] + arr[v+1][i+1]; //ㅏ
			for(int j=0; j<19; j++) {
				if (sumArr[j] > max)
					max = sumArr[j];
			}
		}
		for(int i=0; i<N; i++) {
			if (!check[i])
				dfs(arr, check, i);
		}
		
	}

}
