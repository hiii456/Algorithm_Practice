## Programmers - 타겟 넘버 
- Level 2 
- dfs  
🔗[타겟 넘버 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/43165)



## 풀이

재귀는 어렵다... dfs 문제를 많이 풀어봐야겠다.


## 소스코드
~~~java
class Solution {
    static int answer = 0;
	public int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
        return answer;
    }
	private static void dfs(int[] numbers, int target, int idx, int sum) {
		// numbers의 값을 모두 계산했으면 
		if(idx==numbers.length) {
            // 타겟 넘버와 sum이 같으면 answer+1
			if(sum==target) {
				answer++;
			}
            return;
		}
        
        sum += numbers[idx];
        dfs(numbers, target, idx+1, sum);
        // 원래 값으로 복귀 
        sum -= numbers[idx];
        sum += (-1)*numbers[idx];
        dfs(numbers, target, idx+1, sum);

	}
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (5.71ms, 73.7MB)|
|테스트 2 |	통과 (5.73ms, 74.2MB)|
|테스트 3 |	통과 (0.19ms, 75.5MB)|
|테스트 4 |	통과 (0.32ms, 86.6MB)|
|테스트 5 |	통과 (0.81ms, 71MB)|
|테스트 6 |	통과 (0.29ms, 84.3MB)|
|테스트 7 |	통과 (0.20ms, 75.7MB)|
|테스트 8 |	통과 (0.43ms, 72.1MB)|