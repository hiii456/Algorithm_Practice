## BOJ - ๋จ์ด ์ํ 
- Gold 4 
- greedy
๐[๋จ์ด ์ํ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1339)



## ํ์ด

๋จ์ด๋ฅผ ํตํด ์ํ๋ฒณ์ ์์์ ์ซ์๋ก ๋ฐ๊พธ์ด ์ต๋๊ฐ์ ๊ตฌํ๊ธฐ ์ํด์๋ ๋ฌธ์์ด์ ๊ฐ ์ํ๋ฒณ์ ์๋ฆฟ์๊ฐ ๋์ ์์๋๋ก 9~0์ ์์ฐจ์ ์ผ๋ก ๋ถ์ฌํ์ฌ ๊ฐ์ ๊ตฌํด์ผํ๋ค.
์๋ฅผ๋ค์ด ๋ฌธ์๊ฐ 'GCF' ์ธ๊ฒฝ์ฐ, ์ฐจ๋ก๋๋ก G์ 100, C์ 10, F์ 1์ ๋ถ์ฌํด์ผํ๋ค.
๋ฐ๋ผ์ ๋จ์ด๋ฅผ ์๋ ฅ๋ฐ์ผ๋ฉด, ๋จ์ด์ ๊ธธ์ด๋งํผ 10์ ์ ๊ณฑ์ ํ์ฌ ํฌ๊ธฐ๊ฐ 26์ธ (A~Z๋ 26๊ฐ) alphabet๋ฐฐ์ด์ ์ฐจ๋ก๋ก ๋ํ์ฌ ๋์ ์๋ฅผ ๋ถ์ฌํด์ผํ๋ ์์๋๋ก ์ ๋ ฌ ์ํจ๋ค.

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

๋ค์ ๋์ ์์๋๋ก ๋ฐ๋ณต๋ฌธ์ ๋๋ฉฐ, 9๋ถํฐ 0๊น์ง ์ซ์๋ฅผ ๋ถ์ฌํ์ฌ ํด๋น alphabet์ ์ ์ฅ๋ ๊ฐ๊ณผ ๋ถ์ฌํ ์ซ์๋ฅผ ๊ณฑํ์ฌ ๊ฒฐ๊ณผ๋ฅผ ๊ตฌํ๋ค.

~~~java
		int sum = 0;
		int num = 9;
		for(int i=alphabet.length-1; i>=0; i--) {
			if(alphabet[i] == 0)	break;
			sum += alphabet[i]*num--;
		}
~~~


## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1339_G4_๋จ์ด_์ํ {
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

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|11544KB	|76ms|