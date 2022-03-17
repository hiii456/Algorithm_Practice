## BOJ - 서강그라운드 
- Gold 4 
- Floyd-Warshall 
🔗[서강 그라운드 문제 바로가기](https://www.acmicpc.net/problem/14938)



## 풀이

저번에 이 문제를 다익스트라로 풀어본 적이 있는데, 예은이 낙하한 지역이 어디인지 모르므로 
낙하한 지역의 수만큼 다익스트라 메소드를 실행하기보다는 한번에 모든 정점에서의 최소거리를 구하는 플로이드와샬 알고리즘을 이용해 풀기로 결정하였다.


## 소스코드
~~~java
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
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|12148KB	|104ms|