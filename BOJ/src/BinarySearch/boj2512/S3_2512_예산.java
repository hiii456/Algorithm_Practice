package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2512_예산 {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end= arr[N-1];
		
		while(start<=end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]<=mid) {
					sum += arr[i];
				}else {
					sum += mid;
				}
			}
			
			if(sum<=M) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);

	}

}
