## BOJ 2458 ํค ์์ 
- FloydWarshall
- ๐ฅ Gold 4

## ํ์ด

์ด ๋ฌธ์ ๋ ๋ณด์๋ง์ ํ๋ก๊ทธ๋๋จธ์ค์ [์์](https://programmers.co.kr/learn/courses/30/lessons/49191) ๋ฌธ์ ๊ฐ ๋ ์ฌ๋๋ค. ๋ธ๋๊ฐ์ ์ฐ๊ฒฐ ์ ๋ฌด์ ๊ดํด ์๊ณ  ์ถ์๋ ํ๋ก์ด๋ ์์ฌ์ ํ๋ฉด ์ฝ๊ฒ ๊ตฌํ  ์ ์๊ธฐ ๋๋ฌธ์ ์ด ๋ฌธ์ ๋ ํ๋ก์ด๋ ์์ฌ์ ์ด์ฉํ์ฌ ๋ฌธ์ ๋ฅผ ํ์๋ค. 

๋จผ์  ํ,์ด์ ํฌ๊ธฐ๊ฐ N+1์ธ ํฌ๊ธฐ์ 2์ฐจ์ ๋ฐฐ์ด์ ๋ง๋ค์ด Arrays.fill์ ์ด์ฉํ์ฌ INF๊ฐ์ ๋ฃ์ด์ค๋ค.
๊ทธ๋ฆฌ๊ณ  ํค ์์๋ฅผ ์ ์ ์๋ ๋ฐฐ์ด์๋ 1์ ๋ฃ์ด์ค๋ค. ๊ทธ๋ฆฌ๊ณ  M๋ฒ๋งํผ ๋ฐ๋ณต๋ฌธ์ ๋๋ ค ๋ชจ๋  ์ ์ ์์ ๋ชจ๋  ์ ์ ์ผ๋ก ๊ฐ ์ ์๋ ์ต๋จ ๊ฒฝ๋ก๋ฅผ ๊ตฌํ๋ค.

3์ค for๋ฌธ์ด ๋๋๊ณ , ๋ฐฐ์ด์ INF๊ฐ ์๋ค๋ฉด ์ ์ ๊ฐ ์ด์ด์ง์ง ์์๋ค๋ ๋ป์ด๋ฏ๋ก ๊ฐ ์ ์ ์์ ์ด์ด์ ธ์๋ ์ ์ ๋ง count ํด์ค๋ค.


~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_2458_G4_ํค_์์ {
	static int N,M;
	static final int INF = 9999999;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N+1][N+1];
		
		// ๋ฐฐ์ด์ ๋ชจ๋  ๊ฐ์ INF๋ก ์ฑ์ด๋ค. ์ด๊ฒ์ ์ธ์ ํ์ง ์๋ ๊ฒฝ์ฐ๋ฅผ ๊ตฌ๋ถํ๊ธฐ ์ํจ์ด๋ค.
		for (int[] arr : matrix) {
			Arrays.fill(arr, INF);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// ์๋ก ํค๋ฅผ ๋น๊ตํ  ์ ์์ผ๋ฉด 1์ ๋ฃ๋๋ค.
			matrix[a][b] = 1;
			
		}
		
		// ๊ฒฝ์ ์ง 
		for(int k=1; k<=N; k++) {
			// ์ถ๋ฐ์ง 
			for(int i=1; i<=N; i++) {
				// ๋ง์ฝ ๊ฒฝ์ ์ง์ ์ถ๋ฐ์ง๊ฐ ๊ฐ๋ค๋ฉด continue
				if(k==i)	continue;
				// ๋์ฐฉ์ง 
				for(int j=1; j<=N; j++) {
					// ๋์ฐฉ์ง๊ฐ ๊ฒฝ์ ์ง๋ ์ถ๋ฐ์ง์ ๊ฐ๋ค๋ฉด continue
					if(j==i || k==j)	continue;
					// ๋ง์ฝ ๊ฒฝ์ ์ง๋ฅผ ๊ฑฐ์ณ์ ๊ฐ๋ ๊ฒ๋ณด๋ค ๊ฐ์ค์น๊ฐ ๋ ํฌ๋ค๋ฉด ๊ฐ์ ๊ฐฑ์  
					if(matrix[i][j]>matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
					
				}
				
			}
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			boolean isTrue = true;
			for(int j=1; j<=N; j++) {
				if(i==j)	continue;
				if(matrix[i][j]==INF && matrix[j][i]==INF) {
					isTrue = false;
					break;
				}
			}
			
			if(isTrue) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
		
		

	}

}
~~~


|๋ฉ๋ชจ๋ฆฌ | ์๊ฐ |
|-----|-----|
|37364kb|	692ms|

