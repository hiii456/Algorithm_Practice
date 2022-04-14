package 카카오_예선_2017.카카오프렌즈_컬러링북;
import java.util.*;
public class 카카오프렌즈_컬러링북 {
	static class Node{
        int r;
        int c;
        public Node(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    int tmp = bfs(i,j,picture,n,m);
                    maxSizeOfOneArea = Math.max(tmp,maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
    public static int bfs(int r,int c,int[][] picture,int n,int m){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r,c));
        visited[r][c] = true;
        int area = 1;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nc<0 || nr>=m || nc>=n)  continue;
                if(visited[nr][nc] || picture[nr][nc] != picture[r][c]) continue;
                visited[nr][nc] = true;
                queue.add(new Node(nr,nc));
                area++;
            }
        }
        
        return area;
    }

}
