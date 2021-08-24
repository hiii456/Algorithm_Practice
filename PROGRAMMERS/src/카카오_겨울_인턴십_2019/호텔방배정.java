package 카카오_겨울_인턴십_2019;

import java.util.*;

class Solution {
    static HashMap<Long, Long> hm = new HashMap<>();
    static long find(long a){
        if(!hm.containsKey(a)){
            return a;
        }else{
            // 경로 압축
            hm.put(a,find(hm.get(a)));
            return hm.get(a);
        }
    }
    
    public long[] solution(long k, long[] room_number) {
        int len = room_number.length;
        long[] answer = new long[len];
        
        for(int i = 0; i < len; i++){
            long room = room_number[i];
            // map에 방번호가 존재할 때 
            if(!hm.containsKey(room)){
                answer[i] = room;
                hm.put(room, find(room)+1);
            }
            // map에 방번호가 존재하지 않을때
            else{
                long tmp = find(room);
                answer[i] = tmp;
                hm.put(tmp, find(tmp)+1);
            }         
        }
        
        return answer;
    }
}
