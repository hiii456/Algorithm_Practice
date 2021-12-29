## Programmers - 다트게임 
- Level 1
- String
🔗[다트게임 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/17682)

🏅🥇🥈🥉

## 풀이

쉽게 풀 수 있는 문자열~~~ 인덱스만 조심해서 풀면 금방 풀 수 있다.


## 소스코드
~~~java
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] cnt = new int[3];        
        int seq = -1;
        
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            if(ch>='0' && ch<='9'){
                seq++;
                if(ch == '1' && dartResult.charAt(i+1) == '0'){
                    cnt[seq] = 10;
                    i++;
                }else{
                    cnt[seq] = ch - '0';
                }
            }
            
            if(ch == 'D'){
                cnt[seq] *= cnt[seq];
            }else if(ch == 'T'){
                cnt[seq] *= cnt[seq] * cnt[seq];
            }
            
            if(ch == '*'){
                if(seq==0){
                    cnt[seq] *= 2;
                }else{
                    cnt[seq-1] *= 2;
                    cnt[seq] *= 2;
                }
            }
            
            if(ch == '#'){
                cnt[seq] *= -1;
            }
        }
        
        for(int i=0; i<3; i++){
            answer += cnt[i];
        }
  
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.02ms, 81.1MB)|
|테스트 2 |	통과 (0.02ms, 74.2MB)|
|테스트 3 |	통과 (0.04ms, 73.1MB)|
|테스트 4 |	통과 (0.03ms, 78.5MB)|
|테스트 5 |	통과 (0.03ms, 74.9MB)|
|테스트 6 |	통과 (0.03ms, 74.9MB)|
|테스트 7 |	통과 (0.03ms, 77.5MB)|
|테스트 8 |	통과 (0.02ms, 74.4MB)|
|테스트 9 |	통과 (0.02ms, 73.6MB)|
|테스트 10 |	통과 (0.02ms, 75.5MB)|
|테스트 11 |	통과 (0.03ms, 72.1MB)|
|테스트 12 |	통과 (0.03ms, 69.8MB)|
|테스트 13 |	통과 (0.03ms, 74.3MB)|
|테스트 14 |	통과 (0.02ms, 72.7MB)|
|테스트 15 |	통과 (0.02ms, 75.3MB)|
|테스트 16 |	통과 (0.02ms, 72.9MB)|
|테스트 17 |	통과 (0.02ms, 76.3MB)|
|테스트 18 |	통과 (0.04ms, 77.6MB)|
|테스트 19 |	통과 (0.03ms, 72.9MB)|
|테스트 20 |	통과 (0.02ms, 73.8MB)|
|테스트 21 |	통과 (0.03ms, 75.1MB)|
|테스트 22 |	통과 (0.02ms, 70.1MB)|
|테스트 23 |	통과 (0.03ms, 69MB)|
|테스트 24 |	통과 (0.04ms, 72.7MB)|
|테스트 25 |	통과 (0.03ms, 70.2MB)|
|테스트 26 |	통과 (0.03ms, 72.3MB)|
|테스트 27 |	통과 (0.02ms, 77.1MB)|
|테스트 28 |	통과 (0.02ms, 73.9MB)|
|테스트 29 |	통과 (0.02ms, 74.7MB)|
|테스트 30 |	통과 (0.03ms, 80.4MB)|
|테스트 31 |	통과 (0.03ms, 74.7MB)|
|테스트 32 |	통과 (0.05ms, 93.1MB)|