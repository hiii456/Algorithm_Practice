## Programmers - 쿼드압축 후 개수 세기 
- Level 2 
- divide and conquer 
🔗[쿼드압축 후 개수 세기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/68936)



## 풀이

이 문제는 분할정복 알고리즘을 이용해서 풀어야 했다.

배열을 작은 영역으로 나누는 작업, 더 이상 나누어 지지 않을때까지 재귀를 이용한 탐색 

~~~java
    public static void div(int startr,int startc,int size,int[][] arr){
        if(check(startr,startc,size,arr)){
            answer[arr[startr][startc]]++;
            return;
        }
        
        div(startr, startc, size/2, arr);
        div(startr + size/2 , startc , size/2, arr);
        div(startr, startc + size/2 , size/2, arr);
        div(startr + size/2,startc + size/2,size/2,arr);
        
    }
~~~

분할된 배열 안의 숫자가 모두 일치하는지 확인하는 작업 

~~~java
    public static boolean check(int r,int c,int size,int[][] arr){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[r][c] != arr[i][j])  return false;
            }
        }
        return true;
    }
~~~


## 소스코드
~~~java
class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        div(0,0,arr.length,arr);
        return answer;
    }
    public static void div(int startr,int startc,int size,int[][] arr){
        if(check(startr,startc,size,arr)){
            answer[arr[startr][startc]]++;
            return;
        }
        
        div(startr, startc, size/2, arr);
        div(startr + size/2 , startc , size/2, arr);
        div(startr, startc + size/2 , size/2, arr);
        div(startr + size/2,startc + size/2,size/2,arr);
        
    }
    public static boolean check(int r,int c,int size,int[][] arr){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[r][c] != arr[i][j])  return false;
            }
        }
        return true;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.19ms, 79.2MB)|
|테스트 2 |	통과 (0.18ms, 75MB)|
|테스트 3 |	통과 (0.07ms, 75.3MB)|
|테스트 4 |	통과 (0.04ms, 86.6MB)|
|테스트 5 |	통과 (5.61ms, 98.2MB)|
|테스트 6 |	통과 (2.78ms, 95.7MB)|
|테스트 7 |	통과 (4.76ms, 90.3MB)|
|테스트 8 |	통과 (2.36ms, 101MB)|
|테스트 9 |	통과 (4.17ms, 102MB)|
|테스트 10|	통과 (6.40ms, 129MB)|
|테스트 11 |	통과 (0.05ms, 77MB)|
|테스트 12 |	통과 (0.03ms, 75MB)|
|테스트 13 |	통과 (4.70ms, 81.5MB)|
|테스트 14 |	통과 (11.57ms, 125MB)|
|테스트 15 |	통과 (7.96ms, 129MB)|
|테스트 16 |	통과 (2.69ms, 94.3MB)|