## BOJ - 로또 
- Silver 2 
- bruteforce 
🔗[로또 문제 바로가기](https://www.acmicpc.net/problem/6603)



## 풀이

브루트포스 중 조합의 기본 문제였다.

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_S2_6603_로또 {
	static int[] src;
	static int[] tgt;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			else {
				src = new int[n];
				tgt = new int[6];
				for(int i=0; i<n; i++) {
					src[i] = Integer.parseInt(st.nextToken());
				}
				
				comb(0,0);
				System.out.println();
			}
		}

	}
	public static void comb(int srcIdx,int tgtIdx){
		if(tgtIdx == 6) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<tgt.length; i++) {
				sb.append(tgt[i]).append(" ");
			}
			System.out.println(sb.toString());
			return;
		}
		
		for(int i=srcIdx; i<src.length; i++) {
			tgt[tgtIdx] = src[i];
			comb(i+1,tgtIdx+1);
		}
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|13028KB	|160ms|