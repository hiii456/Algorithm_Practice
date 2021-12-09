package 카카오_인턴십_2020.키패드누르기;
import java.util.*;
public class 키패드_누르기 {
	
	public String solution(int[] numbers, String hand) {
        String answer = "";
        int right = 10;
        int left = 12;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            if(num==1 || num==4 || num==7){
                sb.append("L");
                left = num;
            }
            else if(num==3 || num==6 || num==9){
                sb.append("R");
                right = num;
            }
            else{
                if(num==0)  num = 11;
                
                int leftDis = Math.abs((num-1)/3-(left-1)/3) + Math.abs((num-1)%3-(left-1)%3);
                int rightDis = Math.abs((num-1)/3-(right-1)/3) + Math.abs((num-1)%3-(right-1)%3);
                
                if(leftDis>rightDis){
                    sb.append("R");
                    right = num;
                }else if(leftDis<rightDis){
                    sb.append("L");
                    left = num;
                }else{
                    if(hand.equals("right")){
                        sb.append("R");
                        right = num;
                    }else if(hand.equals("left")){
                        sb.append("L");
                        left = num;
                    }
                }
            }
        }
        
        answer = sb.toString();
        return answer;
    }

}
