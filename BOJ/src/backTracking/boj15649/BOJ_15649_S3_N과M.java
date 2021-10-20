package backTracking.boj15649;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649_S3_N과M {
	static int N,M;
	static int[] tgt;
	static boolean[] visited;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tgt = new int[M];
		visited = new boolean[N];
		
		backTracking(0);
	}
	private static void backTracking(int tgtIdx) {
		if(tgtIdx==M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(tgt[i]+ " ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visited[i])	continue;
			
			tgt[tgtIdx] = i+1;
			visited[i] = true;
			backTracking(tgtIdx+1);	
			visited[i] = false;
		}
		
	}

}
