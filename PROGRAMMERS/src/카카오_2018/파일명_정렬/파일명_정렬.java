package 카카오_2018.파일명_정렬;
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
