package 카카오_2018.뉴스_클러스터링;

import java.util.*;

public class 뉴스_클러스터링 {
	public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        
        List<String> intersection = new ArrayList<>();
        List<String> union = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i=0; i<str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);
            
            if(a>='a' && b>='a' && a<='z' && b<='z'){
                String s = String.valueOf(a) + String.valueOf(b);
                list1.add(s);
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);
            
            if(a>='a' && b>='a' && a<='z' && b<='z'){
                String s = String.valueOf(a) + String.valueOf(b);
                list2.add(s);
            }
        }
        
        // 오름차순 정렬 
        Collections.sort(list1);
        Collections.sort(list2);
        
        // 교집합 구하기 
        for(String s : list1){
            if(list2.contains(s)){
            	list2.remove(s);
                intersection.add(s);
            }
            union.add(s);
        }
        
        // 합집합 구하기 
        for(String s : list2){
        	union.add(s);
        }
        
        double similar;
        if(union.size() == 0){
            similar = 1.0;
        }else{
            similar = (double) intersection.size() / (double)union.size();
        }
        
        similar *= 65536;
        
        
        answer = (int) Math.floor(similar);
        return answer;
    }

}
