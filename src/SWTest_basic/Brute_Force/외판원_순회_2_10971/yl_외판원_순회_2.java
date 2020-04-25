package SWTest_basic.Brute_Force.외판원_순회_2_10971;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_외판원_순회_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] permu = new int[N];
		for (int i = 0; i < N; i++)
			permu[i] = i;
		int ans = Integer.MAX_VALUE;
		do {
			if (permu[0] != 0)
				break ;
			int sum = 0;
			boolean ok = true;
			for(int i=0; i<N-1; i++) {
				if (arr[permu[i]][permu[i+1]] == 0)
					ok = false;
				else
					sum += arr[permu[i]][permu[i+1]];
			}
			if (ok && arr[permu[N-1]][permu[0]] != 0) {
				sum += arr[permu[N-1]][permu[0]];
				ans = Math.min(ans, sum);
			}
		} while (next_permutation(permu));
		
		System.out.println(ans);
	}

	public static boolean next_permutation(int[] arr) {
		int i = arr.length - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i -= 1;
		if (i <= 0)
			return false;

		int j = arr.length - 1;
		while (arr[i - 1] >= arr[j])
			j -= 1;
		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;

		j = arr.length - 1;
		while (i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i += 1;
			j -= 1;
		}
		return true;
	}

}
