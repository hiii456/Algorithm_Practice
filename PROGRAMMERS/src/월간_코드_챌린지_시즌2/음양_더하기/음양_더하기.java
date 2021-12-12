package 월간_코드_챌린지_시즌2.음양_더하기;

public class 음양_더하기 {
	public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i=0; i<absolutes.length; i++){
            int num = absolutes[i];
            boolean sign = signs[i];
            
            if(sign){
                answer += num;
            }else{
                answer -= num;
            }
        }
        return answer;
    }

}
