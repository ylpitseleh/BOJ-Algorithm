package SWTest_practice.BFS.숨바꼭질4_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
// stack 사용하고 trace 배열 추가해주는 것만 생각해내면 되는데 떠올리기 쉽지 않음. 그냥 외워두는게 나을듯.
public class yl_숨바꼭질4 {
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> s = new Stack<>();
	static int dx[] = {-1, 1, 2};
	static int map[];
	static int trace[]; 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수빈 위치
		int K = Integer.parseInt(st.nextToken()); // 동생 위치
		map = new int[200001];
		trace = new int[200001];
		
		// 최소 시간 구하기
		q.add(N);
		while (!q.isEmpty()) {
			int x = q.poll();
			if (x == K)
				break ;
			for (int i=0; i<3; i++) {
				int nx = x + dx[i];
				if (i == 2)
					nx = x * dx[2];
				
				if (nx < 0 || nx >= 200001)
					continue ;
				if (map[nx] > 0)
					continue ;
				q.add(nx);
				map[nx] = map[x] + 1;
				// 바로 전(x) 위치를 nx에 저장해줌.
				trace[nx] = x;
			}
		}
		System.out.println(map[K]);
		
		// 최소 시간 trace 구하기
		int idx = K;
		s.push(K);
		while (map[K]-- > 0) {
			idx = trace[idx];
			s.push(idx);
		}
		
		int size = s.size(); //for문에서 i<s.size()하면 stack size가 계속 달라져서 다 출력이 안 됨.
		for (int i=0; i<size; i++)
			System.out.print(s.pop()+" ");
		
		

	}

}
