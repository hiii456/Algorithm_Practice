package test_u;

class Solution {
    public int solution(int[][] fees, int usage) {
        int answer = 0;
        // 각 구간의 최대 전력량을 담는 배열 
        int[] score = new int[fees.length];
        // 몇번째 구간의 기본요금을 내는지 나타내는 변수 
        int idx = 0;

        for(int i=0; i<fees.length; i++){
            int a = fees[i][0];
            if(a==0){
                score[i] = 10000;
            }else{
                score[i] = a;
            }
        }

        for(int i=0; i<score.length-1; i++){
            if(i==0){
                if(0<=usage && score[i]>=usage){
                    idx = i;
                    break;
                }
            }
            if(score[i]<=usage && score[i+1]>=usage){
                idx = i+1;
                break;
            }
        }
        
        int sum = 0;
        int money = usage;
        for(int i=0; i<fees.length; i++){
            if(i<idx){
                if(i==0){
                    sum += (fees[i][0] * fees[i][2]);
                    money -= fees[i][0];
                }else{
                    sum += ((score[i] - score[i-1]) * fees[i][2]);
                    money -= (score[i] - score[i-1]);
                }
            }else if(i==idx){
                sum += money * fees[i][2];
                break;
            }
        }
        // 기본요금 추가 
        sum += fees[idx][1];

        answer = sum;

        return answer;
    }
}
