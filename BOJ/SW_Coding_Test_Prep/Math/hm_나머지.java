import java.util.*;
import java.io.*;

public class hm_나머지 {
	public static void main(String[] args) throws IOException {
		int[] n = readInput(3);

		System.out.println((n[0] + n[1]) % n[2]);
		System.out.println((n[0] % n[2] + n[1] % n[2]) % n[2]);
		System.out.println((n[0] * n[1]) % n[2]);
		System.out.println((n[0] % n[2] * n[1] % n[2]) % n[2]);
	}

	public static int[] readInput(int size) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return (arr);
	}
}
