## BOJ 2512 ์์ฐ 
- BinarySearch
- ๐ฅ Silver 3

## ํ์ด

์ด ๋ฌธ์ ๋ ์ด๋ถํ์์ ์ด์ฉํ์ฌ ํ์๋ค. ์์ฐ์ ์ต์๊ฐ์ 1, ์ต๋๊ฐ์ ์ง๋ฐฉ์ ์์ฐ์์ฒญ ์ค ๊ฐ์ฅ ๋์ ์์ฐ์ด๋ฏ๋ก arr ๋ฐฐ์ด์ ์ ๋ ฌํ, arr[N-1]๋ก ๋์๋ค. 

๊ทธ ๋ค์ start๊ณผ end์ ์ค๊ฐ๊ฐ mid๋ฅผ ๋์ด arr์ ๊ฐ์ด mid๋ณด๋ค ์๊ฑฐ๋ ๊ฐ๋ค๋ฉด arr๊ฐ ๊ทธ๋๋ก, mid๋ณด๋ค ํฌ๋ฉด mid๊ฐ์ sum์ ๋์ ํฉ ์์ผ์ฃผ์ด M๊ณผ ๋น๊ตํ์๋ค. ๋ง์ผ sum์ด M๋ณด๋ค ์๊ฑฐ๋ ๊ฐ๋ค๋ฉด mid๋ ๋ ์ปค๋ ๋๋ฏ๋ก start์ ๊ฐ์ mid + 1์ผ๋ก ๋ฐ๊พธ์ด์ฃผ๊ณ , ๋ง์ฝ M๋ณด๋ค ํฌ๋ค๋ฉด mid๋ ๋ ์์ ๋ฒ์์์ ์ฐพ์์ผ ํ๋ฏ๋ก end์ ๊ฐ์ mid - 1๋ก ๋ฐ๊พธ์ด์ค๋ค. ๊ทธ๋์ ๊ตฌํ ๋ฒ์ ์ค ์ต๋๊ฐ์ end์ ์ ์ฅ๋์ด ์์ผ๋ฏ๋ก end๋ฅผ ์ถ๋ ฅํ๋ค.


~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2512_์์ฐ {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end= arr[N-1];
		
		while(start<=end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]<=mid) {
					sum += arr[i];
				}else {
					sum += mid;
				}
			}
			
			if(sum<=M) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);

	}

}
~~~


|๋ฉ๋ชจ๋ฆฌ | ์๊ฐ |
|-----|-----|
|14052kb|128ms|