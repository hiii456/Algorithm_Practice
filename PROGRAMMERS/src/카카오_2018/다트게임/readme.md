## Programmers - ๋คํธ๊ฒ์ 
- Level 1
- String
๐[๋คํธ๊ฒ์ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://programmers.co.kr/learn/courses/30/lessons/17682)

๐๐ฅ๐ฅ๐ฅ

## ํ์ด

์ฝ๊ฒ ํ ์ ์๋ ๋ฌธ์์ด~~~ ์ธ๋ฑ์ค๋ง ์กฐ์ฌํด์ ํ๋ฉด ๊ธ๋ฐฉ ํ ์ ์๋ค.


## ์์ค์ฝ๋
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

## ๊ฒฐ๊ณผ 

| ์ ํ์ฑ  | ํ์คํธ |
|----|----|
|ํ์คํธ 1 |	ํต๊ณผ (0.02ms, 81.1MB)|
|ํ์คํธ 2 |	ํต๊ณผ (0.02ms, 74.2MB)|
|ํ์คํธ 3 |	ํต๊ณผ (0.04ms, 73.1MB)|
|ํ์คํธ 4 |	ํต๊ณผ (0.03ms, 78.5MB)|
|ํ์คํธ 5 |	ํต๊ณผ (0.03ms, 74.9MB)|
|ํ์คํธ 6 |	ํต๊ณผ (0.03ms, 74.9MB)|
|ํ์คํธ 7 |	ํต๊ณผ (0.03ms, 77.5MB)|
|ํ์คํธ 8 |	ํต๊ณผ (0.02ms, 74.4MB)|
|ํ์คํธ 9 |	ํต๊ณผ (0.02ms, 73.6MB)|
|ํ์คํธ 10 |	ํต๊ณผ (0.02ms, 75.5MB)|
|ํ์คํธ 11 |	ํต๊ณผ (0.03ms, 72.1MB)|
|ํ์คํธ 12 |	ํต๊ณผ (0.03ms, 69.8MB)|
|ํ์คํธ 13 |	ํต๊ณผ (0.03ms, 74.3MB)|
|ํ์คํธ 14 |	ํต๊ณผ (0.02ms, 72.7MB)|
|ํ์คํธ 15 |	ํต๊ณผ (0.02ms, 75.3MB)|
|ํ์คํธ 16 |	ํต๊ณผ (0.02ms, 72.9MB)|
|ํ์คํธ 17 |	ํต๊ณผ (0.02ms, 76.3MB)|
|ํ์คํธ 18 |	ํต๊ณผ (0.04ms, 77.6MB)|
|ํ์คํธ 19 |	ํต๊ณผ (0.03ms, 72.9MB)|
|ํ์คํธ 20 |	ํต๊ณผ (0.02ms, 73.8MB)|
|ํ์คํธ 21 |	ํต๊ณผ (0.03ms, 75.1MB)|
|ํ์คํธ 22 |	ํต๊ณผ (0.02ms, 70.1MB)|
|ํ์คํธ 23 |	ํต๊ณผ (0.03ms, 69MB)|
|ํ์คํธ 24 |	ํต๊ณผ (0.04ms, 72.7MB)|
|ํ์คํธ 25 |	ํต๊ณผ (0.03ms, 70.2MB)|
|ํ์คํธ 26 |	ํต๊ณผ (0.03ms, 72.3MB)|
|ํ์คํธ 27 |	ํต๊ณผ (0.02ms, 77.1MB)|
|ํ์คํธ 28 |	ํต๊ณผ (0.02ms, 73.9MB)|
|ํ์คํธ 29 |	ํต๊ณผ (0.02ms, 74.7MB)|
|ํ์คํธ 30 |	ํต๊ณผ (0.03ms, 80.4MB)|
|ํ์คํธ 31 |	ํต๊ณผ (0.03ms, 74.7MB)|
|ํ์คํธ 32 |	ํต๊ณผ (0.05ms, 93.1MB)|