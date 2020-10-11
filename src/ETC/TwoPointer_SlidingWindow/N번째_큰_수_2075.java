package ETC.TwoPointer_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N번째_큰_수_2075 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*n];
        int idx =0;
 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[idx++] = Integer.parseInt(st.nextToken());
                pq.add(arr[idx-1]);
            }
        }
        
        int answer = 0;
        for (int i=0; i<n; i++) {
        	answer = pq.poll();
        }
        System.out.println(answer);
        
        
        

	}

}
