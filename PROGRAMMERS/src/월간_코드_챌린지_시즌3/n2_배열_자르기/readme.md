## Programmers - n^2 배열 자르기
- Level 2
- Implement 
- 월간 코드 챌린지 시즌3
🔗[n^2 배열 자르기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/87390)



## 풀이

처음에 크기가 n^2인 배열을 만들어야 하나 고민했으나 n이 최대 10^7이므로 n^2시 int의 범위를 벗어난다.
따라서 규칙을 찾아서 문제를 풀어주었다.
각 칸의 숫자는 숫자의 각 행과 열 중 더 큰 숫자에서 +1을 해주면 값을 구할 수 있다.

## 소스코드
~~~java
import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int idx = 0;
        for(int i=0; i<answer.length; i++){
            int num = Math.max((int)((left+i)%n),(int)((left+i)/n));
            num += 1;
            answer[idx++] = num;
        }
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (4.81ms, 98.9MB)|
|테스트 2 |	통과 (5.37ms, 94MB)|
|테스트 3 |	통과 (5.18ms, 112MB)|
|테스트 4 |	통과 (0.04ms, 77.1MB)|
|테스트 5 |	통과 (0.03ms, 77.5MB)|
|테스트 6 |	통과 (5.18ms, 106MB)|
|테스트 7 |	통과 (5.16ms, 107MB)|
|테스트 8 |	통과 (5.08ms, 89.9MB)|
|테스트 9 |	통과 (5.20ms, 102MB)|
|테스트 10|	통과 (5.09ms, 98.1MB)|
|테스트 11 |	통과 (4.94ms, 101MB)|
|테스트 12 |	통과 (4.58ms, 85.8MB)|
|테스트 13 |	통과 (10.17ms, 108MB)|
|테스트 14 |	통과 (7.23ms, 106MB)|
|테스트 15 |	통과 (6.60ms, 93.3MB)|
|테스트 16 |	통과 (4.85ms, 106MB)|
|테스트 17 |	통과 (7.02ms, 109MB)|
|테스트 18 |	통과 (6.52ms, 106MB)|
|테스트 19 |	통과 (5.09ms, 102MB)|
|테스트 20 |	통과 (7.00ms, 92.9MB)|