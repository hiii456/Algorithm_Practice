## Programmers - 없는 숫자 더하기
- Level 1
- Implement
- 월간 코드 챌린지 시즌3
🔗[없는 숫자 더하기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/67256)


## 풀이

문제 자체는 쉬웠는데 이중 for문 말고 풀 수 있는 방법 뭐 없을까 하다가 본 다른사람의 간결한 코드

~~~java
class Solution {
    public int solution(int[] numbers) {
        int sum = 45;
        for (int i : numbers) {
            sum -= i;
        }
        return sum;
    }
}
~~~

다른 코드를 보며 또 반성하고 갑니다요..


## 소스코드
~~~java
import java.util.*;

public class 없는_숫자_더하기 {
	public int solution(int[] numbers) {
        int answer = 0;

        for(int i=0; i<=9; i++){
            boolean isExist = false;
            for(int j=0; j<numbers.length; j++){
                int num = numbers[j];
                if(i==num){
                    isExist = true;
                }
            }
            if(!isExist){
                answer += i;
            }
        }
        return answer;
    }

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.02ms, 57.6MB)|
|테스트 2 |	통과 (0.02ms, 57.9MB)|
|테스트 3 |	통과 (0.03ms, 58.6MB)|
|테스트 4 |	통과 (0.02ms, 59.3MB)|
|테스트 5 |	통과 (0.02ms, 58MB)|
|테스트 6 |	통과 (0.02ms, 57.2MB)|
|테스트 7 |	통과 (0.02ms, 58MB)|
|테스트 8 |	통과 (0.02ms, 58.9MB)|
|테스트 9 |	통과 (0.02ms, 58.3MB)|