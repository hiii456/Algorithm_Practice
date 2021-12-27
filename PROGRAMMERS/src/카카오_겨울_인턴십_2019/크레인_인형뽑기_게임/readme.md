## Programmers 호텔 방 배정 크레인 인형뽑기 게임 
- Stack 
- Level 1
- 2019 카카오 개발자 겨울 인턴십 문제 
- 🔗[크레인 인형뽑기 게임 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/64061)



## 풀이

이 문제는 stack을 이용해서 인형이 연속해서 있는 경우는 pop, 아닌경우는 add를 해주었다!

## 소스코드
~~~java
import java.util.*;

public class 크레인_인형뽑기_게임 {

	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int move = moves[i];
            for(int j=0; j<board.length; j++){
                int doll = board[j][move-1];
                if(doll==0) continue;
                else{
                    board[j][move-1] = 0;
                    if(stack.size()>0){
                        if(stack.peek()==doll){
                            stack.pop();
                            answer += 2;
                        }else{
                            stack.add(doll);
                        }
                    }else{
                        stack.add(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }

}


~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.12ms, 67.2MB)|
|테스트 2 |	통과 (0.15ms, 73.9MB)|
|테스트 3 |	통과 (0.13ms, 72.9MB)|
|테스트 4 |	통과 (0.92ms, 74MB)|
|테스트 5 |	통과 (0.16ms, 75.6MB)|
|테스트 6 |	통과 (0.15ms, 70.6MB)|
|테스트 7 |	통과 (0.18ms, 73.2MB)|
|테스트 8 |	통과 (0.59ms, 75MB)|
|테스트 9 |	통과 (0.51ms, 73.8MB)|
|테스트 10 |	통과 (0.55ms, 81.2MB)|
|테스트 11 |	통과 (0.90ms, 75.8MB)|
