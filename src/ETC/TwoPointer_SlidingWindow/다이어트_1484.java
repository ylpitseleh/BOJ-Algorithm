package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * 소요 시간: 15분
 * ★☆☆☆☆, Cheating : X
 * 쉬운 투포인터 문제.
 */
public class 다이어트_1484 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		
		// G = 성원이의 현재 몸무게의 제곱 - 성원이가 기억하고 있던 몸무게의 제곱
		//16 1
		//25 16 9 4 1
		//36 25 16 9 4 1
		//49 36 25 16 9 4 1
		//64 49 36 25 16 9 4 1
		//81 64 49 36 25 16 9 4 1
		long n1 = 1;
		long n2 = 2;
		ArrayList<Integer> al = new ArrayList<>();
		while (true) {
			
			while (true) {
				//System.out.println(n1+" "+n2);
				if ((long)(n2*n2) - (long)(n1*n1) < G) {
					n2++;
				}
				else if ((long)(n2*n2) - (long)(n1*n1) == G) {
					al.add((int)n2);
					break ;
				}
				else {
					break ;
				}
			}
			
			if ((long)(n2*n2) - (long)(n2-1)*(n2-1) > G)
				break ;
			n1++;
		}
		//System.out.println(al);
		if (al.size() == 0) {
			System.out.println(-1);
			return ;
		}
		
		for (int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
		
	}

}
