## Programmers - 주차 요금 계산 
- Level 2 
- Implement , String 
- 2022 KAKAO BLIND RECRUITMENT
🔗[주차 요금 계산 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/92341)


## 풀이

현재 주차장에 차가 있는지 없는지 나타내는 hashmap과 총 주차시간을 value로 가지고 있는 hashmap을 사용하여 문제를 풀었다. 

## 소스코드
~~~java
import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> in_car = new HashMap<>();
        HashMap<String,Integer> total_car = new HashMap<>();
        for(int i=0; i<records.length; i++){
            String s = records[i];
            String[] record = s.split(" ");
            String[] timeArr = record[0].split(":");
            int time = Integer.valueOf(timeArr[0])*60 + Integer.valueOf(timeArr[1]);
            String carNum = record[1];
            String state = record[2];
            // 차가 주차장에 없을 경우 
            if(!in_car.containsKey(carNum) || in_car.get(carNum)==-1){
                in_car.put(carNum, time);
            }
            // 차가 주차장에 있을 경우 
            else{
                int in_time = in_car.get(carNum);
                int total_time = time - in_time;
                total_car.put(carNum, total_car.getOrDefault(carNum,0) + total_time);
                in_car.put(carNum,-1);
            }
            
        }
        
        // 입차된 후에 출차된 내역이 없는 차를 23:59에 출차시킨다.
        for(String key : in_car.keySet()) {
        	if(in_car.get(key)!=-1) {
        		int total_time = 1439 - in_car.get(key);
        		total_car.put(key, total_car.getOrDefault(key,0) + total_time);
        	}
        }
        
        Object[] carArr = total_car.keySet().toArray();
		Arrays.sort(carArr);
        
        int[] answer = new int[carArr.length];
        
        int idx = 0;
        for(int i=0; i<carArr.length; i++){
        	String carNum = (String) carArr[i];
        	// 기본시간보다 적다면 기본요금 저장 
            if(total_car.get(carNum)<=fees[0]) {
            	answer[idx++] = fees[1];
            }else {
            	answer[idx++] = fees[1] + (int) Math.ceil((double)(total_car.get(carNum)-fees[0])/fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.81ms, 73.8MB)|
|테스트 2 |	통과 (0.61ms, 75.6MB)|
|테스트 3 |	통과 (0.58ms, 83.5MB)|
|테스트 4 |	통과 (1.30ms, 70.8MB)|
|테스트 5 |	통과 (2.05ms, 76.8MB)|
|테스트 6 |	통과 (2.00ms, 72.7MB)|
|테스트 7 |	통과 (8.09ms, 76.1MB)|
|테스트 8 |	통과 (4.89ms, 80.6MB)|
|테스트 9 |	통과 (3.50ms, 87.8MB)|
|테스트 10|	통과 (5.34ms, 84.6MB)|
|테스트 11 |	통과 (7.27ms, 86.2MB)|
|테스트 12 |	통과 (9.14ms, 84.9MB)|
|테스트 13 |	통과 (0.79ms, 76.9MB)|
|테스트 14 |	통과 (0.45ms, 78.7MB)|
|테스트 15 |	통과 (0.46ms, 77.2MB)|
테스트 16 〉	통과 (0.24ms, 70MB)