package dfs.boj2573;

import java.io.*;
import java.util.*;

public class BOJ_2573_G4_빙산_2 {
	static int n,m;
	static boolean isBreak = false;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Node{
		int r;
		int c;
		public Node(int r,int c){
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		while(true) {
			// 방문 체크 초기화 
			visited = new boolean[n][m];
			int island = 0;
			// 분리된 섬의 개수를 센다.
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j]>0 && !visited[i][j]) {
						dfs(i,j);
						island++;
					}
				}
			}

			if(island>1) {
				break;
			}else if(island == 0) {
				ans = 0;
				break;
			}
			
			melt();
			ans++;
			
		}
		
		System.out.println(ans);

	}
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nc<0 || nr>=n || nc>=m)	continue;
			
			if(arr[nr][nc]>0 && !visited[nr][nc]) {
				dfs(nr,nc);
			}
		}
		
	}
	public static void melt() {
		Queue<Node> queue = new LinkedList<>();
		
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] != 0) {
					queue.add(new Node(i,j));
					visited[i][j] = true;
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int cnt = 0;
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0 || nc<0 || nr>=n || nc>=m)	continue;
				if(arr[nr][nc] == 0 && !visited[nr][nc]) {
					cnt++;
				}
			}

			if(arr[cur.r][cur.c] - cnt < 0) {
				arr[cur.r][cur.c] = 0;
			}else {
				arr[cur.r][cur.c] -= cnt;
			}
		}
	}

}
