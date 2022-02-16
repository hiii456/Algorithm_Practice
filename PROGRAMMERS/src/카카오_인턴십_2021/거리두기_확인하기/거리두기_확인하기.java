package 카카오_인턴십_2021.거리두기_확인하기;
import java.util.*;
public class 거리두기_확인하기 {
	static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Node{
        int r;
        int c;
        public Node(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i<places.length; i++){
            String[] p = places[i];
            boolean flag = true;
            for(int r=0; r<5; r++){
                for(int c=0; c<5; c++){
                    if(p[r].charAt(c) == 'P'){
                        if(!bfs(r,c,p)){
                            flag = false;
                        }
                    }
                }
            }
            if(flag){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    public static boolean bfs(int r,int c,String[] arr){
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        queue.add(new Node(r,c));
        visited[r][c] = true;
        
        while(!queue.isEmpty()){
            Node curNode = queue.poll();
            
            for(int d=0; d<4; d++){
                int nr = curNode.r + dr[d];
                int nc = curNode.c + dc[d];
                
                if(nr<0 || nc<0 || nr>=5 || nc>=5 || visited[nr][nc])   continue;
                visited[nr][nc] = true;
                int dis = Math.abs(nr-r) + Math.abs(nc-c);
                if(arr[nr].charAt(nc) == 'P' && dis<=2)   return false;
                if(arr[nr].charAt(nc) == 'O' && dis<=2){
                    queue.add(new Node(nr,nc));
                }
                
            }
        }
        return true;
        
    } 

}
