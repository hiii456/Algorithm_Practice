package bruteforce.boj16943;

import java.io.*;
import java.util.*;

public class BOJ_16943_S1_숫자_재배치 {
	static String a;
	static int b;
	static int max = -1;
	static int[] src;
	static int[] tgt;
	static boolean[] checked;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = st.nextToken();
		b = Integer.parseInt(st.nextToken());
		
		src = new int[a.length()];
		tgt = new int[a.length()];
		checked = new boolean[a.length()];
		
		for(int i=0; i<a.length(); i++) {
			src[i] = a.charAt(i) - '0';
		}
		
		perm(0,0);
		
		System.out.println(max);

	}
	private static void perm(int sum,int cnt) {
		if(cnt == src.length) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i=0; i<src.length; i++) {
			if(checked[i])	continue;
			if(cnt == 0 && src[i] == 0)	continue;
			if(sum*10 + src[i]>=b)	continue;
			checked[i] = true;
			perm(sum*10 + src[i],cnt+1);
			checked[i] = false;
		}
		
	}

}
