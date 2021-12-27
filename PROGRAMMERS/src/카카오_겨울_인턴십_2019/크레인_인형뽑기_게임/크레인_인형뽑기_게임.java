package 카카오_겨울_인턴십_2019.크레인_인형뽑기_게임;
import java.util.*;

public class 크레인_인형뽑기_게임 {

	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<moves.length; i++){
            int move = moves[i];
            for(int j=0; j<board.length; j++){
                int doll = board[j][move-1];
                if(doll==0) continue;
                else{
                    board[j][move-1] = 0;
                    if(stack.size()>0){
                        if(stack.peek()==doll){
                            stack.pop();
                            answer += 2;
                        }else{
                            stack.add(doll);
                        }
                    }else{
                        stack.add(doll);
                    }
                    break;
                }
            }
        }
        return answer;
    }

}
