## BOJ - κ°λ₯λ²λ  
- Gold 5  
- Prefix Sum 
π[κ°λ₯λ²λ  λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/3020)



## νμ΄

μ΄ λ¬Έμ λ λμ ν©μ μ΄μ©ν΄μ νΈλ λ¬Έμ μ΄λ€. λλ ν΄κ²°λ°©λ²μ μ°Ύλ κ³Όμ μμ μκ°μ΄ μ€λκ±Έλ Έλ€.
λ¨Όμ  μλ ₯μΌλ‘ λ€μ΄μ€λ μμκ³Ό μ’μ μμ κ°―μλ₯Ό count ν΄μ€λ€.

~~~java
		for(int i=0; i<n/2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
~~~

κ·Έλ¦¬κ³  λμ ν©μ μ΄μ©νμ¬ λ°°μ΄μ ν΄λΉ μΈλ±μ€ μ΄νμ μμ, μ’μ μμ λμ ν©μ μ μ₯νλ€.

~~~java
		for(int i=1; i<h+1; i++) {
			top[i] += top[i-1];
			bottom[i] += bottom[i-1];
		}
~~~

λ§μ½ μΈλ²μ§Έ κ΅¬κ°μ μ§λκ² λλ©΄, νκ΄΄λλ μμμ κ°―μ = μ μ²΄ μμμ κ°―μ - μ²«λ²μ§Έ κ΅¬κ°λΆν° λλ²μ§Έ κ΅¬κ°μ μμ λμ ν© μ΄κ³ ,
νκ΄΄λλ μ’μ μμ κ°―μ = μ μ²΄ μ’μ μμ κ°―μ - λ€λ²μ§ΈλΆν° λ§μ§λ§ κ΅¬κ°μ μ’μ μ μ΄λ€.
μ¦, λμ ν©μ μ΄μ©ν€ μ μ²΄μ κ°―μμμ κΉ¨μ§μ§ μλ μμκ³Ό μ’μ μμ κ΅¬νκ³  ν΄λΉ μ΅μκ°μ ν΄λΉνλ©΄ countμ ν΄μ€λ€.

~~~java
		for(int i=1; i<h+1; i++) {
			int crush = 0;	// λΆλͺνλ κ°―μ 
		
			crush += bottom[h] - bottom[i-1];
			crush += top[h] - top[h-i];
			
			if(min>crush) {
				min = crush;
				cnt = 1;
			}else if(min == crush)	cnt++;
		}
~~~


## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class BOJ_3020_G5_κ°λ₯λ²λ  {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int[] bottom = new int[h+1];		// λμ΄μ λ°λ₯Έ μμμ κ°―μ 
		int[] top = new int[h+1];			// λμ΄μ λ°λ₯Έ μ’μ μμ κ°―μ 
		
		for(int i=0; i<n/2; i++) {
			bottom[Integer.parseInt(br.readLine())]++;
			top[Integer.parseInt(br.readLine())]++;
		}
		
		// λμ ν©μ ν΅ν΄ ν΄λΉ μΈλ±μ€μ λμ΄ μ΄νμ μ’μ μ, μμ λμ ν©μ κ°μ§κ² λλ€.
		for(int i=1; i<h+1; i++) {
			top[i] += top[i-1];
			bottom[i] += bottom[i-1];
		}
		
		int min = n;
		int cnt = 0;
		for(int i=1; i<h+1; i++) {
			int crush = 0;	// λΆλͺνλ κ°―μ 
		
			crush += bottom[h] - bottom[i-1];
			crush += top[h] - top[h-i];
			
			if(min>crush) {
				min = crush;
				cnt = 1;
			}else if(min == crush)	cnt++;
		}
		
		System.out.println(min + " " + cnt);
	}

}
~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|29652KB	|236ms|