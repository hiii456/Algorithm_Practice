## Programmers - 음양 더하기
- Level 1
- Implement
- 월간 코드 챌린지 시즌2
🔗[음양 더하기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/76501)


## 풀이

 다른사람의 간결한 코드

~~~java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i=0; i<signs.length; i++)
            answer += absolutes[i] * (signs[i]? 1: -1);
        return answer;
    }
}
~~~

다른 코드를 보며 또 반성하고 갑니다요..


## 소스코드
~~~java
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            int num = absolutes[i];
            boolean sign = signs[i];
            
            if(sign){
                answer += num;
            }else{
                answer -= num;
            }
        }
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.06ms, 75.4MB)|
|테스트 2 |	통과 (0.04ms, 80.8MB)|
|테스트 3 |	통과 (0.05ms, 74.1MB)|
|테스트 4 |	통과 (0.04ms, 75.8MB)|
|테스트 5 |	통과 (0.05ms, 74.7MB)|
|테스트 6 |	통과 (0.04ms, 75.9MB)|
|테스트 7 |	통과 (0.05ms, 75.8MB)|
|테스트 8 |	통과 (0.05ms, 74.2MB)|
|테스트 9 |	통과 (0.05ms, 77.5MB)|