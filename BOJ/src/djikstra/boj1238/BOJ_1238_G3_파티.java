package djikstra.boj1238;

import java.io.*;
import java.util.*;

public class BOJ_1238_G3_파티 {
	static int n,m,x;
	static int[] dist;
	static List<Node>[] list;
	static List<Node>[] reverseList;
	static final int INF = Integer.MAX_VALUE;
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end,int weight) {
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		list = new ArrayList[n+1];
		reverseList = new ArrayList[n+1];

		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		// 그래프 정보 초기화 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
			reverseList[end].add(new Node(start,weight));
		}
		
		int[] dist1 = djikstra(list);
		int[] dist2 = djikstra(reverseList);
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			max = Math.max(max, dist1[i]+dist2[i]);
		}
		
		System.out.println(max);

	}
	private static int[] djikstra(List<Node>[] nodeList) {
		dist = new int[n+1];
		Arrays.fill(dist,INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[n+1];
		pq.add(new Node(x,0));
		dist[x] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.end])	continue;
			visited[cur.end] = true;
			for(Node node : nodeList[cur.end]) {
				if(dist[node.end] > dist[cur.end] + node.weight) {
					dist[node.end] = dist[cur.end] + node.weight;
					pq.add(new Node(node.end,dist[node.end]));
				}
			}
		}
		
		return dist;
		
	}

}
