## BOJ - ์ ์ ์ฌ์ 
- Silver 1 
- greedy 
๐[์ ์ ์ฌ์ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1946)



## ํ์ด

์ฒ์์ ํ์ด๋ฐฉ์์ ์๋ ฅ์ด ์ต๋ 10๋ง๊ฐ์ด๋ฏ๋ก N^2์ ์๊ฐ๋ณต์ก๋๋ฅผ ๊ฐ์ง๊ฒ๋๋ฉด์ ์๊ฐ์ด๊ณผ ์ค๋ฅ๊ฐ ๋๊ฒ ๋์๋ค.(๋ฐ์ ํ๋ฆฐํ์ด ์ฐธ๊ณ )

๋ฐ๋ผ์ ์ด์คfor๋ฌธ์ ์ฌ์ฉํ์ง ์๊ณ  ๋ฌธ์ ๋ฅผ ํด๊ฒฐํ  ์ ์๋ ๋ฐฉ๋ฒ์ ์ฐพ์์ผํ๋ค.
์ด๋ฅผ ์ํด ์๋ฅ ๊ฒฐ๊ณผ ์์๋๋ก ์ค๋ฆ์ฐจ์ ์ ๋ ฌ์ ํ list๋ฅผ 1๋ฒ์งธ ๊ฐ๋ถํฐ ํ์ํ๋ค. (0๋ฒ์งธ ๊ฐ์ ์๋ฅ ๊ฒฐ๊ณผ 1๋ฑ์ด๋ฏ๋ก ๋ค๋ฅธ์ฌ๋์ ์๋ฅ๊ฒฐ๊ณผ๋ณด๋ค ํญ์ ๋๋ค.)
๊ทธ๋ฆฌ๊ณ  ํ์ํ  ์ฌ๋์ ์๋ฅ ๊ฒฐ๊ณผ๋ ์ ๋ ฌ ๊ธฐ์ค์ผ๋ก ์ ์ฌ๋๋ณด๋ค ํญ์ ์๋ฅ๊ฒฐ๊ณผ๊ฐ ๋ฎ์ ์์์ด๋ฏ๋ก ๋ฉด์  ์์๊ฐ ๋์์ผํ๋ค. 
๋ฐ๋ผ์ ๋ฉด์  ์์๊ฐ ๋๋ค๋ฉด, ์ฌ๋ ์๋ฅผ count ํด์ฃผ๊ณ  ๋ฉด์ ๊ฒฐ๊ณผ ์ต๊ณ  ์์๋ฅผ ๊ฐฑ์ ํด์ค๋ค.

## ์์ค์ฝ๋

#### ํ๋ฆฐ ํ์ด 

~~~java
import java.io.*;
import java.util.*;

public class BOJ_1946_S1_์ ์_์ฌ์ {
	static class Grade implements Comparable<Grade>{
		int document;
		int interview;
		public Grade(int document,int interview) {
			this.document = document;
			this.interview = interview;
		}
		@Override
		public int compareTo(Grade o) {
			// TODO Auto-generated method stub
			return this.document - o.document;
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			List<Grade> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Grade(a,b));
			}
			
			Collections.sort(list);
			
			int ans = n;
			for(int i=0; i<n; i++) {
				for(int j=0; j<i; j++) {
					if(list.get(i).interview>list.get(j).interview) {
						ans--;
						break;
					}
				}
			}
			
			System.out.println(ans);
			
		}

	}

}
~~~

#### ์ณ์ ํ์ด 

~~~java
import java.io.*;
import java.util.*;

public class BOJ_1946_S1_์ ์_์ฌ์ {
	static class Grade implements Comparable<Grade>{
		int document;
		int interview;
		public Grade(int document,int interview) {
			this.document = document;
			this.interview = interview;
		}
		@Override
		public int compareTo(Grade o) {
			// TODO Auto-generated method stub
			return this.document - o.document;
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			List<Grade> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Grade(a,b));
			}
			
			Collections.sort(list);
			
			int ans = 1;
			int tmp = list.get(0).interview;
			for(int i=1; i<n; i++) {
				if(tmp>list.get(i).interview) {
					tmp = list.get(i).interview;
					ans++;
				}
			}
			
			System.out.println(ans);
			
		}

	}

}
~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|300892KB	|1500ms|