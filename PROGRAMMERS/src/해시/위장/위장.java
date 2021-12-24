package 해시.위장;

import java.util.*;

public class 위장 {
	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String cloth = clothes[i][1];
            hm.put(cloth,hm.getOrDefault(cloth,0)+1);
        }
        
        for(String key : hm.keySet()){
            answer *= (hm.get(key) + 1);
        }
        
        answer -= 1;
        
        return answer;
    }

}
