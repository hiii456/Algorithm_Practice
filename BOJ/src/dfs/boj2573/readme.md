## BOJ - 빙산 
- Gold 4 
- dfs 
🔗[빙산 문제 바로가기](https://www.acmicpc.net/problem/2573)



## 풀이

이 문제에서 고려해주어야할 부분은 빙산이 녹을때 한꺼번에 녹기 때문에, 순차적으로 녹이면 
네방향에 0이 인접한 갯수가 달라질수 있다는 점이 있다. 
따라서 나는 2개의 배열을 사용하여 문제를 풀어줬으나 이중for문을 많이 쓴것 같아 다른 개선 방법도 고려해보아야할 것 같다.

또한 빙하가 2개로 나누어지지않을때 0이 출력되는 것을 고려해주지 못하여 61%에서 시간초과가 발생하였다.


## 소스코드
~~~java

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
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|45304KB	|456ms|


## BFS를 추가해서 다시 풀어본 문제 (2022/3/8)

이중 for문이 너무 많아서 시간을 줄이기 위해 bfs, dfs를 모두 사용하여 문제를 풀어보았다.
코드는 더 깔끔해졌는데 시간과 메모리가 늘어났다..ㅎ

## 소스코드
~~~java
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
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|128812KB|508ms|

