package dp.boj3687;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3687_G2_성냥개비 {
	static long[] dp;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		dp = new long[101];
		Arrays.fill(dp, Long.MAX_VALUE);
		
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		String[] add= {"1","7","4","2","0","8"};
		
		// 최솟값 구하기 
		for(int i=9; i<=100; i++) {
			for(int j=2; j<=7; j++) {
				String tmp = dp[i-j] + add[j-2];
				dp[i] = Math.min(dp[i],Long.parseLong(tmp));
				
			}
		}
		
		// 최대값 구하기 
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			long min = dp[N];
			
			StringBuilder sb = new StringBuilder();
			long a = N/2;
			long b = N%2;
			// 짝수 
			if(b==0) {
				sb.append("1");
			}
			// 홀수 
			else {
				sb.append("7");
			}
			
			for(int i=1; i<a; i++) {
				sb.append("1");
			}
			
			System.out.println(min + " " + sb.toString());
			
		}

	}

}
