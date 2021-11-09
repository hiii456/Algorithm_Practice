## BOJ 12851 숨바꼭질2 
- Bfs
- 🥇 Gold5
- 🔗[숨바꼭질2 문제 바로가기](https://www.acmicpc.net/problem/12851)



## 풀이

[숨바꼭질](https://www.acmicpc.net/problem/1697) 문제에서 가장 빠른 시간을 찾는 수까지 같이 구해야한다. 이를 위해서는 다음과 같은 기준을 따라야한다.

1. BFS 탐색 종료 기저조건을 시간으로 잡는다.<br>
-> 만약 수빈이를 2초에 만났다고 가정한다면 3초 이상부터는 탐색할 필요가 없다.<br>

2. 중복 방문을 허용한다.<br>
-> 예를 들어 입력이 1 4 로 주어진 경우 최단 루트는 *2 *2 (1 2 4) 일수도 있고, +1 *2 (1,2,4)일 수도 있다. 이런 경우 2의 위치에서 중복 방문을 허용하지 않는다면 여러가지 방법을 구할 수 없다.<br>

3. 하지만 모든 중복을 허용하지 않는다.<br>
-> 똑같은 위치에 방문했을 때 세가지 경우를 생각해봐야한다.<br>
	- 이전 방문시간과 현재 방문시간이 일치하는 경우 : 동일한 시간에 도착했다면 최종 목적지에 도달하는 시간도 동일할 가능성이 있으므로 가능 <br>
	- 이전 방문시간이 현재 방문시간보다 빠른 경우 : 현재 시간이 더 느리므로 최종 목적지에 최단 시간으로 도달할 가능성이 없다.<br>
	- 이전 방문시간이 현재 방문시간보다 늦는 경우 : 현재 시간이 더 빠르므로 가능, 하지만 bfs는 시간 순서대로 진행되므로 발생할 확률은 없다.


출처 : https://bcp0109.tistory.com/154

## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 19032kb| 128ms|
