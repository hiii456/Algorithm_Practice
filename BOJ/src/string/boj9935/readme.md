## BOJ - 문자열 폭발 
- Gold 4 
- String 
🔗[문자열 폭발 문제 바로가기](https://www.acmicpc.net/problem/9935)



## 풀이

기존 문제는 stack을 이용해서 풀었으나 이번에는 StringBuilder를 이용해서 문제를 풀었다.
StringBulder에 문자열을 하나씩 붙여가면서 폭발 문자열보다 길이가 크거나 같을 경우 폭발 문자열을 포함하는지 확인해주었다.
기존에 stack을 활용한 문제보다 반복문 사용횟수가 줄어 풀이시간도 더 빨라진것 같다.

## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bombStr = br.readLine();
		int strLen = str.length();
		int bombLen = bombStr.length();
		StringBuilder sb = new StringBuilder();
		boolean isSame = false;
		
		String answer = "";
		
		for(int i=0; i<strLen; i++) {
			char ch = str.charAt(i);
			sb.append(ch);
			
			if(sb.length()>=bombLen) {
				isSame = true;
				for(int j=0; j<bombLen; j++) {
					char ch1 = sb.charAt(sb.length()-bombLen+j);
					char ch2 = bombStr.charAt(j);
					if(ch1 != ch2) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					sb.delete(sb.length() - bombLen , sb.length());
				}
			}	
		}
		
		if(sb.length()==0) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb.toString());
		}
	}
}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|27256KB	|272ms|