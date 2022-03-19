## BOJ - 단어 수학 
- Gold 4 
- greedy
🔗[단어 수학 문제 바로가기](https://www.acmicpc.net/problem/1339)



## 풀이

단어를 통해 알파벳을 임의의 숫자로 바꾸어 최댓값을 구하기 위해서는 문자열의 각 알파벳의 자릿수가 높은 순서대로 9~0을 순차적으로 부여하여 값을 구해야한다.
예를들어 문자가 'GCF' 인경우, 차례대로 G에 100, C에 10, F에 1을 부여해야한다.
따라서 단어를 입력받으면, 단어의 길이만큼 10에 제곱을 하여 크기가 26인 (A~Z는 26개) alphabet배열에 차례로 더하여 높은 수를 부여해야하는 순서대로 정렬 시킨다.

~~~java
		for(int i=0; i<n; i++) {
			word[i] = br.readLine();
			int tmp = (int) Math.pow(10, word[i].length()-1);
			for(int j=0; j<word[i].length(); j++) {
				alphabet[word[i].charAt(j)-'A'] += tmp;
				tmp /= 10;
			}
		}
		
		Arrays.sort(alphabet);
~~~

다음 높은 순서대로 반복문을 돌며, 9부터 0까지 숫자를 부여하여 해당 alphabet에 저장된 값과 부여한 숫자를 곱하여 결과를 구한다.

~~~java
		int sum = 0;
		int num = 9;
		for(int i=alphabet.length-1; i>=0; i--) {
			if(alphabet[i] == 0)	break;
			sum += alphabet[i]*num--;
		}
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1339_G4_단어_수학 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[] alphabet = new int[26];
		String[] word = new String[n];
			
		for(int i=0; i<n; i++) {
			word[i] = br.readLine();
			int tmp = (int) Math.pow(10, word[i].length()-1);
			for(int j=0; j<word[i].length(); j++) {
				alphabet[word[i].charAt(j)-'A'] += tmp;
				tmp /= 10;
			}
		}
		
		Arrays.sort(alphabet);

		int sum = 0;
		int num = 9;
		for(int i=alphabet.length-1; i>=0; i--) {
			if(alphabet[i] == 0)	break;
			sum += alphabet[i]*num--;
		}
		
		System.out.println(sum);

	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11544KB	|76ms|