## BOJ 3687 ์ฑ๋ฅ๊ฐ๋น 
- dp
- ๐ฅ Gold2
- ๐[์ฑ๋ฅ๊ฐ๋น ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/3687)



## ํ์ด

์ค~~๋๋ง์ dp ๋ฌธ์ . ์ ๊ทผ๋ฒ์ ์ข์์ผ๋ ์ญ์๋ dp๋ ๋ง์ด ํ์ด๋ณด๋๊ฒ ๋ต์ธ๊ฑฐ ๊ฐ๋ค..

์ค๋ฅ์ฌํญ
1. Integer.MAX_VALUE๋ก ์ด๊ธฐ๊ฐ์ ์ง์ ํด์ฃผ์ด ์ค๋ฒํ๋ก์ฐ ๋ฐ์.. Long.MAX_VALUE๋ก ํด๊ฒฐ 
2. ์ด๊ธฐ๊ฐ์ 7๊น์ง๋ง ์ค์ ํด์ฃผ๋ฉด ์ค๋ฅ๊ฐ ๋๋ค. ์ด์ ๋ ๋ชจ๋ฅด๊ฒ ๋ค ใ ใ  ์ด๊ธฐ์กฐ๊ฑด์ ์ ์ค์ ํด์ฃผ๋ ๊ฒ๋ ์ค์ํ๋ค!

## ์์ค์ฝ๋
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3687_G2_์ฑ๋ฅ๊ฐ๋น {
	static long[] dp;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		String[] add= {"1","7","4","2","0","8"};
		
		// ์ต์๊ฐ ๊ตฌํ๊ธฐ 
		for(int i=9; i<=100; i++) {
			for(int j=2; j<=7; j++) {
				String tmp = dp[i-j] + add[j-2];
				dp[i] = Math.min(dp[i],Long.parseLong(tmp));
				
			}
		}
		
		// ์ต๋๊ฐ ๊ตฌํ๊ธฐ 
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			long min = dp[N];
			
			StringBuilder sb = new StringBuilder();
			long a = N/2;
			long b = N%2;
			// ์ง์ 
			if(b==0) {
				sb.append("1");
			}
			// ํ์ 
			else {
				sb.append("7");
			}
			
			for(int i=1; i<a; i++) {
				sb.append("1");
			}
			
			System.out.println(min + " " + sb.toString());
			
		}

	}

}

~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
| 11876kb|88ms|
