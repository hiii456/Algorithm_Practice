## BOJ - 30 
- Silver 5 
- greedy  
๐[30 ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/10610)



## ํ์ด

์ฒ์์๋ ์ด ๋ฌธ์ ๋ฅผ ๋จ์ ์กฐํฉ์ผ๋ก ์๊ฐํ์ฌ ๋ฌธ์ ๋ฅผ ํ์์ผ๋ ๋ฐํ์์๋ฌ๊ฐ ๋ฐ์ํ๋ค.(๋ฐํ์ ์๋ฌ๋ฅผ ์ก์๋ ๋ฉ๋ชจ๋ฆฌ ์ด๊ณผ๊ฐ ๋์์๊ฒ ๊ฐ๋ค.)
๊ทธ ์ด์ ๋ N์ด ์ต๋ 10^5๊ฐ์ ์ซ์๋ก ๊ตฌ์ฑ๋์ด ์๊ธฐ ๋๋ฌธ์ ์ด ๋ถ๋ถ์ ๊ณ ๋ คํด์ฃผ์ง ์์ ๊ฒ์ด๋ค. 
๋ฐ๋ผ์ intํ๋, longํ๋ ์๋ ฅ๋ฐ์ ์ ์๊ธฐ ๋๋ฌธ์ Stringํ์์ผ๋ก n์ ์๋ ฅ๋ฐ์๋ค. 

๊ทธ๋ค์ ์๋ ฅ๋ฐ์ ์ซ์๋ฅผ substring ํจ์๋ฅผ ์ด์ฉํด ํ๋์ฉ ์ชผ๊ฐ์ด 0~9๊น์ง ํด๋นํ๋ idx์ count๋ฅผ ํด์ฃผ์๋ค.

~~~java
		for(int i=0; i<n.length(); i++) {
			int idx = Integer.parseInt(n.substring(i,i+1));
			numCnt[idx]++;
			total += idx;
		}
~~~

๊ทธ๋ฆฌ๊ณ  ์๋ ฅ๋ฐ์ ๋ฐ์ดํฐ๊ฐ 30๋ฐฐ์์ธ์ง ํ์ธํ๋ ์์์ ํด์ฃผ์ด์ผ ํ๋ค.
30๋ฐฐ์๊ฐ ๋๊ธฐ ์ํด์๋ 1. ๋งจ๋ค์ ์ซ์๊ฐ 0์ด์ฌ์ผ ํ๋ฏ๋ก 0์ด๋ผ๋ ์ซ์๋ฅผ ๊ฐ์ง๊ณ  ์์ด์ผ ํ๋ค. 2. ๋ชจ๋  ์๋ฆฟ์์ ํฉ์ 3์ ๋ฐฐ์์ฌ์ผ ํ๋ค.
์ด ์กฐ๊ฑด๋ค์ ๋ง์กฑํด์ผ ํ๋ค.

~~~java
		if(total % 3 !=0 || !n.contains("0")) {
			System.out.println("-1");
			return;
		}
~~~

์ด ์กฐ๊ฑด์ ๋ง์กฑํ๋ค๋ฉด 30๋ฐฐ์๊ฐ ๋๋ ๊ฐ์ฅ ํฐ์๋ฅผ ๋ง๋ค์ด์ฃผ์ด์ผ ํ๋ค. 
๋ฐ๋ผ์ 9๋ถํฐ ์์ํ์ฌ ์ฐจ๋ก๋๋ก ๋ฐฐ์ด์ count๋ ๋งํผ ์ซ์๋ฅผ ๊บผ๋ด์ด ๊ฒฐ๊ณผ๋ฅผ ์ถ๋ ฅํ๋ค.

~~~java
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			while(numCnt[i]>0) {
				sb.append(i);
				numCnt[i]--;
			}
		}
~~~


## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_10610_S5_30 {
	static int[] numCnt = new int[10];
	static long total = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		for(int i=0; i<n.length(); i++) {
			int idx = Integer.parseInt(n.substring(i,i+1));
			numCnt[idx]++;
			total += idx;
		}
		
		if(total % 3 !=0 || !n.contains("0")) {
			System.out.println("-1");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			while(numCnt[i]>0) {
				sb.append(i);
				numCnt[i]--;
			}
		}
		
		System.out.println(sb.toString());
	}

}
~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|19652KB	|172ms|