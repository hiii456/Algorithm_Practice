## BOJ - μμ μμ­ 
- Silver 1 
- bfs
π[μμ μμ­ λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/2468)



## νμ΄

μ‘°κ±΄μ νμΈνκ³  bfs νμμ νλ λ¬Έμ μλ€. μ²μμ λ΅μ΄ νλ Έλ€κ³  λμλλ° λΉκ° μμ μ€μ§ μλ κ²½μ°λ κ³ λ €ν΄μ€μΌνλ λΆλΆμ λμ³
λμ΄λ₯Ό 0~max (maxλ νμ¬ λ°°μ΄ μ€ κ°μ₯ λμ κ°)μμ bfsνμμ ν΄μ£Όμλ€.

## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class BOJ_2468_S1_μμ μμ­ {
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
~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|53252KB	|264ms|