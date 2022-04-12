## Programmers - 올바른 괄호 
- Level 2 
- Queue 
🔗[올바른 괄호 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/12909)


## 소스코드
~~~java
import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                queue.add(ch);
            }else if(ch == ')'){
                if(queue.isEmpty()){
                    answer = false;
                    break;
                }else{
                    queue.poll();
                }
                
            }
        }
        
        if(answer){
          if(queue.isEmpty()){
                answer = true;
            }else{
                answer = false;
            }  
        }
        
        
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.17ms, 81.8MB)|
|테스트 2 |	통과 (0.08ms, 76.4MB)|
|테스트 3 |	통과 (0.08ms, 75MB)|
|테스트 4 |	통과 (0.19ms, 85.5MB)|
|테스트 5 |	통과 (0.16ms, 74.7MB)|
|테스트 6 |	통과 (0.13ms, 83.8MB)|
|테스트 7 |	통과 (0.16ms, 77.6MB)|
|테스트 8 |	통과 (0.18ms, 78.3MB)|
|테스트 9 |	통과 (0.18ms, 73.8MB)|
|테스트 10 |	통과 (0.20ms, 73.7MB)|
|테스트 11 |	통과 (0.21ms, 84.1MB)|
|테스트 12 |	통과 (0.21ms, 65.4MB)|
|테스트 13 |	통과 (0.28ms, 74.4MB)|
|테스트 14 |	통과 (0.24ms, 73.9MB)|
|테스트 15 |	통과 (0.21ms, 78.8MB)|
|테스트 16 |	통과 (0.21ms, 77.9MB)|
|테스트 17 |	통과 (0.20ms, 72.1MB)|
|테스트 18 |	통과 (0.19ms, 72.4MB)|
----
|효율성 | 테스트|
|----|----|
|테스트 1 |	통과 (17.15ms, 53.6MB)|
|테스트 2 |	통과 (16.83ms, 53.4MB)|