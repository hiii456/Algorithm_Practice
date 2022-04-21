package string.문자열_폭발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9935_G4_문자열_폭발 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bombStr = br.readLine();
		int strLen = str.length();
		int bombLen = bombStr.length();
		StringBuilder sb = new StringBuilder();
		boolean isSame = false;
		
		String answer = "";
		
		for(int i=0; i<strLen; i++) {
			char ch = str.charAt(i);
			sb.append(ch);
			
			if(sb.length()>=bombLen) {
				isSame = true;
				for(int j=0; j<bombLen; j++) {
					char ch1 = sb.charAt(sb.length()-bombLen+j);
					char ch2 = bombStr.charAt(j);
					if(ch1 != ch2) {
						isSame = false;
						break;
					}
				}
				if(isSame) {
					sb.delete(sb.length() - bombLen , sb.length());
				}
			}	
		}
		
		if(sb.length()==0) {
			System.out.println("FRULA");
		}else {
			System.out.println(sb.toString());
		}
	}
}
