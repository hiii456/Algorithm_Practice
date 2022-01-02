## Programmers - [1차]뉴스 클러스터링 
- Level 2
- Implement , String
- 2018 KAKAO BLIND RECRUITMENT
🔗[뉴스 클러스터링 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/17677)



## 풀이

합집합을 구하는 부분에서 처음에 중복을 거르는 hashset의 성질을 이용해서 풀려했으나 그럼 반복문을 2번이나 돌려야하므로 아래의 방식으로 풀었다.

각 리스트 오름차순 정렬 -> 같으면 교집합에 add, list1의 원소는 합집합에 무조건 add -> list2에서 교집합인 원소 삭제 -> 나머지 list2 원소 add 

또한 char형을 String으로 바꾸는 과정에서 String.valueOf() 와 "" 중 전자가 속도가 더 빠르기 때문에 Stinrg.valueOf() 함수를 통해 형변환을 해주었다!

## 소스코드
~~~java
import java.util.*;

public class 뉴스_클러스터링 {
	public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(a>='a' && b>='a' && a<='z' && b<='z'){
                String s = String.valueOf(a) + String.valueOf(b);
                list1.add(s);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(a>='a' && b>='a' && a<='z' && b<='z'){
                String s = String.valueOf(a) + String.valueOf(b);
                list2.add(s);
            }
        }
        
        // 오름차순 정렬 
        Collections.sort(list1);
        Collections.sort(list2);
        
        // 교집합 구하기 
        for(String s : list1){
            if(list2.contains(s)){
            	list2.remove(s);
                intersection.add(s);
            }
            union.add(s);
        }
        
        // 합집합 구하기 
        for(String s : list2){
        	union.add(s);
        }
        
        double similar;
        if(union.size() == 0){
            similar = 1.0;
        }else{
            similar = (double) intersection.size() / (double)union.size();
        }
        
        similar *= 65536;
        
        
        answer = (int) Math.floor(similar);
        return answer;
    }

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (2.39ms, 73.8MB)|
|테스트 2 |	통과 (1.59ms, 71.4MB)|
|테스트 3 |	통과 (2.30ms, 74.7MB)|
|테스트 4 |	통과 (7.04ms, 72.9MB)|
|테스트 5 |	통과 (1.55ms, 72.3MB)|
|테스트 6 |	통과 (1.62ms, 79.6MB)|
|테스트 7 |	통과 (2.57ms, 75.4MB)|
|테스트 8 |	통과 (1.71ms, 67.8MB)|
|테스트 9 |	통과 (2.04ms, 73.7MB)|
|테스트 10 |	통과 (2.61ms, 73.5MB)|
|테스트 11 |	통과 (4.05ms, 75.7MB)|
|테스트 12 |	통과 (0.44ms, 77.7MB)|
|테스트 13 |	통과 (2.04ms, 85.6MB)|