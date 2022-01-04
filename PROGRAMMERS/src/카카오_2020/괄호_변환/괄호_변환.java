package 카카오_2020.괄호_변환;
import java.util.*;

public class 괄호_변환 {
	public String solution(String p) {
        // 1단계 수행 
        if(p.length()==0){
            return p;
        }
        // 2단계 수행 
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
        // 3단계, 4단계 수행
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
