package SWTest_problem.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 톱니바퀴_14891 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char wheels[][] = new char[4][8];
		for (int i=0; i<4; i++) {
			String s = br.readLine();
			for (int j=0; j<8; j++) {
				wheels[i][j] = s.charAt(j);
			}
		}
		// N극 = 0, S극 = 1
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		// 다른 톱니바퀴랑 겹치는 charAt
		// 1번 톱니바퀴 = 2 / 2번 톱니바퀴 = 2, 6 / 3번 톱니바퀴 = 2, 6 / 4번 톱니바퀴 = 6
		int answer = 0;
		for (int i=0; i<K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 회전시킬 톱니바퀴 번호
			int dir = Integer.parseInt(st.nextToken()); // 방향(1 = 시계, -1 = 반시계)
		
			int turnFlag[] = new int[4];
			turnFlag[n-1] = dir;
			
			if (n == 1) {
				if (wheels[1][6] != wheels[0][2])
					turnFlag[1] = turnFlag[0] * -1;
				
				if (wheels[1][2] != wheels[2][6])
					turnFlag[2] = turnFlag[1] * -1;
				
				if (wheels[2][2] != wheels[3][6])
					turnFlag[3] = turnFlag[2] * -1;
			}
			else if (n == 2) {
				if (wheels[1][6] != wheels[0][2])
					turnFlag[0] = turnFlag[1] * -1;
				
				if (wheels[1][2] != wheels[2][6])
					turnFlag[2] = turnFlag[1] * -1;
				
				if (wheels[2][2] != wheels[3][6])
					turnFlag[3] = turnFlag[2] * -1;
			}
			else if (n == 3) {
				if (wheels[2][2] != wheels[3][6])
					turnFlag[3] = turnFlag[2] * -1; // 다른 극이면 반대 방향으로 회전
				
				if (wheels[1][2] != wheels[2][6])
					turnFlag[1] = turnFlag[2] * -1; // 다른 극이면 반대 방향으로 회전
				
				if (wheels[0][2] != wheels[1][6])
					turnFlag[0] = turnFlag[1] * -1; // 다른 극이면 반대 방향으로 회전
			}
			else if (n == 4) {
				if (wheels[3][6] != wheels[2][2])
					turnFlag[2] = turnFlag[3] * -1;
				
				if (wheels[1][2] != wheels[2][6])
					turnFlag[1] = turnFlag[2] * -1;
				
				if (wheels[1][6] != wheels[0][2])
					turnFlag[0] = turnFlag[1] * -1;
			}
			
			
			for (int j=0; j<4; j++)
				System.out.print(turnFlag[j]+" ");
			System.out.println();
			
			for (int j=0; j<4; j++) {
				if (turnFlag[j] == 1) { // 시계
					char save = wheels[j][7];
					for (int k=7; k>=1; k--) {
						wheels[j][k] = wheels[j][k-1];
					}
					wheels[j][0] = save;
				}
				else if (turnFlag[j] == -1) { // 반시계
					char save = wheels[j][0];
					for (int k=0; k<7; k++) {
						wheels[j][k] = wheels[j][k+1];
					}
					wheels[j][7] = save;
				}
			}
		
			for (int j=0; j<4; j++) {
				for (int k=0; k<8; k++) {
					System.out.print(wheels[j][k]);
				}
				System.out.println();
			}
		}
		if (wheels[0][0] == '1')
			answer += 1;
		if (wheels[1][0] == '1')
			answer += 2;
		if (wheels[2][0] == '1')
			answer += 4;
		if (wheels[3][0] == '1')
			answer += 8;
		
		System.out.println(answer);
	}

}
