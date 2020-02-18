import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//에라토스테네스의 체 사용 - 제일 효율적인 방법
//n보다 작은 소수를 ArrayList에 모두 넣어 반복문이 돌때마다 새로 갱신했더니 50%에서 시간초과가 발생했ㅕ다.
public class 골드바흐의_추측 {
	public static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[MAX + 1];
		
		for(int i=2; i<=MAX; i++)
			isPrime[i] = true;
		
		for(int i=2; i<=MAX; i++) {
			for(int j=i*2; j<=MAX; j+=i) {
				if(!isPrime[j])
					continue;
				isPrime[j] = false;
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			boolean ok = false;
			//내가 2중 포문으로 짠 것을 1중 포문으로 개선했다. 기억하기 !!
			for (int i=2; i<=n/2; i++) {
				if (isPrime[i] && isPrime[n-i]) {
					System.out.println(n+" = "+i+" + "+(n-i));
					ok = true;
					break;
				}
			}
			if(!ok)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}

}
