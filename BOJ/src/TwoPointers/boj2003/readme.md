## BOJ 2003 ์๋ค์ ํฉ2 
- Two Pointers
- ๐ฅ Silver 3

## ํ์ด

์ด ๋ฌธ์ ๋ Two Pointers๋ฅผ ์ดํดํ  ์ ์๋ ๊ธฐ๋ณธ์ ์ธ ๋ฌธ์ ์ด๊ธฐ ๋๋ฌธ์ Two Pointers๋ฅผ ์ฌ์ฉํ์ฌ ๋ฌธ์ ๋ฅผ ํ์๋ค. Two Pointers์์ ์ค์ํ ๊ฒ์ ๋จผ์  ํฌ์ธํฐ ๋๊ฐ๋ฅผ ์ค๋นํ๊ณ , ๋งจ ์ฒ์์ 0์ผ๋ก ์ค์ ํด์ค๋ค. ์ ๋ ์ฒ์์ s,e๋ก ์ค์ ์ ํด๋จ๋๋ฐ ์ฌ๊ธฐ์ s<=e์ฌ์ผ ํ๋ค.

๊ทธ๋ค์ s<N์ผ ๋์ ๋ง์ฝ ํ์ฌ ๋ถ๋ถํฉ์ด M ์ด์์ด๊ฑฐ๋ e=N์ด๋ฉด s++, ๊ทธ๋ ์ง ์๋ค๋ฉด e++, ํ์ฌ ๋ถ๋ถํฉ M๊ณผ ๊ฐ๋ค๋ฉด result++๋ฅผ ํด์ฃผ์ด ๊ฒฐ๊ณผ๋ฅผ ๊ตฌํ์๋ค.


~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2003_์_๋ค์_ํฉ2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		int result = 0;
		int sum = 0;
		
		while(true) {
			if(sum>=M) {
				sum -= arr[s++];
			}else if(e == N) {
				break;
			}else {
				sum += arr[e++];
			}
			
			if(sum==M) {
				result++;
			}
		}
		
		System.out.println(result);

	}

}
~~~



|๋ฉ๋ชจ๋ฆฌ | ์๊ฐ |
|-----|-----|
|14420kb|124ms|