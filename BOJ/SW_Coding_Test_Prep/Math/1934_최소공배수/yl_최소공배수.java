import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// �ּҰ���� ���ϱ� - ��Ŭ���� ȣ���� ���
public class �ּҰ���� {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (b > a) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			find_lcm(a, b);
		}
	}

	public static void find_lcm(int a, int b) {
		int tmp = 1;
		int lcm = a * b;
		while (tmp != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		System.out.println(lcm / a);
	}
}
