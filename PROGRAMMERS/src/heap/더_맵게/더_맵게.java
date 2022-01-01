package heap.더_맵게;
import java.util.*;

public class 더_맵게 {
	public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        for(int i : scoville){
            pq.add(i);
        }
        
        while(pq.peek()<K){
            if(pq.size()==1){
                if(pq.peek()<K){
                    answer = -1;
                    break;
                }
            }
            int a = pq.poll();
            int b = pq.poll();
            
            int mixed = a + (b*2);
            
            pq.add(mixed);
            
            answer++;
        }
        
        return answer;
    }

}
