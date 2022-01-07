package 카카오_인턴십_2021.거리두기_확인하기;
import java.util.*;

public class 거리두기_확인하기 {
	class Solution {
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
	            String[] arr = places[i];
	            // 거리두기가 잘 지켜준 경우 true 
	            boolean flag = true;
	            for(int r=0; r<5; r++){
	                for(int c=0; c<5; c++){
	                    if(arr[r].charAt(c)=='P'){
	                        if(!bfs(r,c,arr)){
	                            flag = false;
	                            break;
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
	        Queue<Node> q = new LinkedList<>();
	        boolean[][] visited = new boolean[arr.length][arr.length];
	        q.add(new Node(r,c));
	        visited[r][c] = true;
	        
	        while(!q.isEmpty()){
	            Node node = q.poll();
	            
	            // 사방탐색 진행 
	            for(int d=0; d<4; d++){
	                int nr = node.r + dr[d];
	                int nc = node.c + dc[d];
	                int dis = Math.abs(nr-r) + Math.abs(nc-c); 
	                
	                if(nr<0 || nc<0 || nr>=5 || nc>=5 || dis>2 || visited[nr][nc])  continue;
	                
	                if(arr[nr].charAt(nc)=='P'){
	                    return false;
	                }else if(arr[nr].charAt(nc)=='O' && dis<2){
	                    q.add(new Node(nr,nc));
	                    visited[nr][nc] = true;
	                }
	            }
	        }
	        return true;
	    }
	}

}
