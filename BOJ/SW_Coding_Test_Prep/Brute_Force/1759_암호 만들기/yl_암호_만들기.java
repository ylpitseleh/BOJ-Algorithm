import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_암호_만들기 {
	static int L;
	static int C;
	static String[] alpha;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new String[C];
		visited = new int[C];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st1.nextToken();
		}
		Arrays.sort(alpha);
		// 최소 한 개의 모음과 두 개의 자음으로 구성되어 있음.
		solve(0, 0);
	}

	static int consonants; //자음
	static int vowels; //모음
	public static void solve(int idx, int depth) {
		if (depth > L)
			return ;
		consonants = 0;
		vowels = 0;
		for (int i = 0; i < C; i++) {
			if (visited[i] == 1) {
				if (alpha[i] == "a" || alpha[i] == "e" || alpha[i] == "i" || alpha[i] == "o" || alpha[i] == "u")
					vowels++;
				else
					consonants++;
			}
		}
		if (vowels + consonants == L && vowels >= 1 && consonants >= 2) {
			for (int i = 0; i < C; i++) {
				if (visited[i] == 1) {
					System.out.print(alpha[i]);
				}
			}
			System.out.println();
		}
		for (int i = idx; i < C; i++) {
			visited[i] = 1;
			solve(i + 1, depth + 1);
			visited[i] = 0;
		}
	}

}
