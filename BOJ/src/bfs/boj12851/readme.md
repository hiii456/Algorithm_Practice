## BOJ 12851 ์จ๋ฐ๊ผญ์ง2 
- Bfs
- ๐ฅ Gold5
- ๐[์จ๋ฐ๊ผญ์ง2 ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/12851)



## ํ์ด

[์จ๋ฐ๊ผญ์ง](https://www.acmicpc.net/problem/1697) ๋ฌธ์ ์์ ๊ฐ์ฅ ๋น ๋ฅธ ์๊ฐ์ ์ฐพ๋ ์๊น์ง ๊ฐ์ด ๊ตฌํด์ผํ๋ค. ์ด๋ฅผ ์ํด์๋ ๋ค์๊ณผ ๊ฐ์ ๊ธฐ์ค์ ๋ฐ๋ผ์ผํ๋ค.

1. BFS ํ์ ์ข๋ฃ ๊ธฐ์ ์กฐ๊ฑด์ ์๊ฐ์ผ๋ก ์ก๋๋ค.<br>
-> ๋ง์ฝ ์๋น์ด๋ฅผ 2์ด์ ๋ง๋ฌ๋ค๊ณ  ๊ฐ์ ํ๋ค๋ฉด 3์ด ์ด์๋ถํฐ๋ ํ์ํ  ํ์๊ฐ ์๋ค.<br>

2. ์ค๋ณต ๋ฐฉ๋ฌธ์ ํ์ฉํ๋ค.<br>
-> ์๋ฅผ ๋ค์ด ์๋ ฅ์ด 1 4 ๋ก ์ฃผ์ด์ง ๊ฒฝ์ฐ ์ต๋จ ๋ฃจํธ๋ *2 *2 (1 2 4) ์ผ์๋ ์๊ณ , +1 *2 (1,2,4)์ผ ์๋ ์๋ค. ์ด๋ฐ ๊ฒฝ์ฐ 2์ ์์น์์ ์ค๋ณต ๋ฐฉ๋ฌธ์ ํ์ฉํ์ง ์๋๋ค๋ฉด ์ฌ๋ฌ๊ฐ์ง ๋ฐฉ๋ฒ์ ๊ตฌํ  ์ ์๋ค.<br>

3. ํ์ง๋ง ๋ชจ๋  ์ค๋ณต์ ํ์ฉํ์ง ์๋๋ค.<br>
-> ๋๊ฐ์ ์์น์ ๋ฐฉ๋ฌธํ์ ๋ ์ธ๊ฐ์ง ๊ฒฝ์ฐ๋ฅผ ์๊ฐํด๋ด์ผํ๋ค.<br>
	- ์ด์  ๋ฐฉ๋ฌธ์๊ฐ๊ณผ ํ์ฌ ๋ฐฉ๋ฌธ์๊ฐ์ด ์ผ์นํ๋ ๊ฒฝ์ฐ : ๋์ผํ ์๊ฐ์ ๋์ฐฉํ๋ค๋ฉด ์ต์ข ๋ชฉ์ ์ง์ ๋๋ฌํ๋ ์๊ฐ๋ ๋์ผํ  ๊ฐ๋ฅ์ฑ์ด ์์ผ๋ฏ๋ก ๊ฐ๋ฅ <br>
	- ์ด์  ๋ฐฉ๋ฌธ์๊ฐ์ด ํ์ฌ ๋ฐฉ๋ฌธ์๊ฐ๋ณด๋ค ๋น ๋ฅธ ๊ฒฝ์ฐ : ํ์ฌ ์๊ฐ์ด ๋ ๋๋ฆฌ๋ฏ๋ก ์ต์ข ๋ชฉ์ ์ง์ ์ต๋จ ์๊ฐ์ผ๋ก ๋๋ฌํ  ๊ฐ๋ฅ์ฑ์ด ์๋ค.<br>
	- ์ด์  ๋ฐฉ๋ฌธ์๊ฐ์ด ํ์ฌ ๋ฐฉ๋ฌธ์๊ฐ๋ณด๋ค ๋ฆ๋ ๊ฒฝ์ฐ : ํ์ฌ ์๊ฐ์ด ๋ ๋น ๋ฅด๋ฏ๋ก ๊ฐ๋ฅ, ํ์ง๋ง bfs๋ ์๊ฐ ์์๋๋ก ์งํ๋๋ฏ๋ก ๋ฐ์ํ  ํ๋ฅ ์ ์๋ค.


์ถ์ฒ : https://bcp0109.tistory.com/154

## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_12851_G5_์จ๋ฐ๊ผญ์ง2 {
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
				// ์ฒซ ๋ฐฉ๋ฌธ์ด๊ฑฐ๋ ์ด์ ์ ๋ฐฉ๋ฌธํ ๊ณณ์ด์ฌ๋ ๊ฐ์ ์๊ฐ์ ๋ฐฉ๋ฌธํ๋ค๋ฉด 
				if(visited[next]==0 || visited[next] == visited[now]+1) {
					queue.add(next);
					visited[next] = visited[now]+1;
				}
			}
			
		}
		
	}

}

~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
| 19032kb| 128ms|
