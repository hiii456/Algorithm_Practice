package 연습문제.Jadencase_문자열_만들기;
import java.util.*;
public class Jadencase_문자열_만들기 {
	public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            String str = arr[i];
            
            if(str.length()==0) sb.append(" ");
            else{
                str = str.substring(0,1).toUpperCase() + str.substring(1,str.length()).toLowerCase();
            sb.append(str).append(" ");
            }
        }
        if(s.charAt(s.length()-1) == ' '){
            return sb.toString();
        }
        sb.deleteCharAt(sb.length()-1);
        answer = sb.toString();
        return answer;
    }
}
