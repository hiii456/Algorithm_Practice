## BOJ - Puyo Puyo
- Gold 4 
- bfs
🔗[Puyo Puyo 문제 바로가기](https://www.acmicpc.net/problem/11559)



## 풀이

이 문제는 연쇄가 몇 번 연속으로 일어날지 구하는 문제이므로 먼저 연쇄작용이 발생할때까지 반복문을 돌려주었다. 
필드 중 뿌요를 나타내는 경우 bfs탐색을 수행해주었다.

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
			
			// 연쇄작용이 일어나지 않는다면 break 
			if(!bomb) {
				break;
			}
			
			isDown();
			answer++;
			
		}
~~~

큐를 이용하여 탐색을 진행하였고, Node class를 생성하여 방문하지 않았고 처음 탐색 위치의 뿌요와 색깔이 같은 경우 Node를 큐에 담으며 너비탐색을 진행하였다.  

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

그리고 같은 색상의 뿌요가 4개 이상이 상하좌우로 있는 경우에 연쇄작용이 발생하므로 앞선 bfs 과정에서같은 색상의 뿌요 위치를 list에 담아주었다.
그리고 이 리스트의 담긴 위치의 뿌요를 '.'로 바꾸어주는 작업을 진행한다.

~~~java
		if(pop.size()>=4) {
			bomb = true;
			for(int i=0; i<pop.size(); i++) {
				// 연쇄작용이 일어난 자리에 '.'로 바꿔준다.
				Node node = pop.get(i);
				map[node.r][node.c] = '.';
			}
		}
~~~

연쇄작용이 일어났을 경우 뿌요를 중력에 의해 내려주는 작업을 진행한다.
현재 위치가 빈 공간일 경우 같은 열에 위치한 가장 가까운 뿌요의 색상을 저장해준다.

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

## 소스코드
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
		// 연쇄작용이 일어나지 않을때까지 반복문 
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
			
			// 연쇄작용이 일어나지 않는다면 break 
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
				// 연쇄작용이 일어난 자리에 '.'로 바꿔준다.
				Node node = pop.get(i);
				map[node.r][node.c] = '.';
			}
		}
	
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11544KB	|80ms|