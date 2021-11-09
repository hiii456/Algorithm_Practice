package bfs.boj12851;

import java.io.*;
import java.util.*;

public class BOJ_12851_G5_숨바꼭질2 {
	static int N,K,count=0;
	static int minTime = Integer.MAX_VALUE;
	static int[] visited = new int[100001];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		if(N>=K) {
			System.out.println(N-K);
			System.out.println(1);
		}else {
			bfs(N,K);
			System.out.println(minTime);
			System.out.println(count);
		}

	}
	private static void bfs(int n,int k) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = 1;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			if(minTime<visited[now])	return;
			
			for(int i=0; i<3; i++) {
				int next = 0;
				if(i==0) {
					next = now-1;
				}else if(i==1) {
					next = now+1;
				}else if(i==2) {
					next = now*2;
				}
				
				
				if(next<0 || next>100000) 	continue;
				
				if(next==K) {
					minTime = visited[now];
					count++;
				}
				// 첫 방문이거나 이전에 방문한 곳이여도 같은 시간에 방문했다면 
				if(visited[next]==0 || visited[next] == visited[now]+1) {
					queue.add(next);
					visited[next] = visited[now]+1;
				}
			}
			
		}
		
	}

}
