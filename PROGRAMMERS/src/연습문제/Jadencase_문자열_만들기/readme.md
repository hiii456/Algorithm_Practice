## Programmers - JadenCase 문자열 만들기 
- Level 2 
- String 
🔗[JadenCase 문자열 만들기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/12951)



## 풀이

이 문제는 단어의 첫글자는 대문자, 나머지 글자는 소문자로 바꿔주어야하는 Jadencase 기법을 사용해서 푸는 문제이다.
따라서 toUpperCase(), toLowerCase() 메소드를 이용하였다.
추가적으로 공백이 여러개인 단어가 있기 때문에 그 부분을 고려해서 문제를 풀어주어야 테스트케이스에서 실패가 나오지 않았다.

ex) "a a a " -> 마지막에 공백이 들어가는지 확인하는 로직 필요 
 "a  av a" -> 공백이 여러개인 경우에 필요한 로직 추가 

## 소스코드
~~~java
import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            
            if(str.length()==0) sb.append(" ");
            else{
                str = str.substring(0,1).toUpperCase() + str.substring(1,str.length()).toLowerCase();
            sb.append(str).append(" ");
            }
        }
        if(s.charAt(s.length()-1) == ' '){
            return sb.toString();
        }
        sb.deleteCharAt(sb.length()-1);
        answer = sb.toString();
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 〉	통과 (1.28ms, 76.7MB)|
|테스트 2 〉	통과 (1.42ms, 74.2MB)|
|테스트 3 〉	통과 (1.34ms, 71.4MB)|
|테스트 4 〉	통과 (1.52ms, 72.7MB)|
|테스트 5 〉	통과 (1.96ms, 72.3MB)|
|테스트 6 〉	통과 (1.55ms, 78.2MB)|
|테스트 7 〉	통과 (1.44ms, 74.7MB)|
|테스트 8 〉	통과 (1.25ms, 78.7MB)|
|테스트 9 〉	통과 (1.71ms, 77.2MB)|
|테스트 10 〉	통과 (1.25ms, 77.1MB)|
|테스트 11 〉	통과 (1.54ms, 77.1MB)|
|테스트 12 〉	통과 (1.28ms, 74.7MB)|
|테스트 13 〉	통과 (1.81ms, 78.2MB)|
|테스트 14 〉	통과 (2.63ms, 77MB)|
|테스트 15 〉	통과 (1.28ms, 76MB)|
|테스트 16 〉	통과 (1.58ms, 72.3MB)|
|테스트 17 〉	통과 (1.79ms, 86.3MB)|
|테스트 18 〉	통과 (1.27ms, 80.3MB)|