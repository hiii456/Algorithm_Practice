package winter_coding_2019.멀쩡한_사각형;

public class 멀쩡한_사각형 {
	class Solution {
	    public long solution(int w, int h) {
	        long answer = 1;
	        int gcd = GCD(w,h);
	        answer = ((long)w*(long)h) -((((long)w/gcd) + ((long)h/gcd) -1) * gcd);
	        
	        return answer;
	    }
	    private static int GCD(int a,int b){
	        if(b==0){
	            return a;
	        }
	        
	        return GCD(b,a%b);
	    }
	}

}
