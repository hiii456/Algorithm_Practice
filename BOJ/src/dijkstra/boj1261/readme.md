## BOJ 1261 μκ³ μ€ν 
- Dijkstra , bfs
- π₯ Gold4
- π[μκ³ μ€ν λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/1261)



## νμ΄

μμ bfsλ‘ νμλλ° μκ°μ΄λ λ©λͺ¨λ¦¬ μΈ‘λ©΄μμ μΌλ§λ μ°¨μ΄κ° λλμ§ κΆκΈν΄μ νμ΄λ³΄μλ€. 
bfsλ§ μ¬μ©ν΄μ νμμλμ λ€λ₯Έ μ μ ν΄λΉμμΉκΉμ§μ μ΅λ¨ κ²½λ‘κ°μ μ μ₯νλ dist λ°°μ΄μ μ¬μ©νλ€λ κ²μ΄λ€.

μκ³ μ€νμ²λΌ μμμ κ³Ό λμ°©μ μ΄ μ£Όμ΄μ Έ μλ κ²½μ° κ°μ€μΉ κ°μ λ°λΌ μ΅λ¨κ²½λ‘λ₯Ό κ΅¬ν  λ ν¨μ¨μ μ΄λΌ ν  μ μλ€.

ν° νμ bfsλ₯Ό μ¬μ©ν΄μ κ·Έλ°μ§ μ°¨μ΄λ λμ§ μμλ€..

## μμ€μ½λ

~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261_G4_μκ³ μ€ν {
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
		
		// μ΅λ¨ κ±°λ¦¬ κ°μ μ μ₯νλ dist λ°°μ΄μ λ¬΄νλκ°μΌλ‘ μ΄κΈ°ν 
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
				// λ²μ μ²΄ν¬ 
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

~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
| 12336kb| 108ms|