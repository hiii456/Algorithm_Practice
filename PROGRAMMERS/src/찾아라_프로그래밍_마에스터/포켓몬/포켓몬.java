package 찾아라_프로그래밍_마에스터.포켓몬;
import java.util.*;
public class 포켓몬 {
	public int solution(int[] nums) {
        int len = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            hs.add(nums[i]);
        }
        
        if(hs.size()<len/2){
            return hs.size();
        }else{
            return len/2;
        }
    }
}
