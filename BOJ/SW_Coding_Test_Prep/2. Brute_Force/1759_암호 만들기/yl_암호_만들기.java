import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//백트래킹
public class yl_암호_만들기 {
	static int L;
	static int C;
	static String[] alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new String[C];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st1.nextToken();
		}
		Arrays.sort(alpha);
		// 최소 한 개의 모음과 두 개의 자음으로 구성되어 있음.
		solve("", 0);
	}

	public static void solve(String password, int depth) {
		if (password.length() == L) {
			if (check(password)) {
				System.out.println(password);
			}
			return ;
		}
		if (depth >= C)
			return ;
		//System.out.println(password);
		solve(password + alpha[depth], depth + 1);
		solve(password, depth + 1);
	}
	
	public static boolean check(String password) {
		int consonants = 0; //자음
		int vowels = 0; //모음
		for(char c : password.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				vowels++;
			else
				consonants++;
		}
		if (consonants >= 2 && vowels >= 1)
			return true;
		else
			return false;
	}

}
