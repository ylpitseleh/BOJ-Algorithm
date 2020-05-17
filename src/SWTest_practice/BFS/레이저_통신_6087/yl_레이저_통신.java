package SWTest_practice.BFS.레이저_통신_6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_레이저_통신 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		char map[][] = new char[H][W];
		
		for (int i=0; i<H; i++) {
			String s = br.readLine();
			for (int j=0; j<W; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
