package bruteforce.boj1436;

import java.io.*;
import java.util.*;

public class BOJ_1436_S5_영화감독_숌 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int num = 665;
		while(cnt!=n) {
			num++;
			if(String.valueOf(num).contains("666")) {
				cnt++;
			}
		}
		System.out.println(num);

	}

}
