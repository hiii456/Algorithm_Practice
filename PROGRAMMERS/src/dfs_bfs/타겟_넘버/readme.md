## Programmers - ํ๊ฒ ๋๋ฒ 
- Level 2 
- dfs  
๐[ํ๊ฒ ๋๋ฒ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://programmers.co.kr/learn/courses/30/lessons/43165)



## ํ์ด

์ฌ๊ท๋ ์ด๋ ต๋ค... dfs ๋ฌธ์ ๋ฅผ ๋ง์ด ํ์ด๋ด์ผ๊ฒ ๋ค.


## ์์ค์ฝ๋
~~~java
class Solution {
    static int answer = 0;
	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
        return answer;
    }
	private static void dfs(int[] numbers, int target, int idx, int sum) {
		// numbers์ ๊ฐ์ ๋ชจ๋ ๊ณ์ฐํ์ผ๋ฉด 
		if(idx==numbers.length) {
            // ํ๊ฒ ๋๋ฒ์ sum์ด ๊ฐ์ผ๋ฉด answer+1
			if(sum==target) {
				answer++;
			}
            return;
		}
        
        sum += numbers[idx];
        dfs(numbers, target, idx+1, sum);
        // ์๋ ๊ฐ์ผ๋ก ๋ณต๊ท 
        sum -= numbers[idx];
        sum += (-1)*numbers[idx];
        dfs(numbers, target, idx+1, sum);

	}
}
~~~

## ๊ฒฐ๊ณผ 

| ์ ํ์ฑ  | ํ์คํธ |
|----|----|
|ํ์คํธ 1 |	ํต๊ณผ (5.71ms, 73.7MB)|
|ํ์คํธ 2 |	ํต๊ณผ (5.73ms, 74.2MB)|
|ํ์คํธ 3 |	ํต๊ณผ (0.19ms, 75.5MB)|
|ํ์คํธ 4 |	ํต๊ณผ (0.32ms, 86.6MB)|
|ํ์คํธ 5 |	ํต๊ณผ (0.81ms, 71MB)|
|ํ์คํธ 6 |	ํต๊ณผ (0.29ms, 84.3MB)|
|ํ์คํธ 7 |	ํต๊ณผ (0.20ms, 75.7MB)|
|ํ์คํธ 8 |	ํต๊ณผ (0.43ms, 72.1MB)|