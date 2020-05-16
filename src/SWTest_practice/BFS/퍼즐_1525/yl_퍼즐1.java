package SWTest_practice.BFS.퍼즐_1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 푸는데 3시간 걸림.
 * 메모리 초과 때문에 String을 int로 바꿔서 연산해야 하는데
 * 0123 -> 123이 되므로 처음에 입력받을때부터 0을 9로 바꿔서 계산하는게 관건.
 * 주의 !!
 * 1 0 3
 * 4 2 5
 * 7 8 6 에서 3과 4, 5와7은 -1, +1 차이여도 교환 못 함!!! -> 21% 에서 틀렸습니다 나온 이유
 */
public class yl_퍼즐1 {
	static int number = 0;
	static Queue q = new LinkedList<Integer>();
	static HashMap hm = new HashMap<Integer, Integer>();
	static int dx[] = {-1, 1, -3, 3};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<9; i+=3) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				int val = Integer.parseInt(st.nextToken());
				if (val == 0)
					val = 9;
				number = number * 10 + val;
			}
		}
		
		hm.put(number, 0);
		int ans = 123456789;
		
		q.add(number);
		while(!q.isEmpty()) {
			int n =  (int) q.poll();
			
			// n이 123456789면 break
			if (n == ans) {
				System.out.println(hm.get(n));
				return ;
			}
			
			// 0이 위치한 index 저장
			String strN = Integer.toString(n);
			int zeroIdx = strN.indexOf('9');
			
			// -1, 1, -3, 3 (상,하,좌,우) add 
			for (int x=0; x<4; x++) {
				if (dx[x] == 1) {
					if (zeroIdx == 2 || zeroIdx == 5)
						continue ;
				}
				if (dx[x] == -1) {
					if (zeroIdx == 3 || zeroIdx == 6)
						continue ;
				}
				int nx = dx[x] + zeroIdx;
				if(nx < 0 || nx >= 9) 
					continue ;
				
				StringBuilder sb = new StringBuilder(strN);
				for (int i=0; i<9; i++) {
					if (i == zeroIdx)
						sb.setCharAt(i, strN.charAt(nx));
					else if (i == nx)
						sb.setCharAt(i, '9');
				}
				
				int nn = Integer.parseInt(sb.toString());
				
				if (!hm.containsKey(nn)) {
					hm.put(nn, (int)hm.get(n) + 1);
					q.add(nn);
				}
			}
		}
		
		System.out.println(-1);
	}

}
