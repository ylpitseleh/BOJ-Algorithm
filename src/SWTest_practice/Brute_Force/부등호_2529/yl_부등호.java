package SWTest_practice.Brute_Force.부등호_2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/* 
 * 백트래킹으로 풀었는데 효율이 너무 떨어진다. 근데 다른사람들도 다 이렇게 풀은 것 같다. 
 * 012처럼 0으로 시작하는 숫자 처리 때문에 브루트포스로 012 부터 999까지 하는걸 고려하지 않았는데 생각해보니
 * String을 parseInt 해서 했어도 될 것 같다. 어차피 099 다음은 100이니까.
*/
public class yl_부등호 {
	static int N;
	static boolean visited[];
	static String s;
	static ArrayList al = new ArrayList<String>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = "";
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			s += st.nextToken();
		}
		visited = new boolean[10];
		
		dfs("", 0);
		System.out.println(al.get(al.size()-1));
		System.out.println(al.get(0));
		
		
	}
	
	public static void dfs(String answer, int depth) {
		if (answer.length() == N+1) {
			al.add(answer);
			return ;
		}
		
		if (depth > N+1)
			return ;
		for (int i=0; i <= 9; i++) {
			if (!visited[i]) {
				if (depth > 0) {
					if (s.charAt(depth-1) == '>') {
						if (answer.charAt(depth-1)-'0' < i)
							continue ;
					}
					else if (s.charAt(depth-1) == '<') {
						if (answer.charAt(depth-1)-'0' > i)
							continue ;
					}
				}
				visited[i] = true;
				dfs(answer + Integer.toString(i), depth + 1);
				visited[i] = false;
			}
		}
	}

}
