package 월간_코드_챌린지_시즌2.괄호_회전하기;
import java.util.*;

public class 괄호_회전하기 {

	public int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            String str = s.substring(i,s.length()) + s.substring(0,i);
            if(isRight(str)){
                answer++;
            }
        }
        return answer;
    }
    
    public static boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='('){
                stack.push('(');
            }else if(str.charAt(i)=='{'){
                stack.push('{');
            }else if(str.charAt(i)=='['){
                stack.push('[');
            }
            else{
                if(stack.isEmpty()) {
                	return false;
                }else {
                	if(str.charAt(i)==')'){
                        if(stack.peek()=='('){
                            stack.pop();
                        }else {
                        	return false;
                        }
                    }else if(str.charAt(i)=='}'){
                        if(stack.peek()=='{'){
                            stack.pop();
                        }else {
                        	return false;
                        }
                    }else if(str.charAt(i)==']'){
                        if(stack.peek()=='['){
                            stack.pop();
                        }else {
                        	return false;
                        }
                    }
                }
            }
        }
        
        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

}
