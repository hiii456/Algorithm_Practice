package dp.boj16500;

import java.io.*;
import java.util.*;

public class BOJ_16500_S2_문자열_판별 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dp = new int[101];
		
		HashSet<String> A = new HashSet<>();
		
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			A.add(br.readLine());
		}
		
		for(int i=str.length()-1; i>=0; i--) {
			for(int j=i+1; j<str.length(); j++) {
				if(dp[j]==1) {
					if(A.contains(str.substring(i, j))){
						dp[i] = 1;
					}
				}
			}
			if(A.contains(str.substring(i))) {
				dp[i] = 1;
			}
		}
		
		System.out.println(dp[0]);
		
		
	}

}
