package Math.소수_찾기_1978;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class hm_소수찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int case_cnt = Integer.parseInt(br.readLine());
		int prime_cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < case_cnt; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (isPrime(n))
				prime_cnt++;
		}

		System.out.println(prime_cnt);
	}

	public static boolean isPrime(int n)
	{
		if (n < 2)
			return (false);

		int nearest_sqrt = (int)(Math.sqrt((double)n));
		nearest_sqrt += 1;
		for (int i = 2; i < nearest_sqrt; i++)
		{
			if (n % i == 0)
				return (false);
		}
		return (true);
	}
}
