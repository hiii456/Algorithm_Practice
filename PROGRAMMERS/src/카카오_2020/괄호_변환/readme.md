## Programmers - 괄호 변환 
- Level 2
- Implement 
- 2020 KAKAO BLIND RECRUITMENT
🔗[괄호 변환 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/60058)



## 풀이

문제 자체가 처음에 이해하기 어려웠으나 천천히 보기대로 구현하니 술술 풀리는 문제였다! 
다만  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 이부분에서 
"(())()" 이면 "))(()("로 변환해주어야 하는데 아예 통으로 뒤집어서 ")())((" 이렇게 해주어 12번 테케부터 싹 틀렸었다.

## 소스코드
~~~java
import java.util.*;

public class 괄호_변환 {
	public String solution(String p) {
        // 1단계 수행 
        if(p.length()==0){
            return p;
        }
        // 2단계 수행 
        String u = "",v = "";
        int right = 0,left = 0;
        
        for(int i=0; i<p.length(); i++){
            u += String.valueOf(p.charAt(i));
            if(p.charAt(i)=='(')    left++;
            else if(p.charAt(i)==')')   right++;
            
            if(left==right){
                v = p.substring(i+1,p.length());
                break;
            }
        }
        // 3단계, 4단계 수행
        if(isCorrect(u)){
            return u + solution(v); 
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            u = u.substring(1,u.length()-1);
            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i)=='(')    sb2.append(")");
                else    sb2.append("(");
            }
            
            return sb.toString() + sb2.toString();
        }

    }
    public static boolean isCorrect(String p){
        int right = 0, left = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(')    left++;
            else if(p.charAt(i)==')')   right++;
            
            if(right>left)  return false;
        }
        return true;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (1.67ms, 74.5MB)|
|테스트 2 |	통과 (1.32ms, 87.3MB)|
|테스트 3 |	통과 (1.62ms, 73.1MB)|
|테스트 4 |	통과 (1.98ms, 70.5MB)|
|테스트 5 |	통과 (2.05ms, 74.2MB)|
|테스트 6 |	통과 (1.66ms, 70.5MB)|
|테스트 7 |	통과 (2.27ms, 76.7MB)|
|테스트 8 |	통과 (1.93ms, 78.6MB)|
|테스트 9 |	통과 (1.80ms, 65.7MB)|
|테스트 10|	통과 (1.37ms, 73.1MB)|
|테스트 11 |	통과 (1.73ms, 86.7MB)|
|테스트 12 |	통과 (3.85ms, 88MB)|
|테스트 13 |	통과 (2.40ms, 83.3MB)|
|테스트 14 |	통과 (1.92ms, 80.8MB)|
|테스트 15 |	통과 (2.39ms, 72.3MB)|
|테스트 16 |	통과 (2.87ms, 75.9MB)|
|테스트 17 |	통과 (3.29ms, 72.3MB)|
|테스트 18 |	통과 (2.96ms, 74MB)|
|테스트 19 |	통과 (2.84ms, 74.6MB)|
|테스트 20 |	통과 (3.19ms, 73.9MB)|
|테스트 21 |	통과 (4.00ms, 69.5MB)|
|테스트 22 |	통과 (2.83ms, 71.4MB)|
|테스트 23 |	통과 (2.33ms, 77.5MB)|
|테스트 24 |	통과 (2.13ms, 74.3MB)|
|테스트 25 |	통과 (3.05ms, 71.7MB)|