## Programmers - 네트워크 
- Union-find
- Level 3
🔗[네트워크 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/43162)


## 풀이

이 문제는 dfs로 풀어봤던 문제인데 이번에는 union-find 알고리즘을 이용해서 문제를 풀었다! 


## 소스코드
~~~java
import java.util.*;

public class 네트워크 {
	static int[] parents;
    static int find(int a){
        if(parents[a]==a){
            return a;
        }
        
        return parents[a] = find(parents[a]);
    }
    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot!=bRoot){
            parents[bRoot] = aRoot;
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parents = new int[n];
        
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1){
                    union(i,j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set.add(find(parents[i]));
        }
        
        answer = set.size();
        return answer;
    }

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.12ms, 69.1MB)|
|테스트 2 |	통과 (0.07ms, 73MB)|
|테스트 3 |	통과 (0.20ms, 69.1MB)|
|테스트 4 |	통과 (0.20ms, 70.1MB)|
|테스트 5 |	통과 (0.04ms, 58.6MB)|
|테스트 6 |	통과 (0.35ms, 58.8MB)|
|테스트 7 |	통과 (0.17ms, 60.6MB)|
|테스트 8 |	통과 (0.22ms, 72.1MB)|
|테스트 9 |	통과 (0.17ms, 74.6MB)|
|테스트 10 |	통과 (0.16ms, 69.4MB)|
|테스트 11 |	통과 (0.49ms, 62.4MB)|
|테스트 12 |	통과 (0.45ms, 72.8MB)|
|테스트 13 |	통과 (0.26ms, 59.9MB)|
