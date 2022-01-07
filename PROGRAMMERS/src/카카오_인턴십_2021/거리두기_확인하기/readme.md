## Programmers - 거리두기 확인하기 
- Level 2 
- BFS 
🔗[거리두기 확인하기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/81302)



## 풀이

bfs의 특징과 조건을 잘 이해하면 풀 수 있는 문제였다!


## 소스코드
~~~java
import java.util.*;
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
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.40ms, 77.5MB)|
|테스트 2 |	통과 (0.35ms, 72.7MB)|
|테스트 3 |	통과 (0.33ms, 85.4MB)|
|테스트 4 |	통과 (0.31ms, 74.3MB)|
|테스트 5 |	통과 (0.40ms, 76MB)|
|테스트 6 |	통과 (0.40ms, 74.2MB)|
|테스트 7 |	통과 (0.45ms, 74.9MB)|
|테스트 8 |	통과 (0.48ms, 74.7MB)|
|테스트 9 |	통과 (0.48ms, 74MB)|
|테스트 10 |	통과 (0.36ms, 70.2MB)|
|테스트 11 |	통과 (0.35ms, 75.7MB)|
|테스트 12 |	통과 (0.33ms, 77.4MB)|
|테스트 13 |	통과 (0.35ms, 75.8MB)|
|테스트 14 |	통과 (0.30ms, 73.4MB)|
|테스트 15 |	통과 (0.32ms, 74.2MB)|
|테스트 16 |	통과 (0.33ms, 72.8MB)|
|테스트 17 |	통과 (0.32ms, 76MB)|
|테스트 18 |	통과 (0.36ms, 74.7MB)|
|테스트 19 |	통과 (0.39ms, 75.3MB)|
|테스트 20 |	통과 (0.36ms, 67.5MB)|
|테스트 21 |	통과 (0.33ms, 73.7MB)|
|테스트 22 |	통과 (0.30ms, 75.1MB)|
|테스트 23 |	통과 (0.03ms, 77.7MB)|
|테스트 24 |	통과 (0.52ms, 67.7MB)|
|테스트 25 |	통과 (0.04ms, 65.6MB)|
|테스트 26 |	통과 (0.02ms, 76.7MB)|
|테스트 27 |	통과 (0.51ms, 73.8MB)|
|테스트 28 |	통과 (0.36ms, 77.2MB)|
|테스트 29 |	통과 (0.48ms, 73.2MB)|
|테스트 30 |	통과 (0.38ms, 75.3MB)|