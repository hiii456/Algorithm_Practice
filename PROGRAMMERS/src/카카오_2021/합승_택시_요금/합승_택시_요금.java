package 카카오_2021.합승_택시_요금;
import java.util.*;
public class 합승_택시_요금 {
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
