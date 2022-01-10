## Programmers - 순위 검색 
- Level 2 
- dfs, binarySearch  
- 2021 KAKAO BLIND RECRUITMENT
🔗[순위 검색 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/72412)



## 풀이

이 문제는 dfs와 이분탐색을 사용하였고 카카오 문제풀이를 참고하여 문제를 풀었다.

이 문제는 효율성도 통과해야하므로 info 배열에서 조건에 해당하는 지원자를 찾는다면 정확성은 다 맞을지 몰라도 효율성을 시간초과로 뜬다.
따라서 지원자들을 그룹별로 미리 분류해두어 문제를 풀어야한다.

예를 들어 “java backend junior pizza 150” 지원자의 경우,
|언어|	직군	|경력	|소울 푸드	|점수|
|---|---|---|---|---|
|java|	backend|	|junior|	pizza|	|150|
|–|	backend|	junior	pizza|	150|
|java|	–|	junior	pizza|	150|
|java|	backend|	–	pizza|	150|
|java|	backend	|junior|	–|	150|
|–|	–|	junior|	pizza|	150|
|–|	backend|	–	|pizza|	150|
|…(생략)|	|	|	|	|
|java|	–|	–	|–|	150|
|–|	–|	–|	–|	150|

즉, 16가지 형태로 나타낼 수 있다. 

이렇게 만든 지원자의 정보를 hashmap에 key값으로 저장하고 각각에 해당하는 점수는 리스트 형태로 만들어 저장한다.
즉, 검색 조건이 “java and backend and junior and pizza 100″이라 하면, 위 지원자는 검색 대상에 포함되며, 검색 조건이 “java and – and junior and – 100” 인 경우에도 검색 대상에 포함이 되어야한다.

~~~java
    public static void dfs(String[] applicant,String str,int cnt){
        if(cnt == 4){
            if(!hm.containsKey(str)){
                List<Integer> list = new ArrayList<>();               
                hm.put(str,list);
            }
            // info의 맨마지막에 해당하는 코딩테스트 점수는 해당하는 info의 list에 넣는다.
            hm.get(str).add(Integer.parseInt(applicant[4]));
            return;
        }
        
        dfs(applicant, str + "-" , cnt+1);
        dfs(applicant, str + applicant[cnt], cnt+1);
    }
~~~

그리고 이분탐색을 위해 각 key에 해당하는 점수 리스트를 오름차순해주는 작업을 한다.

~~~java
        for(String key : hm.keySet()){
            // 각 key에 맞는 코딩테스트 점수를 오름차순 정렬 
            Collections.sort(hm.get(key));
        }
~~~

그리고 검색조건에 해당하는 점수의 인원을 세기위해 이분탐색을 실행한다. (필요한 값을 여러번 찾아야 한다면 시간복잡도가 O(logN)인 이분탐색을 사용하는 것이 효율적이다.)
여기서 배열에 찾는 값이 없을 수도 있으므로 특정 값보다 크거나 같은 첫번째 원소의 인덱스를 리턴하는 lower bound를 사용한다.

~~~java
    public static int binarySearch(String info, int score){
        if(!hm.containsKey(info)){
            return 0;
        }
        
        List<Integer> list = hm.get(info);
        
        int left = 0;
        int right = list.size()-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(score>list.get(mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
~~~

## 막힌점 

처음에 2, 3, 4, 7, 13, 16 테스트 케이스에서 런타임 에러가 발생하였다. 그 이유는 지원자 정보에 해당하는 코딩테스트 점수 리스트의 정렬을 query 배열 반복문에서 실행해주었는데 이때 query 배열의 정보가 info에 없는 정보이기 때문이였다.

따라서 따로 리스트를 정렬해주는 반복문을 밖에서 실행하였고, 이분탐색을 할때 해당하는 정보가 없으면 0을 리턴하도록 if문을 설정해주었다.


## 소스코드
~~~java
import java.util.*;
class Solution {
    static HashMap<String,List<Integer>> hm = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(int i=0; i<info.length; i++){
            String[] applicant = info[i].split(" ");
            dfs(applicant,"",0);
        }
        
        for(String key : hm.keySet()){
            // 각 key에 맞는 코딩테스트 점수를 오름차순 정렬 
            Collections.sort(hm.get(key));
        }

        for(int i=0; i<query.length; i++){
            query[i] = query[i].replaceAll(" and ","");
            // 조건에 해당하는 지원자 정보와 코딩테스트 점수 분리 
            String[] arr = query[i].split(" ");
            answer[i] = binarySearch(arr[0],Integer.parseInt(arr[1]));
        }
        return answer;
    }
    public static int binarySearch(String info, int score){
        if(!hm.containsKey(info)){
            return 0;
        }
        
        List<Integer> list = hm.get(info);
        
        int left = 0;
        int right = list.size()-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(score>list.get(mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return list.size() - left;
    }
    public static void dfs(String[] applicant,String str,int cnt){
        if(cnt == 4){
            if(!hm.containsKey(str)){
                List<Integer> list = new ArrayList<>();               
                hm.put(str,list);
            }
            // info의 맨마지막에 해당하는 코딩테스트 점수는 해당하는 info의 list에 넣는다.
            hm.get(str).add(Integer.parseInt(applicant[4]));
            return;
        }
        
        dfs(applicant, str + "-" , cnt+1);
        dfs(applicant, str + applicant[cnt], cnt+1);
    }
}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (5.01ms, 76.1MB)|
|테스트 2 |	통과 (5.92ms, 77.7MB)|
|테스트 3 |	통과 (8.57ms, 75.4MB)|
|테스트 4 |	통과 (15.45ms, 89.5MB)|
|테스트 5 |	통과 (21.81ms, 78.9MB)|
|테스트 6 |	통과 (25.40ms, 94.9MB)|
|테스트 7 |	통과 (24.42ms, 91.5MB)|
|테스트 8 |	통과 (59.70ms, 122MB)|
|테스트 9 |	통과 (104.17ms, 114MB)|
|테스트 10 |	통과 (69.84ms, 129MB)|
|테스트 11 |	통과 (16.46ms, 80.8MB)|
|테스트 12 |	통과 (23.42ms, 88.2MB)|
|테스트 13 |	통과 (30.44ms, 88.6MB)|
|테스트 14 |	통과 (39.22ms, 112MB)|
|테스트 15 |	통과 (66.52ms, 106MB)|
|테스트 16 |	통과 (16.74ms, 94.9MB)|
|테스트 17 |	통과 (19.75ms, 91.8MB)|
|테스트 18 |	통과 (38.56ms, 110MB)|

---

|효율성  |테스트|
|---|---|
|테스트 1 |	통과 (1086.45ms, 289MB)|
|테스트 2 |	통과 (1286.87ms, 305MB)|
|테스트 3 |	통과 (1274.50ms, 317MB)|
|테스트 4 〉	통과 (1759.69ms, 339MB)|