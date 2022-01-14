## Programmers - 신고 결과 받기 
- Level 1
- Implement , Hash 
- 2022 KAKAO BLIND RECRUITMENT
🔗[신고 결과 받기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/92334)



## 풀이

문제대로 풀면 되는 문제라 괜찮았으나 null값 체크를 안해주어서 자꾸 에러가 났다! 

## 소스코드
~~~java
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 아이디 별로 신고당한 횟수 
        HashMap<String,Integer> reportList = new HashMap<>();
        // key : 신고한 아이디 , value : 신고된 아이디 리스트 를 나타내는 hashmap 
        HashMap<String,HashSet<String>> pauseList = new HashMap<>();
        
        for(int i=0; i<report.length; i++){
            String[] name = report[i].split(" ");
            String id1 = name[0];
            String id2 = name[1];
            if(pauseList.containsKey(id1)){
                HashSet<String> hs = pauseList.get(id1);
                
                if(!hs.contains(id2)){
                    reportList.put(id2, reportList.getOrDefault(id2,0)+1);
                }   
                
                hs.add(id2);
                pauseList.put(id1, hs);
            }else{
                reportList.put(id2, reportList.getOrDefault(id2,0)+1);
                HashSet<String> hs = new HashSet<>();
                hs.add(id2);
                pauseList.put(id1,hs);
            }
        }
        
        int idx = 0;
        for(String key : id_list){
        	if(pauseList.containsKey(key)) {
        		HashSet<String> hs = pauseList.get(key);
        		for(String name : hs) {
        			if(reportList.containsKey(name)){
                        if(reportList.get(name)>=k){
                            answer[idx]++;
                        }
                    }
        			
        		}
        	} 
        	idx++;
        }
        
        
        return answer;
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.14ms, 77.6MB)|
|테스트 2 |	통과 (0.22ms, 73.3MB)|
|테스트 3 |	통과 (219.02ms, 185MB)|
|테스트 4 |	통과 (0.32ms, 80.3MB)|
|테스트 5 |	통과 (0.44ms, 73.8MB)|
|테스트 6 |	통과 (10.93ms, 69.5MB)|
|테스트 7 |	통과 (9.33ms, 85.1MB)|
|테스트 8 |	통과 (23.19ms, 94MB)|
|테스트 9 |	통과 (192.78ms, 127MB)|
|테스트 10 |	통과 (142.95ms, 135MB)|
|테스트 11 |	통과 (212.22ms, 165MB)|
|테스트 12 |	통과 (1.31ms, 77.2MB)|
|테스트 13 |	통과 (0.96ms, 80.9MB)|
|테스트 14 |	통과 (109.70ms, 142MB)|
|테스트 15 |	통과 (211.85ms, 176MB)|
|테스트 16 |	통과 (1.12ms, 77.5MB)|
|테스트 17 |	통과 (0.98ms, 77.7MB)|
|테스트 18 |	통과 (1.73ms, 80.2MB)|
|테스트 19 |	통과 (3.58ms, 76.3MB)|
|테스트 20 |	통과 (86.52ms, 130MB)|
|테스트 21 |	통과 (203.39ms, 166MB)|
|테스트 22 |	통과 (0.16ms, 77.8MB)|
|테스트 23 |	통과 (0.25ms, 74.8MB)|
|테스트 24 |	통과 (0.14ms, 72.1MB)|




+ 추가로 다른 사람의 풀이를 참고하여 더 간단하게 코드를 풀어보았는데 

~~~java
import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
		HashMap<String, HashSet<String>> hm = new HashMap<>();
		
		for(String id : id_list) {
			hm.put(id, new HashSet<>());
		}
		
		for(String s : report) {
			String[] arr = s.split(" ");
			String name1 = arr[0];
			String name2 = arr[1];
			Set<String> reportList = hm.get(name2);
			reportList.add(name1);
		}
		
		for(String key : hm.keySet()) {
			HashSet<String> set = hm.get(key);
			if(set.size()>=k) {
				for(String str : set) {
					answer[Arrays.asList(id_list).indexOf(str)] += 1;
				}
			}
		}
        
        
        return answer;
    }
}
~~~

신고당한 사람을 key, 신고한 사람의 id의 List를 value로 하는 hashmap을 만들면 

|신고당한ID | 신고자 ID |
|---|----|
|muzi|apeach|
|frodo| muzi,apeach|
|apeach||
|neo |frodo,muzi|

여기서 value의 size가 k이상인 id만 메일이 오므로 이 조건에 해당하는 set만 순회하면 된다. 
따라서 각 조건에 해당하는 set의 원소의 값을 +1 해주면 답을 구할 수 있다. 