## BOJ 13305 ์ฃผ์ ์ 
- Greedy
- ๐ฅ Silver 4 
- ๐[์ฃผ์ ์ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/13305)



## ํ์ด

๊ทธ๋ฆฌ๋ ์๊ณ ๋ฆฌ์ฆ! ์ด๋ป๊ฒ ํ์ดํ ๊ฑด์ง ์๊ฐํ๋๊ฒ ํฌ์ธํธ ๊ฐ๋ค.
๊ฐ๊ฒฉ์ ๋ฒ์๊ฐ int ํ์ ๋ฒ์ด๋๊ธฐ ๋๋ฌธ์ long ํ์์ผ๋ก ์ ์ธํด์ผ ํ๋ค.
์ฒ์์ int๋ก ์ ์ธํ์ฌ ๋ต์ ๋ง์์ผ๋ 58์ ์ด ๋์๊ณ , longํ์์ผ๋ก ๋ฐ๊พผ ํ 100์ ์ ๋ง์ ์ ์์๋ค.


## ์์ค์ฝ๋
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_์ฃผ์ ์ {
	static int N;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] len = new int[N-1];
		long[] cost = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// ๊ธฐ๋ฆ ๊ฐ๊ฒฉ์ ๋ด๋ฆผ์ฐจ์์ผ๋ก ๋ง๋ ๋ค.
		for(int i=1; i<N; i++) {
			if(cost[i]>cost[i-1]) {
				cost[i] = cost[i-1];
			}

		}
		
		long ans = 0;
		for(int i=0; i<N-1; i++) {
			ans += cost[i] * len[i];
		}
		
		System.out.println(ans);
		

	}

}

~~~

## ๊ฒฐ๊ณผ 

100์  

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
| 41000kb| 364ms|