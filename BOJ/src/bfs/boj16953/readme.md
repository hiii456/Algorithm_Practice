## BOJ - A -> B
- Silver 1 
- bfs
🔗[A->B 문제 바로가기](https://www.acmicpc.net/problem/16953)



## 풀이

이 문제는 최소 연산횟수를 구하는 문제이므로 down-top 형식의 bfs를 이용하여 문제를 풀었다. 
기저조건은 해당 숫자가 b가 되었을 경우이고,

~~~java
			if(p.num == b) {
				ans = p.cnt;
				return;
			}
~~~

연산을 할 수 있는 두가지 방법이 b보다 작거나 같은 경우 큐에 담아주어 탐색을 진행하였다.

여기서 막혔던 점은, 1을 수의 가장 오른쪽에 추가한다. -> 이 연산을 해당 숫자 x 10 + 1 로 연산해주었는데 
그 경우 숫자가 10^9일때 overflow가 발생할 수 있기 때문에 Pair의 num은 long 타입으로 선언해주었다.

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class Main {
	static int a,b,ans;
	static class Pair{
		long num;
		int cnt;
		public Pair(long num,int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		bfs(a,1);
		
		System.out.println(ans);
		
	}
	public static void bfs(int a,int cnt) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(a,cnt));
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			if(p.num == b) {
				ans = p.cnt;
				return;
			}
			
			if(p.num*2<=b) {
				queue.add(new Pair(p.num*2,p.cnt+1));
			}
			
			if(p.num*10+1<=b) {
				queue.add(new Pair(p.num*10+1,p.cnt+1));
			}
		}
		ans = -1;
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|15084KB	|104ms|