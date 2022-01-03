## Programmers - 짝지어 제거하기 
- Level 2
- Stack 
- 2017 팁스타운 
🔗[짝지어 제거하기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/12973)



## 풀이

처음에 stack으로 안풀었다가 효율성 난리난리~~ stack으로 간단하게 풀 수 있는 문제였다.

## 소스코드
~~~java
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        
        answer = (stack.size()>0) ? 0 : 1; 

        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.18ms, 76.5MB)|
|테스트 2 |	통과 (12.29ms, 84.1MB)|
|테스트 3 |	통과 (15.04ms, 86.6MB)|
|테스트 4 |	통과 (11.80ms, 81.9MB)|
|테스트 5 |	통과 (20.09ms, 80.4MB)|
|테스트 6 |	통과 (14.53ms, 84.3MB)|
|테스트 7 |	통과 (22.37ms, 78.7MB)|
|테스트 8 |	통과 (14.97ms, 87.6MB)|
|테스트 9 |	통과 (0.17ms, 75MB)|
|테스트 10 |	통과 (0.26ms, 75.3MB)|
|테스트 11 |	통과 (0.26ms, 73.6MB)|
|테스트 12 |	통과 (0.21ms, 80.6MB)|
|테스트 13 |	통과 (0.19ms, 82.3MB)|
| 효율성  | 테스트 |
|----|----|
|테스트 1 |	통과 (59.69ms, 61.2MB)|
|테스트 2 |	통과 (41.65ms, 56.1MB)|
|테스트 3 |	통과 (48.21ms, 58.6MB)|
|테스트 4 |	통과 (86.18ms, 77.3MB)|
|테스트 5 |	통과 (45.54ms, 58.5MB)|
|테스트 6 |	통과 (47.82ms, 58.5MB)|
|테스트 7 |	통과 (48.18ms, 59.2MB)|
|테스트 8 |	통과 (47.32ms, 58.8MB)|