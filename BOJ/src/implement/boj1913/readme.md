## BOJ - ๋ฌํฝ์ด 
- Silver 4 
- Implement 
๐[๋ฌํฝ์ด ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1913)



## ํ์ด

์ด ๋ฌธ์ ๋ ๋ฐฐ์ด์ ์ซ์๊ฐ ์ฑ์์ง๋ ๊ฒ์ ์์๋๋ก ๊ตฌํํ๋ฉด ๋๋ค.
๋จผ์  ๋ฐฐ์ด์ ๊ฐ์ฅ ํฐ ์๋ ํญ์ 0ํ0์ด์ ์์นํ๋ n*n์ด๋ค. ๊ทธ๋ฆฌ๊ณ  ๊ฐ์ฅ ์์ ์๋ 1์ด๋ค.
๋ฐ๋ผ์ n*n๊ฐ์ด 1์ด ๋ ๋๊น์ง ๋ฐ๋ณต๋ฌธ์ ์คํํ๋ค.
๋๋ โ โ โ โ ๋ฐฉํฅ์ผ๋ก ์ฑ์์ฃผ์๋ค.

~~~JAVA
		while(cnt>0) {
			for(int i=r; i<limit; i++) {
				arr[i][c] = cnt--;
			}
			r = limit-1;
			for(int i=c+1; i<limit; i++) {
				arr[r][i] = cnt--;
			}
			c = limit-1;
			for(int i=r-1; i>=time; i--) {
				arr[i][r] = cnt--;
			}
			r = time;
			for(int i=c-1; i>time; i--) {
				arr[r][i] = cnt--;
			}
			time++;
			limit--;
			r = time;
			c = time;
			
		}
~~~

๊ทธ๋ฆฌ๊ณ  ๋ฐฐ์ด์ println() ๋ฉ์๋๋ก ๋ฐฐ์ด์ ์ ์ฅ๋ ๊ฐ์ ์ผ์ผํ ์ถ๋ ฅํด์ค๋ ๋์ง๋ง ํจ์จ์ ์ธ ๋ฉ๋ชจ๋ฆฌ ์ฌ์ฉ์ ์ํด StringBuilder๋ฅผ ์ฌ์ฉํ์๋ค.

~~~java
		StringBuilder sb = new StringBuilder();
		int answerR=0, answerC=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(num==arr[i][j]) {
					answerR=i+1;
					answerC=j+1;
				}
				sb.append(arr[i][j] +" ");
			}
			sb.append("\n");
		}
~~~


## ์์ค์ฝ๋
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1913_S4_๋ฌํฝ์ด {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		int cnt = n*n;
		int r = 0, c = 0;
		int time  = 0;
		int limit = n;
		
		while(cnt>0) {
			for(int i=r; i<limit; i++) {
				arr[i][c] = cnt--;
			}
			r = limit-1;
			for(int i=c+1; i<limit; i++) {
				arr[r][i] = cnt--;
			}
			c = limit-1;
			for(int i=r-1; i>=time; i--) {
				arr[i][r] = cnt--;
			}
			r = time;
			for(int i=c-1; i>time; i--) {
				arr[r][i] = cnt--;
			}
			time++;
			limit--;
			r = time;
			c = time;
			
		}

		StringBuilder sb = new StringBuilder();
		int answerR=0, answerC=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(num==arr[i][j]) {
					answerR=i+1;
					answerC=j+1;
				}
				sb.append(arr[i][j] +" ");
			}
			sb.append("\n");
		}
		sb.append(answerR+" "+answerC);
		System.out.println(sb.toString());
	}

}
~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
|11544KB	|80ms|