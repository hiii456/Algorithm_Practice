package 연습문제.올바른_괄호;
import java.util.*;
public class 올바른_괄호 {
	boolean solution(String s) {
        boolean answer = true;
        Queue<Character> queue = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                queue.add(ch);
            }else if(ch == ')'){
                if(queue.isEmpty()){
                    answer = false;
                    break;
                }else{
                    queue.poll();
                }
                
            }
        }
        
        if(answer){
          if(queue.isEmpty()){
                answer = true;
            }else{
                answer = false;
            }  
        }
        
        
        return answer;
    }

}
