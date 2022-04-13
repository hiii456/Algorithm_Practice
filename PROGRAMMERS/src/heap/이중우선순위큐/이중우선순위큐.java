package heap.이중우선순위큐;
import java.util.*;

public class 이중우선순위큐 {

	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0; i<operations.length; i++){
            String[] arr= operations[i].split(" ");
            String op = arr[0];
            int num = Integer.parseInt(arr[1]);
            
            if(op.equals("I")){
                minHeap.add(num);
                maxHeap.add(num);
            }else if(op.equals("D")){
                // 빈 큐에 데이터를 삭제하라는 연산이 주어진 경우 
                if(minHeap.size() < 1) continue;
                if(num == 1){
                    int tmp = maxHeap.poll();
                    minHeap.remove(tmp);
                }else if(num == -1){
                    int tmp = minHeap.poll();
                    maxHeap.remove(tmp);
                }
            }
        }
    
        if(maxHeap.size()>0){
            answer[0] = maxHeap.poll();
            answer[1] = minHeap.poll();
        }

        return answer;
    }

}
