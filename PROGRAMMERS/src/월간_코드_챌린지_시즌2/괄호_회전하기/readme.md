## Programmers - 괄호 회전하기 
- Level 2 
- Stack 
- 월간 코드 챌린지 시즌2
🔗[괄호 회전 하기 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/76502)



## 풀이

닫는 괄호를 확인하는 부분에서 stack의 값이랑 비교해주어야 하는데 str(비교할 괄호 문자열)이랑 비교해주고 있었다.. 바보 같은 실수!

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
|테스트 1 |	통과 (16.36ms, 88.3MB)|
|테스트 2 |	통과 (11.07ms, 81.2MB)|
|테스트 3 |	통과 (11.32ms, 82.8MB)|
|테스트 4 |	통과 (13.38ms, 77.7MB)|
|테스트 5 |	통과 (21.96ms, 83.4MB)|
|테스트 6 |	통과 (12.18ms, 71.8MB)|
|테스트 7 |	통과 (21.44ms, 79.1MB)|
|테스트 8 |	통과 (17.74ms, 84.3MB)|
|테스트 9 |	통과 (30.51ms, 95.1MB)|
|테스트 10 |	통과 (36.17ms, 82.1MB)|
|테스트 11 |	통과 (75.45ms, 96.3MB)|
|테스트 12 |	통과 (1.68ms, 73.9MB)|
|테스트 13 |	통과 (1.27ms, 83.8MB)|
|테스트 14 |	통과 (1.74ms, 74.5MB)|
