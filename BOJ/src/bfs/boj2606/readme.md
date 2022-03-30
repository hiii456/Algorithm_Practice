## BOJ - 바이러스 
- Silver 3 
- bfs
🔗[바이러스 문제 바로가기](https://www.acmicpc.net/problem/2606)



## 풀이

이 문제는 2차원 배열을 만들어주어 각각 연결된 컴퓨터를 표시해주고, 
1번 컴퓨터에서 연결된 컴퓨터로 탐색을 하는 bfs 형식으로 문제를 풀었다.

## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11756KB	|76ms|