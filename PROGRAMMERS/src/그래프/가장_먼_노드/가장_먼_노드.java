package 그래프.가장_먼_노드;
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
