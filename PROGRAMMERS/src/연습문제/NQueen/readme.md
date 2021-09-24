## Programmers - N-Queen 
- Back Tracking
- Level 3

🔗[N-Queen 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/12952)


## 풀이

오늘은 백트래킹 기본문제라 할 수 있는 N-Queen을 풀어보았다! 
N- Queen 이란 체스판 위의 n개의 퀸이 서로를 공격할 수 없도록 배치하는 것이다.

~~~java

        for(int i=0; i<row; i++){
            if(cols[i] == cols[row] || Math.abs(row-i) == Math.abs(cols[row]-cols[i])){
                return false;
            }
        }
        return true;
    }
~~~

여기서 퀸이 서로 공격할 수 없게 하려면 isPossible 메소드를 통해
퀸이 서로 같은 열에 위치하지 않고 대각선 상에 놓여있지 않는 경우를 만족해야 한다.

~~~java
    public void backTracking(int n,int row){
        if(row == n){
            answer++;
            return;
        }
        else{
            for(int i=0; i<n; i++){
                cols[row] = i;
                if(isPossible(row)){
                    backTracking(n,row+1);
                }
            }
        }
    }
~~~

먼저 row (N-1까지) 는 모두 조건을 만족하는 경우에 퀸을 배치한다. 
그리고 row가 N이 되면 이제 모든 퀸을 놓았다는 뜻으로 count를 해준다.


## 소스코드
~~~java
import java.util.*;
class Solution {
    static int answer = 0;
    static int[] cols;
    public int solution(int n) {

        for(int i=0; i<n; i++){
            cols = new int[n];
            cols[0] = i;
            backTracking(n,1);
        }
        
        return answer;
    }
    public void backTracking(int n,int row){
        if(row == n){
            answer++;
            return;
        }
        else{
            for(int i=0; i<n; i++){
                cols[row] = i;
                if(isPossible(row)){
                    backTracking(n,row+1);
                }
            }
        }
    }
    public boolean isPossible(int row){
        for(int i=0; i<row; i++){
            if(cols[i] == cols[row] || Math.abs(row-i) == Math.abs(cols[row]-cols[i])){
                return false;
            }
        }
        return true;
    }
    
}

~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.02ms, 89.6MB)|
|테스트 2 |	통과 (0.03ms, 75.6MB)|
|테스트 3 |	통과 (0.05ms, 69.2MB)|
|테스트 4 |	통과 (0.12ms, 75MB)|
|테스트 5 |	통과 (0.51ms, 81.1MB)|
|테스트 6 |	통과 (1.50ms, 69.8MB)|
|테스트 7 |	통과 (5.31ms, 71.2MB)|
|테스트 8 |	통과 (8.20ms, 75.7MB)|
|테스트 9 |	통과 (17.72ms, 80.7MB)|
|테스트 10 |	통과 (63.25ms, 88.9MB)|
|테스트 11 |	통과 (195.69ms, 81.7MB)|
