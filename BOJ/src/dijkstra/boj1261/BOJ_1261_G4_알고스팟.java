package dijkstra.boj1261;

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
