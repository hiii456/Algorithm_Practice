## BOJ - ์ปต๋ผ๋ฉด 
- Gold 2
- greedy
๐[์ปต๋ผ๋ฉด ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1781)



## ํ์ด

์ด ๋ฌธ์ ๋ ์ ๋ ฌ์ ์ด์ฉํ์ฌ ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ์๋ค.
๋จผ์  ๋ฐ๋๋ผ์ธ์ ์ค๋ฆ์ฐจ์, ๋ฐ๋๋ผ์ธ์ด ๊ฐ์ ๊ฒฝ์ฐ ๋ผ๋ฉด์ ๊ฐฏ์๋ฅผ ๋ด๋ฆผ์ฐจ์์ผ๋ก ์ ๋ ฌํ๋ Problem ํด๋์ค๋ฅผ ๋ง๋ค์๋ค.

~~~java
	static class Problem implements Comparable<Problem>{
		int deadline;
		int ramen;
		public Problem(int deadline,int ramen) {
			this.deadline = deadline;
			this.ramen = ramen;
		}
		@Override
		public int compareTo(Problem o) {
			if(this.deadline == o.deadline) {
				return o.ramen - this.ramen;
			}
			return this.deadline - o.deadline;
		}
		
	}
~~~

์ฌ๊ธฐ์ ์ฃผ์ํ  ์ ์, ์ด ์ ๋ ฌ๋๋ก๋ง ๊ตฌํ๊ฒ ๋๋ ๊ฒฝ์ฐ ๋ฐ๋๋ผ์ธ์ด ๋ค ์ฐจ์ง ์์์ ๋, ๋ฐ๋๋ผ์ธ ์ ๋ ฌ์ด ์ฐ์ ์ด๊ธฐ ๋๋ฌธ์ ๋ฐ๋๋ผ์ธ์ ๋น ๋ฅด์ง๋ง ๋ผ๋ฉด์ ๊ฐฏ์๋ ์ ์ ๋ฌธ์ ๋ฅผ ํ์ด์ผํ๋ค. ๋ฐ๋ผ์ ์ด๋ฅผ ์ํด ์ฐ์ ์์ ํ์ size๋ฅผ ๋จ์์๊ฐ์ผ๋ก ์ค์ ํ๋ค.(๋ฌธ์ ํธ๋๋ฐ ๋จ์์๊ฐ์ด 1 ๊ฑธ๋ฆฌ๋ฏ๋ก) ๊ทธ๋ฆฌ๊ณ  ์ฐ์ ์์ํ size์ ์ ๋ ฌ๋ ๋ฌธ์ ์ ๋ฐ๋๋ผ์ธ์ ๋น๊ตํ๋ค. ๋ง์ผ, ๋ฐ๋๋ผ์ธ์ด ์ฐ์ ์์ ํ์ size์ ๊ฐ๊ฑฐ๋ ํฌ๋ค๋ฉด ๋ผ๋ฉด ํฌ๊ธฐ๋ฅผ ๋น๊ตํ์ฌ ์ฐ์ ์์ ํ์ ๋ผ๋ฉด์ ๊ฐ์ด ๋ ๋ง์ ๋ฌธ์ ๋ฅผ ๋ฃ์ด์ค๋ค.

~~~java
		for(Problem p : arr) {
			if(pq.size()<p.deadline) {
				pq.add(p.ramen);
			}else {
				if(pq.peek()<p.ramen) {
					pq.poll();
					pq.add(p.ramen);
				}
			}
		}
~~~


## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1781_G2_์ปต๋ผ๋ฉด {
	static class Problem implements Comparable<Problem>{
		int deadline;
		int ramen;
		public Problem(int deadline,int ramen) {
			this.deadline = deadline;
			this.ramen = ramen;
		}
		@Override
		public int compareTo(Problem o) {
			if(this.deadline == o.deadline) {
				return o.ramen - this.ramen;
			}
			return this.deadline - o.deadline;
		}
		
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Problem[] arr = new Problem[n];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Problem(a,b);
		}
		
		long ans = 0;
		Arrays.sort(arr);
		
		for(Problem p : arr) {
			if(pq.size()<p.deadline) {
				pq.add(p.ramen);
			}else {
				if(pq.peek()<p.ramen) {
					pq.poll();
					pq.add(p.ramen);
				}
			}
		}
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		
		System.out.println(ans);

	}

}

~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|76556KB	|1064ms|