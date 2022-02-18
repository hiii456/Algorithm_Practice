package 월간_코드_챌린지_시즌3.n2_배열_자르기;
import java.util.*;
public class n2_배열_자르기 {

	public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        int idx = 0;
        for(int i=0; i<answer.length; i++){
            int num = Math.max((int)((left+i)%n),(int)((left+i)/n));
            num += 1;
            answer[idx++] = num;
        }
        return answer;
    }

}
