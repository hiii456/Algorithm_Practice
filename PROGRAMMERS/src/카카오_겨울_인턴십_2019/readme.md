## Programmers 호텔 방 배정 
- Union-Find, HashMap
- 2019 카카오 개발자 겨울 인턴십 문제 
- 🔗[호텔 방 배정 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/64063)



## 풀이

이 문제는 Union-Find를 이용해서 풀었다. k가 10^12이기때문에 순차적으로 빈방을 찾을 경우 시간복잡도 문제가 발생하기 때문이다.
그리고 HashMap을 통해 Key는 방 번호, Value에는 다음 방번호를 저장하였다.
만약 1번방을 원하는 경우 1번방에 map에 없다면 1번에 배정하고, 만약 map에 이미 배정되었다면 map의 부모노드를 찾아 부모노드부터 조회하도록 한다.

어떻게 이렇게 생각하쥐....  

## 소스코드
~~~java
import java.util.*;

class Solution {
    static HashMap<Long, Long> hm = new HashMap<>();
    static long find(long a){
        if(!hm.containsKey(a)){
            return a;
        }else{
            // 경로 압축
            hm.put(a,find(hm.get(a)));
            return hm.get(a);
        }
    }
    
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        
        for(int i = 0; i < len; i++){
            long room = room_number[i];
            // map에 방번호가 존재할 때 
            if(!hm.containsKey(room)){
                answer[i] = room;
                hm.put(room, find(room)+1);
            }
            // map에 방번호가 존재하지 않을때
            else{
                long tmp = find(room);
                answer[i] = tmp;
                hm.put(tmp, find(tmp)+1);
            }         
        }
        
        return answer;
    }
}


~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.03ms, 68MB)|
|테스트 2 |	통과 (0.08ms, 63.9MB)|
|테스트 3 |	통과 (0.06ms, 60.1MB)|
|테스트 4 |	통과 (0.47ms, 58.9MB)|
|테스트 5 |	통과 (0.06ms, 59.4MB)|
|테스트 6 |	통과 (0.14ms, 60.4MB)|
|테스트 7 |	통과 (0.15ms, 61.5MB)|
|테스트 8 |	통과 (0.03ms, 58.2MB)|
|테스트 9 |	통과 (0.09ms, 63.9MB)|
|테스트 10 |	통과 (0.05ms, 71.5MB)|
|테스트 11 |	통과 (0.05ms, 71.4MB)|
|테스트 12 |	통과 (0.11ms, 60.3MB)|
|테스트 13 |	통과 (0.11ms, 78.3MB)|
|테스트 14 |	통과 (0.10ms, 67.1MB)|
|테스트 15 |	통과 (0.32ms, 59.9MB)|
|테스트 16 |	통과 (0.52ms, 72.2MB)|
|테스트 17 |	통과 (0.69ms, 59.6MB)|
|테스트 18 |	통과 (0.92ms, 71.6MB)|
|테스트 19 |	통과 (0.90ms, 68.6MB)|
|테스트 20 |	통과 (1.02ms, 70.2MB)|
|테스트 21 |	통과 (1.89ms, 76.6MB)|
|테스트 22 |	통과 (2.07ms, 73.5MB)|
|테스트 23 |	통과 (1.43ms, 70.4MB)|
|테스트 24 |	통과 (2.80ms, 61.2MB)|
|테스트 25 |	통과 (0.27ms, 70.9MB)|
|테스트 26 |	통과 (0.44ms, 72.9MB)|


-------

|효율성 | 테스트 |
|---|---|
|테스트 1 |	통과 (408.74ms, 158MB)|
|테스트 2 |	통과 (449.54ms, 171MB)|
|테스트 3 |	통과 (230.98ms, 174MB)|
|테스트 4 |	통과 (274.00ms, 189MB)|
|테스트 5 |	통과 (380.30ms, 194MB)|
|테스트 6 |	통과 (499.22ms, 197MB)|
|테스트 7 |	통과 (293.37ms, 187MB)|