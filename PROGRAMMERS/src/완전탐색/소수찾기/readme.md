## Programmers - μμμ°ΎκΈ° 
- bruteforce
- Level2
- π[μμμ°ΎκΈ° λ¬Έμ  λ°λ‘κ°κΈ°](https://programmers.co.kr/learn/courses/30/lessons/42839)

## νμ΄

μμκ° μ€μνκΈ° λλ¬Έμ μμ΄μ μ΄μ©ν΄μ νμ΄μ£Όμκ³ , μμ νλ³μ μλΌν μ€νλ€μ€μ μ²΄ μκ³ λ¦¬μ¦ μ΄μ©ν΄μ νμμ΅λλ€.

## μμ€μ½λ
~~~java
import java.util.*;
public class μμμ°ΎκΈ° {
	static char[] src;
    static boolean[] selected;
    static char[] tgt;
    static HashSet<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        src = numbers.toCharArray();
        selected = new boolean[src.length];
        
        for(int i=1; i<=src.length; i++){
            tgt = new char[i];
            perm(0);
        }
        
        answer = hs.size();
        
        return answer;
    }
    public static void perm(int tgtIdx){
        if(tgtIdx == tgt.length){
            // λ§¨ μμ 0μ΄ μ€λ©΄ return
            if(tgt[0]=='0') return;
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<tgt.length; i++){
                sb.append(tgt[i]);
            }
            int num = Integer.parseInt(sb.toString());
            
            if(isPrime(num)){
                hs.add(num);
            }
            
            
            return;
        }
        
        for(int i=0; i<src.length; i++){
            if(selected[i]) continue;
            
            tgt[tgtIdx] = src[i];
            selected[i] = true;
            perm(tgtIdx+1);
            selected[i] = false;
        }

    }
    // μλΌν μ€νλ€μ€μ μ²΄ μκ³ λ¦¬μ¦ μ΄μ© 
	private static boolean isPrime(int num) {
		// 1μ μμκ° μλλ―λ‘ false 
		if(num==1)	return false;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) 	return false;
		}

		return true;
	}

}

~~~

## κ²°κ³Ό 

| μ νμ±  | νμ€νΈ |
|----|----|
|νμ€νΈ 1 |	ν΅κ³Ό (0.23ms, 78.6MB)|
|νμ€νΈ 2 |	ν΅κ³Ό (2.38ms, 78.3MB)|
|νμ€νΈ 3 |	ν΅κ³Ό (0.08ms, 66.5MB)|
|νμ€νΈ 4 |	ν΅κ³Ό (1.99ms, 82MB)|
|νμ€νΈ 5 |	ν΅κ³Ό (8.81ms, 82MB)|
|νμ€νΈ 6 |	ν΅κ³Ό (0.09ms, 72.4MB)|
|νμ€νΈ 7 |	ν΅κ³Ό (0.28ms, 76.4MB)|
|νμ€νΈ 8 |	ν΅κ³Ό (7.95ms, 79.5MB)|
|νμ€νΈ 9 |	ν΅κ³Ό (0.07ms, 74.4MB)|
|νμ€νΈ 10|	ν΅κ³Ό (2.68ms, 79.1MB)|
|νμ€νΈ 11 |	ν΅κ³Ό (1.12ms, 73.3MB)|
|νμ€νΈ 12 |	ν΅κ³Ό (0.88ms, 78.2MB)|