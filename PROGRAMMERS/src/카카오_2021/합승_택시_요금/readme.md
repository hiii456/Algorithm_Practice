## Programmers - 합승 택시 요금 
- Level 3 
- Dijkstra 
🔗[합승 택시 요금 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/72413)



## 풀이

이 문제는 다익스트라로 풀어보았으나, s,a,b에서 한 지점의 최단거리를 구해야하기 때문에 플로이드와샬 알고리즘을 이용해 푸는 것도 좋을 것 같다.
먼저 우선순위큐를 이용하여 다익스트라 알고리즘 메소드를 만들어준다.

~~~java
    public static int[] dijkstra(int start,int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(visited[cur.end])    continue;
            visited[cur.end] = true;
            
            for(Node node : list[cur.end]){
                if(dist[node.end]> dist[cur.end] + node.weight){
                    dist[node.end] = dist[cur.end] + node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }
        
        return dist;
 
    } 
~~~

각 s와 다른 노드들의 최소 거리, a와 다른 노드들의 최소 거리 등을 담은 int형 배열을 통해 최소 환승 거리를 찾는다.

~~~java
        int[] distS = dijkstra(s,n);
        int[] distA = dijkstra(a,n);
        int[] distB = dijkstra(b,n);
            
        for(int i=1; i<=n; i++){
            min = Math.min(min,distS[i] + distA[i] + distB[i]);
        }
~~~


## 소스코드
~~~java
import java.util.*;
class Solution {
    static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    static List<Node>[] list;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        list = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<fares.length; i++){
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            
            list[c].add(new Node(d,f));
            list[d].add(new Node(c,f));
        }
        
        int min = Integer.MAX_VALUE;
        
        int[] distS = dijkstra(s,n);
        int[] distA = dijkstra(a,n);
        int[] distB = dijkstra(b,n);
            
        for(int i=1; i<=n; i++){
            min = Math.min(min,distS[i] + distA[i] + distB[i]);
        }
        answer = min;
        return answer;
    }
    public static int[] dijkstra(int start,int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        pq.add(new Node(start,0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(visited[cur.end])    continue;
            visited[cur.end] = true;
            
            for(Node node : list[cur.end]){
                if(dist[node.end]> dist[cur.end] + node.weight){
                    dist[node.end] = dist[cur.end] + node.weight;
                    pq.add(new Node(node.end,dist[node.end]));
                }
            }
        }
        
        return dist;
 
    } 
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.67ms, 79.7MB)|
|테스트 2 |	통과 (0.75ms, 79.4MB)|
|테스트 3 |	통과 (0.83ms, 74.8MB)|
|테스트 4 |	통과 (0.87ms, 73.7MB)|
|테스트 5 |	통과 (0.91ms, 73.6MB)|
|테스트 6 |	통과 (0.88ms, 73.9MB)|
|테스트 7 |	통과 (1.14ms, 79.3MB)|
|테스트 8 |	통과 (0.84ms, 73.6MB)|
|테스트 9 |	통과 (0.77ms, 76.7MB)|
|테스트 10 |	통과 (0.92ms, 72MB)|

----

| 효율성   | 테스트 |
|----|----|
|테스트 1 |	통과 (7.18ms, 52.7MB)|
|테스트 2 |	통과 (11.31ms, 53.9MB)|
|테스트 3 |	통과 (4.39ms, 52.7MB)|
|테스트 4 |	통과 (4.59ms, 53.2MB)|
|테스트 5 |	통과 (4.30ms, 52.1MB)|
|테스트 6 |	통과 (4.56ms, 53MB)|
|테스트 7 |	통과 (27.15ms, 65.5MB)|
|테스트 8 |	통과 (19.26ms, 66.5MB)|
|테스트 9 |	통과 (25.00ms, 65.6MB)|
|테스트 10 |	통과 (26.49ms, 65.4MB)|
|테스트 11 |	통과 (19.78ms, 66.2MB)|
|테스트 12 |	통과 (20.34ms, 61.9MB)|
|테스트 13 |	통과 (15.00ms, 60.3MB)|
|테스트 14 |	통과 (18.62ms, 61MB)|
|테스트 15 |	통과 (17.87ms, 59.9MB)|
|테스트 16 |	통과 (8.53ms, 68MB)|
|테스트 17 |	통과 (4.24ms, 52.7MB)|
|테스트 18 |	통과 (3.89ms, 52.4MB)|
|테스트 19 |	통과 (6.36ms, 53MB)|
|테스트 20 |	통과 (9.54ms, 53.2MB)|
|테스트 21 |	통과 (13.86ms, 56.9MB)|
|테스트 22 |	통과 (21.15ms, 58.2MB)|
|테스트 23 |	통과 (21.19ms, 58.5MB)|
|테스트 24 |	통과 (19.87ms, 59.8MB)|
|테스트 25 |	통과 (2.80ms, 52.1MB)|
|테스트 26 |	통과 (2.67ms, 51.9MB)|
|테스트 27 |	통과 (8.08ms, 53.4MB)|
|테스트 28 |	통과 (10.65ms, 52.8MB)|
|테스트 29 |	통과 (3.14ms, 53.4MB)|
|테스트 30 |	통과 (2.35ms, 52.1MB)|