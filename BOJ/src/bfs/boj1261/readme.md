## BOJ 1261 ìê³ ì¤í 
- Bfs 
- ð¥ Gold4
- ð[ìê³ ì¤í ë¬¸ì  ë°ë¡ê°ê¸°](https://www.acmicpc.net/problem/1261)



## íì´

ì´ ë¬¸ì ë ìµë¨ ê²½ë¡ë¥¼ ì°¾ë ë¬¸ì ì íê³¼ ë¹ì·íê¸° ëë¬¸ì bfsë¥¼ íìë¤. 
ë¤ìµì¤í¸ë¼ë¡ë íì ìë¤ê³  í¸ì§ë§ ê°ì¤ì¹ê° ìê¸° ëë¬¸ì bfsë¡ íì´ë ë ê² ê°ë¤.

ìµë¨ ê²½ë¡ë¥¼ ë¬´ìì  êµ¬íë ê²ì´ ìë, ë²½ì ë¶ìë ìµì íìë¥¼ êµ¬í´ì¼ íê¸° ëë¬¸ì ì°ì ììíë¥¼ ì¬ì©íì¬ ë¬¸ì ë¥¼ íìê³ , ëë¨¸ì§ë ì¼ë° bfsì ë¹ì·íê² íìë¤.

## ìì¤ì½ë

~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261_G4_ìê³ ì¤í {
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
				// ë²ì ì²´í¬ 
				if(nr>0 && nc>0 && nr<=N && nc<=M) {
					
					if(visited[nr][nc])	continue;
					// ë²½ì´ ìë ê²½ì° ë²½ì ë¶ìì¼ ì´ëì´ ê°ë¥íê¸° ëë¬¸ì count+1
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

~~~

## ê²°ê³¼ 

| ë©ëª¨ë¦¬  | ìê° |
|----|----|
| 12320kb| 108ms|


