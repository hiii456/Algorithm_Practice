## Programmers - ์คํจ์จ 
- Level 1
- Implement 
๐[์คํจ์จ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://programmers.co.kr/learn/courses/30/lessons/42889)



## ํ์ด

intํ, doubleํ์ด ํฌํจ๋ ๊ฐ์ฒด์ ์ ๋ ฌ์ ์ ์ธํด์ฃผ๋ ๋ถ๋ถ์์ ์กฐ๊ธ ๋งํ๋ค.
๊ทธ๋ฆฌ๊ณ  ์์ธ์ฒ๋ฆฌ๋ฅผ ์ํด์ฃผ์ด์ ์ฒ์์ 5๋ฌธ์  ์ ๋ ์คํจ๊ฐ ๋์๋ค!
๋๋์์ ํ ๋ 0์ ๋๋๋ ๋ถ๋ถ ์์ธ์ฒ๋ฆฌ ํด์ฃผ๊ธฐ ๊ธฐ์ต..!!


## ์์ค์ฝ๋
~~~java
import java.util.*;
class Solution {
    static class Stage implements Comparable<Stage>{
        // ์คํ์ด์ง ๋ฒํธ, ์คํจ์จ  
        int num;
        double fail;
        public Stage(int num,double fail){
            this.num = num;
            this.fail = fail;
        }
        @Override
        public int compareTo(Stage o){
            if(o.fail - this.fail > 0)
                return 1;
            else if(o.fail == this.fail)
                return this.num - o.num;
            else
                return -1;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] user = new int[N+1];
        List<Stage> list = new ArrayList<>();
        for(int i=0; i<stages.length; i++){
            user[stages[i]-1]++;
        }
        
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<N+1; j++){
                sum += user[j];
            }
            if(user[i]==0){
                list.add(new Stage(i+1,0.0));
            }else{
                double fail = (double) user[i]/sum;
                list.add(new Stage(i+1,fail));
            }
            
        }
        
        Collections.sort(list);
        
        for(int i=0; i<N; i++){
            answer[i] = list.get(i).num;
        }
        
        return answer;
    }
}
~~~

## ๊ฒฐ๊ณผ 

| ์ ํ์ฑ  | ํ์คํธ |
|----|----|
|ํ์คํธ 1 |	ํต๊ณผ (0.46ms, 70.5MB)|
|ํ์คํธ 2 |	ํต๊ณผ (0.65ms, 74.6MB)|
|ํ์คํธ 3 |	ํต๊ณผ (3.56ms, 80.8MB)|
|ํ์คํธ 4 |	ํต๊ณผ (3.07ms, 75.5MB)|
|ํ์คํธ 5 |	ํต๊ณผ (7.15ms, 89.4MB)|
|ํ์คํธ 6 |	ํต๊ณผ (0.96ms, 72.8MB)|
|ํ์คํธ 7 |	ํต๊ณผ (1.33ms, 82.1MB)|
|ํ์คํธ 8 |	ํต๊ณผ (3.42ms, 86.1MB)|
|ํ์คํธ 9 |	ํต๊ณผ (4.26ms, 90.6MB)|
|ํ์คํธ 10 |	ํต๊ณผ (2.73ms, 79.5MB)|
|ํ์คํธ 11 |	ํต๊ณผ (3.77ms, 79.3MB)|
|ํ์คํธ 12 |	ํต๊ณผ (2.86ms, 87.7MB)|
|ํ์คํธ 13 |	ํต๊ณผ (3.78ms, 86.7MB)|
|ํ์คํธ 14 |	ํต๊ณผ (0.41ms, 77MB)|
|ํ์คํธ 15 |	ํต๊ณผ (2.55ms, 87.4MB)|
|ํ์คํธ 16 |	ํต๊ณผ (1.15ms, 74.2MB)|
|ํ์คํธ 17 |	ํต๊ณผ (2.00ms, 81.6MB)|
|ํ์คํธ 18 |	ํต๊ณผ (1.13ms, 81.8MB)|
|ํ์คํธ 19 |	ํต๊ณผ (0.57ms, 79.6MB)|
|ํ์คํธ 20 |	ํต๊ณผ (1.60ms, 74.2MB)|
|ํ์คํธ 21 |	ํต๊ณผ (4.10ms, 75.5MB)|
|ํ์คํธ 22 |	ํต๊ณผ (4.02ms, 84.3MB)|
|ํ์คํธ 23 |	ํต๊ณผ (3.93ms, 95MB)|
|ํ์คํธ 24 |	ํต๊ณผ (3.55ms, 84.8MB)|
|ํ์คํธ 25 |	ํต๊ณผ (0.41ms, 76.4MB)|
|ํ์คํธ 26 |	ํต๊ณผ (0.32ms, 78.3MB)|
|ํ์คํธ 27 |	ํต๊ณผ (0.44ms, 75.8MB)|