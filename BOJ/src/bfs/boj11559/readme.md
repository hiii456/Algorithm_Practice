## BOJ - Puyo Puyo
- Gold 4 
- bfs
π[Puyo Puyo λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/11559)



## νμ΄

μ΄ λ¬Έμ λ μ°μκ° λͺ λ² μ°μμΌλ‘ μΌμ΄λ μ§ κ΅¬νλ λ¬Έμ μ΄λ―λ‘ λ¨Όμ  μ°μμμ©μ΄ λ°μν λκΉμ§ λ°λ³΅λ¬Έμ λλ €μ£Όμλ€. 
νλ μ€ λΏμλ₯Ό λνλ΄λ κ²½μ° bfsνμμ μνν΄μ£Όμλ€.

~~~java
	while(true) {
			bomb = false;
			visited = new boolean[12][6];
			for(int i=11; i>=0; i--) {
				for(int j=0; j<5; j++) {
					if(!visited[i][j] && map[i][j]!='.') {
						bfs(i,j);
					}
				}
			}
			
			// μ°μμμ©μ΄ μΌμ΄λμ§ μλλ€λ©΄ break 
			if(!bomb) {
				break;
			}
			
			isDown();
			answer++;
			
		}
~~~

νλ₯Ό μ΄μ©νμ¬ νμμ μ§ννμκ³ , Node classλ₯Ό μμ±νμ¬ λ°©λ¬Ένμ§ μμκ³  μ²μ νμ μμΉμ λΏμμ μκΉμ΄ κ°μ κ²½μ° Nodeλ₯Ό νμ λ΄μΌλ©° λλΉνμμ μ§ννμλ€.  

~~~Java
		Queue<Node> queue = new LinkedList<>();
		List<Node> pop = new ArrayList<>();
		queue.add(new Node(r,c));
		visited[r][c] = true;

		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			pop.add(curNode);
			
			for(int d=0; d<4; d++) {
				int nr = curNode.r + dr[d];
				int nc = curNode.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=12 || nc>=6 || visited[nr][nc])	continue;
				
				if(map[r][c] == map[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Node(nr,nc));
				}
				
			}
		}
~~~

κ·Έλ¦¬κ³  κ°μ μμμ λΏμκ° 4κ° μ΄μμ΄ μνμ’μ°λ‘ μλ κ²½μ°μ μ°μμμ©μ΄ λ°μνλ―λ‘ μμ  bfs κ³Όμ μμκ°μ μμμ λΏμ μμΉλ₯Ό listμ λ΄μμ£Όμλ€.
κ·Έλ¦¬κ³  μ΄ λ¦¬μ€νΈμ λ΄κΈ΄ μμΉμ λΏμλ₯Ό '.'λ‘ λ°κΎΈμ΄μ£Όλ μμμ μ§ννλ€.

~~~java
		if(pop.size()>=4) {
			bomb = true;
			for(int i=0; i<pop.size(); i++) {
				// μ°μμμ©μ΄ μΌμ΄λ μλ¦¬μ '.'λ‘ λ°κΏμ€λ€.
				Node node = pop.get(i);
				map[node.r][node.c] = '.';
			}
		}
~~~

μ°μμμ©μ΄ μΌμ΄λ¬μ κ²½μ° λΏμλ₯Ό μ€λ ₯μ μν΄ λ΄λ €μ£Όλ μμμ μ§ννλ€.
νμ¬ μμΉκ° λΉ κ³΅κ°μΌ κ²½μ° κ°μ μ΄μ μμΉν κ°μ₯ κ°κΉμ΄ λΏμμ μμμ μ μ₯ν΄μ€λ€.

~~~java
	private static void isDown() {
		for(int i=0; i<6; i++) {
			for(int j=11; j>0; j--) {
				if(map[j][i]=='.') {
					for(int k=j-1; k>=0; k--) {
						if(map[k][i]!='.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}
		
	}
~~~

## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class BOJ_11559_Puyo_Puyo {
	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static boolean bomb;
	static int answer = 0;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
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
		for(int i=0; i<12; i++) {
			String str = br.readLine();
			for(int j=0; j<6; j++) {				
				map[i][j] = str.charAt(j);
			}	
		}
		// μ°μμμ©μ΄ μΌμ΄λμ§ μμλκΉμ§ λ°λ³΅λ¬Έ 
		while(true) {
			bomb = false;
			visited = new boolean[12][6];
			for(int i=11; i>=0; i--) {
				for(int j=0; j<5; j++) {
					if(!visited[i][j] && map[i][j]!='.') {
						bfs(i,j);
					}
				}
			}
			
			// μ°μμμ©μ΄ μΌμ΄λμ§ μλλ€λ©΄ break 
			if(!bomb) {
				break;
			}
			
			isDown();
			answer++;
			
		}
		

		System.out.println(answer);

	}
	private static void isDown() {
		for(int i=0; i<6; i++) {
			for(int j=11; j>0; j--) {
				if(map[j][i]=='.') {
					for(int k=j-1; k>=0; k--) {
						if(map[k][i]!='.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							break;
						}
					}
				}
			}
		}
		
	}
	private static void bfs(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		List<Node> pop = new ArrayList<>();
		queue.add(new Node(r,c));
		visited[r][c] = true;

		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			pop.add(curNode);
			
			for(int d=0; d<4; d++) {
				int nr = curNode.r + dr[d];
				int nc = curNode.c + dc[d];
				
				if(nr<0 || nc<0 || nr>=12 || nc>=6 || visited[nr][nc])	continue;
				
				if(map[r][c] == map[nr][nc]) {
					visited[nr][nc] = true;
					queue.add(new Node(nr,nc));
				}
				
			}
		}
		
		if(pop.size()>=4) {
			bomb = true;
			for(int i=0; i<pop.size(); i++) {
				// μ°μμμ©μ΄ μΌμ΄λ μλ¦¬μ '.'λ‘ λ°κΏμ€λ€.
				Node node = pop.get(i);
				map[node.r][node.c] = '.';
			}
		}
	
	}

}
~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|11544KB	|80ms|