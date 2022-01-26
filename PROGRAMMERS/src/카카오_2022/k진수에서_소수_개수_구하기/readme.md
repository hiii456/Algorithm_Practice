## Programmers - k진수에서 소수 개수 구하기
- Level 2 
- Implement 
- 2022 KAKAO BLIND RECRUITMENT 
🔗[k진수에서 소수 개수 구하기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/92335)



## 풀이

처음에 테스트케이스 12번을 통과하지 못하였다. num이 0일때 소수판별하는 메소드에서 true를 return해줘서 그런것이였다.
따라서 에라토스체네스의 체를 이용한 소수를 판별하는 메소드에서 1일때 return false인 조건을 0,1일때 return false로 바꾸어주었다.

## 소스코드
~~~java
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String prime = "";
        
        while(n>0){
            prime = (n%k) + prime;
            n/=k;
        }
        
        int i,j = 0;
        for(i=0; i<prime.length(); i=j+1){
            for(j=i; j<prime.length(); j++){
                if(prime.charAt(j)=='0' && i!=j){
                    String str = prime.substring(i,j);
                    if(isPrime(Long.parseLong(str))){
                        answer++;
                    }
                    break;
                }
                if(j==prime.length()-1) {
                	String str = prime.substring(i,prime.length());
                    if(isPrime(Long.parseLong(str))){
                        answer++;
                    }
                }
            }      
        }
        return answer;
    }
    // 에라토스체네스의 체를 이용하여 소수 판별 
    public static boolean isPrime(long num){
        if(num==1){
            return false;
        }
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i ==0) return false;
        }
        
        return true;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (21.05ms, 78.7MB)|
|테스트 2 |	통과 (9.41ms, 73.3MB)|
|테스트 3 |	통과 (9.56ms, 75.5MB)|
|테스트 4 |	통과 (9.16ms, 68.6MB)|
|테스트 5 |	통과 (10.11ms, 77.8MB)|
|테스트 6 |	통과 (9.89ms, 74.2MB)|
|테스트 7 |	통과 (10.41ms, 78.8MB)|
|테스트 8 |	통과 (12.02ms, 84MB)|
|테스트 9 |	통과 (9.50ms, 76.8MB)|
|테스트 10 |	통과 (10.15ms, 78.2MB)|
|테스트 11 |	통과 (9.03ms, 79.9MB)|
|테스트 12 |	통과 (9.31ms, 79.1MB)|
|테스트 13 |	통과 (9.23ms, 79.1MB)|
|테스트 14 |	통과 (8.98ms, 71.9MB)|
|테스트 15 |	통과 (9.52ms, 73.8MB)|
|테스트 16 |	통과 (9.51ms, 77.4MB)|
