import java.util.*;
import java.io.*;

/*

2 | 24 20
2 | 12 10
	 6  5
최대공약수: 2*2
최소공배수: 6*5 * 2*2

*/

public class hm_최대공약수와_최소공배수 {
	public static void main(String[] args) throws IOException {
		int[] n = readInput(2);
		int gcd, lcm;
		int i;

		gcd = 1; // greatest common divisor
		lcm = 1; // least common multiple
		i = 2;
		while (n[0] >= i && n[1] >= i) {
			if (n[0] % i == 0 && n[1] % i == 0) {
				gcd *= i;
				n[0] /= i;
				n[1] /= i;
				i = 1;
			}
			i++;
		}
		lcm = gcd * n[0] * n[1];
		System.out.println(gcd);
		System.out.println(lcm);
	}

	public static int[] readInput(int size) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return (arr);
	}
}
