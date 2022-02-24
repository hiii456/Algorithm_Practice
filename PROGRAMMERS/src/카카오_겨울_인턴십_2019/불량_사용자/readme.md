## Programmers - 불량 사용자 
- Level 3
- backtracking 
- 2019 카카오 개발자 겨울 인턴십
🔗[불량 사용자 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/64064)



## 풀이

이 문제는 정규표현식의 메소드를 사용해야 풀 수 있는 문제였다.
먼저 정규표현식 메소드 사용을 위해 불량 사용자의 아이디에서 '*' 부분을 '.'로 바꾸어주는 작업을 진행하였다.

~~~java
        for(int i=0; i<banned_id.length; i++){
            tmp[i] = banned_id[i].replace("*",".");
        }
~~~

그리고 백트래킹을 통해 나올 수 있는 경우의 수를 String 형태로 hashset에 저장해준다.
hashset을 사용할 경우 중복된 경우는 모두 거를 수 있기 때문에 set.size를 통해 답을 구할 수 있다.

~~~java
    public static void backtracking(int cnt,String[] user_id){
        if(cnt == tmp.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sb.append(user_id[i]);
                }
            }
            hs.add(sb.toString());
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && user_id[i].matches(tmp[cnt])){
                visited[i] = true;
                backtracking(cnt+1,user_id);
                visited[i] = false;
            }
        }
    }
~~~


## 소스코드
~~~java
import java.util.*;
class Solution {
    static HashSet<String> hs = new HashSet<>();
    static String[] result;
    static boolean[] visited;
    static String[] tmp;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        tmp = new String[banned_id.length];
        // 불량사용자 아이디중 '*'를 '.'로 바꾸어준다.
        for(int i=0; i<banned_id.length; i++){
            tmp[i] = banned_id[i].replace("*",".");
        }
        
        visited = new boolean[user_id.length];
        backtracking(0,user_id);
        answer = hs.size();
        return answer;
    }
    public static void backtracking(int cnt,String[] user_id){
        if(cnt == tmp.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sb.append(user_id[i]);
                }
            }
            hs.add(sb.toString());
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && user_id[i].matches(tmp[cnt])){
                visited[i] = true;
                backtracking(cnt+1,user_id);
                visited[i] = false;
            }
        }
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.46ms, 77.7MB)|
|테스트 2 |	통과 (0.97ms, 73.3MB)|
|테스트 3 |	통과 (1.09ms, 66.4MB)|
|테스트 4 |	통과 (1.57ms, 75.3MB)|
|테스트 5 |	통과 (84.40ms, 143MB)|
|테스트 6 |	통과 (7.88ms, 70.4MB)|
|테스트 7 |	통과 (1.00ms, 78.4MB)|
|테스트 8 |	통과 (1.26ms, 77.8MB)|
|테스트 9 |	통과 (2.73ms, 73.1MB)|
|테스트 10 |	통과 (0.93ms, 75.3MB)|
|테스트 11 |	통과 (2.21ms, 78.6MB)|