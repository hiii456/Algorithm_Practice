## BOJ - 달팽이 
- Silver 4 
- Implement 
🔗[달팽이 문제 바로가기](https://www.acmicpc.net/problem/1913)



## 풀이

이 문제는 배열에 숫자가 채워지는 것을 순서대로 구현하면 된다.
먼저 배열의 가장 큰 수는 항상 0행0열에 위치하는 n*n이다. 그리고 가장 작은 수는 1이다.
따라서 n*n값이 1이 될때까지 반복문을 실행한다.
나는 ↓ → ↑ ← 방향으로 채워주었다.

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

그리고 배열은 println() 메소드로 배열에 저장된 값을 일일히 출력해줘도 되지만 효율적인 메모리 사용을 위해 StringBuilder를 사용하였다.

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


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1913_S4_달팽이 {

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

## 결과 

| 메모리  | 시간 |
|----|----|
|11544KB	|80ms|