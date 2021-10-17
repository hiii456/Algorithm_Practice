## BOJ 13305 주유소 
- Greedy
- 🥈 Silver 4 
- 🔗[주유소 문제 바로가기](https://www.acmicpc.net/problem/13305)



## 풀이

그리디 알고리즘! 어떻게 풀이할건지 생각하는게 포인트 같다.
가격의 범위가 int 형을 벗어나기 때문에 long 타입으로 선언해야 한다.
처음에 int로 선언하여 답은 맞았으나 58점이 나왔고, long타입으로 바꾼 후 100점을 맞을 수 있었다.


## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {
	static int N;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] len = new int[N-1];
		long[] cost = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 기름 가격을 내림차순으로 만든다.
		for(int i=1; i<N; i++) {
			if(cost[i]>cost[i-1]) {
				cost[i] = cost[i-1];
			}

		}
		
		long ans = 0;
		for(int i=0; i<N-1; i++) {
			ans += cost[i] * len[i];
		}
		
		System.out.println(ans);
		

	}

}

~~~

## 결과 

100점 

| 메모리  | 시간 |
|----|----|
| 41000kb| 364ms|