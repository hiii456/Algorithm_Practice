package 카카오_인턴십_2020.보석쇼핑;

import java.util.*;

public class 보석쇼핑 {

	public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<>();
        
        for(String s : gems){
            set.add(s);
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int dis = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int startPoint = 0;
        while(true){
            if(set.size()==map.size()){
                map.put(gems[start],map.get(gems[start])-1);
                if(map.get(gems[start])==0){
                    map.remove(gems[start]);
                }
                start++;
            }else if(end == gems.length){
                break;
            }else{
                map.put(gems[end], map.getOrDefault(gems[end],0)+1);
                end++;
            }
            
            if(set.size()==map.size() && dis>end-start){
                dis = end-start;
                startPoint = start;
            }
        }
        
        answer[0] = startPoint + 1;
        answer[1] = startPoint + dis;
               
        return answer;
    }

}
