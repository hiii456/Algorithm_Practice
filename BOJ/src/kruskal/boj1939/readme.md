## BOJ - ์ค๋์ ํ 
- Gold 4 
- kruskal
๐[์ค๋์ ํ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1939)



## ํ์ด

์ด ๋ฌธ์ ๋ ์ต์ ์ ์ฅ ๊ฑฐ๋ฆฌ์ ๋ฐ๋์ ์ต๋ ์ ์ฅ ๊ฑฐ๋ฆฌ์ ๊ฐ๋์ ์ด์ฉํด ๋ฌธ์ ๋ฅผ ํ์๋ค.
๋ฐ๋ผ์ ํฌ๋ฃจ์ค์นผ ์๊ณ ๋ฆฌ์ฆ์ ์ฌ์ฉํ๋, ๊ธฐ์กด์ ๋ฎ์ ๊ฐ์ค์น๋ถํฐ ํธ๋ฆฌ๋ฅผ ์ฐ๊ฒฐ์์ผฐ๋ค๋ฉด, ๋ฐ๋๋ก ๋์ ๊ฐ์ค์น๋ถํฐ ์ฐ๊ฒฐ์์ผฐ๋ค.

๋ ์ ์ ๋ง ์ด์ผ๋ฉด ๋๋๊น ๋ค์ต์คํธ๋ผ ์๊ณ ๋ฆฌ์ฆ์ ์ฌ์ฉํด๋ ๋์ง ์์๊น ์๊ฐํ์ง๋ง
์ด ๋ฌธ์ ๋ ๋ ์ฌ ์ฌ์ด์ ๋ค๋ฆฌ๋ฅผ ์ง๋๊ฐ ์ ์๋ ์ฆ๋ ์ต๋๊ฐ์ ๊ตฌํ๋ ๊ฒ์ด๋ฏ๋ก ํฌ๋ฃจ์ค์นผ์ ์ฌ์ฉํ๊ฒ ๋์๋ค.

ํฌ๋ฃจ์ค์นผ ์๊ณ ๋ฆฌ์ฆ์์ ๋์ ๊ฐ์ค์น๋ถํฐ ์ฐ๊ฒฐํ๋ ๊ฒ๋ง ๋ค๋ฅด๊ณ  
์ฐ์ ์์ํ์์ ์์ฐจ์ ์ผ๋ก ๋ ์ฌ์ ์ฐ๊ฒฐ์ํค๊ณ , ๋ง์ฝ ๊ณต์ฅ์ด ์์นํด์๋ ๋ ์ฌ์ด ์ฐ๊ฒฐ๋์ด ์๋ค๋ฉด ํด๋น ๊ฐ์ ์ ๊ฐ์ค์น๋ฅผ ๋ฐํํ์๋ค.

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


## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1939_G4_์ค๋์ ํ {
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

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|49032KB	|416ms|