package 팁스타운_2017.짝지어_제거하기;
import java.util.*;

public class 짝지어_제거하기 {
	public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        
        answer = (stack.size()>0) ? 0 : 1; 

        return answer;
    }

}
