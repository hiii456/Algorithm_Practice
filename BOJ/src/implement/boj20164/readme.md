## BOJ - 홀수 홀릭 호석 
- Gold 5 
- implement 
🔗[홀수 홀릭 호석 문제 바로가기](https://www.acmicpc.net/problem/20164)



## 풀이

이 문제는 숫자(타입은 String)과 홀수의 갯수를 인자로 받는 split 메소드에서 재귀를 이용하여 문제를 해결할 수 있었다. 

split 메소드를 살펴보면, 먼저 숫자에서 홀수의 개수를 찾는다. 

~~~Java
		for(int i=0; i<str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			if(tmp%2 == 1)	cnt++;
		}
~~~

그리고 숫자의 길이에 따라 각각 조건에 맞는 역할을 수행하고, 길이가 1인 경우에만 return, 1보다 길이가 클 경우 재귀를 이용한다.

~~~java
		else if(str.length() == 2) {
			int tmp1 = Integer.parseInt(str.substring(0,1));
			int tmp2 = Integer.parseInt(str.substring(1,2));
			int sum = tmp1 + tmp2;
			
			split(String.valueOf(sum),cnt);
		}else if(str.length() >= 3) {
			for(int i=0; i<str.length()-2; i++) {
				for(int j=i+1; j<str.length()-1; j++){
					int tmp1 = Integer.parseInt(str.substring(0,i+1));
					int tmp2 = Integer.parseInt(str.substring(i+1,j+1));
					int tmp3 = Integer.parseInt(str.substring(j+1,str.length()));
					
					int sum = tmp1 + tmp2 + tmp3;
					
					split(String.valueOf(sum),cnt);
				}
			}
		}
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_20164_G5_홀수_홀릭_호석 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0;
		split(str,cnt);
		
		System.out.println(min + " " + max);
		
	}
	private static void split(String str,int cnt) {
		for(int i=0; i<str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			if(tmp%2 == 1)	cnt++;
		}
		
		if(str.length() == 1) {
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			return;
		}else if(str.length() == 2) {
			int tmp1 = Integer.parseInt(str.substring(0,1));
			int tmp2 = Integer.parseInt(str.substring(1,2));
			int sum = tmp1 + tmp2;
			
			split(String.valueOf(sum),cnt);
		}else if(str.length() >= 3) {
			for(int i=0; i<str.length()-2; i++) {
				for(int j=i+1; j<str.length()-1; j++){
					int tmp1 = Integer.parseInt(str.substring(0,i+1));
					int tmp2 = Integer.parseInt(str.substring(i+1,j+1));
					int tmp3 = Integer.parseInt(str.substring(j+1,str.length()));
					
					int sum = tmp1 + tmp2 + tmp3;
					
					split(String.valueOf(sum),cnt);
				}
			}
		}
		
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|12004KB	|88ms|