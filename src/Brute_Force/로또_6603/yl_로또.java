package Brute_Force.로또_6603;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//https://zoonvivor.tistory.com/108
//https://mygumi.tistory.com/191
//백트래킹 기초
public class yl_로또 {
	static int N;
	static int[] arr;
	static int[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0)
				break;
			arr = new int[N];
			visited = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			DFS(0, 0);
			System.out.println();
		}
	}
	public static void DFS(int start, int depth) {
		if (depth == 6) {
			for(int i=0; i<N; i++) {
				if (visited[i] == 1)
					System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
		
		for(int i=start; i<N; i++) {
			visited[i] = 1;
			DFS(i+1, depth+1);
			visited[i] = 0; //백트래킹. 탐색을 한 후에 다시 값을 탐색하기 이전으로 되돌림.
		}
	}
	

}
