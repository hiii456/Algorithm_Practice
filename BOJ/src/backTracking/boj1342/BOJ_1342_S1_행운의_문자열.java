package backTracking.boj1342;

import java.io.*;
import java.util.Arrays;

public class BOJ_1342_S1_행운의_문자열 {
	static int count;
	static int[] alphabet = new int[26];
	static char[] arr;
	static char[] tgt;
	static boolean[] selected;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		arr = str.toCharArray();
		
		tgt = new char[arr.length];
		selected = new boolean[arr.length];
		
		perm(0);
		
		for(int i=0; i <arr.length; i++) {
			alphabet[arr[i] - 'a']++;
		}

		
		// 중복의 개수 제거하기 위해 팩토리얼 사용 
		for(int i=0; i<26; i++) {
            if(alphabet[i] > 1) {
                count /= factorial(alphabet[i]);
            }
        }
		
		System.out.println(count);

	}
	
	private static int factorial(int n) {
		if(n==1)
			return 1;
		
		return n * factorial(n-1);
		
	}
	
	private static void perm(int tgtIdx) {
		if(tgtIdx == tgt.length) {
			if(check()) {
				count++;
			}
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(selected[i])	continue;
			
			tgt[tgtIdx] = arr[i];
			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}
		
	}
	
	
	private static boolean check() {
		for(int i=0; i<tgt.length-1; i++) {
			if(tgt[i]==tgt[i+1]) {
				return false;
			}
		}
		return true;
	}

}
