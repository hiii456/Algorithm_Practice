## BOJ - A -> B
- Silver 1 
- bfs
๐[A->B ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/16953)



## ํ์ด

์ด ๋ฌธ์ ๋ ์ต์ ์ฐ์ฐํ์๋ฅผ ๊ตฌํ๋ ๋ฌธ์ ์ด๋ฏ๋ก down-top ํ์์ bfs๋ฅผ ์ด์ฉํ์ฌ ๋ฌธ์ ๋ฅผ ํ์๋ค. 
๊ธฐ์ ์กฐ๊ฑด์ ํด๋น ์ซ์๊ฐ b๊ฐ ๋์์ ๊ฒฝ์ฐ์ด๊ณ ,

~~~java
			if(p.num == b) {
				ans = p.cnt;
				return;
			}
~~~

์ฐ์ฐ์ ํ  ์ ์๋ ๋๊ฐ์ง ๋ฐฉ๋ฒ์ด b๋ณด๋ค ์๊ฑฐ๋ ๊ฐ์ ๊ฒฝ์ฐ ํ์ ๋ด์์ฃผ์ด ํ์์ ์งํํ์๋ค.

์ฌ๊ธฐ์ ๋งํ๋ ์ ์, 1์ ์์ ๊ฐ์ฅ ์ค๋ฅธ์ชฝ์ ์ถ๊ฐํ๋ค. -> ์ด ์ฐ์ฐ์ ํด๋น ์ซ์ x 10 + 1 ๋ก ์ฐ์ฐํด์ฃผ์๋๋ฐ 
๊ทธ ๊ฒฝ์ฐ ์ซ์๊ฐ 10^9์ผ๋ overflow๊ฐ ๋ฐ์ํ  ์ ์๊ธฐ ๋๋ฌธ์ Pair์ num์ long ํ์์ผ๋ก ์ ์ธํด์ฃผ์๋ค.

## ์์ค์ฝ๋
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

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|15084KB	|104ms|