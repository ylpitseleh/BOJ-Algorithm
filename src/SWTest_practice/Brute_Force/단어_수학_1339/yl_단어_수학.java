package SWTest_practice.Brute_Force.단어_수학_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
/*
 * 수학적으로 식 세워서 풀어도 되는데 백트래킹 연습하려고 백트래킹으로 풀었다.
 * indexOf 쓰면 되는걸 잘 안 써봐서 이런게 있는지 생각이 안 나서 알파벳 배열 만들고 세시간동안 개ㅈㄹ떨었다.
 * indexOf를 활용하자!!
 * 백트래킹으로 풀었더니 메모리랑 시간 터지려고 한다.
 */
public class yl_단어_수학 {
	static int N;
	static String s[];
	static boolean visited[];
	static int alphaN, max = 0;
	static String alpha;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new String[N]; 
		for (int i=0; i<N; i++) {
			s[i] = br.readLine();
		}
		
		alpha = "";
		// 사용되는 알파벳만을 문자열로 만들자.
		for (int i=0; i<N; i++) {
			for (int j=0; j<s[i].length(); j++) {
				if (alpha.indexOf(s[i].charAt(j)) == -1) // 없으면
					alpha += s[i].charAt(j);
			}
		}
		alphaN = alpha.length();
		// alpha에 해당하는 숫자들을 방문했는지 확인하기 위한 배열.
		visited = new boolean[alphaN];
		dfs("", 0);
		System.out.println(max);
		
		
	}
	// 9부터 시작하는 순열 만들어서 모두 탐색하기
	public static void dfs(String str, int depth) {
		if (depth == alphaN) {
			// 순열이 많이 나오기때문에 여기서 sum 구하는 연산을 최소화 해서 복잡도를 줄여야한다.
			int sum = 0;
			for (int i=0; i<N; i++) {
				int n = 0;
				int mul = 1;
				for (int j=s[i].length()-1; j>=0; j--) {
					// 이 식 세우는데 2시간 걸림 ㅋ
					n += (str.charAt(alpha.indexOf(s[i].charAt(j)))-'0') * mul;
					mul *= 10;
				}
				sum += n;
			}
			max = Math.max(sum, max);
			
			return ;
		}
		
		for (int i=0; i<alphaN; i++) {
			if (!visited[i]) {
				visited[i] = true;
				// 순열 구한건 길이 7 이면 0123456 이지만 9-i 해줘서 이걸 9876543로 바꿔줬다.
				dfs(str + Integer.toString(9-i), depth + 1);
				visited[i] = false;
			}
		}
		
	}

}
