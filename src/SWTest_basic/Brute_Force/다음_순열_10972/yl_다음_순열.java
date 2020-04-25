package SWTest_basic.Brute_Force.다음_순열_10972;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class yl_다음_순열 {
//https://dundung.tistory.com/58
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if (next_permutation(arr))
		{
			for(int i=0; i<N; i++)
				System.out.print(arr[i]+" ");
			System.out.println();
		}
		else
			System.out.println("-1");
	}

	public static boolean next_permutation(int[] arr)
	{
		//첫 번째부터 탐색하면 while문이 ex)5 4 1 2 3 일때 안 돌아서 마지막부터 탐색해야 함.
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] >= arr[i]) {
			i -= 1;
		}
		if(i <= 0)
			return false;
		
		/*
		 * 1. A[i-1] > A[i]를 만족하는 가장 큰 i를 찾는다.
		 * 2. j >= i이면서 A[j] < A[i-1]을 만족하는 가장 큰 j를 찾는다.
		 * 3. A[i-1]과 A[j]를 swap한다.
		 * 4. A[i]부터 순열을 뒤집는다.
		 */
		int j = arr.length - 1;
		while(arr[i-1] >= arr[j]) {
			j -= 1;
		}
		int tmp = arr[i-1];
		arr[i-1] = arr[j];
		arr[j] = tmp;
		
		j = arr.length - 1;
		while(i<j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i += 1;
			j -= 1;
		}
		return true;
	}
}

