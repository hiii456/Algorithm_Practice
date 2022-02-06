## Programmers - 구명보트 
- Level 2
- Greedy 
🔗[구명보트 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42885)



## 풀이

배열의 값을 오름차순으로 정렬해 준 뒤 배열의 첫번째 값과 마지막값을 합한 것을 limit과 비교를 해주었다.
그렇게 앞뒤로 비교를 해주어 answer을 구하였다.


## 소스코드
~~~java
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);
        int min = 0;
        for(int i = people.length-1; i>=min; i--){
            if(people[min] + people[i] <= limit){
                min++;
            }
            answer++;
        }
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (1.42ms, 77.3MB)|
|테스트 2 |	통과 (1.39ms, 78.8MB)|
|테스트 3 |	통과 (1.75ms, 79.4MB)|
|테스트 4 |	통과 (1.30ms, 75.3MB)|
|테스트 5 |	통과 (1.25ms, 74MB)|
|테스트 6 |	통과 (0.91ms, 77.2MB)|
|테스트 7 |	통과 (1.16ms, 79.8MB)|
|테스트 8 |	통과 (0.45ms, 80.5MB)|
|테스트 9 |	통과 (0.44ms, 73MB)|
|테스트 10 |	통과 (1.57ms, 70MB)|
|테스트 11 |	통과 (1.25ms, 76MB)|
|테스트 12 |	통과 (1.04ms, 77.6MB)|
|테스트 13 |	통과 (1.48ms, 80.7MB)|
|테스트 14 |	통과 (1.43ms, 74.3MB)|
|테스트 15 |	통과 (0.47ms, 76.4MB)|
|효율성 | 테스트|
|----|----|
|테스트 1 |	통과 (13.83ms, 55.4MB)|
|테스트 2 |	통과 (8.95ms, 53.6MB)|
|테스트 3 |	통과 (10.96ms, 55.8MB)|
|테스트 4 |	통과 (6.21ms, 54MB)|
|테스트 5 |	통과 (8.99ms, 53.3MB)|