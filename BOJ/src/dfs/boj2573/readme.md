## BOJ - ๋น์ฐ 
- Gold 4 
- dfs 
๐[๋น์ฐ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/2573)



## ํ์ด

์ด ๋ฌธ์ ์์ ๊ณ ๋ คํด์ฃผ์ด์ผํ  ๋ถ๋ถ์ ๋น์ฐ์ด ๋น์๋ ํ๊บผ๋ฒ์ ๋น๊ธฐ ๋๋ฌธ์, ์์ฐจ์ ์ผ๋ก ๋น์ด๋ฉด 
๋ค๋ฐฉํฅ์ 0์ด ์ธ์ ํ ๊ฐฏ์๊ฐ ๋ฌ๋ผ์ง์ ์๋ค๋ ์ ์ด ์๋ค. 
๋ฐ๋ผ์ ๋๋ 2๊ฐ์ ๋ฐฐ์ด์ ์ฌ์ฉํ์ฌ ๋ฌธ์ ๋ฅผ ํ์ด์คฌ์ผ๋ ์ด์คfor๋ฌธ์ ๋ง์ด ์ด๊ฒ ๊ฐ์ ๋ค๋ฅธ ๊ฐ์  ๋ฐฉ๋ฒ๋ ๊ณ ๋ คํด๋ณด์์ผํ  ๊ฒ ๊ฐ๋ค.

๋ํ ๋นํ๊ฐ 2๊ฐ๋ก ๋๋์ด์ง์ง์์๋ 0์ด ์ถ๋ ฅ๋๋ ๊ฒ์ ๊ณ ๋ คํด์ฃผ์ง ๋ชปํ์ฌ 61%์์ ์๊ฐ์ด๊ณผ๊ฐ ๋ฐ์ํ์๋ค.


## ์์ค์ฝ๋
~~~java

import java.io.*;
import java.util.*;

public class BOJ_2573_G4_๋น์ฐ {
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
			// ๋ฐฉ๋ฌธ ์ฒดํฌ ์ด๊ธฐํ 
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
			
			// 2์ค ๋ฐฐ์ด์ ๊น์ ๋ณต์ฌ 
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
~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|45304KB	|456ms|


## BFS๋ฅผ ์ถ๊ฐํด์ ๋ค์ ํ์ด๋ณธ ๋ฌธ์  (2022/3/8)

์ด์ค for๋ฌธ์ด ๋๋ฌด ๋ง์์ ์๊ฐ์ ์ค์ด๊ธฐ ์ํด bfs, dfs๋ฅผ ๋ชจ๋ ์ฌ์ฉํ์ฌ ๋ฌธ์ ๋ฅผ ํ์ด๋ณด์๋ค.
์ฝ๋๋ ๋ ๊น๋ํด์ก๋๋ฐ ์๊ฐ๊ณผ ๋ฉ๋ชจ๋ฆฌ๊ฐ ๋์ด๋ฌ๋ค..ใ

## ์์ค์ฝ๋
~~~java
package dfs.boj2573;

import java.io.*;
import java.util.*;

public class BOJ_2573_G4_๋น์ฐ_2 {
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
			// ๋ฐฉ๋ฌธ ์ฒดํฌ ์ด๊ธฐํ 
			visited = new boolean[n][m];
			int island = 0;
			// ๋ถ๋ฆฌ๋ ์ฌ์ ๊ฐ์๋ฅผ ์ผ๋ค.
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
~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|128812KB|508ms|

