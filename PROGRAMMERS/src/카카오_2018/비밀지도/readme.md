## Programmers - 비밀지도 
- Level 1
- Implement 
🔗[비밀지도 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/17681)



## 풀이

문제를 풀면서 관련 함수를 많이 알아야겠다는 생각이 들었다. 
하지만 반복문을 여러번 사용했기 때문에 속도는 느릴거 같다.. ㅎ

## 소스코드
~~~java
import java.util.*;

public class 비밀지도 {
	
	class Solution {
	    public String[] solution(int n, int[] arr1, int[] arr2) {
	        String[] answer = new String[n];
	        
	        for(int i=0; i<n; i++){
	            String str = Integer.toBinaryString(arr1[i] | arr2[i]);
	            
	            while(str.length()<n){
	                str = "0" + str;
	            }
	            
	            StringBuilder sb = new StringBuilder();
	            for(int j=0; j<str.length(); j++){
	                if(str.charAt(j)=='1'){
	                    sb.append("#");
	                }else if(str.charAt(j)=='0'){
	                    sb.append(" ");
	                }
	            }

	            answer[i] = sb.toString();
	            
	        }
	        return answer;
	    }
	}

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.05ms, 74.9MB)|
|테스트 2 |	통과 (2.00ms, 74.7MB)|
|테스트 3 |	통과 (3.02ms, 77.6MB)|
|테스트 4 |	통과 (1.74ms, 73.3MB)|
|테스트 5 |	통과 (1.74ms, 75MB)|
|테스트 6 |	통과 (2.88ms, 76.2MB)|
|테스트 7 |	통과 (1.82ms, 76.9MB)|
|테스트 8 |	통과 (0.06ms, 76.8MB)|