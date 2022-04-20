## BOJ - 종이의 개수 
- Silver 2
- dfs, divide and conquer 
🔗[종이의 개수 문제 바로가기](https://www.acmicpc.net/problem/1780)



## 풀이

분할정복을 이용하여 문제에 나온 범위 나누는 작업과 종이 내의 숫자가 다 일치하는지 확인하는 메소드를 각각 만들어 문제를 해결하였다.

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1780_S2_종이의_개수 {
	static int n;
	static int[][] arr;
	static int zero = 0,one = 0,minus = 0;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr =new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0,0,n);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);

	}
	public static void cut(int startr,int startc,int size) {
		if(check(startr,startc,size)) {
			if(arr[startr][startc] == -1) minus++;
			else if(arr[startr][startc] == 0)	zero++;
			else if(arr[startr][startc] == 1)	one++;
			
			return;
		}
		
		cut(startr,startc,size/3);
		cut(startr + size/3,startc,size/3);
		cut(startr + size/3*2,startc,size/3);
		cut(startr,startc+ size/3,size/3);
		cut(startr,startc+ size/3*2,size/3);
		cut(startr+ size/3,startc+ size/3,size/3);
		cut(startr+ size/3,startc+ size/3*2,size/3);
		cut(startr+ size/3*2,startc+ size/3,size/3);
		cut(startr+ size/3*2,startc+ size/3*2,size/3);
		
	}
	public static boolean check(int r,int c,int size) {
		for(int i=r; i<size+r; i++) {
			for(int j=c; j<size+c; j++) {
				if(arr[r][c] != arr[i][j])	return false;
			}
		}
		return true;
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|319716KB	|848ms|