package 카카오_2022.신고_결과_받기;
import java.util.*;

public class 신고_결과_받기 {
	public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 각 아이디 별로 신고당한 횟수 
        HashMap<String,Integer> reportList = new HashMap<>();
        // key : 신고한 아이디 , value : 신고된 아이디 리스트 를 나타내는 hashmap 
        HashMap<String,HashSet<String>> pauseList = new HashMap<>();
        
        for(int i=0; i<report.length; i++){
            String[] name = report[i].split(" ");
            String id1 = name[0];
            String id2 = name[1];
            if(pauseList.containsKey(id1)){
                HashSet<String> hs = pauseList.get(id1);
                
                if(!hs.contains(id2)){
                    reportList.put(id2, reportList.getOrDefault(id2,0)+1);
                }   
                
                hs.add(id2);
                pauseList.put(id1, hs);
            }else{
                reportList.put(id2, reportList.getOrDefault(id2,0)+1);
                HashSet<String> hs = new HashSet<>();
                hs.add(id2);
                pauseList.put(id1,hs);
            }
        }
        
        int idx = 0;
        for(String key : id_list){
        	if(pauseList.containsKey(key)) {
        		HashSet<String> hs = pauseList.get(key);
        		for(String name : hs) {
        			if(reportList.containsKey(name)){
                        if(reportList.get(name)>=k){
                            answer[idx]++;
                        }
                    }
        			
        		}
        	} 
        	idx++;
        }
        
        
        return answer;
    }

}
