## BOJ - 30 
- Silver 5 
- greedy  
🔗[30 문제 바로가기](https://www.acmicpc.net/problem/10610)



## 풀이

처음에는 이 문제를 단순 조합으로 생각하여 문제를 풀었으나 런타임에러가 발생했다.(런타임 에러를 잡아도 메모리 초과가 나왔을것 같다.)
그 이유는 N이 최대 10^5개의 숫자로 구성되어 있기 때문에 이 부분을 고려해주지 않은 것이다. 
따라서 int형도, long형도 입력받을 수 없기 때문에 String타입으로 n을 입력받았다. 

그다음 입력받은 숫자를 substring 함수를 이용해 하나씩 쪼개어 0~9까지 해당하는 idx에 count를 해주었다.

~~~java
		for(int i=0; i<n.length(); i++) {
			int idx = Integer.parseInt(n.substring(i,i+1));
			numCnt[idx]++;
			total += idx;
		}
~~~

그리고 입력받은 데이터가 30배수인지 확인하는 작업을 해주어야 한다.
30배수가 되기 위해서는 1. 맨뒤의 숫자가 0이여야 하므로 0이라는 숫자를 가지고 있어야 한다. 2. 모든 자릿수의 합은 3의 배수여야 한다.
이 조건들을 만족해야 한다.

~~~java
		if(total % 3 !=0 || !n.contains("0")) {
			System.out.println("-1");
			return;
		}
~~~

이 조건을 만족했다면 30배수가 되는 가장 큰수를 만들어주어야 한다. 
따라서 9부터 시작하여 차례대로 배열에 count된 만큼 숫자를 꺼내어 결과를 출력한다.

~~~java
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			while(numCnt[i]>0) {
				sb.append(i);
				numCnt[i]--;
			}
		}
~~~


## 소스코드
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

## 결과 

| 메모리  | 시간 |
|----|----|
|19652KB	|172ms|