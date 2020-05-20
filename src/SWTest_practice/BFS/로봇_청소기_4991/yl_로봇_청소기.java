package SWTest_practice.BFS.로봇_청소기_4991;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://developer-pi.tistory.com/45
// bfs + dfs 죽음의 콜라보. 나중에 꼭 다시 풀어보기....
public class yl_로봇_청소기 {
	static class Pos{
        int y;
        int x;
        Pos(int y, int x){
            this.y=y;
            this.x=x;
        }
    }
    static int w,h;
    static char[][] map;
    static int count;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,-1,1};
    static ArrayList<Pos> al;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        outloof:
            do {
                al= new ArrayList<>(); 
                w = sc.nextInt();
                h = sc.nextInt();
                if(w==0 && h==0) break;
                map = new char[h][w];
                for(int i=0; i<h; i++) {
                    String s = sc.next();
                    for(int j=0; j<w; j++) {
                        map[i][j] = s.charAt(j);
                        if(map[i][j]=='o') {
                            al.add(0, new Pos(i,j)); //첫 번째로 시작해야 하므로 0번째에 넣어줌.
                        }else if(map[i][j]=='*') {
                            al.add(new Pos(i,j));
                        }
                    }
                }
                
                //al.size () = 'o'와 '*'를 합한 개수 
                int[][] d = new int[al.size()][al.size()];
                for(int i=0; i<al.size(); i++) {
                    Pos src = al.get(i); //i에서부터 시작하는 각각의 더러운 지점(*)의 거리
                    int[][] dist = bfs(src);
                    for(int j=0; j<al.size(); j++) {
                    	Pos dest = al.get(j);
                        d[i][j] = dist[dest.y][dest.x];
                        if(d[i][j] == Integer.MAX_VALUE) {
                            System.out.println("-1");
                            continue outloof;
                        }
                    }
                }
                /*
                for (int i=0; i<al.size(); i++) {
                	for (int j=0; j<al.size(); j++) {
                		System.out.print(d[i][j]+" ");
                	}
                	System.out.println();
                }
                */
                /*
                 0 4 2 6 
				 4 0 6 2 
				 2 6 0 4 
				 6 2 4 0 
                 */
                visited = new boolean[al.size()];
                ans = Integer.MAX_VALUE;
                dfs(0, 0, al.size() - 1, 0, d); //자기 위치는 0이니까 검사 안 해도 돼서 al.size()-1
                System.out.println(ans);
            }while(true);
    }
    
    static boolean[] visited;
    static int ans;
    private static void dfs(int num, int sum, int end, int index, int[][] d) {
        if(index == end) {
        	// ans에 최소값 저장
            ans = Math.min(ans, sum);
            return;
        }
        
        for(int i=1; i<al.size(); i++) {
            if (visited[i]) 
            	continue;
            visited[i] = true;
            int next = sum + d[num][i];
            dfs(i, next, end, index+1, d);
            visited[i] = false;
        }
    }
    
    private static int[][] bfs(Pos start) {
        int[][] dist = new int[h][w];
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[start.y][start.x] = 0;
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
        	Pos p = q.remove();
            for(int i=0; i<4; i++) {
                int ny = dy[i] + p.y;
                int nx = dx[i] + p.x;
                if (ny < 0 || nx < 0 || ny >= h || nx >= w) 
                	continue;
                if (map[ny][nx] == 'x') 
                	continue;
                if (dist[ny][nx] <= dist[p.y][p.x]+1) 
                	continue;
                dist[ny][nx] = dist[p.y][p.x] + 1;
                q.add(new Pos(ny,nx));
            }
        }
        return dist;
    }
}
