package summer_winter_coding_2018.점프와_순간_이동;

public class 점프와_순간_이동 {
	public int solution(int n) {
        int ans = 0;

        while(n!=0){
            // 짝수일 경우 
            if(n%2==0){
                n /= 2;
            }
            // 홀수일 경우 
            else if(n%2==1){
                n -= 1;
                ans += 1;
            }
        }
        return ans;
    }
}
