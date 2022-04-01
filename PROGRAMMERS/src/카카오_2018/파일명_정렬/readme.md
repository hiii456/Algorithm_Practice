## BOJ - 파일명 정렬 
- level 2 
- String 
🔗[파일명 정렬 문제 바로가기](https://www.acmicpc.net/problem/17686)



## 풀이

compareTo()를 이용한 문자열 비교에 대해서 다시 복습하였다.
<br><br>
0 : 두개의 문자열이 동일<br>
양수 : compareTo()를 호출하는 객체가 인자보다 사전적으로 순서가 앞설 때<br>
음수 : 인자가 객체보다 사전적으로 순서가 앞설 때<br>

이 부분에 유의하여 comparator을 이용한 비교 문제를 풀었다!

## 소스코드
~~~java
import java.util.*;

public class 파일명_정렬 {
	 public String[] solution(String[] files) {
	        String[] answer = new String[files.length];
	        Arrays.sort(files,new Comparator<String>(){
	           @Override
	            public int compare(String o1,String o2){
	                // 대소문자 구분하지 않으므로 toLowerCase 사용 
	                String head1 = o1.split("[0-9]")[0].toLowerCase();
	                String head2 = o2.split("[0-9]")[0].toLowerCase();
	                
	                int result = head1.compareTo(head2);
	                // head가 같을 경우 
	                if(result == 0){
	                    result = convertNum(o1,head1) - convertNum(o2,head2);
	                }
	                
	                return result;
	            }
	        });
	        
	        
	        return files;
	    }
	    public static int convertNum(String str,String head){
	        str = str.substring(head.length());
	        StringBuilder sb = new StringBuilder();
	        for(int i=0; i<str.length(); i++){
	            char c = str.charAt(i);
	            if(c - '0'>=0 && c - '0'<=9 && sb.length()<5){
	                sb.append(c);
	            }else{
	                break;
	            }
	        }
	        
	        int tmp = Integer.parseInt(sb.toString());
	        return tmp;
	    }
	

}
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (1.21ms, 73.6MB)|
|테스트 2 |	통과 (1.11ms, 78.1MB)|
|테스트 3 |	통과 (71.92ms, 117MB)|
|테스트 4 |	통과 (77.56ms, 114MB)|
|테스트 5 |	통과 (76.72ms, 116MB)|
|테스트 6 |	통과 (51.87ms, 107MB)|
|테스트 7 |	통과 (48.80ms, 128MB)|
|테스트 8 |	통과 (48.90ms, 112MB)|
|테스트 9 |	통과 (64.36ms, 112MB)|
|테스트 10|	통과 (50.47ms, 125MB)|
|테스트 11 |	통과 (80.05ms, 118MB)|
|테스트 12 |	통과 (44.22ms, 126MB)|
|테스트 13 |	통과 (14.92ms, 85.4MB)|
|테스트 14 |	통과 (15.64ms, 90.7MB)|
|테스트 15 |	통과 (15.59ms, 79.9MB)|
|테스트 16 |	통과 (45.29ms, 118MB)|
|테스트 17 |	통과 (17.01ms, 79.9MB)|
|테스트 18 |	통과 (27.38ms, 102MB)|
|테스트 19 |	통과 (29.92ms, 93.5MB)|
|테스트 20 |	통과 (33.94ms, 114MB)|