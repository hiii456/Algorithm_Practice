## Programmers - 멀쩡한 사각형 
- Level 2
- Math 
- Summer/Winter Coding(2019)
🔗[멀쩡한 사각형 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/62048)



## 풀이

아무리 풀어도 해결방법을 찾지 못해서 검색을 통해 최대공약수를 사용한 방법으로 문제를 풀었다.
수학 관련 규칙 찾는 문제는 아무리 풀어도 어렵다! 



## 소스코드
~~~java
class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int gcd = GCD(w,h);
        answer = ((long)w*(long)h) -((((long)w/gcd) + ((long)h/gcd) -1) * gcd);
        
        return answer;
    }
    private static int GCD(int a,int b){
        if(b==0){
            return a;
        }
        
        return GCD(b,a%b);
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.02ms, 78.1MB)|
|테스트 2 |	통과 (0.02ms, 75.2MB)|
|테스트 3 |	통과 (0.02ms, 75.6MB)|
|테스트 4 |	통과 (0.03ms, 75.2MB)|
|테스트 5 |	통과 (0.02ms, 79.8MB)|
|테스트 6 |	통과 (0.03ms, 76.3MB)|
|테스트 7 |	통과 (0.03ms, 78.9MB)|
|테스트 8 |	통과 (0.02ms, 77.9MB)|
|테스트 9 |	통과 (0.02ms, 76.1MB)|
|테스트 10 |	통과 (0.02ms, 78.6MB)|
|테스트 11 |	통과 (0.02ms, 75.7MB)|
|테스트 12 |	통과 (0.04ms, 72.7MB)|
|테스트 13 |	통과 (0.03ms, 72.7MB)|
|테스트 14 |	통과 (0.04ms, 76.3MB)|
|테스트 15 |	통과 (0.04ms, 77.1MB)|
|테스트 16 |	통과 (0.03ms, 79.1MB)|
|테스트 17 |	통과 (0.03ms, 73.9MB)|
|테스트 18 |	통과 (0.02ms, 73.2MB)|