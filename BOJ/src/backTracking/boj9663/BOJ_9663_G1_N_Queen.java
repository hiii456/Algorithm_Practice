package backTracking.boj9663;

import java.io.*;

public class BOJ_9663_G1_N_Queen {
	static int N,answer;
	static int[] cols;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			cols = new int[N];
			cols[0] = i;
			backTracking(1);
		}
		
		System.out.println(answer);

	}
	private static void backTracking(int col) {
		if(col==N) {
			answer++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			cols[col] = i;
			if(isPossible(col)) {
				backTracking(col+1);
			}
		}
		
	}
	private static boolean isPossible(int col) {
		for(int i=0; i<col; i++) {
			if(cols[i]==cols[col] || Math.abs(i-col) == Math.abs(cols[i]-cols[col]))
				return false;
		}
		return true;
	}

}
