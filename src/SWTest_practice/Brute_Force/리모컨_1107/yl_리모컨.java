package SWTest_practice.Brute_Force.리모컨_1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 0부터 1,000,000까지 for문 돌리면서 일일이 확인하는 아이디어만 떠올리면 풀 수 있음.
// broken을 int 배열 말고 boolean 배열로 체크하는게 관건 -> 메모리 , 시간복잡도 절약
public class yl_리모컨 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); //이동하려고 하는 채널
		int M = Integer.parseInt(br.readLine()); //고장난 버튼의 개수
		
		boolean broken1[] = new boolean[10];
		
		int broken[] = new int[M];
		if (M >= 1) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) 
				broken1[Integer.parseInt(st.nextToken())] = true; //이렇게도 쓸 수 있구나
			
			//for (int i=0; i<M; i++)
				//broken[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Math.abs(N - 100); //+,- 버튼만 사용하는 경우
		
		//0부터 1,000,000까지 일일이 구해봄
		for (int x=0; x<=1000000; x++) {
			int num = x; //i의 값 저장
			int tmpAns = 0;
			
			// num의 모든 자릿수가 고장나지 않았는지 확인
			// String contains로 확인하는 것 보다 broken을 boolean으로 만들어서 하는게 메모리가 10배 이상 절약됨.
			if (num == 0) {
				if (broken1[0])
					continue ;
				else
					tmpAns = 1;
			}
			int brokenFlag = 0;
			while (num > 0) {
				if (broken1[num % 10]) {
					brokenFlag = 1;
					break ;
				}
				tmpAns++;
				num /= 10;
			}
			if (brokenFlag == 1)
				continue ;
			
			/*
			int brokenFlag = 0;
			String sNum = Integer.toString(num); //num을 String으로
			
			for (int i=0; i<M; i++) {
				// num에 고장난 숫자가 있다면 continue
				
				if (sNum.contains(Integer.toString(broken[i]))) {
					brokenFlag = 1;
					break ;
				}
			}
			if (brokenFlag == 1)
				continue ;
			else {
				tmpAns = sNum.length();
			}*/
			
			// 있는 숫자 눌렀으면 이제 +,- 누르기
			tmpAns += Math.abs(x - N);
			ans = Math.min(ans, tmpAns);
		}
		System.out.println(ans);
		
		
			

	}

}
