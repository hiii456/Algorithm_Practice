package bruteforce.boj6603;

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
