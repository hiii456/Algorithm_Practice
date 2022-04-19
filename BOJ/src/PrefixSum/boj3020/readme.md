## BOJ - 개똥벌레 
- Gold 5  
- Prefix Sum 
🔗[개똥벌레 문제 바로가기](https://www.acmicpc.net/problem/3020)



## 풀이

이 문제는 누적합을 이용해서 푸는 문제이다. 나는 해결방법을 찾는 과정에서 시간이 오래걸렸다.
먼저 입력으로 들어오는 석순과 종유석의 갯수를 count 해준다.

~~~java
		for(int i=0; i<n/2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
~~~

그리고 누적합을 이용하여 배열에 해당 인덱스 이하의 석순, 종유석의 누적합을 저장한다.

~~~java
		for(int i=1; i<h+1; i++) {
			top[i] += top[i-1];
			bottom[i] += bottom[i-1];
		}
~~~

만약 세번째 구간을 지나게 되면, 파괴되는 석순의 갯수 = 전체 석순의 갯수 - 첫번째 구간부터 두번째 구간의 석순 누적합 이고,
파괴되는 종유석의 갯수 = 전체 종유석의 갯수 - 네번째부터 마지막 구간의 종유석 이다.
즉, 누적합을 이용헤 전체의 갯수에서 깨지지 않는 석순과 종유석을 구하고 해당 최솟값에 해당하면 count을 해준다.

~~~java
		for(int i=1; i<h+1; i++) {
			int crush = 0;	// 부딪히는 갯수 
		
			crush += bottom[h] - bottom[i-1];
			crush += top[h] - top[h-i];
			
			if(min>crush) {
				min = crush;
				cnt = 1;
			}else if(min == crush)	cnt++;
		}
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_3020_G5_개똥벌레 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] bottom = new int[h+1];		// 높이에 따른 석순의 갯수 
		int[] top = new int[h+1];			// 높이에 따른 종유석의 갯수 
		
		for(int i=0; i<n/2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
		
		// 누적합을 통해 해당 인덱스의 높이 이하의 종유석, 석순 누적합을 가지게 된다.
		for(int i=1; i<h+1; i++) {
			top[i] += top[i-1];
			bottom[i] += bottom[i-1];
		}
		
		int min = n;
		int cnt = 0;
		for(int i=1; i<h+1; i++) {
			int crush = 0;	// 부딪히는 갯수 
		
			crush += bottom[h] - bottom[i-1];
			crush += top[h] - top[h-i];
			
			if(min>crush) {
				min = crush;
				cnt = 1;
			}else if(min == crush)	cnt++;
		}
		
		System.out.println(min + " " + cnt);
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|29652KB	|236ms|