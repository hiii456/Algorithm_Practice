## Programmers - 가장 먼 노드 
- Graph , Dijkstra 
- Level3
- 🔗[가장 먼 노드 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/49189)

## 풀이

먼저 정점과 정점까지의 거리를 가지고 있는 Node 객체를 만들어줍니다. 이때 거리는 오름차순으로 정렬되게 생성합니다.

~~~java
	static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
        // 가중치 오름차순 
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
~~~

그리고 각 노드 별로 이어지는 정점을 담은 리스트와 최소 거리를 담을 dist 배열을 생성합니다.

~~~java
	static List<Integer>[] minNode;
	static int[] dist;
~~~

방향이 없기 때문에 start,end 각각 이어지는 정점을 넣어주었습니다.

~~~java
        for(int[] v : edge){
            int start = v[0];
            int end = v[1];
            minNode[start].add(end);
            minNode[end].add(start);
        }
~~~

그리고 정점 1에서 먼 노드를 구해야하므로 다익스트라에서 사용할 임의의 정점은 1로 지정합니다.
우선순위큐와 방문했는지를 나타내는 boolean 배열을 만들고 정점 1을 넣어주고 거리는 0으로 둡니다.
그리고 큐가 비지 않을 동안 반복문을 실행합니다.
먼저 가중치가 낮은 순부터 우선순위큐에서 뽑아 방문체크를 해준 뒤 
현재 정점을 거쳐서 가는것과 이어지는 정점의 거리를 비교하여 최솟값으로 갱신해줍니다.

~~~java
	public static void dijkstra(int start,int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        pq.add(new Node(start,0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
            
            if(check[cur])  continue;
            // 방문체크 
            check[cur] = true;
            for(Integer i : minNode[cur]){
                if(dist[i] > dist[cur] + 1){
                    dist[i] = dist[cur] + 1;
                    pq.add(new Node(i,dist[i]));
                }
            }
        }
        
    }
~~~

이렇게 구해진 dist을 배열에서 최대값의 개수를 카운트하여 답을 출력하였습니다.



## 소스코드
~~~java
import java.util.*;

public class 가장_먼_노드 {
	static class Node implements Comparable<Node>{
        int end;
        int weight;
        public Node(int end,int weight){
            this.end = end;
            this.weight = weight;
        }
        // 가중치 오름차순 
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
    static List<Integer>[] minNode;
    static int[] dist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        minNode = new ArrayList[n+1];
        dist = new int[n+1];
        
        for(int i=1; i<=n; i++){
            minNode[i] = new ArrayList<>();
        }
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        for(int[] v : edge){
            int start = v[0];
            int end = v[1];
            minNode[start].add(end);
            minNode[end].add(start);
        }
        
        dijkstra(1,n);
        
        int max = 0;
        for(int i=2; i<=n; i++){
            max = Math.max(dist[i],max);
        }
        for(int i=2; i<=n; i++){
            if(max==dist[i])    answer++;
        }
        
        return answer;
    }
    public static void dijkstra(int start,int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[n+1];
        pq.add(new Node(start,0));
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;
            
            if(check[cur])  continue;
            // 방문체크 
            check[cur] = true;
            for(Integer i : minNode[cur]){
                if(dist[i] > dist[cur] + 1){
                    dist[i] = dist[cur] + 1;
                    pq.add(new Node(i,dist[i]));
                }
            }
        }
        
    }

}

~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.61ms, 73.5MB)|
|테스트 2 |	통과 (0.59ms, 76.3MB)|
|테스트 3 |	통과 (0.65ms, 75MB)|
|테스트 4 |	통과 (1.62ms, 75.3MB)|
|테스트 5 |	통과 (2.89ms, 79.5MB)|
|테스트 6 |	통과 (4.58ms, 80.5MB)|
|테스트 7 |	통과 (24.73ms, 89.7MB)|
|테스트 8 |	통과 (38.71ms, 115MB)|
|테스트 9 |	통과 (62.55ms, 113MB)|