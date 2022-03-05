## BOJ - 섬의 개수 
- Silver 2 
- bfs
🔗[섬의 개수 문제 바로가기](https://www.acmicpc.net/problem/4963)



## 풀이

이 문제는 8방탐색을 이용한 기초적인 bfs 문제였다!

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_4963_S2_섬의_개수 {
	static int w,h,ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
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
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			ans = 0;
			
			if(w==0 && h==0)	break;
			
			arr = new int[h][w];
			visited = new boolean[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(arr[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
					}
				}
			}
			
			System.out.println(ans);
			
		}

	}
	public static void bfs(int r,int c) {
		Queue<Node> queue = new LinkedList<>();
		visited[r][c] = true;
		queue.add(new Node(r,c));
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			for(int d=0; d<8; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=h || nc>=w || visited[nr][nc])	continue;
				
				if(arr[nr][nc]==1) {
					visited[nr][nc] = true;
					queue.add(new Node(nr,nc));
				}
			}
			
		}
		
		ans++;
		
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|13504KB	|124ms|