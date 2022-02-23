## Programmers - 징검다리 건너기 
- Level 3
- BinarySearch  
- 2019 카카오 개발자 겨울 인턴십
🔗[징검다리 건너기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/64062)



## 풀이

효율성까지 체크하는 문제라고 해서 이진탐색을 사용해야했다.
먼저 min와 max는 징검다리 각 원소의 최솟값과 최대값으로 설정해주었다.
cross 메소드는 현재 주어진 stones배열과 임의의 친구의 수 mid가 주어지면, 모두 건널수 있는지 확인하는 메소드이다.

~~~java
	public static boolean cross(int[] stones,int k,int mid){
        int cnt = 0;
        for(int stone : stones){
            if(stone - mid<0){
                cnt++;
            }else{
                cnt = 0;
            }
            
            if(cnt == k){
                return false;
            }
        }
        
        return true;
    } 
~~~

만약 mid명의 친구가 징검다리를 건너지 못한다면 max의 값을 mid-1로, 건널 수 있다면 min = mid+1로 바꾼다음 친구 수의 최대값을 구해주었다.

~~~java
	while(min<=max){
            int mid = (min+max)/2;
            
            if(!cross(stones,k,mid)){
                max = mid - 1;
            }else{
                min = mid + 1;
                answer = Math.max(answer,mid);
            }
            
        }
~~~


## 소스코드
~~~java
import java.util.*;
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while(min<=max){
            int mid = (min+max)/2;
            
            if(!cross(stones,k,mid)){
                max = mid - 1;
            }else{
                min = mid + 1;
                answer = Math.max(answer,mid);
            }
            
        }
        return answer;
    }
    public static boolean cross(int[] stones,int k,int mid){
        int cnt = 0;
        for(int stone : stones){
            if(stone - mid<0){
                cnt++;
            }else{
                cnt = 0;
            }
            
            if(cnt == k){
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
테스트 1 |	통과 (0.02ms, 77.8MB)|
테스트 2 |	통과 (0.10ms, 76.9MB)|
테스트 3 |	통과 (0.04ms, 81.6MB)|
테스트 4 |	통과 (0.04ms, 84.5MB)|
테스트 5 |	통과 (0.10ms, 78.8MB)|
테스트 6 |	통과 (0.12ms, 72.3MB)|
테스트 7 |	통과 (0.25ms, 76.6MB)|
테스트 8 |	통과 (0.24ms, 77.1MB)|
테스트 9 |	통과 (0.19ms, 68.9MB)|
테스트 10 |	통과 (0.04ms, 67.7MB)|
테스트 11 |	통과 (0.03ms, 76.1MB)|
테스트 12 |	통과 (0.04ms, 77.7MB)|
테스트 13 |	통과 (0.11ms, 73.4MB)|
테스트 14 |	통과 (0.10ms, 74.6MB)|
테스트 15 |	통과 (0.24ms, 81.9MB)|
테스트 16 |	통과 (0.20ms, 72.2MB)|
테스트 17 |	통과 (0.25ms, 77.2MB)|
테스트 18 |	통과 (0.12ms, 76.5MB)|
테스트 19 |	통과 (0.05ms, 79MB)|
테스트 20 |	통과 (0.06ms, 75.4MB)|
테스트 21 |	통과 (0.12ms, 66.6MB)|
테스트 22 |	통과 (0.42ms, 71.1MB)|
테스트 23 |	통과 (0.36ms, 74.9MB)|
테스트 24 |	통과 (0.26ms, 73.3MB)|
테스트 25 |	통과 (0.03ms, 79MB)|
-------
|효율성 | 테스트|
|----|----|
|테스트 1 |	통과 (19.62ms, 61.6MB)|
|테스트 2 |	통과 (20.23ms, 61.7MB)|
|테스트 3 |	통과 (23.90ms, 61.6MB)|
|테스트 4 |	통과 (15.15ms, 61.7MB)|
|테스트 5 |	통과 (13.93ms, 62.3MB)|
|테스트 6 |	통과 (21.49ms, 61.9MB)|
|테스트 7 |	통과 (20.87ms, 61.7MB)|
|테스트 8 |	통과 (25.29ms, 61.2MB)|
|테스트 9 |	통과 (20.45ms, 62MB)|
|테스트 10 |	통과 (20.61ms, 61.7MB)|
|테스트 11 |	통과 (20.60ms, 61.6MB)|
|테스트 12 |	통과 (19.81ms, 62MB)|
|테스트 13 |	통과 (20.17ms, 61.7MB)|
|테스트 14 |	통과 (16.35ms, 62MB)|