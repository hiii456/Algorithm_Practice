## Programmers - 2주차 상호평가 
- Level 1
🔗[2주차 상호평가 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/83201)


## 풀이

네이버 코딩테스트 기출문제라고 해서 풀어보았다! (아닐수도 있음 ㅎㅎ)
간단히 풀 수 있는 문제로 각 열의 점수를 비교하면서 자기 자신이 매긴 점수가 아니면서 자기자신이 매긴 점수와 같은 경우에는 해당 열의 모든 점수를 평균 계산시 다 더하여 계산하였다. 만약 자기 자신이 매긴점수가 최고점이거나 최저점이면서, 같은 점수가 없는 경우에는 해당 점수를 제외하고 평균을 계산하였다.


## 소스코드
~~~java
import java.util.*;

public class 위클리_2주차_상호평가 {
	public String solution(int[][] scores) {
        String answer = "";
       
        for(int j=0; j<scores.length; j++){
            // 자기 자신에게 준 점수 
            int selfScore = scores[j][j];
            int sum = 0;
            int min = 100;
            int max = -1;
            int count = scores.length;
            // 자기 자신에게 매긴 점수가 유일한 값인지 판단하는 변수 
            boolean flag = true;
            for(int i=0; i<scores.length; i++){
                int score = scores[i][j];
                
                min = Math.min(score,min);
                max = Math.max(score,max);
                
                // 자기 자신이 매긴 점수가 아니면서 자기 자신이 매긴 점수와 같은 경우
                if(i!=j && score==selfScore){
                    flag = false;
                } 
                
                // 평균을 구하기 위한 점수의 총 합
                sum += score;
  
            }
            if(flag && (min==selfScore || max==selfScore)){
                // 자기 자신을 평가한 점수는 평균을 구할때 제외
                count--;
                sum -= selfScore;
            }
            
            float avg = sum/count;
            String grade = calcGrade(avg);
            
            answer += grade;
        }
        return answer;
    }
    
    public String calcGrade(float avg){
        if(avg >= 90.0){
            return "A";
        }else if(avg>=80.0 && avg<90.0){
            return "B";
        }else if(avg>=70.0 && avg<80.0){
            return "C";
        }else if(avg>=50.0 && avg<70.0){
            return "D";
        }else{
            return "F";
        }
    }

}

~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (1.59ms, 72.5MB)|
|테스트 2 |	통과 (1.40ms, 59.1MB)|
|테스트 3 |	통과 (1.38ms, 75.9MB)|
|테스트 4 |	통과 (1.16ms, 72.5MB)|
|테스트 5 |	통과 (1.85ms, 69.4MB)|
|테스트 6 |	통과 (1.60ms, 69.6MB)|
|테스트 7 |	통과 (1.64ms, 73.7MB)|
|테스트 8 |	통과 (1.53ms, 71.6MB)|
|테스트 9 |	통과 (1.83ms, 73.4MB)|
|테스트 10 |	통과 (1.33ms, 59.2MB)|
|테스트 11 |	통과 (1.73ms, 61.9MB)|
|테스트 12 |	통과 (1.65ms, 72.2MB)|
|테스트 13 |	통과 (2.18ms, 72.5MB)|
|테스트 14 |	통과 (1.86ms, 73.8MB)|
|테스트 15 |	통과 (6.88ms, 61.2MB)|
|테스트 16 |	통과 (1.33ms, 59.1MB)|
|테스트 17 |	통과 (1.49ms, 69.5MB)|
|테스트 18 |	통과 (1.41ms, 74.4MB)|
|테스트 19 |	통과 (1.62ms, 70.1MB)|
|테스트 20 |	통과 (1.26ms, 69.6MB)|
|테스트 21 |	통과 (1.35ms, 60.5MB)|

