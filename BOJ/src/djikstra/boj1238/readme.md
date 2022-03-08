## BOJ - 파티 
- Gold 3 
- djikstra
🔗[파티 문제 바로가기](https://www.acmicpc.net/problem/1238)



## 풀이

이 문제는 시작지점이 x인 경우의 최단거리와 끝지점이 x인 경우 최단거리를 구해주어야 했다.
따라서 특정지점으로부터 최단거리의 값을 가지는 배열인 dist가 2개가 필요했다.
그러나 다익스트라 알고리즘의 경우 특정 시작점을 두고 탐색을 시작하기 때문에 끝지점이 2인 경우를 찾기 위해서
양방향의 값을 저장해준다. (처음에는 왕복이니까 최단거리*2를 해주면 되지 않을까 했으나 다시 집으로 돌아가는 경우,
왔던 길로 가는 것보다 다른 길로 가는것이 더 빠를 수 있다는 점을 유의하지 못했다.)

~~~java
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
~~~

그리고 특정 지점을 x로 설정하고 각각 해당하는 가중치 정보가 담긴 리스트를 통해 
시작점이 2인 경우의 최단거리와 끝점이 2인 경우의 최단거리를 구해주었다.

~~~java
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
~~~


## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|17112KB	|172ms|