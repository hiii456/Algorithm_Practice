## BOJ 1261 알고스팟 
- Dijkstra , bfs
- 🥇 Gold4
- 🔗[알고스팟 문제 바로가기](https://www.acmicpc.net/problem/1261)



## 풀이

앞서 bfs로 풀었는데 시간이나 메모리 측면에서 얼마나 차이가 나는지 궁금해서 풀어보았다. 
bfs만 사용해서 풀었을때와 다른 점은 해당위치까지의 최단 경로값을 저장하는 dist 배열을 사용한다는 것이다.

알고스팟처럼 시작점과 도착점이 주어져 있는 경우 가중치 값에 따라 최단경로를 구할 때 효율적이라 할 수 있다.

큰 틀은 bfs를 사용해서 그런지 차이는 나지 않았다..

## 소스코드

~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261_G4_알고스팟 {
	static int M,N;
	static int[][] arr;
	static int[][] dist;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int cost;
		public Node(int r,int c,int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		dist = new int[N+1][M+1];
		
		// 최단 거리 값을 저장하는 dist 배열을 무한대값으로 초기화 
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		int answer = bfs(1,1);
		
		System.out.println(answer);

		
	}
	private static int bfs(int r, int c) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(r,c,0));
		dist[r][c] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if(curNode.r == N && curNode.c == M) {
				return curNode.cost;
			}
			
			for(int d=0; d<4; d++) {
				int nr = curNode.r + dr[d];
				int nc = curNode.c + dc[d];
				// 범위 체크 
				if(nr>0 && nc>0 && nr<=N && nc<=M) {
					
					if(dist[nr][nc] > dist[curNode.r][curNode.c] + arr[nr][nc]) {
						dist[nr][nc] = dist[curNode.r][curNode.c] + arr[nr][nc];
						pq.add(new Node(nr,nc,dist[nr][nc]));
					}
					
				}
			}
		}
		
		return 0;
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 12336kb| 108ms|