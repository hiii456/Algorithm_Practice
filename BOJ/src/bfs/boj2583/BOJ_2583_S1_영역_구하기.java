package bfs.boj2583;

import java.io.*;
import java.util.*;

public class BOJ_2583_S1_영역_구하기 {
	static int M,N,K,answer;
	static int[][] arr;
	static boolean[][] visited;
	static List<Integer> area = new LinkedList<>();
	static int[] dr = {1,-1,0,0};
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			// 입력받은 직사각형의 좌표를 통해 배열에 직사각형의 위치를 표시한다.
			checkSquare(x1,y1,x2,y2);
		}
		
		int idx = 1;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==0 && !visited[i][j]) {
					answer++;
					bfs(i,j,idx);
					idx++;
				}
			}
		}
		Collections.sort(area);
		
		System.out.println(answer);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<area.size(); i++) {
			sb.append(area.get(i) + " ");
		}
		System.out.println(sb.toString());

	}
	private static void bfs(int r, int c,int idx) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r,c));
		visited[r][c] = true;
		arr[r][c] = idx;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr<0 || nc<0 || nr>=M || nc>=N)	continue;
				if(visited[nr][nc] || arr[nr][nc]==-1)	continue;
				
				visited[nr][nc] = true;
				arr[nr][nc] = idx;
				queue.add(new Node(nr,nc));
			}
			
		}
		
		calcArea(idx);
		
	}
	private static void calcArea(int idx) {
		int cnt = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]==idx) {
					cnt++;
				}
			}
		}
		area.add(cnt);
		
	}
	private static void checkSquare(int x1, int y1, int x2, int y2) {
		for(int i=y1; i<y2; i++) {
			for(int j=x1; j<x2; j++) {
				arr[i][j] = -1;
			}
		}
		
	}

}
