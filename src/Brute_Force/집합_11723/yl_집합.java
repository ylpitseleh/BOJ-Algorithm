package Brute_Force.집합_11723;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class yl_집합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[21];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "add":
				arr[Integer.parseInt(st.nextToken())] = 1;
				break;

			case "check":
				if (arr[Integer.parseInt(st.nextToken())] == 1)
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
				break;

			case "remove":
				arr[Integer.parseInt(st.nextToken())] = 0;
				break;

			case "toggle":
				int t = Integer.parseInt(st.nextToken());
				if (arr[t] == 1)
					arr[t] = 0;
				else
					arr[t] = 1;
				break;

			case "all":
				Arrays.fill(arr, 1);
				break;

			case "empty":
				Arrays.fill(arr, 0);
				break;
			}
		}
		System.out.println(sb);
	}
}
