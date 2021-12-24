## Programmers - 위장 
- Hash 
- Level2
- 🔗[위장 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42578)

## 풀이

hashmap에 옷의 종류와 갯수 별로 넣어주었습니다. 이때 key가 없으면 기본값을, 아니면 value값을 불러오는 getOrDefault를 사용했습니다.

~~~java
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String cloth = clothes[i][1];
            hm.put(cloth,hm.getOrDefault(cloth,0)+1);
        }
~~~

그리고 경우의 수를 구하기 위해서는 옷의 종류 갯수 + 1 한값을 모두 곱한 뒤 (옷을 입거나 안입거나 이므로) 
하나도 안입는 경우는 없으므로 -1을 뺀다.



## 소스코드
~~~java
import java.util.*;

public class 위장 {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String cloth = clothes[i][1];
            hm.put(cloth,hm.getOrDefault(cloth,0)+1);
        }
        
        for(String key : hm.keySet()){
            answer *= (hm.get(key) + 1);
        }
        
        answer -= 1;
        
        return answer;
    }

}

~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.07ms, 76.3MB)|
|테스트 2 |	통과 (0.07ms, 70.2MB)|
|테스트 3 |	통과 (1.73ms, 84.3MB)|
|테스트 4 |	통과 (0.09ms, 69.5MB)|
|테스트 5 |	통과 (0.06ms, 72.6MB)|
|테스트 6 |	통과 (0.07ms, 73.9MB)|
|테스트 7 |	통과 (0.08ms, 78.3MB)|
|테스트 8 |	통과 (0.07ms, 74.8MB)|
|테스트 9 |	통과 (0.05ms, 75.8MB)|
|테스트 10 |	통과 (0.03ms, 75.1MB)|
|테스트 11 |	통과 (0.05ms, 77.6MB)|
|테스트 12 |	통과 (0.07ms, 77.1MB)|
|테스트 13 |	통과 (0.06ms, 74.4MB)|
|테스트 14 |	통과 (0.07ms, 68.7MB)|
|테스트 15 |	통과 (0.04ms, 78.8MB)|
|테스트 16 |	통과 (0.04ms, 73.2MB)|
|테스트 17 |	통과 (0.08ms, 74.3MB)|
|테스트 18 |	통과 (0.04ms, 72.6MB)|
|테스트 19 |	통과 (0.05ms, 78.3MB)|
|테스트 20 |	통과 (0.06ms, 85.2MB)|
|테스트 21 |	통과 (0.03ms, 68.2MB)|
|테스트 22 |	통과 (0.05ms, 72.5MB)|
|테스트 23 |	통과 (0.04ms, 82.3MB)|
|테스트 24 |	통과 (0.05ms, 76.9MB)|
|테스트 25 |	통과 (0.05ms, 71.5MB)|
|테스트 26 |	통과 (0.07ms, 75.6MB)|
|테스트 27 |	통과 (0.07ms, 71.7MB)|
|테스트 28 |	통과 (0.07ms, 72.2MB)|