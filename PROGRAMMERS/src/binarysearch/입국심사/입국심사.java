package binarysearch.입국심사;
import java.util.*;
public class 입국심사 {
	public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        
        long left = 1;
        // 모든 사람이 심사를 받는데 걸리는 최대값 : 인원수 * 젤 오래걸리는 심사시간 
        long right = (long) n * times[times.length - 1];
        
        while(left<=right){
            long mid = (left+right)/2;
            long cnt = 0;
            for(int i=0; i<times.length; i++){
                cnt += mid/times[i];
            }
            // 입국심사할 인원이 더 많아야 하면 시간 범위를 늘려야 한다.
            if(cnt<n){
                left = mid + 1;
            }
            // 입국심사할 인원이 더 적어야 한다면 시간 범위를 줄인다.
            else{
                right = mid - 1;
                answer = mid;
            }            
        }
        return answer;
    }

}
