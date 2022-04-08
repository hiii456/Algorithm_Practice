## BOJ - 차이를 최대로 
- Silver 2 
- bruteforce 
🔗[차이를 최대로 문제 바로가기](https://www.acmicpc.net/problem/10819)



## 풀이

이 문제는 dfs를 사용하여 차이를 최대로 만들 수 있는 모든 경우의 수를 구한 뒤 최댓값을 구하면 답을 구할 수 있었다.
방문체크 배열과 n만큼 길이의 배열을 하나 더 만들어 순열과 비슷한 방식으로 문제를 풀었다.

## 소스코드
~~~java
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
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|12416KB	|100ms|