package Brute_Force.차이를_최대로_10819;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_차이를_최대로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int ans = 0;
		do {
			int tmp = calculate(arr);
			ans = Math.max(ans,  tmp);
		} while(next_permutation(arr));
		
		System.out.println(ans);
	}
	public static int calculate(int arr[])
	{
		int sum = 0;
		for(int i=1; i<arr.length; i++)
			sum += Math.abs(arr[i] - arr[i-1]);
		return sum;
	}
	public static boolean next_permutation(int[] arr)
	{
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] >= arr[i]) {
			i -= 1;
		}
		if(i <= 0)
			return false;
		
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
