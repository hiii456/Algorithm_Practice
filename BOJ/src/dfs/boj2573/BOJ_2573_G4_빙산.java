package dfs.boj2573;

import java.io.*;
import java.util.*;

public class BOJ_2573_G4_빙산 {
	static int n,m;
	static boolean isBreak = false;
	static int[][] arr;
	static int[][] copy;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		copy = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = arr[i][j];
			}
		}
		
		int ans = 0;
		while(true) {
			// 방문 체크 초기화 
			visited = new boolean[n][m];

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(arr[i][j]>0) {
						int cnt = melt(i,j);
						if(arr[i][j]-cnt<0)	copy[i][j] = 0;
						else copy[i][j] = arr[i][j] - cnt;
					}
				}
			}
			
			int island = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(copy[i][j]>0 && !visited[i][j]) {
						dfs(i,j);
						island++;
					}
				}
			}
			
			// 2중 배열의 깊은 복사 
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = copy[i][j];
				}
			}
			
			ans++;
			
			if(island>1) {
				break;
			}else if(island == 0) {
				ans = 0;
				break;
			}
			
		}
		
		System.out.println(ans);

	}
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nc<0 || nr>=n || nc>=m)	continue;
			
			if(copy[nr][nc]>0 && !visited[nr][nc]) {
				dfs(nr,nc);
			}
		}
		
	}
	public static int melt(int r,int c) {
		int cnt = 0;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nc<0 || nr>=n || nc>=m)	continue;
			
			if(arr[nr][nc]==0)	cnt++;
		}
		
		return cnt;
	}

}
