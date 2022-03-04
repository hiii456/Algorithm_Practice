## BOJ - 숨바꼭질 
- Silver 1
- bfs
🔗[숨바꼭질 문제 바로가기](https://www.acmicpc.net/problem/1697)



## 풀이

이 문제는 앞으로만 가는 것이 아닌, 앞으로 갔다가 다시 뒤로도 이동할 수 있기 때문에 방문처리를 해주어야 했다.
따라서 숨바꼭질을 할 수 있는 범위의 크기만큼 int 타입의 배열을 만들어주었다.

그리고 x의 범위와 방문하지 않은 곳을 bfs 탐색을 진행해주었다.

여기서 막혔던 점은, 테케는 통과하는데 틀렸습니다 가 나온다는 점이었다.
이 부분은 n,k가 같은 값을 때 예외처리를 해주지 않아 생긴 문제였다.

~~~java
        if(n==k){
            System.out.println(0);
        }else{
            bfs(n);
		    System.out.println(visited[k]);
        }
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class Main {
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
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|16104KB	|112ms|