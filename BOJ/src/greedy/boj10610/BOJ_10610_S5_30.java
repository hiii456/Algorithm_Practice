package greedy.boj10610;

import java.io.*;
import java.util.*;

public class BOJ_10610_S5_30 {
	static int[] numCnt = new int[10];
	static long total = 0;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String n = br.readLine();
		
		for(int i=0; i<n.length(); i++) {
			int idx = Integer.parseInt(n.substring(i,i+1));
			numCnt[idx]++;
			total += idx;
		}
		
		if(total % 3 !=0 || !n.contains("0")) {
			System.out.println("-1");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=9; i>=0; i--) {
			while(numCnt[i]>0) {
				sb.append(i);
				numCnt[i]--;
			}
		}
		
		System.out.println(sb.toString());
	}

}
