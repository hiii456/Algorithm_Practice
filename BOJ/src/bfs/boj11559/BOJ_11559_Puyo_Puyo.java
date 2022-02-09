package bfs.boj11559;

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
