## BOJ - 영화감독 숌 
- Silver 5 
- bruteforce
🔗[영화감독 숌 문제 바로가기](https://www.acmicpc.net/problem/1436)



## 풀이



## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1436_S5_영화감독_숌 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int num = 665;
		while(cnt!=n) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);

	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|158444KB	|344ms|