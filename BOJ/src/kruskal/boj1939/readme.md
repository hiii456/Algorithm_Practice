## BOJ - 중량제한 
- Gold 4 
- kruskal
🔗[중량제한 문제 바로가기](https://www.acmicpc.net/problem/1939)



## 풀이

이 문제는 최소 신장 거리의 반대의 최대 신장 거리의 개념을 이용해 문제를 풀었다.
따라서 크루스칼 알고리즘을 사용하되, 기존에 낮은 가중치부터 트리를 연결시켰다면, 반대로 높은 가중치부터 연결시켰다.

두 정점만 이으면 되니까 다익스트라 알고리즘을 사용해도 되지 않을까 생각했지만
이 문제는 두 섬 사이의 다리를 지나갈 수 있는 증량 최댓값을 구하는 것이므로 크루스칼을 사용하게 되었다.

크루스칼 알고리즘에서 높은 가중치부터 연결하는 것만 다르고 
우선순위큐에서 순차적으로 두 섬을 연결시키고, 만약 공장이 위치해있는 두 섬이 연결되어 있다면 해당 간선의 가중치를 반환하였다.

~~~java
		while(!pq.isEmpty()) {
			Edge e = pq.poll();
			union(e.from,e.to);
			if(find(islandA) == find(islandB)) {
				result = e.weight;
				break;
			}
		}
~~~


## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|49032KB	|416ms|