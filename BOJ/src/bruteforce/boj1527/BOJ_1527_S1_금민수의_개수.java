package bruteforce.boj1527;

import java.io.*;
import java.util.*;

public class BOJ_1527_S1_금민수의_개수 {
	static int cnt = 0;
	static int a,b;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		dfs(0);
		
		System.out.println(cnt);
	}

	private static void dfs(long n) {
		// n의 기저조건, 만약 a~b 범위에 있다면 count 
		if(n>b)	return;
		if(n>=a && n<=b)	cnt++;
		
		dfs(n*10+4);
		dfs(n*10+7);
		
	}

}
