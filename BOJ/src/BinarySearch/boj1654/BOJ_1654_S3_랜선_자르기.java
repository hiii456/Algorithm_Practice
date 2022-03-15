package BinarySearch.boj1654;

import java.io.*;
import java.util.*;

public class BOJ_1654_S3_랜선_자르기 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[k-1];
		
		while(left<=right) {
			long mid = (left + right)/2;
			int cnt = 0;
			for(int i=0; i<k; i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt<n) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}

		System.out.println(right);

	}

}
