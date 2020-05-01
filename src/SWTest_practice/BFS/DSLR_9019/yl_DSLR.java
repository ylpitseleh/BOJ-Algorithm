package SWTest_practice.BFS.DSLR_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
// L이랑 R 계산할 때 String으로 풀었다가 7%에서 메모리초과나서 int로 바꿨다....
public class yl_DSLR {
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> s = new Stack<>();
	static int map[];
	static int trace[];
	static int dslrSave[];
	static int A, B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			map = new int[10001];
			trace = new int[10001];
			dslrSave = new int[10001];
			q.clear();
			bfs(A);
			//System.out.println(map[B]);
			
			s.clear();
			int idx = B;
			s.push(dslrSave[idx]);
			
			while (map[B]-- > 0) {
				idx = trace[idx];
				s.push(dslrSave[idx]);
			}
			s.pop();
			
			int size = s.size();
			for (int i=0; i<size; i++) {
				int pop = s.pop();
				if (pop == 1)
					System.out.print("D");
				else if (pop == 2)
					System.out.print("S");
				else if (pop == 3)
					System.out.print("L");
				else if (pop == 4)
					System.out.print("R");
			}
			System.out.println();
		}

	}
	
	public static void bfs(int start) {
		q.add(start);
		
		while (!q.isEmpty()) {
			int x = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = 0;
				int dslr = 0; //D = 1, S = 2, L = 3, R = 4
				// D
				if (i == 0) {
					nx = 2 * x;
					if (nx == 0) // continue 안 해주면 0에 0을 곱해서 무의미한 연산일때도 방문이 추가되므로 contineu 해준다.
						continue ;
					if (nx > 9999)
						nx %= 10000;
					dslr = 1;
				}
				
				// S
				if (i == 1) {
					if (x == 0)
						nx = 9999;
					else
						nx = x - 1;
					dslr = 2;
				}
				
				// L
				if (i == 2) {
					// 1234 -> 2341, 1024 -> 241, 1000 -> 1
					nx = (x%1000)*10 + x/1000;
					/*String sX = Integer.toString(x);
					sX += sX.charAt(0);
					sX = sX.substring(1, sX.length());
					nx = Integer.parseInt(sX);*/
					dslr = 3;
				}
				
				// R
				if (i == 3) {
					// 1234 -> 4123, 1230 -> 123, 1000 -> 100
					nx = (x/10) + 1000*(x%10);
					/*String tmpsX = Integer.toString(x);
					String sX = tmpsX.substring(tmpsX.length() - 1, tmpsX.length());
					sX += tmpsX.substring(0, tmpsX.length() - 1);
					nx = Integer.parseInt(sX);*/
					dslr = 4;
				}
				
				if (nx < 0)
					continue ;
				if (map[nx] == 0) {
					q.add(nx);
					map[nx] = map[x] + 1;
					trace[nx] = x;
					dslrSave[nx] = dslr;
				}
				if (nx == B)
					return ;
			}
			
		}
	}

}
