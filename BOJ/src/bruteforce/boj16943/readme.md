## BOJ - 숫자 재배치 
- Silver 1 
- bruteforce 
🔗[숫자 재배치 문제 바로가기](https://www.acmicpc.net/problem/16943)



## 풀이

이 문제는 순열을 이용해서 푸는 문제였다. 사실 나는 순열문제를 풀때 2개의 배열을 사용해서 문제를 푸는데 그렇게 되면 반복문을 더 많이 사용해야되서 시간복잡도에 좋지 않을 것이라 생각했다.

따라서 숫자 재배치를 할때, 이미 방문한 경우, 맨 처음 숫자가 0으로 시작하는 경우, 재배치한 값이 b보다 크거나 같을 경우을 제외하고 순열을 진행해주었다.

~~~java
		for(int i=0; i<src.length; i++) {
			if(checked[i])	continue;
			if(cnt == 0 && src[i] == 0)	continue;
			if(sum*10 + src[i]>=b)	continue;
			checked[i] = true;
			perm(sum*10 + src[i],cnt+1);
			checked[i] = false;
		}
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_16943_S1_숫자_재배치 {
	static String a;
	static int b;
	static int max = -1;
	static int[] src;
	static int[] tgt;
	static boolean[] checked;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		
		src = new int[a.length()];
		tgt = new int[a.length()];
		checked = new boolean[a.length()];
		
		for(int i=0; i<a.length(); i++) {
			src[i] = a.charAt(i) - '0';
		}
		
		perm(0,0);
		
		System.out.println(max);

	}
	private static void perm(int sum,int cnt) {
		if(cnt == src.length) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=0; i<src.length; i++) {
			if(checked[i])	continue;
			if(cnt == 0 && src[i] == 0)	continue;
			if(sum*10 + src[i]>=b)	continue;
			checked[i] = true;
			perm(sum*10 + src[i],cnt+1);
			checked[i] = false;
		}
		
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11992KB	|136ms|