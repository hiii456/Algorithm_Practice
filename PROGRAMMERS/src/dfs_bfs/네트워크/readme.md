## Programmers - ๋คํธ์ํฌ 
- Union-find
- Level 3
๐[๋คํธ์ํฌ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://programmers.co.kr/learn/courses/30/lessons/43162)


## ํ์ด

์ด ๋ฌธ์ ๋ dfs๋ก ํ์ด๋ดค๋ ๋ฌธ์ ์ธ๋ฐ ์ด๋ฒ์๋ union-find ์๊ณ ๋ฆฌ์ฆ์ ์ด์ฉํด์ ๋ฌธ์ ๋ฅผ ํ์๋ค! 


## ์์ค์ฝ๋
~~~java
import java.util.*;

public class ๋คํธ์ํฌ {
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

## ๊ฒฐ๊ณผ 

| ์ ํ์ฑ  | ํ์คํธ |
|----|----|
|ํ์คํธ 1 |	ํต๊ณผ (0.12ms, 69.1MB)|
|ํ์คํธ 2 |	ํต๊ณผ (0.07ms, 73MB)|
|ํ์คํธ 3 |	ํต๊ณผ (0.20ms, 69.1MB)|
|ํ์คํธ 4 |	ํต๊ณผ (0.20ms, 70.1MB)|
|ํ์คํธ 5 |	ํต๊ณผ (0.04ms, 58.6MB)|
|ํ์คํธ 6 |	ํต๊ณผ (0.35ms, 58.8MB)|
|ํ์คํธ 7 |	ํต๊ณผ (0.17ms, 60.6MB)|
|ํ์คํธ 8 |	ํต๊ณผ (0.22ms, 72.1MB)|
|ํ์คํธ 9 |	ํต๊ณผ (0.17ms, 74.6MB)|
|ํ์คํธ 10 |	ํต๊ณผ (0.16ms, 69.4MB)|
|ํ์คํธ 11 |	ํต๊ณผ (0.49ms, 62.4MB)|
|ํ์คํธ 12 |	ํต๊ณผ (0.45ms, 72.8MB)|
|ํ์คํธ 13 |	ํต๊ณผ (0.26ms, 59.9MB)|
