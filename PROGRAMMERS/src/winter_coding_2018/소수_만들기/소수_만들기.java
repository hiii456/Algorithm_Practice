package winter_coding_2018.소수_만들기;

public class 소수_만들기 {
	class Solution {
	    static int[] tgt = new int[3];
	    static int cnt = 0;
	    public int solution(int[] nums) {
	        int answer = -1;    
	        comb(0,0,nums);
	        answer = cnt;
	        
	        return answer;
	    }
	    public static void comb(int srcIdx, int tgtIdx,int[] nums){
	        if(tgtIdx == 3){
	            int sum = 0;
	            for(int i=0; i<tgt.length; i++){
	                int tmp = tgt[i];
	                sum += tmp;
	            }
	            if(isPrime(sum)){
	                cnt++;
	            }
	            return;
	        }
	        
	        for(int i=srcIdx; i<nums.length; i++){
	            tgt[tgtIdx] = nums[i];
	            comb(i+1, tgtIdx+1, nums);            
	        }
	    } 
	    
	    public static boolean isPrime(int n){
	        if(n==0 || n==1)    return false;
	        
	        for(int i=2; i*i<=n; i++){
	            if(n%i==0){
	                return false;
	            }
	        }
	        
	        return true;
	    }
	}
}
