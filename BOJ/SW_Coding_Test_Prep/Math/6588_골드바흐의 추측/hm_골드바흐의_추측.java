import java.io.*;
import java.lang.Math;

public class hm_골드바흐의_추측 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		while ((n = Integer.parseInt(br.readLine())) != 0) {
			System.out.print(n + " = ");

			int n1 = 0;
			int n2 = 0;
			for (int i = 3; i <= n / 2; i++) {
				if (isPrime(i))
					n1 = i;
				else
					continue;
				for (int j = n - 1; j >= i; j--) {
					if (isPrime(j))
						n2 = j;
					else
						continue;

					if (n1 + n2 == n) {
						System.out.println(n1 + " + " + n2);
						i = 2147483646;
						j = -2147483647;
					} else if (n1 + n2 < n)
						j = -2147483647;
				}
			}
			if (n1 % 2 != 1 || n2 % 2 != 1)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return (false);

		int nearest_sqrt = (int) (Math.sqrt((double) n));
		nearest_sqrt += 1;
		for (int i = 2; i < nearest_sqrt; i++) {
			if (n % i == 0)
				return (false);
		}
		return (true);
	}
}
//yl-답을 출력한 뒤 왜 i와 j에 int형 범위 양 끝 값을 넣으신건지 궁금합니다. 에라토스테네스의 체 방법을 이용하시면 더욱 효율적일 것 같습니다.
//hm-return ; 으로 끝내는 게 좋은 convention인지 확신이 없어서 저렇게 반복문을 끝냈습니다. 그냥 return ; 쓰는게 낫겠네요.
//C++로 다시 짤 때는 에라토스테네스의 체 방법을 활용해서 짜볼게요 :)
