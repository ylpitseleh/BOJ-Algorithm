package ETC.TwoPointer_SlidingWindow;
/*
 * 소요 시간: 20분
 * ★☆☆☆☆, Cheating : X
 * 투 포인터인데 범위가 소수만 해당되는 문제. 원리는 똑같다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 소수의_연속합_1644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 소수 구하기
		boolean arr[] = new boolean[N+1];
		arr[0] = arr[1] = false;
		for (int i=2; i<=N; i++)
			arr[i] = true;
		
		for (int i=2; i*i<=N; i++) {
			for (int j=i*i; j<=N; j+=i) {
				arr[j] = false;
			}
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<=N; i++) {
			if (arr[i] == true)
				al.add(i);
		}
		System.out.println(al);
		int start = 0;
		int end = 0;
		int size = al.size();
		int answer = 0;
		
		while (start < size) {
			int sum = 0;
			end = start;
			while (end < size) {
				//System.out.println(start+" "+end+" sum = "+sum);
				sum += al.get(end);
				if (sum == N) {
					answer++;
					break ;
				}
				else if (sum > N)
					break ;
				else {
					end++;
				}
			}
			start++;
		}
		System.out.println(answer);
	}

}
