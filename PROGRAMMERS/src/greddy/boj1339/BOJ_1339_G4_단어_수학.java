package greddy.boj1339;

import java.io.*;
import java.util.*;

public class BOJ_1339_G4_단어_수학 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[] alphabet = new int[26];
		String[] word = new String[n];
			
		for(int i=0; i<n; i++) {
			word[i] = br.readLine();
			int tmp = (int) Math.pow(10, word[i].length()-1);
			for(int j=0; j<word[i].length(); j++) {
				alphabet[word[i].charAt(j)-'A'] += tmp;
				tmp /= 10;
			}
		}
		
		Arrays.sort(alphabet);

		int sum = 0;
		int num = 9;
		for(int i=alphabet.length-1; i>=0; i--) {
			if(alphabet[i] == 0)	break;
			sum += alphabet[i]*num--;
		}
		
		System.out.println(sum);

	}

}
