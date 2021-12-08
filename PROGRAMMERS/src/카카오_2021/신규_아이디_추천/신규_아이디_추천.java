package 카카오_2021.신규_아이디_추천;
import java.util.*;
public class 신규_아이디_추천 {
	public String solution(String new_id) {
        String answer = "";
        // 1단계
        String id = new_id.toLowerCase();
        // 2단계
        StringBuilder id2 = new StringBuilder();
        for(int i=0; i<id.length(); i++){
            char ch = id.charAt(i);
            if((ch -'0'>=0 && ch-'0'<=9) || (ch>='a' && ch<='z') || ch=='-' || ch=='_' || ch=='.'){
                id2.append(ch);
            }
        }
        
        String id3 = id2.toString();
        // 3단계
        while(id3.contains("..")){
            id3 = id3.replace("..",".");
        }
        
        // 4단계
        if(id3.length()>0){
            if(id3.charAt(0)=='.'){
                id3 = id3.substring(1,id3.length());
            }
        }
        if(id3.length()>0){
            if(id3.charAt(id3.length()-1)=='.'){
                id3 = id3.substring(0,id3.length()-1);
            }
        }
        
        // 5단계
        if(id3.length()==0){
            id3 = "a";
        }
        
        // 6단계
        if(id3.length()>=16){
            id3 = id3.substring(0,15);
            while(id3.charAt(id3.length()-1)=='.'){
                id3 = id3.substring(0,id3.length()-1);
            }
        }
        
        // 7단계
        if(id3.length()<=2){
            while(id3.length()<3){
                id3 += id3.charAt(id3.length()-1);
            }
        }
        
        answer = id3;
        return answer;
    }

}
