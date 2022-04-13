## Programmers - 이중우선순위큐 
- Level 3 
- Heap  
🔗[이중우선순위큐 문제 바로가기](https://programmers.co.kr/learn/courses/30/lessons/42628)



## 풀이

이 문제는 최소힙과 최대힙을 이용한 문제이다. 따라서 우선순위큐를 통해 최소힙, 최대힙을 만들어주었다.
여기서 최대힙이란, 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리이고 최소힙은 그 반대 개념이다.
특히 최댓값부터 출력하는 최대힙은 Collectiosn.reverseOrder() 함수를 통해 만들어주었고, 
각각 명령애 따라 삭제시 remove 메소드를 같이 사용해주었다.

## 소스코드
~~~java
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
~~~

## 결과 

| 정확성  | 테스트 |
|----|----|
|테스트 1 |	통과 (0.47ms, 79.8MB)|
|테스트 2 |	통과 (0.72ms, 81.8MB)|
|테스트 3 |	통과 (2.41ms, 73MB)|
|테스트 4 |	통과 (0.76ms, 78.5MB)|
|테스트 5 |	통과 (0.46ms, 76.5MB)|
|테스트 6 |	통과 (0.48ms, 75.1MB)|