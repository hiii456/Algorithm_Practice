## Programmers 보석쇼핑 

- HashMap,HashSet,Two-Pointers
- Level3
- 2020 카카오 인턴십 문제 
- 🔗[보석쇼핑 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/67258)

## 풀이

너무 어려웠다... 투포인터 개념을 완벽하게 익혔다고 생각했는데 아직 아닌가보다!
일단 HashSet의 데이터 중복을 제거하는 속성을 이용하여 보석을 각각 set에 저장해주었다.

그리고 투포인터의 속성을 이용하여 map에 보석을 다 넣었으면 start++, 그리고 보석의 key를 -1,
만약 end가 N과 같다면 탐색이 끝난 것 이므로 break,
둘다 아니라면 end++, 부분배열에는 보석이 하나 더 들어오므로 getOrDefault를 이용해서 (getOrDefault : 해당 key값이 존재하면 key값을 반환하고 존재하지 않으면 기본값을 반환한다.) 보석의 key값에 +1을 해준다.

알게된 점 : HashMap의 메소드 getOrDefault에 대해 새로 알게 되었다. 중복된 데이터는 hash를 앞으로 이용해야 겠다.

## 소스코드
~~~java
import java.util.*;

public class 보석쇼핑 {

	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : gems){
            set.add(s);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int dis = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int startPoint = 0;
        while(true){
            if(set.size()==map.size()){
                map.put(gems[start],map.get(gems[start])-1);
                if(map.get(gems[start])==0){
                    map.remove(gems[start]);
                }
                start++;
            }else if(end == gems.length){
                break;
            }else{
                map.put(gems[end], map.getOrDefault(gems[end],0)+1);
                end++;
            }
            
            if(set.size()==map.size() && dis>end-start){
                dis = end-start;
                startPoint = start;
            }
        }
        
        answer[0] = startPoint + 1;
        answer[1] = startPoint + dis;
               
        return answer;
    }

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.11ms, 70.2MB)|
|테스트 2 |	통과 (0.21ms, 73.9MB)|
|테스트 3 |	통과 (0.61ms, 73.8MB)|
|테스트 4 |	통과 (0.64ms, 73.1MB)|
|테스트 5 |	통과 (0.75ms, 72.3MB)|
|테스트 6 |	통과 (0.08ms, 77.9MB)|
|테스트 7 |	통과 (0.09ms, 74.8MB)|
|테스트 8 |	통과 (0.95ms, 75.1MB)|
|테스트 9 |	통과 (0.87ms, 74.4MB)|
|테스트 10 |	통과 (1.01ms, 76MB)|
|테스트 11 |	통과 (0.83ms, 76.3MB)|
|테스트 12 |	통과 (1.88ms, 71.9MB)|
|테스트 13 |	통과 (1.38ms, 60MB)|
|테스트 14 |	통과 (1.78ms, 59.4MB)|
|테스트 15 |	통과 (2.95ms, 61.3MB)|

-------

|효율성 | 테스트 |
|---|---|
|테스트 1 |	통과 (4.98ms, 54.9MB)|
|테스트 2 |	통과 (7.74ms, 56.2MB)|
|테스트 3 |	통과 (14.73ms, 58.1MB)|
|테스트 4 |	통과 (14.93ms, 61.9MB)|
|테스트 5 |	통과 (21.57ms, 61.8MB)|
|테스트 6 |	통과 (26.58ms, 66MB)|
|테스트 7 |	통과 (28.67ms, 65MB)|
|테스트 8 |	통과 (37.06ms, 70MB)|
|테스트 9 |	통과 (40.22ms, 70.9MB)|
|테스트 10 |	통과 (32.13ms, 74.9MB)|
|테스트 11 |	통과 (36.94ms, 78.8MB)|
|테스트 12 |	통과 (35.26ms, 80.5MB)|
|테스트 13 |	통과 (39.73ms, 80.5MB)|
|테스트 14 |	통과 (44.39ms, 80.8MB)|
|테스트 15 |	통과 (60.55ms, 82MB)|