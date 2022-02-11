## Programmers - 문자열 압축 
- Level 2
- Implement 
- 2020 KAKAO BLIND RECRUITMENT
🔗[문자열 압축 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/60057)



## 풀이

문자열을 나눌 수 있는 범위는 1~s.length()/2이다. 이 구간안에서 각각 문자열을 나누어 압축한 문자열의 길이를 비교하여 답을 구하였다.
문자열을 압축하는 과정은 매개변수로 주어진 문자열을 나눌 길이만큼 문자열을 나누어 비교한다.
그리고 주어진 길이만큼 나누어떨어지지 않을 수 있으므로 마지막에 s.substring(s.length() - s.length()%size , s.length())를 더해준다.

## 소스코드
~~~java
import java.util.*; 
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2; i++){
            int len = compression(i,s);
            answer = Math.min(answer,len);
        }
        return answer;
    }
    public static int compression(int size,String s){
        StringBuilder sb = new StringBuilder();
        String pattern = "";
        String comp = "";
        int cnt = 1;
        for(int i=0; i<=s.length()-size; i+=size){
            if(pattern.equals(s.substring(i,i+size))){
                cnt++;
                continue;
            }
            
            if(cnt>1){
                sb.append(cnt + pattern);
                cnt = 1;
            }else{
                sb.append(pattern);
            }
            pattern = s.substring(i,i+size);
            
        }
        if(cnt>1){
        	sb.append(cnt + pattern);
        }else{
            sb.append(pattern);
        }
        
        sb.append(s.substring(s.length() - s.length()%size , s.length()));
        return sb.length();
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (10.60ms, 76.7MB)|
|테스트 2 |	통과 (21.03ms, 77.9MB)|
|테스트 3 |	통과 (11.69ms, 79.3MB)|
|테스트 4 |	통과 (11.00ms, 79.9MB)|
|테스트 5 |	통과 (0.03ms, 70.1MB)|
|테스트 6 |	통과 (11.62ms, 80.1MB)|
|테스트 7 |	통과 (11.71ms, 81.5MB)|
|테스트 8 |	통과 (13.80ms, 84.2MB)|
|테스트 9 |	통과 (15.77ms, 81.8MB)|
|테스트 10 |	통과 (12.61ms, 78.5MB)|
|테스트 11 |	통과 (11.31ms, 78.5MB)|
|테스트 12 |	통과 (11.21ms, 78.3MB)|
|테스트 13 |	통과 (12.12ms, 74.9MB)|
|테스트 14 |	통과 (13.67ms, 76.8MB)|
|테스트 15 |	통과 (11.05ms, 81.6MB)|
|테스트 16 |	통과 (0.06ms, 78.5MB)|
|테스트 17 |	통과 (10.72ms, 80.1MB)|
|테스트 18 |	통과 (12.78ms, 84.5MB)|
|테스트 19 |	통과 (10.32ms, 77.3MB)|
|테스트 20 |	통과 (13.38ms, 81.6MB)|
|테스트 21 |	통과 (15.62ms, 74.9MB)|
|테스트 22 |	통과 (16.87ms, 91.4MB)|
|테스트 23 |	통과 (13.68ms, 79.9MB)|
|테스트 24 |	통과 (15.32ms, 89.5MB)|
|테스트 25 |	통과 (16.83ms, 81.9MB)|
|테스트 26 |	통과 (16.44ms, 76.7MB)|
|테스트 27 |	통과 (12.90ms, 80.6MB)|
|테스트 28 |	통과 (10.55ms, 72.8MB)|