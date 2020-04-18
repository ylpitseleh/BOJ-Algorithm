import java.util.*;
import java.io.*;

/*

2 | 24 20
2 | 12 10
	 6  5
최대공약수: 2*2

3

4	10 20 30 40
3	7 5 12
3	125 15 25
*/

public class hm_GCD_합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int case_cnt = Integer.parseInt(br.readLine());

		for (int i = 0; i < case_cnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num_cnt = Integer.parseInt(st.nextToken());

			int[] arr = new int[num_cnt];
			for (int j = 0; j < num_cnt; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			System.out.println(getSumOfGcd(arr, num_cnt));
		}
	}

	public static int getGcd(int a, int b) {
		int gcd;
		int i;

		gcd = 1; // greatest common divisor
		i = 2;
		while (a >= i && b >= i) {
			if (a % i == 0 && b % i == 0) {
				gcd *= i;
				a /= i;
				b /= i;
				i = 1;
			}
			i++;
		}
		return (gcd);
	}

	public static long getSumOfGcd(int[] arr, int num_cnt) {
		long rst = 0;
		for (int i = 0; i < num_cnt; i++) {
			for (int j = i + 1; j < num_cnt; j++) {
				rst += getGcd(arr[i], arr[j]);
			}
		}
		return (rst);
	}
}
