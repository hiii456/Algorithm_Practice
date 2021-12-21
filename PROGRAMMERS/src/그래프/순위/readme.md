## Programmers - 순위 
- Graph , Floyd-Warshall
- Level3

🔗[순위 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/49191)

## 풀이
모든 정점의 연결의 유무를 파악해야했기 때문에 플로이드-워셜 알고리즘을 사용했습니다.
먼저 int형의 2차원 인접행렬을 생성해주고 최대값 INF를 채워줍니다.

~~~java
	for (int[] arr : matrix) {
        	Arrays.fill(arr, INF);
	}
~~~

results에서 인접한 행렬은 1로 표시를 해줍니다.
그리고 플로이드-워셜 알고리즘을 통해 모든 정점의 모든 정점으로 부터 최소거리를 구해줍니다.

~~~java
	for(int k=1; k<=n; k++) {
        	// 출발지 
        	for(int i=1; i<=n; i++) {
        		// 출발지와 경유지가 같다면 다음 출발지 
        		if(i==k)	continue;
        		// 도착지 
        		for(int j=1; j<=n; j++) {
        			// 도착지가 경유지나 출발지와 같다면 continue
        			if(j==k || j==i)	continue;
        			if(matrix[i][j]>matrix[i][k] + matrix[k][j]) {
        				matrix[i][j] = matrix[i][k] + matrix[k][j];
        			}
        		}
        	}
        }
~~~
그리고 인접행렬을 탐색하여 연결이 되어있다면 answer을 count 해주어 답을 구하였습니다.


## 막힌점 
플로이드-워셜 알고리즘을 너무 오랜만에 사용해서 개념을 다시 익힌 후 적용해서 문제를 풀었습니다.

## 소스코드
~~~java
import java.util.*;

public class 순위 {
	static final int INF = 9999999;
	static int[][] matrix;
	public int solution(int n, int[][] results) {
		int answer = 0;
        // 인접행렬 
        matrix = new int[n+1][n+1];
        // INF로 행렬을 다 채운다. (인접하지 않으면 INF)
        for (int[] arr : matrix) {
        	Arrays.fill(arr, INF);
		}
        // 인접한 행렬은 1로 채우기! 승패가 있으므로 단뱡향 그래프 
        for (int[] arr : results) {
			matrix[arr[0]][arr[1]] = 1;
		}
        // 경유지 
        for(int k=1; k<=n; k++) {
        	// 출발지 
        	for(int i=1; i<=n; i++) {
        		// 출발지와 경유지가 같다면 다음 출발지 
        		if(i==k)	continue;
        		// 도착지 
        		for(int j=1; j<=n; j++) {
        			// 도착지가 경유지나 출발지와 같다면 continue
        			if(j==k || j==i)	continue;
        			if(matrix[i][j]>matrix[i][k] + matrix[k][j]) {
        				matrix[i][j] = matrix[i][k] + matrix[k][j];
        			}
        		}
        	}
        }
        
        
        for(int i=1; i<=n; i++) {
        	boolean check = true;
        	for(int j=1; j<=n; j++) {
        		// 자기 자신이 아닌 경우 
        		if(i==j)	continue;
        		// 어느 한쪽이라도 연결이 안되어있는 경우 false 
        		if(matrix[i][j]==INF && matrix[j][i]==INF) {
        			check = false;
        		}
        	}
        	if(check) {
        		answer++;
        	}
        }
        

        return answer;
        
	      
    }

}

~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.04ms, 51.9MB)|
|테스트 2 |	통과 (0.07ms, 52.8MB)|
|테스트 3 |	통과 (0.11ms, 53.1MB)|
|테스트 4 |	통과 (0.61ms, 52.6MB)|
|테스트 5 |	통과 (1.87ms, 52.3MB)|
|테스트 6 |	통과 (6.82ms, 55.1MB)|
|테스트 7 |	통과 (12.70ms, 53.1MB)|
|테스트 8 |	통과 (15.29ms, 54.8MB)|
|테스트 9 |	통과 (18.90ms, 55.1MB)|
|테스트 10 |	통과 (27.29ms, 57.3MB)|