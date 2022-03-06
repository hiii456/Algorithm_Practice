package bfs.boj2468;

import java.io.*;
import java.util.*;

public class BOJ_2468_S1_안전영역 {
	static int n,cnt,ans = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	static int max = Integer.MIN_VALUE;
	static class Node{
		int r;
		int c;
		public Node(int r,int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(max<arr[i][j])	max = arr[i][j];
			}
		}
		
		for(int i=0; i<max; i++) {
			visited = new boolean[n][n];
			cnt = 0;
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					if(!visited[r][c] && arr[r][c]>i) {
						bfs(r,c,i);
					}
				}
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		
		
	}
	public static void bfs(int r,int c,int height) {
		Queue<Node> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.add(new Node(r,c));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0 || nc<0 || nr>=n || nc>=n)	continue;
				
				if(visited[nr][nc] || arr[nr][nc]<=height)	continue;
				
				visited[nr][nc] = true;
				queue.add(new Node(nr,nc));
			}
		}
		
		cnt++;
		
	}

}
