package 카카오_2018.비밀지도;
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
