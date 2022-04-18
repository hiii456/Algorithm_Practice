## BOJ - 색종이 만들기 
- Silver 3 
- dfs, divide and conquer 
🔗[색종이 만들기 문제 바로가기](https://www.acmicpc.net/problem/2630)



## 풀이

이 문제는 프로그래머스의 쿼드압축 후 개수세기 문제와 똑같은 문제로 분할정복의 개념을 응용하여 문제를 풀었다.

## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_2630_S3_색종이_만들기 {
	static int white = 0, blue = 0;
	static int[][] paper;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		div(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}

	public static void div(int startr,int startc,int size) {
		if(check(startr,startc,size)) {
			if(paper[startr][startc] == 0) {
				white++;
			}else if(paper[startr][startc] == 1) {
				blue++;
			}
			return;
		}
		
		div(startr,startc,size/2);
		div(startr + size/2,startc,size/2);
		div(startr,startc+ size/2,size/2);
		div(startr+ size/2,startc+ size/2,size/2);
	}

	private static boolean check(int r, int c,int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(paper[r][c] != paper[i][j])	return false;
				
			}
		}
		return true;
	}
}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|13168KB	|116ms|