package CodingTestPreparationSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		int[] num = new int[10];
		for (int i=0; i<N.length(); i++) {
			int n = N.charAt(i)-'0';
			num[n]++;
		}
		int answer = 0;
		
		if (num[6] != num[9]) {
			while (true) {
				if (Math.abs(num[6] - num[9]) == 1 || num[6] == num[9])
					break ;
				if (num[6] < num[9]) {
					num[6]++;
					num[9]--;
				}
				else {
					num[6]--;
					num[9]++;
				}
			}
		}
		
		for (int i=0; i<10; i++) {
			answer = Math.max(answer, num[i]);
			System.out.print(num[i]+" ");
		}
		System.out.println(answer);
		
	}

}
