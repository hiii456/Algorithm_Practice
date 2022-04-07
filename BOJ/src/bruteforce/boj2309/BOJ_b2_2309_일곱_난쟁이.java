package bruteforce.boj2309;

import java.io.*;
import java.util.*;

public class BOJ_b2_2309_일곱_난쟁이 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] dwarf = new int[9];
		int a = 0,b = 0;
		
		for(int i=0; i<9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}
		
		Arrays.sort(dwarf);
		
		for(int i=0; i<8; i++) {
			for(int j = i+1; j<9; j++) {
				if(sum - dwarf[i] - dwarf[j] == 100) {
					a = i;
					b = j;
					break;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i==a || i==b)	continue;
			System.out.println(dwarf[i]);
		}
	}

}
