## BOJ - ํํฐ 
- Gold 3 
- djikstra
๐[ํํฐ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1238)



## ํ์ด

์ด ๋ฌธ์ ๋ ์์์ง์ ์ด x์ธ ๊ฒฝ์ฐ์ ์ต๋จ๊ฑฐ๋ฆฌ์ ๋์ง์ ์ด x์ธ ๊ฒฝ์ฐ ์ต๋จ๊ฑฐ๋ฆฌ๋ฅผ ๊ตฌํด์ฃผ์ด์ผ ํ๋ค.
๋ฐ๋ผ์ ํน์ ์ง์ ์ผ๋ก๋ถํฐ ์ต๋จ๊ฑฐ๋ฆฌ์ ๊ฐ์ ๊ฐ์ง๋ ๋ฐฐ์ด์ธ dist๊ฐ 2๊ฐ๊ฐ ํ์ํ๋ค.
๊ทธ๋ฌ๋ ๋ค์ต์คํธ๋ผ ์๊ณ ๋ฆฌ์ฆ์ ๊ฒฝ์ฐ ํน์  ์์์ ์ ๋๊ณ  ํ์์ ์์ํ๊ธฐ ๋๋ฌธ์ ๋์ง์ ์ด 2์ธ ๊ฒฝ์ฐ๋ฅผ ์ฐพ๊ธฐ ์ํด์
์๋ฐฉํฅ์ ๊ฐ์ ์ ์ฅํด์ค๋ค. (์ฒ์์๋ ์๋ณต์ด๋๊น ์ต๋จ๊ฑฐ๋ฆฌ*2๋ฅผ ํด์ฃผ๋ฉด ๋์ง ์์๊น ํ์ผ๋ ๋ค์ ์ง์ผ๋ก ๋์๊ฐ๋ ๊ฒฝ์ฐ,
์๋ ๊ธธ๋ก ๊ฐ๋ ๊ฒ๋ณด๋ค ๋ค๋ฅธ ๊ธธ๋ก ๊ฐ๋๊ฒ์ด ๋ ๋น ๋ฅผ ์ ์๋ค๋ ์ ์ ์ ์ํ์ง ๋ชปํ๋ค.)

~~~java
		list = new ArrayList[n+1];
		reverseList = new ArrayList[n+1];

		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
			reverseList[i] = new ArrayList<>();
		}
		// ๊ทธ๋ํ ์ ๋ณด ์ด๊ธฐํ 
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
			reverseList[end].add(new Node(start,weight));
		}
~~~

๊ทธ๋ฆฌ๊ณ  ํน์  ์ง์ ์ x๋ก ์ค์ ํ๊ณ  ๊ฐ๊ฐ ํด๋นํ๋ ๊ฐ์ค์น ์ ๋ณด๊ฐ ๋ด๊ธด ๋ฆฌ์คํธ๋ฅผ ํตํด 
์์์ ์ด 2์ธ ๊ฒฝ์ฐ์ ์ต๋จ๊ฑฐ๋ฆฌ์ ๋์ ์ด 2์ธ ๊ฒฝ์ฐ์ ์ต๋จ๊ฑฐ๋ฆฌ๋ฅผ ๊ตฌํด์ฃผ์๋ค.

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


## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1238_G3_ํํฐ {
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
		// ๊ทธ๋ํ ์ ๋ณด ์ด๊ธฐํ 
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

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|17112KB	|172ms|