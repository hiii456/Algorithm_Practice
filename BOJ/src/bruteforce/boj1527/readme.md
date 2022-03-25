## BOJ - 금민수의 개수 
- Silver 1 
- bruteforce 
🔗[금민수의 개수 문제 바로가기](https://www.acmicpc.net/problem/1527)



## 풀이

이 문제는 dfs를 이용해서 4,7이 되는 숫자를 재귀를 통해 만들어주고 조건에 해당하는 범위이면 count, 해당 조건에서 벗어나면(b보다 크면) return을 해주었다.

이때, 입력받는 수의 최대 크기는 1,000,000,000 이므로 long 타입이여야 한다. 

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1527_S1_금민수의_개수 {
	static int cnt = 0;
	static int a,b;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		dfs(0);
		
		System.out.println(cnt);
	}

	private static void dfs(long n) {
		// n의 기저조건, 만약 a~b 범위에 있다면 count 
		if(n>b)	return;
		if(n>=a && n<=b)	cnt++;
		
		dfs(n*10+4);
		dfs(n*10+7);
		
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11548KB	|76ms|