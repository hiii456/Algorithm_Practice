package comb.boj13558;

import java.io.*;
import java.util.*;

public class BOJ_13558_G2_등차수열의_개수 {
	static int N;
	static long cnt;
	static long[] src;
	static int[] tgt;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		src = new long[N];
		tgt = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		
		comb(0,0);
		
		System.out.println(cnt);
		
	}
	private static void comb(int srcIdx, int tgtIdx) {
		if(tgtIdx == tgt.length) {
			check();
			return;
		}
		
		for(int i=srcIdx; i<N; i++) {
			tgt[tgtIdx] = i;
			comb(i+1,tgtIdx+1);
		}
		
	}
	private static void check() {
		long tmp1 = src[tgt[1]] - src[tgt[0]];
		long tmp2 = src[tgt[2]] - src[tgt[1]];
		
		if(tmp1 == tmp2) {
			cnt++;
		}
		
	}

}
