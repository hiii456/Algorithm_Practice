package implement.boj20164;

import java.io.*;
import java.util.*;

public class BOJ_20164_G5_홀수_홀릭_호석 {
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int n;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//n = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int cnt = 0;
		split(str,cnt);
		
		System.out.println(min + " " + max);
		
	}
	private static void split(String str,int cnt) {
		for(int i=0; i<str.length(); i++) {
			int tmp = str.charAt(i) - '0';
			if(tmp%2 == 1)	cnt++;
		}
		
		if(str.length() == 1) {
			max = Math.max(max, cnt);
			min = Math.min(min, cnt);
			return;
		}else if(str.length() == 2) {
			int tmp1 = Integer.parseInt(str.substring(0,1));
			int tmp2 = Integer.parseInt(str.substring(1,2));
			int sum = tmp1 + tmp2;
			
			split(String.valueOf(sum),cnt);
		}else if(str.length() >= 3) {
			for(int i=0; i<str.length()-2; i++) {
				for(int j=i+1; j<str.length()-1; j++){
					int tmp1 = Integer.parseInt(str.substring(0,i+1));
					int tmp2 = Integer.parseInt(str.substring(i+1,j+1));
					int tmp3 = Integer.parseInt(str.substring(j+1,str.length()));
					
					int sum = tmp1 + tmp2 + tmp3;
					
					split(String.valueOf(sum),cnt);
				}
			}
		}
		
	}

}
