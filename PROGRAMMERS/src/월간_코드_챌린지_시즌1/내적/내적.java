package 월간_코드_챌린지_시즌1.내적;

public class 내적 {
	public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i<a.length; i++){
            int num_a = a[i];
            int num_b = b[i];
            
            answer += num_a * num_b;
        }
        return answer;
    }

}
