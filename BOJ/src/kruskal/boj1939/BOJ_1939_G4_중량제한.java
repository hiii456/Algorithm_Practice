package kruskal.boj1939;

import java.io.*;
import java.util.*;

public class BOJ_1939_G4_중량제한 {
	static int n,m;
	static int[] parents;
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from,int to,int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.weight - this.weight;
		}
	}
	static int find(int a) {
		if(parents[a] == a){
			return a;
		}
		
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a,int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB)	return false;
		
		parents[rootB] = rootA;
		
		return true;
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			pq.add(new Edge(from,to,weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int islandA = Integer.parseInt(st.nextToken());
		int islandB = Integer.parseInt(st.nextToken());
		
		int result = 0;

		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			union(e.from,e.to);
			if(find(islandA) == find(islandB)) {
				result = e.weight;
				break;
			}
		}
		
		System.out.println(result);
		

	}

}
