## BOJ - 숫자 정사각형 
- Silver 3 
- bruteforce 
🔗[숫자 정사각형 문제 바로가기](https://www.acmicpc.net/problem/1051)



## 풀이

이 문제는 배열에서 정사각형을 만들 수 있는 모든 경우의 수를 통해 최대 넓이를 구하는 방식으로 풀었다.

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1051_S3_숫자_정사각형 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int min = Math.max(N,M);
		int max = 1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int k=0; k<min; k++) {
					if(i+k<N && j+k<M)
						if(arr[i][j] == arr[i][j+k] && arr[i][j] == arr[i+k][j+k] && arr[i][j] == arr[i+k][j]) {
							max = Math.max(max, (k+1)*(k+1));
					}
				}
			}
		}
		
		System.out.println(max);

	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11816KB	|84ms|