package bfs.boj1697;

import java.io.*;
import java.util.*;

public class BOJ_1697_S1_숨바꼭질 {
	static int n,k,ans;
	static int[] visited;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 숨바꼭질을 할 수 있는 범위는 0~100000 
		visited = new int[100001];
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
        if(n==k){
            System.out.println(0);
        }else{
            bfs(n);
		    System.out.println(visited[k]);
        }
		

	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(cur);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			// 0이 아닌경우 최솟값을 찾은것이므로 break 
			if(visited[k]!=0)	break;
			
			if(x-1>=0 && visited[x-1]==0) {
				queue.add(x-1);
				visited[x-1] = visited[x]+1;
			}
			
			if(x+1<=100000 && visited[x+1]==0) {
				queue.add(x+1);
				visited[x+1] = visited[x]+1;
			}
			
			if(x*2<100001 && visited[x*2]==0) {
				queue.add(x*2);
				visited[x*2] = visited[x]+1;
			}
		}
		
	}

}
