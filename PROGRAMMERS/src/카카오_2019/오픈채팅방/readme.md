## Programmers - 오픈채팅방 
- Level 2 
- Hash
🔗[오픈채팅방 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42888)



## 풀이

HashMap의 중복으로 값이 저장되지 않는다는 속성을 사용하였고 String과 관련된 함수에 대해 알 수 있는 문제였다! 

## 소스코드
~~~java
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                hm.put(str[1],str[2]);
                list.add(str[1]+"님이 들어왔습니다.");
            }else if(str[0].equals("Leave")){
                list.add(str[1]+"님이 나갔습니다.");
            }else if(str[0].equals("Change")){
                hm.put(str[1],str[2]);
            }            
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            int idx = list.get(i).indexOf("님");
            String uid = list.get(i).substring(0,idx);
            String log = list.get(i).substring(idx,list.get(i).length());     
            String nickname = hm.get(uid);
            String newlog = nickname + log;
            answer[i] = newlog;
        }

        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 〉	통과 (2.41ms, 75.3MB)|
|테스트 2 〉	통과 (2.15ms, 77MB)|
|테스트 3 〉	통과 (2.55ms, 71.7MB)|
|테스트 4 〉	통과 (2.72ms, 76.5MB)|
|테스트 5 〉	통과 (5.67ms, 78.9MB)|
|테스트 6 〉	통과 (6.02ms, 77.4MB)|
|테스트 7 〉	통과 (6.92ms, 86.2MB)|
|테스트 8 〉	통과 (6.28ms, 85.9MB)|
|테스트 9 〉	통과 (6.66ms, 87.5MB)|
|테스트 10 〉	통과 (5.72ms, 80MB)|
|테스트 11 〉	통과 (5.60ms, 91.4MB)|
|테스트 12 〉	통과 (4.97ms, 78.4MB)|
|테스트 13 〉	통과 (6.00ms, 81.3MB)|
|테스트 14 〉	통과 (6.11ms, 75.9MB)|
|테스트 15 〉	통과 (2.27ms, 78MB)|
|테스트 16 〉	통과 (2.05ms, 74.4MB)|
|테스트 17 〉	통과 (3.05ms, 74.5MB)|
|테스트 18 〉	통과 (2.88ms, 76.8MB)|
|테스트 19 〉	통과 (6.13ms, 74.6MB)|
|테스트 20 〉	통과 (5.51ms, 82MB)|
|테스트 21 〉	통과 (7.05ms, 80.2MB)|
|테스트 22 〉	통과 (5.45ms, 66.6MB)|
|테스트 23 〉	통과 (8.58ms, 80.3MB)|
|테스트 24 〉	통과 (6.63ms, 88.5MB)|
|테스트 25 〉	통과 (90.78ms, 202MB)|
|테스트 26 〉	통과 (101.92ms, 191MB)|
|테스트 27 〉	통과 (121.45ms, 216MB)|
|테스트 28 〉	통과 (116.00ms, 222MB)|
|테스트 29 〉	통과 (105.09ms, 194MB)|
|테스트 30 〉	통과 (93.39ms, 187MB)|
|테스트 31 〉	통과 (98.96ms, 195MB)|
|테스트 32 〉	통과 (89.36ms, 191MB)|