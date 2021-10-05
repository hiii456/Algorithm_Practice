## BOJ 3687 성냥개비 
- dp
- 🥇 Gold2
- 🔗[성냥개비 문제 바로가기](https://www.acmicpc.net/problem/3687)



## 풀이

오~~랜만에 dp 문제. 접근법은 좋았으나 역시나 dp는 많이 풀어보는게 답인거 같다..

오류사항
1. Integer.MAX_VALUE로 초기값을 지정해주어 오버플로우 발생.. Long.MAX_VALUE로 해결 
2. 초기값을 7까지만 설정해주면 오류가 난다. 이유는 모르겠다 ㅠㅠ 초기조건을 잘 설정해주는 것도 중요하다!

## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3687_G2_성냥개비 {
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
		
		// 최솟값 구하기 
		for(int i=9; i<=100; i++) {
			for(int j=2; j<=7; j++) {
				String tmp = dp[i-j] + add[j-2];
				dp[i] = Math.min(dp[i],Long.parseLong(tmp));
				
			}
		}
		
		// 최대값 구하기 
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			long min = dp[N];
			
			StringBuilder sb = new StringBuilder();
			long a = N/2;
			long b = N%2;
			// 짝수 
			if(b==0) {
				sb.append("1");
			}
			// 홀수 
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

## 결과 

| 메모리  | 시간 |
|----|----|
| 11876kb|88ms|
