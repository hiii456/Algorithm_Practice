## Programmers - N-Queen 
- Back Tracking
- Level 3

๐[N-Queen ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://programmers.co.kr/learn/courses/30/lessons/12952)


## ํ์ด

์ค๋์ ๋ฐฑํธ๋ํน ๊ธฐ๋ณธ๋ฌธ์ ๋ผ ํ  ์ ์๋ N-Queen์ ํ์ด๋ณด์๋ค! 
N- Queen ์ด๋ ์ฒด์คํ ์์ n๊ฐ์ ํธ์ด ์๋ก๋ฅผ ๊ณต๊ฒฉํ  ์ ์๋๋ก ๋ฐฐ์นํ๋ ๊ฒ์ด๋ค.

~~~java

        for(int i=0; i<row; i++){
            if(cols[i] == cols[row] || Math.abs(row-i) == Math.abs(cols[row]-cols[i])){
                return false;
            }
        }
        return true;
    }
~~~

์ฌ๊ธฐ์ ํธ์ด ์๋ก ๊ณต๊ฒฉํ  ์ ์๊ฒ ํ๋ ค๋ฉด isPossible ๋ฉ์๋๋ฅผ ํตํด
ํธ์ด ์๋ก ๊ฐ์ ์ด์ ์์นํ์ง ์๊ณ  ๋๊ฐ์  ์์ ๋์ฌ์์ง ์๋ ๊ฒฝ์ฐ๋ฅผ ๋ง์กฑํด์ผ ํ๋ค.

~~~java
    public void backTracking(int n,int row){
        if(row == n){
            answer++;
            return;
        }
        else{
            for(int i=0; i<n; i++){
                cols[row] = i;
                if(isPossible(row)){
                    backTracking(n,row+1);
                }
            }
        }
    }
~~~

๋จผ์  row (N-1๊น์ง) ๋ ๋ชจ๋ ์กฐ๊ฑด์ ๋ง์กฑํ๋ ๊ฒฝ์ฐ์ ํธ์ ๋ฐฐ์นํ๋ค. 
๊ทธ๋ฆฌ๊ณ  row๊ฐ N์ด ๋๋ฉด ์ด์  ๋ชจ๋  ํธ์ ๋์๋ค๋ ๋ป์ผ๋ก count๋ฅผ ํด์ค๋ค.


## ์์ค์ฝ๋
~~~java
import java.util.*;
class Solution {
    static int answer = 0;
    static int[] cols;
    public int solution(int n) {

        for(int i=0; i<n; i++){
            cols = new int[n];
            cols[0] = i;
            backTracking(n,1);
        }
        
        return answer;
    }
    public void backTracking(int n,int row){
        if(row == n){
            answer++;
            return;
        }
        else{
            for(int i=0; i<n; i++){
                cols[row] = i;
                if(isPossible(row)){
                    backTracking(n,row+1);
                }
            }
        }
    }
    public boolean isPossible(int row){
        for(int i=0; i<row; i++){
            if(cols[i] == cols[row] || Math.abs(row-i) == Math.abs(cols[row]-cols[i])){
                return false;
            }
        }
        return true;
    }
    
}

~~~

## ๊ฒฐ๊ณผ 

| ์ ํ์ฑ  | ํ์คํธ |
|----|----|
|ํ์คํธ 1 |	ํต๊ณผ (0.02ms, 89.6MB)|
|ํ์คํธ 2 |	ํต๊ณผ (0.03ms, 75.6MB)|
|ํ์คํธ 3 |	ํต๊ณผ (0.05ms, 69.2MB)|
|ํ์คํธ 4 |	ํต๊ณผ (0.12ms, 75MB)|
|ํ์คํธ 5 |	ํต๊ณผ (0.51ms, 81.1MB)|
|ํ์คํธ 6 |	ํต๊ณผ (1.50ms, 69.8MB)|
|ํ์คํธ 7 |	ํต๊ณผ (5.31ms, 71.2MB)|
|ํ์คํธ 8 |	ํต๊ณผ (8.20ms, 75.7MB)|
|ํ์คํธ 9 |	ํต๊ณผ (17.72ms, 80.7MB)|
|ํ์คํธ 10 |	ํต๊ณผ (63.25ms, 88.9MB)|
|ํ์คํธ 11 |	ํต๊ณผ (195.69ms, 81.7MB)|
