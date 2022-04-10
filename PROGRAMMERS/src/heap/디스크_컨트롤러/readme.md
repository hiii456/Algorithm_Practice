## Programmers - 디스크 컨트롤러 
- Level 3 
- Heap  
🔗[디스크 컨트롤러 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42627)



## 풀이

이 문제는 Compaeable을 사용하여 작업시간이 적은 작업부터 먼저 처리를 해주어 답을 구하였다.

이 문제에서 막혔던 부분은 list를 삭제해줄때 길이도 변동되므로 break와 while문을 통해 순차적으로 작업을 처리해야 되는 것을 고려했어야 되는 부분이다.


## 소스코드
~~~java
import java.util.*;
class Solution {
    static class Job implements Comparable<Job>{
        int start;
        int work;
        public Job(int start,int work){
            this.start = start;
            this.work = work;
        }
        @Override
        public int compareTo(Job o){
            return work - o.work;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        
        List<Job> list = new ArrayList<>();
        for(int i=0; i<jobs.length; i++){
            int a = jobs[i][0];
            int b = jobs[i][1];
            
            list.add(new Job(a,b));
        }
        
        Collections.sort(list);
        
        int time = 0;
        int total = 0;
        while(list.size()>0){
            for(int i=0; i<list.size(); i++){
                Job job = list.get(i);
                if(time >= job.start){
                    time += job.work;
                    total += time - job.start;
                    list.remove(i);
                    break;
                }
                // 처리할 요청이 없으면 
                if(i == list.size()-1){
                    time++;
                }
            }
        }
        
        answer = total/jobs.length;
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (1.83ms, 76.1MB)|
|테스트 2 |	통과 (1.11ms, 76.3MB)|
|테스트 3 |	통과 (1.21ms, 79.2MB)|
|테스트 4 |	통과 (1.07ms, 74.6MB)|
|테스트 5 |	통과 (1.32ms, 74.5MB)|
|테스트 6 |	통과 (0.51ms, 75.6MB)|
|테스트 7 |	통과 (1.19ms, 76.3MB)|
|테스트 8 |	통과 (1.07ms, 75.6MB)|
|테스트 9 |	통과 (1.43ms, 81.3MB)|
|테스트 10 |	통과 (1.54ms, 77.7MB)|
|테스트 11 |	통과 (0.43ms, 76.1MB)|
|테스트 12 |	통과 (0.55ms, 66.3MB)|
|테스트 13 |	통과 (0.53ms, 75.9MB)|
|테스트 14 |	통과 (0.37ms, 76.2MB)|
|테스트 15 |	통과 (0.37ms, 78MB)|
|테스트 16 |	통과 (0.38ms, 75.2MB)|
|테스트 17 |	통과 (0.36ms, 80.5MB)|
|테스트 18 |	통과 (0.37ms, 77.5MB)|
|테스트 19 |	통과 (0.37ms, 75MB)|
|테스트 20 |	통과 (0.33ms, 77.2MB)|