package 연습문제.최댓값과_최솟값;
import java.util.*;

public class 최댓값과_최솟값 {
	class Solution {
	    public String solution(String s) {
	        String answer = "";
	        String[] str = s.split(" ");
	        List<Integer> list = new ArrayList<>();
	        
	        for(int i=0; i<str.length; i++){
	            list.add(Integer.parseInt(str[i]));
	        }
	        
	        Collections.sort(list);
	        
	        StringBuilder sb = new StringBuilder();
	        sb.append(list.get(0)).append(" ").append(list.get(list.size()-1));
	        answer = sb.toString();
	        return answer;
	    }
	}

}
