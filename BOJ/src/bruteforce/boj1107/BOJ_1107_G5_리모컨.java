package bruteforce.boj1107;

import java.io.*;
import java.util.*;

public class BOJ_1107_G5_리모컨 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[] channel = new boolean[10];
		
		// 고장난 채널은 true로 배열에 표시 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int ch = Integer.parseInt(st.nextToken());
			channel[ch] = true;
		}
		
		/*
		 * N의 최대값은 500,000이다.
		 * 따라서 6자리수 중 최대값이 999,999까지 완전탐색을 진행한다.
		 * 이때, + 또는 - 만 이용하여 채널을 이동하는 경우와 
		 * 가장 n과 가까운 채널로 이동한 후 + 또는 - 로 채널을 이동하는 경우 중 
		 * 누르는 버튼 횟수의 최솟값을 찾아야 한다.
		 * 따라서 기존에 비교할 값을 n에서 100을 뺀 절댓값으로 설정한다. (+ 또는 - 만으로 변경한 횟수)
		 */
		int result = Math.abs(n-100);
		for(int i=0; i<=999999; i++) {
			String num = String.valueOf(i);
			boolean isBreak = false;
			// 해당 num 중 고장난 숫자가 포함된 채널인지 판별 
			for(int j=0; j<num.length(); j++) {
				if(channel[num.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak)
				result = Math.min(result, (num.length() + Math.abs(n-i)));
			
		}
		
		System.out.println(result);
		
	}

}
