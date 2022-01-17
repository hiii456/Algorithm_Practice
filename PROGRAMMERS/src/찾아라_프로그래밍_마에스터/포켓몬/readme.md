## Programmers - 포켓몬 
- Level 1
- Implement 
- 찾아라 프로그래밍 마에스터
🔗[포켓몬 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/1845)



## 풀이

처음 조합으로 해서 푼 코드는 테스트 7번부터 시간초과가 났다.
근데 최대값을 구하는 건데 N/2개 까지 가져갈 수 있다고 했으면 무조건 최대값은 N/2가 된다.
단, 중복을 제거한 리스트의 크기가 N/2보다 작을경우에는 리스트의 크기를 출력한다.
너무 꼬아서 생각한 문제였다..

## 소스코드

### 처음 푼 코드 

~~~java
import java.util.*;
class Solution {
    static int[] tgt;
    static int answer = 0;
    static HashSet<Integer> hs;
    public int solution(int[] nums) {
        int len = nums.length;
        tgt = new int[len/2];

        comb(0,0,nums);
        
        return answer;
    }
    public static void comb(int tgtIdx,int srcIdx,int[] nums){
        if(tgtIdx == nums.length/2){
            hs = new HashSet<>();
            for(int i=0; i<tgt.length; i++){
                hs.add(tgt[i]);
            }
            answer = Math.max(answer,hs.size());
            return;
        }
        
        for(int i=srcIdx; i<nums.length; i++){
            tgt[tgtIdx] = nums[i];
            comb(tgtIdx+1,i+1,nums);
        }
        
    }
}
~~~

### 수정 코드 

~~~java
import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int len = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        
        if(hs.size()<len/2){
            return hs.size();
        }else{
            return len/2;
        }
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.04ms, 74.8MB)|
|테스트 2 |	통과 (0.04ms, 74.2MB)|
|테스트 3 |	통과 (0.04ms, 75.9MB)|
|테스트 4 |	통과 (0.04ms, 75MB)|
|테스트 5 |	통과 (0.04ms, 75.3MB)|
|테스트 6 |	통과 (0.09ms, 78.8MB)|
|테스트 7 |	통과 (0.37ms, 77.7MB)|
|테스트 8 |	통과 (0.19ms, 78.2MB)|
|테스트 9 |	통과 (0.23ms, 66.5MB)|
|테스트 10 |	통과 (0.32ms, 77.1MB)|
|테스트 11 |	통과 (0.27ms, 78MB)|
|테스트 12 |	통과 (0.35ms, 73.2MB)|
|테스트 13 |	통과 (0.49ms, 76.6MB)|
|테스트 14 |	통과 (0.71ms, 86.5MB)|
|테스트 15 |	통과 (0.57ms, 73.7MB)|
|테스트 16 |	통과 (2.41ms, 81.5MB)|
|테스트 17 |	통과 (2.37ms, 83.6MB)|
|테스트 18 |	통과 (4.30ms, 83MB)|
|테스트 19 |	통과 (2.45ms, 81.1MB)|
|테스트 20 |	통과 (2.24ms, 80.4MB)|