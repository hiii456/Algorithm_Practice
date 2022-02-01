## Programmers - 큰 수 만들기 
- Level 2 
- Greedy  
🔗[큰 수 만들기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42883?language=java)



## 풀이

처음에 조합으로 푸는건가 했는데 순서가 있는 조합?이라 풀이에 대해 고민을 했다.
다양한 풀이 방법이 있었는데 나는 이 풀이 방법을 참고 했다.

https://fbtmdwhd33.tistory.com/230

문제 풀이 방향에 대해 더 생각해보는 시간을 가져야겠다...

## 소스코드
~~~java
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<number.length()-k; i++){
            int max = 0;
            for(int j=idx; j<=k+i; j++){
                if(max<number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        answer = sb.toString();
        
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.03ms, 73.3MB)|
|테스트 2 |	통과 (0.05ms, 88.3MB)|
|테스트 3 |	통과 (0.06ms, 78MB)|
|테스트 4 |	통과 (0.37ms, 77.4MB)|
|테스트 5 |	통과 (0.72ms, 75.5MB)|
|테스트 6 |	통과 (14.07ms, 83.3MB)|
|테스트 7 |	통과 (24.82ms, 81.8MB)|
|테스트 8 |	통과 (187.70ms, 93.1MB)|
|테스트 9 |	통과 (16.65ms, 96.5MB)|
|테스트 10 |	통과 (6826.26ms, 88.7MB)|
|테스트 11 |	통과 (0.02ms, 76.2MB)|
|테스트 12 |	통과 (0.03ms, 78.4MB)|