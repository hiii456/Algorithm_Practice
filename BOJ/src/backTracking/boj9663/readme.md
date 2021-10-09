## BOJ 9663 N-Queen
- BackTracking
- 🥇 Gold5
- 🔗[트리 문제 바로가기](https://www.acmicpc.net/problem/1068)



## 풀이

엄청난 시간,, N-Queen이 갑자기 기억나지 않아서 다시 풀어본 문제! 

## 소스코드
~~~java

import java.io.*;

public class BOJ_9663_G1_N_Queen {
	static int N,answer;
	static int[] cols;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			cols = new int[N];
			cols[0] = i;
			backTracking(1);
		}
		
		System.out.println(answer);

	}
	private static void backTracking(int col) {
		if(col==N) {
			answer++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			cols[col] = i;
			if(isPossible(col)) {
				backTracking(col+1);
			}
		}
		
	}
	private static boolean isPossible(int col) {
		for(int i=0; i<col; i++) {
			if(cols[i]==cols[col] || Math.abs(i-col) == Math.abs(cols[i]-cols[col]))
				return false;
		}
		return true;
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 12176kb| 5844ms|