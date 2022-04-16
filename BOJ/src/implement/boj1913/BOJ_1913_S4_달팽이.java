package implement.boj1913;

import java.io.*;
import java.util.*;

public class BOJ_1913_S4_달팽이 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		int cnt = n*n;
		int r = 0, c = 0;
		int time  = 0;
		int limit = n;
		
		while(cnt>0) {
			for(int i=r; i<limit; i++) {
				arr[i][c] = cnt--;
			}
			r = limit-1;
			for(int i=c+1; i<limit; i++) {
				arr[r][i] = cnt--;
			}
			c = limit-1;
			for(int i=r-1; i>=time; i--) {
				arr[i][r] = cnt--;
			}
			r = time;
			for(int i=c-1; i>time; i--) {
				arr[r][i] = cnt--;
			}
			time++;
			limit--;
			r = time;
			c = time;
			
		}

		StringBuilder sb = new StringBuilder();
		int answerR=0, answerC=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(num==arr[i][j]) {
					answerR=i+1;
					answerC=j+1;
				}
				sb.append(arr[i][j] +" ");
			}
			sb.append("\n");
		}
		sb.append(answerR+" "+answerC);
		System.out.println(sb.toString());
	}

}
