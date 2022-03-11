package simulation.boj2292;

import java.io.*;
import java.util.*;

public class BOJ_2292_B2_벌집 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 1;
		int layer = 1;
		
		while(true) {
			if(n<=layer) {
				System.out.println(cnt);
				break;
			}else {
				layer += 6 * cnt++;
			}
		}
	}

}
