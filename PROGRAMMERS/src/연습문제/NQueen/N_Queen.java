package 연습문제.NQueen;

import java.util.*;

class Solution {
    static int answer = 0;
    static int[] cols;
    public int solution(int n) {

        for(int i=0; i<n; i++){
            cols = new int[n];
            cols[0] = i;
            backTracking(n,1);
        }
        
        return answer;
    }
    public void backTracking(int n,int row){
        if(row == n){
            answer++;
            return;
        }
        else{
            for(int i=0; i<n; i++){
                cols[row] = i;
                if(isPossible(row)){
                    backTracking(n,row+1);
                }
            }
        }
    }
    public boolean isPossible(int row){
        for(int i=0; i<row; i++){
            if(cols[i] == cols[row] || Math.abs(row-i) == Math.abs(cols[row]-cols[i])){
                return false;
            }
        }
        return true;
    }
    
}
