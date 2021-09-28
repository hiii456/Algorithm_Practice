## BOJ 14889 스타트와 링크 
- BackTracking 
- 🥈 Silver3 
- 🔗[스타트와 링크 문제 바로가기](https://www.acmicpc.net/problem/14889)



## 풀이

백트래킹이자 조합 문제인 스타트와 링크를 다시 풀어보았다..! 
너무 오랜만에 풀어서 조합을 구하는 로직이 기억이 안났다.....ㅎ....


## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14889_S3_스타트와_링크 {
	static int N;
	static int result = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] start;
	static boolean[] check;
	static int[] link;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		start = new int[N/2];
		check = new boolean[N+1];
		link = new int[N/2];
		
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
				
			}
		}
		
		comb(1,0);
		
		System.out.println(result);

	}
	private static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx==N/2) {
			int idx = 0;
			for(int i=1; i<=N; i++) {
				if(!check[i-1]) {
					link[idx] = i;
					idx++;
				}
			}

			calc();
			
			return;
		}
		
		for(int i=srcIdx; i<=N; i++) {
			start[tgtIdx] = i;
			check[i-1] = true;
			comb(i+1, tgtIdx+1);
			check[i-1] = false;
		}
		
	}
	private static void calc() {
		int startSum = 0;
		int linkSum = 0;
		
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				startSum += arr[start[i]][start[j]];
				linkSum += arr[link[i]][link[j]];
			}
		}
		
		result = Math.min(result, Math.abs(startSum-linkSum));
	
		
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 14360kb| 200ms|