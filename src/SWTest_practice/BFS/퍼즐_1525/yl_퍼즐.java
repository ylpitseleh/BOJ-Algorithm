package SWTest_practice.BFS.퍼즐_1525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class yl_퍼즐 {
	static int num[];
	static Queue q = new LinkedList<int []>();
	static int dx[] = {-1, 1, -3, 3};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = new int[10];
		int zeroIdx = 0;
		for (int i=0; i<9; i+=3) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				num[i + j] = Integer.parseInt(st.nextToken());
				if (num[i+j] == 0)
					zeroIdx = (i+j);
			}
		}
		int ansArr[] = {1,2,3,4,5,6,7,8,0};
		
		q.add(num);
		while(!q.isEmpty()) {
			
			int[] n = (int[]) q.poll();
			
			// poll한 배열이 {1,2,3,4,5,6,7,8,0}이면 break;
			int diffFlag = 0;
			for (int i=0; i<9; i++) {
				if (n[i] != ansArr[i])
					diffFlag = 1;
			}
			if (diffFlag == 0) {
				System.out.println(n[9]);
				break ;
			}
			
			// 0이 위치한 index 저장
			for (int i=0; i<9; i++) {
				if (n[i] == 0)
					zeroIdx = i;
			}
			
			// -1, 1, -3, 3 (상,하,좌,우) add 
			for (int x=0; x<4; x++) {
				int nx = dx[x] + zeroIdx;
				if(nx < 0 || nx >= 9) 
					continue ;
				
				int arr[] = new int[10];
				for (int i=0; i<9; i++) {
					arr[i] = n[i];
					if (i == zeroIdx)
						arr[i] = n[nx];
					if (i == nx)
						arr[i] = 0;
				}
				arr[9] = n[9] + 1; //arr의 9번째 원소에는 카운트 저장
				q.add(arr);
			}
			
			
		}
		

	}

}
