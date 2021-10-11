package bfs.boj1261;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261_G4_알고스팟 {
	static int M,N;
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int cnt;
		public Node(int r,int c,int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cnt - o.cnt;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		
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
		boolean[][] visited = new boolean[N+1][M+1];
		pq.add(new Node(r,c,0));
		visited[r][c] = true;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			
			if(curNode.r == N && curNode.c == M) {
				return curNode.cnt;
			}
			
			for(int d=0; d<4; d++) {
				int nr = curNode.r + dr[d];
				int nc = curNode.c + dc[d];
				// 범위 체크 
				if(nr>0 && nc>0 && nr<=N && nc<=M) {
					
					if(visited[nr][nc])	continue;
					// 벽이 있는 경우 벽을 부셔야 이동이 가능하기 때문에 count+1
					if(arr[nr][nc]==1) {
						visited[nr][nc] = true;
						pq.add(new Node(nr,nc,curNode.cnt+1));
					}else if(arr[nr][nc]==0) {
						visited[nr][nc] = true;
						pq.add(new Node(nr,nc,curNode.cnt));
					}
					
				}
			}
		}
		
		return 0;
	}

}
