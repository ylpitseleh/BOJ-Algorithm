import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3

1 45000
6 10
13 17

45000
30
221
*/

public class hm_최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int case_cnt = Integer.parseInt(br.readLine());
		for (int i = 0; i < case_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			System.out.println(getLcm(n1, n2));
		}
	}

	public static int getGcd(int a, int b) {
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		while (b > 0) {
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return a;
	}

	public static int getLcm(int a, int b) {
		return a * b / getGcd(a, b);
	}
}
//yl - 변수명과 함수 구분이 인상적입니다!
//hm - 감사합니다 XD
