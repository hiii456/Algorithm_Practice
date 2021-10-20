## BOJ 1342 행운의 문자열 
- BackTracking
- 🥈 Silver1
- 🔗[행운의 문자열 문제 바로가기](https://www.acmicpc.net/problem/1342)



## 풀이

이 문제는 입력된 문자열의 순열을 먼저 구해준다음 행운의 문자열인지 아닌지 검사해주면 된다.
그치만 aaab인 경우 a가 3번이나 들어가므로 중복된 순열 값이 나온다.

이러한 중복된 값을 제거하기 위해 팩토리얼을 사용한다.

이를 위해 먼저 각 알파벳이 쓰인 갯수를 count 해준다.

~~~java
		for(int i=0; i <arr.length; i++) {
			alphabet[arr[i] - 'a']++;
		}
~~~

똑같은 값이 있을 때 똑같은 문자들의 갯수들의 팩토리얼 값을 결과값에 나누어주면 된다.

~~~java
		for(int i=0; i<26; i++) {
            if(alphabet[i] > 1) {
                count /= factorial(alphabet[i]);
            }
        }
~~~

hashset을 사용하여 중복을 제거하는 방법도 있었지만.. 메모리초과가 나올수도 있기 때문에!! 이 방법 유용하니까 꼬옥.. 기억해... 

## 소스코드
~~~java
import java.io.*;
import java.util.Arrays;

public class BOJ_1342_S1_행운의_문자열 {
	static int count;
	static int[] alphabet = new int[26];
	static char[] arr;
	static char[] tgt;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		arr = str.toCharArray();
		
		tgt = new char[arr.length];
		selected = new boolean[arr.length];
		
		perm(0);
		
		for(int i=0; i <arr.length; i++) {
			alphabet[arr[i] - 'a']++;
		}

		
		// 중복의 개수 제거하기 위해 팩토리얼 사용 
		for(int i=0; i<26; i++) {
            if(alphabet[i] > 1) {
                count /= factorial(alphabet[i]);
            }
        }
		
		System.out.println(count);

	}
	
	private static int factorial(int n) {
		if(n==1)
			return 1;
		
		return n * factorial(n-1);
		
	}
	
	private static void perm(int tgtIdx) {
		if(tgtIdx == tgt.length) {
			if(check()) {
				count++;
			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(selected[i])	continue;
			
			tgt[tgtIdx] = arr[i];
			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}
		
	}
	
	
	private static boolean check() {
		for(int i=0; i<tgt.length-1; i++) {
			if(tgt[i]==tgt[i+1]) {
				return false;
			}
		}
		return true;
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 12432kb| 336ms|