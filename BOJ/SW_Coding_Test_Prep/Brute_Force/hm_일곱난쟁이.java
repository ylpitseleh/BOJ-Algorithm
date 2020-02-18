import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class hm_일곱난쟁이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;
		int[] heights = new int[9];
		for (int i = 0; i < 9; i++) {
			heights[i] = Integer.parseInt(br.readLine());
			sum += heights[i];
		}

		Arrays.sort(heights);
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - heights[i] - heights[j] == 100)
				{
					prt_solution(heights, i, j);
					i = 9;
					j = 9;
				}
			}
		}
	}

	public static void prt_solution(int[] heights, int a, int b) {
		for (int i = 0; i < 9; i++) {
			if (i != a && i != b)
				System.out.println(heights[i]);
		}
	}
}
