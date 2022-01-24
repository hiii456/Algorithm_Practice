## Programmers - 튜플  
- Level 2 
- Hash 
- 2019 카카오 개발자 겨울 인턴십  
🔗[튜플 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/64065)



## 풀이

반복문을 조금만 쓰고 싶었는데.. 효율적인 측면에서 떨어지는 코드 같다 ㅠㅠ 
각 숫자를 배열 형태로 나누어준 뒤 각 숫자와 숫자의 개수를 저장하는 hashmap을 만들어준 뒤 개수가 많은 순서대로 answer에 저장해주었다.


## 소스코드
~~~java
import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("[{}]"," ").trim();
		String[] str = s.split(" , ");

		HashMap<Integer,Integer> hm = new HashMap<>();

		for(int i=0; i<str.length; i++) {
			String[] tmp = str[i].split(",");
			for(int j=0; j<tmp.length; j++) {
				int num = Integer.parseInt(tmp[j]);
				hm.put(num, hm.getOrDefault(num,0)+1);
			}	
		}

		List<Integer> list = new ArrayList<>(hm.keySet());
		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return hm.get(o2) - hm.get(o1);
			}	
		});
		
		int[] answer = new int[list.size()];
		int idx = 0;
		for(int i : list) {
			answer[idx++] = i;
		}
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.96ms, 73.2MB)|
|테스트 2 |	통과 (1.11ms, 77.6MB)|
|테스트 3 |	통과 (0.86ms, 75MB)|
|테스트 4 |	통과 (1.50ms, 77.2MB)|
|테스트 5 |	통과 (7.04ms, 67.9MB)|
|테스트 6 |	통과 (6.92ms, 77.3MB)|
|테스트 7 |	통과 (32.15ms, 73.7MB)|
|테스트 8 |	통과 (62.85ms, 91.5MB)|
|테스트 9 |	통과 (43.12ms, 91MB)|
|테스트 10 |	통과 (52.22ms, 92MB)|
|테스트 11 |	통과 (55.56ms, 88.6MB)|
|테스트 12 |	통과 (67.66ms, 113MB)|
|테스트 13 |	통과 (68.45ms, 114MB)|
|테스트 14 |	통과 (73.75ms, 110MB)|
|테스트 15 |	통과 (0.63ms, 78.1MB)|