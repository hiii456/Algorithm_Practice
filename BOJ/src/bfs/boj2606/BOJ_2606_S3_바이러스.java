package bfs.boj2606;

import java.io.*;
import java.util.*;

public class BOJ_2606_S3_바이러스 {
	static int[][] arr;
	static boolean[] visited;
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int computer = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		arr = new int[computer+1][computer+1];
		visited = new boolean[computer+1];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		bfs(1);
		System.out.println(cnt);
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int i=2; i<arr.length; i++) {
				if(arr[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
					cnt++;
				}
			}
		}
		
	}

}
