package 카카오_인턴십_2019.징검다리_건너기;
import java.util.*;

public class 징검다리_건너기 {
	public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while(min<=max){
            int mid = (min+max)/2;
            
            if(!cross(stones,k,mid)){
                max = mid - 1;
            }else{
                min = mid + 1;
                answer = Math.max(answer,mid);
            }
            
        }
        return answer;
    }
    public static boolean cross(int[] stones,int k,int mid){
        int cnt = 0;
        for(int stone : stones){
            if(stone - mid<0){
                cnt++;
            }else{
                cnt = 0;
            }
            
            if(cnt == k){
                return false;
            }
        }
        
        return true;
    }

}
