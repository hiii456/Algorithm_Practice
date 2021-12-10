package 월간_코드_챌린지_시즌3.없는_숫자_더하기;
import java.util.*;

public class 없는_숫자_더하기 {
	public int solution(int[] numbers) {
        int answer = 0;

        for(int i=0; i<=9; i++){
            boolean isExist = false;
            for(int j=0; j<numbers.length; j++){
                int num = numbers[j];
                if(i==num){
                    isExist = true;
                }
            }
            if(!isExist){
                answer += i;
            }
        }
        return answer;
    }

}
