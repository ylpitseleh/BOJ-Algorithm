package Math.GCD_합_9613;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_GCD_합 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long sum;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int arr[] = new int[n1];
			sum = 0;
			for (int j = 0; j < n1; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < n1; j++) {
				for (int k = j + 1; k < n1; k++) {
					if (arr[k] > arr[j])
						sum += find_gcd(arr[k], arr[j]);
					else
						sum += find_gcd(arr[j], arr[k]);
				}
			}
			System.out.println(sum);
		}
	}

	public static int find_gcd(int a, int b) {
		int tmp = 1;
		while (tmp != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}

}
