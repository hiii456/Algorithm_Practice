package bruteforce.boj10819;

import java.io.*;
import java.util.*;

public class BOJ_S2_10819_차이를_최대로 {
	static int n;
	static int[] arr;
	static boolean[] visited;
	static int[] selected;
	static int result = Integer.MIN_VALUE;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		selected = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0);
		System.out.println(result);
	}

	private static void dfs(int cnt) {
		if(n == cnt) {
			int sum = 0;
			for(int i=0; i<n-1; i++) {
				sum += Math.abs(selected[i] - selected[i+1]);
			}
			result = Math.max(result, sum);
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i])	continue;
			visited[i] = true;
			selected[cnt] = arr[i];
			dfs(cnt+1);
			visited[i] = false;
		}
		
	}

}
