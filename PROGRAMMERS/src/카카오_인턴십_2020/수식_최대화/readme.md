## Programmers - 수식 최대화 
- Level 2
- dfs
- 2020 카카오 인턴십
🔗[수식 최대화 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/67257)



## 풀이

숫자와 기호를 각각의 List에 따로 분리시켜준 다음 dfs를 통해 가장 큰 결과값을 찾았습니다.
먼저 dfs를 통해 기호의 우선순의를 정해주고 cnt가 3이 되었을때 (기호의 종류가 3개이므로 cnt가 3이면 모든 기호를 순회했다)
우선순위에 따라 결과값을 계산해주어 max값을 갱신시켜 값을 구하였습니다.

## 소스코드
~~~java
import java.util.*;
class Solution {
    static List<Long> numList = new ArrayList<>();
    static List<Character> opList = new ArrayList<>();
    static boolean[] visited = new boolean[3];
    static char[] op = {'+','-','*'};
    static long answer = 0;
    public long solution(String expression) {        
        String num = "";
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)>='0' && expression.charAt(i)<='9'){
                num += expression.charAt(i);
            }else{
                numList.add(Long.parseLong(num));
                num = "";
                opList.add(expression.charAt(i));
            }
        }
        numList.add(Long.parseLong(num));
        dfs(0,new char[3]);
        
        return answer;
    }
    public static void dfs(int cnt, char[] p){
        if(cnt==3){
            List<Long> cNum = new ArrayList<>(numList);
            List<Character> cOp = new ArrayList<>(opList);
            
            for(int i=0; i<p.length; i++){
                for(int j=0; j<cOp.size(); j++){
                    if(p[i] == cOp.get(j)){
                        Long result = calc(cNum.remove(j),cNum.remove(j),p[i]);
                        cNum.add(j,result);
                        cOp.remove(j);
                        j--;
                    }
                }
            }
            
            answer = Math.max(answer,Math.abs(cNum.get(0)));
            return;
        }
        
        for(int i=0; i<3; i++){
            if(!visited[i]){
                p[cnt] = op[i];
                visited[i] = true;
                dfs(cnt+1,p);
                visited[i] = false;
            }
        }
    }
    public static long calc(long num1,long num2,char op){
        long num = 0;
        
        if(op=='*'){
            return num1 * num2;
        }else if(op =='+'){
            return num1 + num2;
        }else if(op == '-'){
            return num1 - num2;
        }
        
        return num;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (9.48ms, 75.3MB)|
|테스트 2 |	통과 (9.75ms, 80.6MB)|
|테스트 3 |	통과 (8.70ms, 74.7MB)|
|테스트 4 |	통과 (9.77ms, 73.3MB)|
|테스트 5 |	통과 (9.62ms, 75.6MB)|
|테스트 6 |	통과 (9.12ms, 73.8MB)|
|테스트 7 |	통과 (9.18ms, 77.3MB)|
|테스트 8 |	통과 (9.46ms, 79.3MB)|
|테스트 9 |	통과 (9.58ms, 78.5MB)|
|테스트 10|	통과 (9.38ms, 77.1MB)|
|테스트 11 |	통과 (9.30ms, 79.1MB)|
|테스트 12 |	통과 (9.30ms, 75.8MB)|
|테스트 13 |	통과 (13.57ms, 80.8MB)|
|테스트 14 |	통과 (13.96ms, 83.1MB)|
|테스트 15 |	통과 (14.67ms, 75.2MB)|
|테스트 16 |	통과 (10.37ms, 76.3MB)|
|테스트 17 |	통과 (12.81ms, 75.1MB)|
|테스트 18 |	통과 (9.42ms, 77.5MB)|
|테스트 19 |	통과 (13.76ms, 79.5MB)|
|테스트 20 |	통과 (9.63ms, 74.5MB)|
|테스트 21 |	통과 (9.94ms, 77.2MB)|
|테스트 22 |	통과 (10.28ms, 81.8MB)|
|테스트 23 |	통과 (9.00ms, 76.4MB)|
|테스트 24 |	통과 (15.18ms, 78.7MB)|
|테스트 25 |	통과 (9.93ms, 68MB)|
|테스트 26 |	통과 (11.33ms, 75.7MB)|
|테스트 27 |	통과 (12.10ms, 81.6MB)|
|테스트 28 |	통과 (17.16ms, 80.5MB)|
|테스트 29 |	통과 (11.04ms, 79.8MB)|
|테스트 30 |	통과 (10.03ms, 77.5MB)|
