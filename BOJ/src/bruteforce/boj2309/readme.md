## BOJ - 일곱 난쟁이 
- Bronze 2 
- bruteforce 
🔗[난쟁이 문제 바로가기](https://www.acmicpc.net/problem/2309)



## 풀이

브루트포스는 모든 경우를 다 구해야하기 때문에 난쟁이중 일곱명을 더한 수가 100이 될때까지 완전탐색을 진행하였다.


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_b2_2309_일곱_난쟁이 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] dwarf = new int[9];
		int a = 0,b = 0;
		
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		Arrays.sort(dwarf);
		
		for(int i=0; i<8; i++) {
			for(int j = i+1; j<9; j++) {
				if(sum - dwarf[i] - dwarf[j] == 100) {
					a = i;
					b = j;
					break;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i==a || i==b)	continue;
			System.out.println(dwarf[i]);
		}
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11484KB	|80ms|