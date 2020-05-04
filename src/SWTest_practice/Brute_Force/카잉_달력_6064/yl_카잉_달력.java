package SWTest_practice.Brute_Force.카잉_달력_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 원래 1부터 모든 숫자 검사해가면서 올렸는데 시간 초과 나서 x기준으로 가능한 수 맞춰보면서 y가 그거에 맞는지 검사해줬음.
public class yl_카잉_달력 {
	static int T, M, N, x, y;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
		
			boolean check = false;
			
			for (int i=x; i<=lcm(N, M); i+=M) {
				if (i % N == y) {
					check = true;
					System.out.println(i);
					break ;
				}
				if (i % N == 0) {
					if (y == N) {
						check = true;
						System.out.println(i);
						break ;
					}
				}
			}
			
			if (!check)
				System.out.println(-1);
		}
	}
	
	// 최소공배수 구하기
	public static int lcm(int num1, int num2) {
        int a = num1, b = num2;
        
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        
        return num1 * num2 / a;
    }

}
