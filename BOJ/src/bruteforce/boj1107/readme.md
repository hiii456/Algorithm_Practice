## BOJ - λ¦¬λͺ¨μ»¨ 
- Gold 5 
- bruteforce 
π[λ¦¬λͺ¨μ»¨ λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/1107)



## νμ΄

μμ νμμ μ΄μ©ν΄μ + λλ - λ§ μ΄μ©νμ¬ μ±λμ μ΄λνλ κ²½μ°μ κ°μ₯ nκ³Ό κ°κΉμ΄ μ±λλ‘ μ΄λν ν + λλ - λ‘ μ±λμ μ΄λνλ κ²½μ° μ€ λλ¬μ§ λ²νΌ νμμ μ΅μκ°μ μ°Ύμ λ΅μ κ΅¬νλ€.

#### λ§ν μ  
mμ΄ 0μΈ κ²½μ°μ κ³ μ₯λ λ²νΌμ΄ μμΌλ―λ‘ μλ ₯ν  κ°μ΄ μλ€. λ°λΌμ μ΄ κ²½μ°μ μμΈμ²λ¦¬λ₯Ό ν΄μ£Όμ΄μΌμ§ NullPointerμλ¬κ° λ°μνμ§ μλλ€.

## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1107_G5_λ¦¬λͺ¨μ»¨ {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[] channel = new boolean[10];
		
		if(m!=0) {
			// κ³ μ₯λ μ±λμ trueλ‘ λ°°μ΄μ νμ 
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				int ch = Integer.parseInt(st.nextToken());
				channel[ch] = true;
			}
		}

		/*
		 * Nμ μ΅λκ°μ 500,000μ΄λ€.
		 * λ°λΌμ 6μλ¦¬μ μ€ μ΅λκ°μ΄ 999,999κΉμ§ μμ νμμ μ§ννλ€.
		 * μ΄λ, + λλ - λ§ μ΄μ©νμ¬ μ±λμ μ΄λνλ κ²½μ°μ 
		 * κ°μ₯ nκ³Ό κ°κΉμ΄ μ±λλ‘ μ΄λν ν + λλ - λ‘ μ±λμ μ΄λνλ κ²½μ° μ€ 
		 * λλ₯΄λ λ²νΌ νμμ μ΅μκ°μ μ°ΎμμΌ νλ€.
		 * λ°λΌμ κΈ°μ‘΄μ λΉκ΅ν  κ°μ nμμ 100μ λΊ μ λκ°μΌλ‘ μ€μ νλ€. (+ λλ - λ§μΌλ‘ λ³κ²½ν νμ)
		 */
		int result = Math.abs(n-100);
		for(int i=0; i<=999999; i++) {
			String num = String.valueOf(i);
			boolean isBreak = false;
			// ν΄λΉ num μ€ κ³ μ₯λ μ«μκ° ν¬ν¨λ μ±λμΈμ§ νλ³ 
			for(int j=0; j<num.length(); j++) {
				if(channel[num.charAt(j) - '0']) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak)
				result = Math.min(result, (num.length() + Math.abs(n-i)));
			
		}
		
		System.out.println(result);
		
	}

}
~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|68848KB	|336ms|