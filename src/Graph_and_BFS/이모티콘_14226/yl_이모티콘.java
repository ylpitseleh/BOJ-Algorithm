package Graph_and_BFS.이모티콘_14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 너모 어려움. 다시 풀어보기. 이 방법 절대 못 생각해내겠음.
// visited를 2차원 배열로 만드는게 관건.
public class yl_이모티콘 {
	static int S;
	static boolean visited[][];
	static Queue<Emoticon> q = new LinkedList<>();
	static class Emoticon {
		int display;
		boolean copyFlag;
		int clipBoard;
		int n;
		Emoticon (int display, boolean copyFlag, int clipBoard, int n) {
			this.display = display;
			this.copyFlag = copyFlag; //복사한 상태면 true, 복사한게 없으면 false
			this.clipBoard = clipBoard; 
			this.n = n; //필요한 시간 (초)
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];
		
		q.add(new Emoticon(1, false, 0, 0));
		// 화면에 있는 이모티콘 개수가 같아도 클립보드에 몇 개 있냐에 따라 달라지므로 visited를 2차원 배열로 만들어야 함.
		// display * clipBoard
		visited[S][0] = true;
		
		while (!q.isEmpty()) {
			Emoticon p = q.poll();
			if (p.display == S) {
				System.out.println(p.n);
				return ;
			}
			
			for (int i=0; i<3; i++) {
				int nDisplay = p.display;
				boolean nCopyFlag = p.copyFlag;
				int nClipBoard = p.clipBoard;
				// 화면 모두 복사
				if (i == 0) {
					nCopyFlag = true;
					nClipBoard = nDisplay; // 덮어쓰기
				}
				// 클립보드를 화면에 붙여넣기
				else if (i == 1) {
					if(!nCopyFlag)
						continue ;
					nDisplay += nClipBoard;
				}
				// 화면의 이모티콘 - 1
				else {
					nDisplay--;
				}
				if (nDisplay < 1 || nDisplay > 1000)
					continue ;
				if (visited[nDisplay][nClipBoard])
					continue ;
				visited[nDisplay][nClipBoard] = true;
				q.add(new Emoticon(nDisplay, nCopyFlag, nClipBoard, p.n + 1));
			}
		}
	}

}
