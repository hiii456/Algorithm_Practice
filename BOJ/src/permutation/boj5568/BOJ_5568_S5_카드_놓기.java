package permutation.boj5568;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5568_S5_카드_놓기 {
	static int n,k;
	static int[] src;
	static int[] tgt;
	static boolean[] selected;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		src = new int[n];
		selected = new boolean[n];
		tgt = new int[k];
		
		for(int i=0; i<n; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		
		perm(0);
		
		System.out.println(hs.size());
		

	}
	private static void perm(int tgtIdx) {
		if(tgtIdx == k) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<tgt.length; i++) {
				sb.append(tgt[i]);
			}
			int tmp = Integer.parseInt(sb.toString());
			hs.add(tmp);
			return;
		}
		
		for(int i=0; i<src.length; i++) {
			if(selected[i])	continue;
			
			tgt[tgtIdx] = src[i];
			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}
		
	}

}
