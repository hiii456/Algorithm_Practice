## Programmers - 입국심사 
- Level 3 
- BinarySearch 
🔗[입국심사 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/43238)



## 풀이

이진탐색의 개념을 익힐겸 프로그래머스에서 하나 풀어보았다.
이진탐색에서 주의해야할 점은 int,long 타입 주의 (변수의 크기를 잘보자..) 하는 것과 
구하는 값이 최대값인지 최소값인지 잘 알아보는 것인것 같다.

나같은 경우는 처음에 이진탐색을 하는 과정에서 cnt(이진탐색하면서 구한 입국심사한 사람의 수)와 n(입국심사해야할 사람의 수)를 비교할 떄 
cnt가 n보다 같거나 작을때 left값을 mid+1로 갱신해주었으나, 이 문제는 입국심사시간의 최솟값을 구하는 문제이므로 cnt와 n이 같은 경우에는 
right를 갱신시켜주어야 한다. (cnt와 n이 같은 경우가 여러개일 수도 있으므로!)

~~~java
            // 입국심사할 인원이 더 많아야 하면 시간 범위를 늘려야 한다.
            if(cnt<n){
                left = mid + 1;
            }
            // 입국심사할 인원이 더 적어야 한다면 시간 범위를 줄인다.
            else{
                right = mid - 1;
                answer = mid;
            } 
~~~


## 소스코드
~~~java
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 1;
        // 모든 사람이 심사를 받는데 걸리는 최대값 : 인원수 * 젤 오래걸리는 심사시간 
        long right = (long) n * times[times.length - 1];
        
        while(left<=right){
            long mid = (left+right)/2;
            long cnt = 0;
            for(int i=0; i<times.length; i++){
                cnt += mid/times[i];
            }
            // 입국심사할 인원이 더 많아야 하면 시간 범위를 늘려야 한다.
            if(cnt<n){
                left = mid + 1;
            }
            // 입국심사할 인원이 더 적어야 한다면 시간 범위를 줄인다.
            else{
                right = mid - 1;
                answer = mid;
            }            
        }
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.38ms, 86.5MB)|
|테스트 2 |	통과 (0.51ms, 72.9MB)|
|테스트 3 |	통과 (2.75ms, 80.3MB)|
|테스트 4 |	통과 (89.61ms, 92.9MB)|
|테스트 5 |	통과 (80.24ms, 83.2MB)|
|테스트 6 |	통과 (95.61ms, 92.8MB)|
|테스트 7 |	통과 (113.63ms, 101MB)|
|테스트 8 |	통과 (96.33ms, 87.5MB)|
|테스트 9 |	통과 (0.37ms, 77.3MB)|