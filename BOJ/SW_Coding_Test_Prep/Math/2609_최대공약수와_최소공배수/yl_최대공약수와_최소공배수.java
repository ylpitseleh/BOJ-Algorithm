import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수와_최소공배수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a;
		int b;
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int gcd = 0;
		for (int i = Math.min(a, b); i >= 1; i--)
			if (a % i == 0 && b % i == 0) {
				gcd = i;
				break;
			}
		System.out.println(gcd);
		int lcm = 0;
		if (gcd == 0)
			lcm = a * b;
		else
			lcm = (a / gcd) * (b / gcd) * gcd;
		System.out.println(lcm);
	}

}
