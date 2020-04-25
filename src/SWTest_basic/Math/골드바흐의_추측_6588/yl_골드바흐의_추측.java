package SWTest_basic.Math.골드바흐의_추측_6588;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//에라토스테네스의 체 사용 - 제일 효율적인 방법
//n보다 작은 소수를 ArrayList에 모두 넣어 반복문이 돌때마다 새로 갱신했더니 50%에서 시간초과가 발생했다.
public class yl_골드바흐의_추측 {
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
/*	hm
	32bit짜리 배열인 ArrayList<Integer>에서 1bit짜리 배열인 boolean[] isPrime으로 개선한 건 엄청 획기적인 아이디어네요. 그리고 반복문을 활용해서 소수 여부를 구분한다는 아이디어는 상상도 못 해봤어요ㅋㅋ 대단합니다.

	isPrime 값을 할당하는 부분이 O(n) ~ O(n^2) 이긴 하지만, 그래도 소수 여부를 일일이 확인하는 것보단 시간적으로 효율적일 것 같고, 메모리 상으로는 말할 것도 없이 효율적이겠네요.

	line 29 부분의 1중 for문도 효율성을 극대화시킨 아주 좋은 코드네요.
	많이 배워갑니다!
*/
