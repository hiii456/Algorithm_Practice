## BOJ 16500 문자열 판별 
- dp 
- 🥈 Silver2 
- 🔗[문자열 판별 문제 바로가기](https://www.acmicpc.net/problem/16500)



## 풀이

문자열을 나눌 수 있으면 substring을 쓰자..! 아직 dp는 어렵다 다시 한번 풀어봐야지..

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_16500_S2_문자열_판별 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[101];
		
		HashSet<String> A = new HashSet<>();
		
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			A.add(br.readLine());
		}
		
		for(int i=str.length()-1; i>=0; i--) {
			for(int j=i+1; j<str.length(); j++) {
				if(dp[j]==1) {
					if(A.contains(str.substring(i, j))){
						dp[i] = 1;
					}
				}
			}
			if(A.contains(str.substring(i))) {
				dp[i] = 1;
			}
		}
		
		System.out.println(dp[0]);
		
		
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 12044kb| 80ms|