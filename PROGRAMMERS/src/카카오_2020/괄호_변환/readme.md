## Programmers - ê´í¸ ë³í 
- Level 2
- Implement 
- 2020 KAKAO BLIND RECRUITMENT
ð[ê´í¸ ë³í ë¬¸ì  ë°ë¡ê°ê¸°](https://programmers.co.kr/learn/courses/30/lessons/60058)



## íì´

ë¬¸ì  ìì²´ê° ì²ìì ì´í´íê¸° ì´ë ¤ì ì¼ë ì²ì²í ë³´ê¸°ëë¡ êµ¬ííë ì ì  íë¦¬ë ë¬¸ì ìë¤! 
ë¤ë§  4-4. uì ì²« ë²ì§¸ì ë§ì§ë§ ë¬¸ìë¥¼ ì ê±°íê³ , ëë¨¸ì§ ë¬¸ìì´ì ê´í¸ ë°©í¥ì ë¤ì§ì´ì ë¤ì ë¶ìëë¤. ì´ë¶ë¶ìì 
"(())()" ì´ë©´ "))(()("ë¡ ë³íí´ì£¼ì´ì¼ íëë° ìì íµì¼ë¡ ë¤ì§ì´ì ")())((" ì´ë ê² í´ì£¼ì´ 12ë² íì¼ë¶í° ì¹ íë ¸ìë¤.

## ìì¤ì½ë
~~~java
import java.util.*;

public class ê´í¸_ë³í {
	public String solution(String p) {
        // 1ë¨ê³ ìí 
        if(p.length()==0){
            return p;
        }
        // 2ë¨ê³ ìí 
        String u = "",v = "";
        int right = 0,left = 0;
        
        for(int i=0; i<p.length(); i++){
            u += String.valueOf(p.charAt(i));
            if(p.charAt(i)=='(')    left++;
            else if(p.charAt(i)==')')   right++;
            
            if(left==right){
                v = p.substring(i+1,p.length());
                break;
            }
        }
        // 3ë¨ê³, 4ë¨ê³ ìí
        if(isCorrect(u)){
            return u + solution(v); 
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(solution(v));
            sb.append(")");
            u = u.substring(1,u.length()-1);
            StringBuilder sb2 = new StringBuilder();
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i)=='(')    sb2.append(")");
                else    sb2.append("(");
            }
            
            return sb.toString() + sb2.toString();
        }

    }
    public static boolean isCorrect(String p){
        int right = 0, left = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(')    left++;
            else if(p.charAt(i)==')')   right++;
            
            if(right>left)  return false;
        }
        return true;
    }
}
~~~

## ê²°ê³¼ 

| ì íì±  | íì¤í¸ |
|----|----|
|íì¤í¸ 1 |	íµê³¼ (1.67ms, 74.5MB)|
|íì¤í¸ 2 |	íµê³¼ (1.32ms, 87.3MB)|
|íì¤í¸ 3 |	íµê³¼ (1.62ms, 73.1MB)|
|íì¤í¸ 4 |	íµê³¼ (1.98ms, 70.5MB)|
|íì¤í¸ 5 |	íµê³¼ (2.05ms, 74.2MB)|
|íì¤í¸ 6 |	íµê³¼ (1.66ms, 70.5MB)|
|íì¤í¸ 7 |	íµê³¼ (2.27ms, 76.7MB)|
|íì¤í¸ 8 |	íµê³¼ (1.93ms, 78.6MB)|
|íì¤í¸ 9 |	íµê³¼ (1.80ms, 65.7MB)|
|íì¤í¸ 10|	íµê³¼ (1.37ms, 73.1MB)|
|íì¤í¸ 11 |	íµê³¼ (1.73ms, 86.7MB)|
|íì¤í¸ 12 |	íµê³¼ (3.85ms, 88MB)|
|íì¤í¸ 13 |	íµê³¼ (2.40ms, 83.3MB)|
|íì¤í¸ 14 |	íµê³¼ (1.92ms, 80.8MB)|
|íì¤í¸ 15 |	íµê³¼ (2.39ms, 72.3MB)|
|íì¤í¸ 16 |	íµê³¼ (2.87ms, 75.9MB)|
|íì¤í¸ 17 |	íµê³¼ (3.29ms, 72.3MB)|
|íì¤í¸ 18 |	íµê³¼ (2.96ms, 74MB)|
|íì¤í¸ 19 |	íµê³¼ (2.84ms, 74.6MB)|
|íì¤í¸ 20 |	íµê³¼ (3.19ms, 73.9MB)|
|íì¤í¸ 21 |	íµê³¼ (4.00ms, 69.5MB)|
|íì¤í¸ 22 |	íµê³¼ (2.83ms, 71.4MB)|
|íì¤í¸ 23 |	íµê³¼ (2.33ms, 77.5MB)|
|íì¤í¸ 24 |	íµê³¼ (2.13ms, 74.3MB)|
|íì¤í¸ 25 |	íµê³¼ (3.05ms, 71.7MB)|