## Programmers - 메뉴 리뉴얼 
- Level 2 
- BruteForce, Hash  
🔗[메뉴 리뉴얼 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/72411)



## 풀이

문제를 꼼꼼히 읽어야 겠다는 생각이 들었던 문제! 조합과 hash를 사용해서 풀었다. 풀이 내용은 주석 참고!


## 소스코드
~~~java
import java.util.*;
class Solution {
    static HashMap<String,Integer> hm;
    static char[] tgt;
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            hm = new HashMap<>();
		    tgt = new char[course[i]];
		    // 코스 종류를 오름차순 해주는 작업 
		    for(int j=0; j<orders.length; j++){
		        char[] tmp = orders[j].toCharArray();
		        Arrays.sort(tmp);
		        orders[j] = String.valueOf(tmp); 
		        // 각 course 길이 만큼의 조합을 구한다.
		        comb(0,0,tmp);
		    }
            int max = Integer.MIN_VALUE;
            // 많이 주문한 코스의 주문 수를 구한다.
            for(String key : hm.keySet()){
                max = Math.max(max,hm.get(key));
            }
            // 미리 구한 max만큼 주문 수가 들어왔으면서 주문 수가 2 이상인 코스를 answer에 저장한다.
            for(String key : hm.keySet()){
                if(hm.get(key)==max && hm.get(key)>=2){
                    answer.add(key);
                }
            }
            
		}
     
        Collections.sort(answer);
        
        return answer;
    }
    public static void comb(int srcIdx,int tgtIdx,char[] tmp){
        if(tgtIdx == tgt.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<tgt.length; i++){
                sb.append(tgt[i]);
            }
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i=srcIdx; i<tmp.length; i++){
            tgt[tgtIdx] = tmp[i];
            comb(i+1,tgtIdx+1,tmp);
        }
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.96ms, 79MB)|
|테스트 2 |	통과 (0.88ms, 69.6MB)|
|테스트 3 |	통과 (1.00ms, 77.9MB)|
|테스트 4 |	통과 (1.08ms, 77.4MB)|
|테스트 5 |	통과 (0.94ms, 80MB)|
|테스트 6 |	통과 (1.54ms, 82.5MB)|
|테스트 7 |	통과 (1.86ms, 74.1MB)|
|테스트 8 |	통과 (4.89ms, 85.3MB)|
|테스트 9 |	통과 (4.83ms, 78.2MB)|
|테스트 10 |	통과 (5.58ms, 76.1MB)|
|테스트 11 |	통과 (2.77ms, 80.4MB)|
|테스트 12 |	통과 (5.09ms, 79.6MB)|
|테스트 13 |	통과 (10.02ms, 78.5MB)|
|테스트 14 |	통과 (8.54ms, 79.2MB)|
|테스트 15 |	통과 (10.23ms, 84.3MB)|
|테스트 16 |	통과 (28.51ms, 87.7MB)|
|테스트 17 |	통과 (3.25ms, 81MB)|
|테스트 18 |	통과 (3.03ms, 78MB)|
|테스트 19 |	통과 (1.80ms, 78.7MB)|
|테스트 20 |	통과 (2.45ms, 79.7MB)|