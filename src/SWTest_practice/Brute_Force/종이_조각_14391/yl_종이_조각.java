package SWTest_practice.Brute_Force.종이_조각_14391;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_종이_조각 {
	static int h, w;
	static int map[][];
	static int binary[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		map = new int[h][w];
		binary = new int[h*w];
		
		for (int i=0; i<h; i++) {
			String s = br.readLine();
			for (int j=0; j<w; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		// map을 0,1만 사용하는 일차원 배열로 만들어서 모든 경우의 수 출력해줌. h=3, w=2일 때 경우의 수는 2의 (3*2)제곱 = 64가지.
		for (int i=0; i<Math.pow(2, h*w); i++) {
			int arr[] = new int[h*w];
			arr = makeBinary(i);
			
			for (int j=0; j<h*w; j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		}
		
		

	}
	
	public static int[] makeBinary(int i) {
		int[] arr = new int[h*w];
		// 배열로 모든 경우의 수 구하기. 신기함. 내가 짜라면 절대 못 짬.
		for (int j=0; j<h*w; j++) {
			arr[j] = i % 2;
			i = i / 2;
		}
		return arr;
	}

}
