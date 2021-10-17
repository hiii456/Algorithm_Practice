package greedy.boj13305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305_S4_주유소 {
	static int N;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int[] len = new int[N-1];
		long[] cost = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			len[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		// 기름 가격을 내림차순으로 만든다.
		for(int i=1; i<N; i++) {
			if(cost[i]>cost[i-1]) {
				cost[i] = cost[i-1];
			}

		}
		
		long ans = 0;
		for(int i=0; i<N-1; i++) {
			ans += cost[i] * len[i];
		}
		
		System.out.println(ans);
		

	}

}
