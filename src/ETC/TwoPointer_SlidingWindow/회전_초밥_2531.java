package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * 소요 시간: 1시간
 * ★☆☆☆☆, Cheating : O
 * 이거 완전 프로그래머스 보석 쇼핑이랑 똑같은거같은디
 */
public class 회전_초밥_2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 회전 초밥 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 메뉴에 있는 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int sushi[] = new int[N + k];
		for (int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		// 원형이니까 마지막 25, 7, 9, 7 까지 포함해줌 
		//sushi[N] = sushi[0];
		//sushi[N+1] = sushi[1];
		//sushi[N+2] = sushi[2];
		for (int i=0; i<k-1; i++) {
			sushi[N+i] = sushi[i];
		}
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		int answer = 0;
		for (int i=0; i<k; i++) {
			if (hm.containsKey(sushi[i])) {
				hm.put(sushi[i], hm.get(sushi[i])+1);
			}
			else {
				hm.put(sushi[i], 1);
			}
		}
		
		//for (int i=0; i<sushi.length; i++)
			//System.out.print(sushi[i]+" ");
		//System.out.println();
		
		for (int i=0; i<N; i++) {
			System.out.println(hm+" "+hm.size());
			if (answer <= hm.size()) {
				answer = hm.size();
				if (!hm.containsKey(c)) {
					answer++;
					System.out.println("answer +1된다.");
				}
			}
			
			if (hm.get(sushi[i]) == 1)
				hm.remove(sushi[i]);
			else
				hm.put(sushi[i], hm.get(sushi[i])-1);
			
			if (hm.containsKey(sushi[i+k]))
				hm.put(sushi[i+k], hm.get(sushi[i+k])+1);
			else
				hm.put(sushi[i+k], 1);
		}
		
		System.out.println(answer);

	}

}
