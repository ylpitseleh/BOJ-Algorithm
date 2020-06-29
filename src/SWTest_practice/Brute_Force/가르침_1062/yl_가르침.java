package SWTest_practice.Brute_Force.가르침_1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
/*
 * HashSet 이용해서 백트래킹 안 쓰고 풀어보려 했지만 실패... 이래서 설계를 하고 풀기 시작해야하나보다
 * 애초에 백트래킹 안쓰면 풀 수 없음.
 * 그냥 aicnt 제외한 모든 알파벳 set에 넣은 다음에 그 중 K-5 만큼 모든 경우의 수 뽑아서 답 구해야겠다.
 */
//Array에 HashSet 넣는 것 아님. ArrayList에 넣어라. 
// Do not mix arrays with generics!
public class yl_가르침 {
	static int N, K, max = 0;
	static boolean visited[];
	static String s = "";
	static ArrayList permuAlpha = new ArrayList<Character>();
	static int permuAlphaN;
	static ArrayList<HashSet<Character>> hsal = new ArrayList<HashSet<Character>>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		K -= 5;
		
		for (int i=0; i<N; i++) {
			String tmp = br.readLine();
			tmp = tmp.substring(4, tmp.length()-4);
			// a, c, i, n, t 제외한 모든 알파벳 HashSet에 저장
			HashSet<Character> hs = new HashSet<Character>();
			for (int j=0; j<tmp.length(); j++) {
				if (tmp.charAt(j) != 'a' && tmp.charAt(j) != 'c' && tmp.charAt(j) != 'i' && tmp.charAt(j) != 'n' && tmp.charAt(j) != 't')
					hs.add(tmp.charAt(j));	
			}
			// 모든 글자가 a, c, i, n, t로 이루어져 있으면 무조건 답에 포함시킴
			if (hs.size() == 0)
				max++;
			
			//System.out.println(hs);
			if (hs.size() <= K) {
				Iterator<Character> it = hs.iterator();
				while (it.hasNext()) {
					char c = it.next();
					if (!(permuAlpha.contains(c)))
						permuAlpha.add(c);
				}
			}
			hsal.add(hs);
		}
		if (K < 0) { //anta, tica -> a,c,i,n,t 최소 5개 필요, 제일 짧은게 K개보다 더 필요하면 끝냄
			System.out.println(0);
			return ;
		}

		permuAlphaN = permuAlpha.size();
		// al의 char원소들을 String으로 변환 // (b, c, d) -> bcd
		for (int i=0; i<permuAlphaN; i++) {
			s += (char) permuAlpha.get(i);
		}
		visited = new boolean[permuAlphaN];
		dfs(0, 0);
		System.out.println(max);
		
		
	}
	public static void dfs(int start, int depth) {
		if (depth == Math.min(K, permuAlphaN)) {
			HashSet<Character> hs = new HashSet<Character>();
			for(int i=0; i<permuAlphaN; i++) {
				if (visited[i] == true) {
					hs.add(s.charAt(i));
				}
			}
			int cnt = 0;
			for (int i=0; i<hsal.size(); i++) {
				if (hs.containsAll(hsal.get(i)))
					cnt++;
			}
			max = Math.max(max, cnt);
		}
		for (int i=start; i<permuAlphaN; i++) {
			visited[i] = true;
			dfs(i+1, depth+1);
			visited[i] = false;
		}
	}
	

}
