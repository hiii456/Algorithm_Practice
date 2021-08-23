package TwoPointers.boj2003;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2003_수_들의_합2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		int result = 0;
		int sum = 0;
		
		while(true) {
			if(sum>=M) {
				sum -= arr[s++];
			}else if(e == N) {
				break;
			}else {
				sum += arr[e++];
			}
			
			if(sum==M) {
				result++;
			}
		}
		
		System.out.println(result);

	}

	
}
