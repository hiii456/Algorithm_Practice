## Programmers - 실패율 
- Level 1
- Implement 
🔗[실패율 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42889)



## 풀이

int형, double형이 포함된 객체의 정렬을 선언해주는 부분에서 조금 막혔다.
그리고 예외처리를 안해주어서 처음에 5문제 정도 실패가 나왔다!
나눗셈을 할때 0을 나누는 부분 예외처리 해주기 기억..!!


## 소스코드
~~~java
import java.util.*;
class Solution {
    static class Stage implements Comparable<Stage>{
        // 스테이지 번호, 실패율  
        int num;
        double fail;
        public Stage(int num,double fail){
            this.num = num;
            this.fail = fail;
        }
        @Override
        public int compareTo(Stage o){
            if(o.fail - this.fail > 0)
                return 1;
            else if(o.fail == this.fail)
                return this.num - o.num;
            else
                return -1;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] user = new int[N+1];
        List<Stage> list = new ArrayList<>();
        for(int i=0; i<stages.length; i++){
            user[stages[i]-1]++;
        }
        
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<N+1; j++){
                sum += user[j];
            }
            if(user[i]==0){
                list.add(new Stage(i+1,0.0));
            }else{
                double fail = (double) user[i]/sum;
                list.add(new Stage(i+1,fail));
            }
            
        }
        
        Collections.sort(list);
        
        for(int i=0; i<N; i++){
            answer[i] = list.get(i).num;
        }
        
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.46ms, 70.5MB)|
|테스트 2 |	통과 (0.65ms, 74.6MB)|
|테스트 3 |	통과 (3.56ms, 80.8MB)|
|테스트 4 |	통과 (3.07ms, 75.5MB)|
|테스트 5 |	통과 (7.15ms, 89.4MB)|
|테스트 6 |	통과 (0.96ms, 72.8MB)|
|테스트 7 |	통과 (1.33ms, 82.1MB)|
|테스트 8 |	통과 (3.42ms, 86.1MB)|
|테스트 9 |	통과 (4.26ms, 90.6MB)|
|테스트 10 |	통과 (2.73ms, 79.5MB)|
|테스트 11 |	통과 (3.77ms, 79.3MB)|
|테스트 12 |	통과 (2.86ms, 87.7MB)|
|테스트 13 |	통과 (3.78ms, 86.7MB)|
|테스트 14 |	통과 (0.41ms, 77MB)|
|테스트 15 |	통과 (2.55ms, 87.4MB)|
|테스트 16 |	통과 (1.15ms, 74.2MB)|
|테스트 17 |	통과 (2.00ms, 81.6MB)|
|테스트 18 |	통과 (1.13ms, 81.8MB)|
|테스트 19 |	통과 (0.57ms, 79.6MB)|
|테스트 20 |	통과 (1.60ms, 74.2MB)|
|테스트 21 |	통과 (4.10ms, 75.5MB)|
|테스트 22 |	통과 (4.02ms, 84.3MB)|
|테스트 23 |	통과 (3.93ms, 95MB)|
|테스트 24 |	통과 (3.55ms, 84.8MB)|
|테스트 25 |	통과 (0.41ms, 76.4MB)|
|테스트 26 |	통과 (0.32ms, 78.3MB)|
|테스트 27 |	통과 (0.44ms, 75.8MB)|