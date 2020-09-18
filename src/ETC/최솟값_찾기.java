package ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/*
 * 소요 시간: 1시간
 * ★★★☆☆, Cheating : O
 * Deque 처음 공부해봄. Deque를 오름차순으로 유지하는게 핵심 아이디어.
 * Deque에서 빼줘야하는 경우 1) 범위가 벗어났을 때 2) arr[i]이 Deque의 제일 큰 값보다 작을 때. (Deque의 제일 큰 값 빼고 arr[i]를 넣어줘야함)
 */
public class 최솟값_찾기 {
	static class Node {
		int index;
		int value;
		Node (int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] answer = new int[N];
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st1.nextToken());
		}
		/*
		for (int i=0; i<N; i++) {
			for (int j=Math.max(i-L+1, 0); j<=i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		*/
		// deque을 오름차순으로 유지하자.
		Deque<Node> deque = new LinkedList<>();
		for (int i=0; i<N; i++) {
			// 새로 들어올 박스의 값보다 더 큰 값이 있으면 pop 해준다.
			while (!deque.isEmpty() && deque.getLast().value > arr[i])
				deque.removeLast();
			deque.addLast(new Node(i, arr[i]));
			
			// 오래돼서 빼야할 박스들을 빼기
			if (deque.getFirst().index <= i - L)
				deque.removeFirst();
			answer[i] = deque.getFirst().value;
		}
		
		for (int i=0; i<N; i++)
			System.out.print(answer[i]+" ");
		
	}

}
