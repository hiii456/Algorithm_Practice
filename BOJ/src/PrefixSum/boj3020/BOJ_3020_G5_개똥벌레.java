package PrefixSum.boj3020;

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
