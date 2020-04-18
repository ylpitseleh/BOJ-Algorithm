import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/* 연산자를 순열로 돌려야 하는데 입력받은 숫자들을 순열로 돌렸다가
 *  연산자 우선순위 때문에 최소값 계산이 안되어서 낭패봄.
 *  2달 전에 짰던 내 코드랑 비교해보니 로직이 거의 100% 동일해서 
 *  지식의 발전이 없음을 깨닫고 슬퍼짐. */
public class yl_연산자_끼워넣기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		int[] op = new int[4];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		//+:1, -:2, x:3, /:4
		int x=1;
		for(int i=0; i<4; i++) {
			op[i] = Integer.parseInt(st1.nextToken());
			for(int j=0; j<op[i]; j++) {
				al.add(x); //ex)op : 1 0 1 0 이면 ArrayList에 1 3 넣음.
			}
			x += 1;
		}
		int[] arr1 = new int[al.size()];
		for(int i=0; i<al.size(); i++) {
			arr1[i] = al.get(i); //ArrayList를 배열로 변환
		}
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		do {
			int n = a[0];
			for(int i=0; i<arr1.length; i++) {
				if(arr1[i]==1) {
					n += a[i+1];
				}
				else if(arr1[i]==2) {
					n -= a[i+1];
				}
				else if(arr1[i]==3) {
					n *= a[i+1];
				}
				else {
					n /= a[i+1];
				}
			}
			if(n < min)
				min = n;
			if(n > max)
				max = n;
			
		}while(next_permutation(arr1)); //연산자들을 순열로 나열하면서 모든 경우의 수 계산하고 최대, 최소값 저장		
		System.out.println(max);
		System.out.println(min);
		
	}
	public static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

}
