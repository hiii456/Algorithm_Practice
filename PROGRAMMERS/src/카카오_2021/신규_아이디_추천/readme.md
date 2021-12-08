## Programmers - 신규 아이디 추천
- Level 1
- Implement
- 2021 KAKAO BLIND RECRUITMENT
🔗[신규 아이디 추천 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/72410)


## 풀이

단순 문자열 구현 문제! 정규식으로 푸는 방법도 있는데 찾아봐야겠다..


## 소스코드
~~~java
import java.util.*;
public class 신규_아이디_추천 {
	public String solution(String new_id) {
        String answer = "";
        // 1단계 
        String id = new_id.toLowerCase();
        // 2단계
        StringBuilder id2 = new StringBuilder();
        for(int i=0; i<id.length(); i++){
            char ch = id.charAt(i);
            if((ch -'0'>=0 && ch-'0'<=9) || (ch>='a' && ch<='z') || ch=='-' || ch=='_' || ch=='.'){
                id2.append(ch);
            }
        }
        
        String id3 = id2.toString();
        // 3단계
        while(id3.contains("..")){
            id3 = id3.replace("..",".");
        }
        
        // 4단계
        if(id3.length()>0){
            if(id3.charAt(0)=='.'){
                id3 = id3.substring(1,id3.length());
            }
        }
        if(id3.length()>0){
            if(id3.charAt(id3.length()-1)=='.'){
                id3 = id3.substring(0,id3.length()-1);
            }
        }
        
        // 5단계
        if(id3.length()==0){
            id3 = "a";
        }
        
        // 6단계
        if(id3.length()>=16){
            id3 = id3.substring(0,15);
            while(id3.charAt(id3.length()-1)=='.'){
                id3 = id3.substring(0,id3.length()-1);
            }
        }
        
        // 7단계
        if(id3.length()<=2){
            while(id3.length()<3){
                id3 += id3.charAt(id3.length()-1);
            }
        }
        
        answer = id3;
        return answer;
    }

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.05ms, 75.1MB)|
|테스트 2 |	통과 (10.75ms, 74.9MB)|
|테스트 3 |	통과 (12.80ms, 80.8MB)|
|테스트 4 |	통과 (0.06ms, 74.1MB)|
|테스트 5 |	통과 (0.05ms, 71.3MB)|
|테스트 6 |	통과 (0.06ms, 77MB)|
|테스트 7 |	통과 (0.05ms, 79MB)|
|테스트 8 |	통과 (0.05ms, 74.2MB)|
|테스트 9 |	통과 (11.64ms, 76.6MB)|
|테스트 10|	통과 (0.04ms, 73.5MB)|
|테스트 11 |	통과 (0.05ms, 78.4MB)|
|테스트 12 |	통과 (0.07ms, 75.2MB)|
|테스트 13 |	통과 (11.46ms, 77.1MB)|
|테스트 14 |	통과 (0.06ms, 82.5MB)|
|테스트 15 |	통과 (0.06ms, 73.3MB)|
|테스트 16 |	통과 (0.15ms, 77.3MB)|
|테스트 17 |	통과 (0.30ms, 71.2MB)|
|테스트 18 |	통과 (0.41ms, 81.7MB)|
|테스트 19 |	통과 (0.49ms, 72.1MB)|
|테스트 20 |	통과 (0.37ms, 71.4MB)|
|테스트 21 |	통과 (0.32ms, 73.4MB)|
|테스트 22 |	통과 (12.39ms, 81.6MB)|
|테스트 23 |	통과 (9.35ms, 78.4MB)|
|테스트 24 |	통과 (0.25ms, 64.9MB)|
|테스트 25 |	통과 (0.39ms, 76.4MB)|
|테스트 26 |	통과 (0.48ms, 73.7MB)|