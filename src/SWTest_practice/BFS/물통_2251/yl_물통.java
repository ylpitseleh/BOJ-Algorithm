package SWTest_practice.BFS.물통_2251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * Object타입의 arraylist는 primitive type처럼 contains연산을 할 수 없다는걸 몰라서 푸는데 두 시간 걸렸다.
 * equals 오버라이드 해야함.
 * -> 이렇게 풀었는데 틀렸습니다 나옴.
 * 
 * A에서 B,C 주는거, B에서 A,C 주는거, C에서 A,B 주는거 다 구현했다가 틀렸습니다 나와서 답 보고 배꼈음.
 * 이해는 되는데 안 보고 짜려면 짱구를 많이 굴려야 할 듯. 두 시간 소요 예상. 비슷한 문제 나오면 시간 안에 풀 수 있을까? No.
 * 나중에 다시 풀어보기.
 */
public class yl_물통 {
	static Queue q = new LinkedList<Pair>();
	static int[] from = {0, 0, 1, 1, 2, 2};
	static int[] to = {1, 2, 0, 2, 0, 1};
	static int[] a = new int[3];
	static boolean[][] check = new boolean[201][201];
	static ArrayList al = new ArrayList<>();
	// C는 맨 처음 가득찬 C용량 - A - B 해주면 되기 때문에 인스턴스 변수가 2개여도 됨.
	static class Pair {
		int x; // A 물의 양
		int y; // B 물의 양
		Pair (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<3; i++)
			a[i] = Integer.parseInt(st.nextToken());
		q.add(new Pair(0, 0));
		check[0][0] = true; //check[A에 들어있는 물의 양][B에 들어있는 물의 양]
		al.add(a[2]);
		
		while (!q.isEmpty()) {
			Pair p = (Pair) q.poll();
			int x = p.x; // 현재 A에 남아있는 물의 양
			int y = p.y; // 현재 B에 남아있는 물의 양
			int z = a[2] - x - y; // 현재 C에 남아있는 물의 양
			
			for (int i=0; i<6; i++) {
				int[] next = {x, y, z}; 
				
				next[to[i]] += next[from[i]];
				next[from[i]] = 0;
				
				if (next[to[i]] > a[to[i]]) {
					next[from[i]] = next[to[i]] - a[to[i]]; // 주는 곳엔 넘친 양만큼 남아있음
					next[to[i]] = a[to[i]]; //가득 차 있음
				}
				
				if (!check[next[0]][next[1]]) {
					check[next[0]][next[1]] = true;
					q.add(new Pair(next[0], next[1]));
					if (next[0] == 0) // A가 비어있을 때
						al.add(next[2]);
				}
			}
		}
		Collections.sort(al);
		for (int i=0; i<al.size(); i++)
			System.out.print(al.get(i)+" ");
	}
	

}
