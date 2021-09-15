package 위클리_챌린지.위클리_2주차;

import java.util.*;

public class 위클리_2주차_상호평가 {
	public String solution(int[][] scores) {
        String answer = "";
       
        for(int j=0; j<scores.length; j++){
            // 자기 자신에게 준 점수 
            int selfScore = scores[j][j];
            int sum = 0;
            int min = 100;
            int max = -1;
            int count = scores.length;
            // 자기 자신에게 매긴 점수가 유일한 값인지 판단하는 변수 
            boolean flag = true;
            for(int i=0; i<scores.length; i++){
                int score = scores[i][j];
                
                min = Math.min(score,min);
                max = Math.max(score,max);
                
                // 자기 자신이 매긴 점수가 아니면서 자기 자신이 매긴 점수와 같은 경우
                if(i!=j && score==selfScore){
                    flag = false;
                } 
                
                // 평균을 구하기 위한 점수의 총 합
                sum += score;
  
            }
            if(flag && (min==selfScore || max==selfScore)){
                // 자기 자신을 평가한 점수는 평균을 구할때 제외
                count--;
                sum -= selfScore;
            }
            
            float avg = sum/count;
            String grade = calcGrade(avg);
            
            answer += grade;
        }
        return answer;
    }
    
    public String calcGrade(float avg){
        if(avg >= 90.0){
            return "A";
        }else if(avg>=80.0 && avg<90.0){
            return "B";
        }else if(avg>=70.0 && avg<80.0){
            return "C";
        }else if(avg>=50.0 && avg<70.0){
            return "D";
        }else{
            return "F";
        }
    }

}
