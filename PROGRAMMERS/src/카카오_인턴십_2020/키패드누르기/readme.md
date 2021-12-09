## Programmers - 키패드 누르기
- Level 1
- Implement
- 2020 카카오 인턴십 
🔗[키패드 누르기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/67256)


## 풀이

두 엄지 손가락의 위치를 구하는 규칙을 찾기가 어려웠다... 규칙적으로 숫자가 나뉘어 있을때는 %와 /을 잘 이용하자!! 


## 소스코드
~~~java
import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int right = 10;
        int left = 12;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            if(num==1 || num==4 || num==7){
                sb.append("L");
                left = num;
            }
            else if(num==3 || num==6 || num==9){
                sb.append("R");
                right = num;
            }
            else{
                if(num==0)  num = 11;
                
                int leftDis = Math.abs((num-1)/3-(left-1)/3) + Math.abs((num-1)%3-(left-1)%3);
                int rightDis = Math.abs((num-1)/3-(right-1)/3) + Math.abs((num-1)%3-(right-1)%3);
                
                if(leftDis>rightDis){
                    sb.append("R");
                    right = num;
                }else if(leftDis<rightDis){
                    sb.append("L");
                    left = num;
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = num;
                    }else if(hand.equals("left")){
                        sb.append("L");
                        left = num;
                    }
                }
            }
        }
        
        answer = sb.toString();
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.02ms, 67.4MB)|
|테스트 2 |	통과 (0.03ms, 74.9MB)|
|테스트 3 |	통과 (0.04ms, 80.4MB)|
|테스트 4 |	통과 (0.03ms, 72.3MB)|
|테스트 5 |	통과 (0.04ms, 71.4MB)|
|테스트 6 |	통과 (0.05ms, 73.3MB)|
|테스트 7 |	통과 (0.03ms, 77.5MB)|
|테스트 8 |	통과 (0.05ms, 74.3MB)|
|테스트 9 |	통과 (0.06ms, 73.5MB)|
|테스트 10|	통과 (0.05ms, 74.5MB)|
|테스트 11 |	통과 (0.06ms, 73MB)|
|테스트 12 |	통과 (0.04ms, 74.4MB)|
|테스트 13 |	통과 (0.06ms, 73.4MB)|
|테스트 14 |	통과 (0.09ms, 78.7MB)|
|테스트 15 |	통과 (0.15ms, 75.9MB)|
|테스트 16 |	통과 (0.14ms, 77.5MB)|
|테스트 17 |	통과 (0.23ms, 72.3MB)|
|테스트 18 |	통과 (0.23ms, 74.5MB)|
|테스트 19 |	통과 (0.24ms, 74.8MB)|
|테스트 20 |	통과 (0.24ms, 78MB)|