## BOJ - 테트로미노 
- Gold 5 
- bruteforce 
🔗[테트로미노 문제 바로가기](https://www.acmicpc.net/problem/14500)



## 풀이

이 문제는 완전탐색을 이용하는 것으로, 테트로미노가 4칸이 되었을때 칸의 총합 중 가장 큰 수를 구하면된다.
따라서 dfs를 통해 4칸의 테트로미노의 칸의 총합 중 최댓값을 구하였다.
그리고 'ㅗ'인 경우 dfs탐색을 통해서 구할 수 없으므로 이 부분은 따로 구해주어 총 최대값을 구하였다.


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_14500_G5_테트로미노 {
	static int n,m;
	static int[][] arr;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max = Integer.MIN_VALUE;
	static boolean[][] visited;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dfs(i,j,0,0);
				exception(i,j);
			}
		}

		System.out.println(max);

	}
	// ㅗ 의 경우 dfs탐색으로 찾을 수 없으므로 칸의 값을 따로 구해준다.
	private static void exception(int r, int c) {
		// ㅗ 
		if(c-1>=0 && r-1>=0 && c+1<m ) {
			max = Math.max(max, arr[r][c-1] + arr[r][c] + arr[r][c+1] + arr[r-1][c]);
		}
		// ㅜ 
		if(c-1>=0 && r+1<n && c+1<m ) {
			max = Math.max(max, arr[r][c-1] + arr[r][c] + arr[r][c+1] + arr[r+1][c]);
		}
		// ㅏ
		if(r-1>=0 && c+1<m && r+1<n ) {
			max = Math.max(max, arr[r-1][c] + arr[r][c] + arr[r+1][c] + arr[r][c+1]);
		}
		// ㅓ 
		if(r-1>=0 && c-1>=0 && r+1<n ) {
			max = Math.max(max, arr[r-1][c] + arr[r][c] + arr[r+1][c] + arr[r][c-1]);
		}
		
		
	}
	// dfs탐색을 통해 이동갯수가 4일때의 테트로미노 칸에 놓인 합의 최댓값을 비교한다.
	private static void dfs(int r, int c, int cnt, int sum) {
		// 기저조건 : 테트로미노 칸 수가 4일때 
		if(cnt == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nc<0 || nr>=n || nc>=m) continue;
			if(visited[nr][nc])	continue;
			
			visited[nr][nc] = true;
			dfs(nr,nc,cnt+1,sum+arr[nr][nc]);
			visited[nr][nc] = false;
		}
		
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|32116KB	|892ms|