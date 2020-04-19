import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//최소공배수 구하기 - 유클리드 호제법 사용
public class yl_최소공배수 {

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
/* hm
+	유클리드 호제법을 사용하여 효율적인 답을 도출해내셨네요 :)

?	제 주관적인 가독성 개선 의견을 제안하자면,
	find_lcm 내부에서 변수명 lcm을 rst(==result)등으로 바꾸는게 더 좋지 않을까 싶어요. 뭔가 변수명과 어울리지 않는 값들이 할당되니 흐름이 직관적이지 	않게 되는 것 같아서 제안 해봅니다.

-	보편적인 Naming convention을 따르시면 더 좋을 것 같아요.
	Java의 Method 변수명은 snake_case가 아닌 camelCase가 좀 더 보편적이더라구요.
	ex) find_lcm -> findLcm
*/
