package dijkstra.boj14938;

import java.io.*;
import java.util.*;

public class BOJ_14938_G4_서강그라운드 {
	static final int INF = 16;
	static int n,m,r;
	static int[][] adjMatrix;
	static int[] item;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		adjMatrix = new int[n+1][n+1];
		item = new int[n+1];

		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j)	continue;
				adjMatrix[i][j] = INF;
			}
		}
		
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			
			adjMatrix[a][b] = l;
			adjMatrix[b][a] = l;
		}

		for(int j=1; j<=n; j++) {
			for(int i=1; i<=n; i++) {
				if(j==i)	continue;
				for(int k=1; k<=n; k++) {
					if(j==k || i==k)	continue;
					if(adjMatrix[i][k]>adjMatrix[i][j] + adjMatrix[j][k]) {
						adjMatrix[i][k] = adjMatrix[i][j] + adjMatrix[j][k];
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			int tmp = 0;
			for(int j=1; j<=n; j++) {
				if(adjMatrix[i][j]<=m)
					tmp += item[j];
			}
			max = Math.max(max, tmp);
		}
		
		System.out.println(max);
		
	}

}
