package dijkstra.boj1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1916_G5_최소비용_구하기 {
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node(int end,int cost) {
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	static List<Node>[] list;
	static int[] dist;
	static int N,M,S,E;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N+1];
		dist = new int[N+1];
		
		Arrays.fill(dist,100_000_000);
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end,cost));
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		dijkstra();
		
		System.out.println(dist[E]);

	}
	private static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		pq.add(new Node(S,0));
		dist[S] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;
			
			if(visited[cur])	continue;
			visited[cur] = true;
			
			for (Node node : list[cur]) {
				if(dist[node.end] > dist[cur] + node.cost) {
					dist[node.end] = dist[cur] + node.cost;
					pq.add(new Node(node.end,dist[node.end]));
				}
			}
		}
		
	}

}
