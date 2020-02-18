import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
//�����佺�׳׽��� ü ��� - ���� ȿ������ ���
public class ��������_���� {
	public static final int MAX = 1000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] isPrime = new boolean[MAX + 1];
		
		for(int i=2; i<=MAX; i++)
			isPrime[i] = true;
		
		for(int i=2; i<=MAX; i++) {
			for(int j=i*2; j<=MAX; j+=i) {
				if(!isPrime[j])
					continue;
				isPrime[j] = false;
			}
		}
		
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			boolean ok = false;
			//���� 2�� �������� § ���� 1�� �������� �����ߴ�. ����ϱ� !!
			for (int i=2; i<=n/2; i++) {
				if (isPrime[i] && isPrime[n-i]) {
					System.out.println(n+" = "+i+" + "+(n-i));
					ok = true;
					break;
				}
			}
			if(!ok)
				System.out.println("Goldbach's conjecture is wrong.");
		}
	}

}
