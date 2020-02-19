import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

// 1 <= E <= 15
// 1 <= S <= 28
// 1 <= M <= 19
//
// 1 1 1: 1
//
// 15 15 15: 15
// 1 16 16: 16
//
// 4 19 19: 19
// 5 20 1: 20
//
// 13 28 9: 28
// 14 1 10: 29
//
// ...
//
// 1 2 3: 5266
// 15 28 19: 7980
//
// Can't figure out any pattern!
// Let's just use bruteforce!

public class hm_날짜_계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans_e = Integer.parseInt(st.nextToken());
		int ans_s = Integer.parseInt(st.nextToken());
		int ans_m = Integer.parseInt(st.nextToken());

		int e = 1;
		int s = 1;
		int m = 1;
		int cnt = 1;
		while(!(e == ans_e && s == ans_s && m == ans_m))
		{
			cnt++;
			e++;
			s++;
			m++;
		}
		System.out.println(cnt);
	}
}
