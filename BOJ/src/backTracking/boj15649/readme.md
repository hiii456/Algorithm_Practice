## BOJ 15649 N과 M 
- BackTracking 
- 🥈 Silver3 
- 🔗[N과 M 문제 바로가기](https://www.acmicpc.net/problem/15649)



## 풀이

기본 순열문제 이므로 풀이는 따로 없음~ 


## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 84572kb| 1496ms|