## Programmers - 더 맵게  
- Level 2
- PriorityQueue
🔗[더 맵게 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42626)



## 풀이

우선순위큐의 특징과 예외인 상황을 잘 고려하여 금방 풀 수 있었던 문제이다.

## 소스코드
~~~java
import java.util.*;

public class 더_맵게 {
	public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(pq.peek()<K){
            if(pq.size()==1){
                if(pq.peek()<K){
                    answer = -1;
                    break;
                }
            }
            int a = pq.poll();
            int b = pq.poll();
            
            int mixed = a + (b*2);
            
            pq.add(mixed);
            
            answer++;
        }
        
        return answer;
    }

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.48ms, 73.1MB)|
|테스트 2 |	통과 (0.49ms, 63.8MB)|
|테스트 3 |	통과 (0.48ms, 79.1MB)|
|테스트 4 |	통과 (0.59ms, 67MB)|
|테스트 5 |	통과 (0.31ms, 73.9MB)|
|테스트 6 |	통과 (2.01ms, 74.9MB)|
|테스트 7 |	통과 (1.51ms, 80.1MB)|
|테스트 8 |	통과 (0.98ms, 83.4MB)|
|테스트 9 |	통과 (0.64ms, 75.4MB)|
|테스트 10 |	통과 (1.43ms, 78MB)|
|테스트 11 |	통과 (1.74ms, 81.4MB)|
|테스트 12 |	통과 (2.39ms, 72.9MB)|
|테스트 13 |	통과 (1.68ms, 73.9MB)|
|테스트 14 |	통과 (0.62ms, 70.4MB)|
|테스트 15 |	통과 (2.33ms, 72.1MB)|
|테스트 16 |	통과 (0.28ms, 72.1MB)|

|효율성 | 테스트|
|----|----|
|테스트 1 |	통과 (162.70ms, 67.2MB)|
|테스트 2 |	통과 (274.24ms, 86.4MB)|
|테스트 3 |	통과 (1344.94ms, 122MB)|
|테스트 4 |	통과 (117.24ms, 63.5MB)|
|테스트 5 |	통과 (1382.18ms, 124MB)|
