## BOJ 1759 암호만들기 
- BackTracking 
- 🥇 Gold5
- 🔗[암호만들기 문제 바로가기](https://www.acmicpc.net/problem/1759)



## 풀이

조합을 이용해서 문제를 풀었다! 
문자열 문제를 풀때는 StringBuilder를 사용하자,,,, 후,,,,,,

## 소스코드
~~~java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759_G5_암호만들기 {
	static int L,C;
	static char[] arr;
	static char[] tgt;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		tgt = new char[L];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		
		comb(0,0);
		

	}
	private static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == L) {
			StringBuilder sb = new StringBuilder();
			int c_cnt = 0;
			int v_cnt = 0;
			for(int i=0; i<L; i++) {
				sb.append(tgt[i]);
				if(tgt[i]=='a' || tgt[i]=='e' || tgt[i]=='i' || tgt[i]=='o' || tgt[i]=='u') {
					c_cnt++;
				}else {
					v_cnt++;
				}
			}
			
			if(c_cnt>=1 && v_cnt>=2) {
				System.out.println(sb.toString());
			}
			return;
		}
		
		for(int i=srcIdx; i<C; i++) {
			tgt[tgtIdx] = arr[i];
			comb(i+1, tgtIdx+1);
		}
		
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 11584kb| 100ms|