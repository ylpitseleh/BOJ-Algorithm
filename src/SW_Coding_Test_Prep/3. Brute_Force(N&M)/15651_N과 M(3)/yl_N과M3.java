import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;
//시간초과 해결 위해 String 대신 StringBuilder 활용
//System.out.print 대신 BufferedWriter 사용
public class yl_N과M3 {
	static int N;
	static int M;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sb = new StringBuilder();

		recur(0, "");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}

	public static void recur(int depth, String str) {
		if (depth == M) {
			sb.append(str.trim() + "\n");
		} else {
			for (int i = 1; i <= N; i++) {
				recur(depth + 1, str + " " + i);
			}
		}
	}
}
