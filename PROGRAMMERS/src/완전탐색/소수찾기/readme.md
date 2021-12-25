## Programmers - 소수찾기 
- bruteforce
- Level2
- 🔗[소수찾기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42839)

## 풀이

순서가 중요하기 때문에 순열을 이용해서 풀어주었고, 소수 판별은 에라토스테네스의 체 알고리즘 이용해서 풀었습니다.

## 소스코드
~~~java
import java.util.*;
public class 소수찾기 {
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
            // 맨 앞에 0이 오면 return
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
    // 에라토스테네스의 체 알고리즘 이용 
	private static boolean isPrime(int num) {
		// 1은 소수가 아니므로 false 
		if(num==1)	return false;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) 	return false;
		}

		return true;
	}

}

~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.23ms, 78.6MB)|
|테스트 2 |	통과 (2.38ms, 78.3MB)|
|테스트 3 |	통과 (0.08ms, 66.5MB)|
|테스트 4 |	통과 (1.99ms, 82MB)|
|테스트 5 |	통과 (8.81ms, 82MB)|
|테스트 6 |	통과 (0.09ms, 72.4MB)|
|테스트 7 |	통과 (0.28ms, 76.4MB)|
|테스트 8 |	통과 (7.95ms, 79.5MB)|
|테스트 9 |	통과 (0.07ms, 74.4MB)|
|테스트 10|	통과 (2.68ms, 79.1MB)|
|테스트 11 |	통과 (1.12ms, 73.3MB)|
|테스트 12 |	통과 (0.88ms, 78.2MB)|