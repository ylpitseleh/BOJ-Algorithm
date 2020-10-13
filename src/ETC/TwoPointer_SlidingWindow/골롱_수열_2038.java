package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
/*
 * 소요 시간: 1시간
 * ★☆☆☆☆, Cheating : O
 * 수학 점화식 갖다써야함. 별로 쓸모없는 문제같음.
 * 다만, 순서가 있는 Map인 TreeMap을 새로 알게되었다.
 * wrapper class 캐스팅때매 자꾸 컴파일오류나서 시간 많이 씀. 
 */
public class 골롱_수열_2038 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		if (n == 1) {
			System.out.println(1);
			return ;
		}
		// n의 최대 크기는 20억이므로 20억 인덱스까지 표시하기 위해 map을 써야한다.
		Map<Long, Long> map = new TreeMap<>(); // 순서가 있는 Map!
		long sum = 0;
		map.put(1L, 1L);
		sum += (long)map.get(1L);
		// java.lang.Integer cannot be cast to java.lang.Long
		for (long i=2; i<=n; i++) {
			map.put(i, 1 + map.get(i - map.get(map.get(i-1))));
			sum += map.get(i);
		
			if (sum >= n) {
				System.out.println(i);
				break ;
			}
		}
		
	}

}
