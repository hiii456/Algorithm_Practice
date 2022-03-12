## BOJ - 체스판 다시 칠하기 
- Silver 5 
- bruteforce
🔗[체스판 다시 칠하기 문제 바로가기](https://www.acmicpc.net/problem/1018)



## 풀이



## 소스코드
~~~java
import java.util.*;
import java.io.*;

public class BOJ_1018_S5_체스판_다시_칠하기 {
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[n][m];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			arr[i] = str.toCharArray();
		}
		
		int min = Integer.MAX_VALUE;
		// 8*8 체스판을 만들어야 하므로 n-8. m-8 까지 탐색 
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int cnt = 0;
				char value = arr[i][j];
				for(int r=i; r<i+8; r++) {
					for(int c=j; c<j+8; c++) {
						if(arr[r][c]!= value) {
							cnt++;
						}
						
						if(value == 'W')	value = 'B';
						else if(value == 'B')	value = 'W';
					}
					if(value == 'W')	value = 'B';
					else if(value == 'B')	value = 'W';
				}
				
				min = Math.min(min, Math.min(cnt, 64-cnt));
			}
		}
		
		System.out.println(min);

	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11776KB	|88ms|