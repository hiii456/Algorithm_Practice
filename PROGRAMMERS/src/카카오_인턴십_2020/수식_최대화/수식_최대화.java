package 카카오_인턴십_2020.수식_최대화;
import java.util.*;

public class 수식_최대화 {
	static List<Long> numList = new ArrayList<>();
    static List<Character> opList = new ArrayList<>();
    static boolean[] visited = new boolean[3];
    static char[] op = {'+','-','*'};
    static long answer = 0;
    public long solution(String expression) {        
        String num = "";
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)>='0' && expression.charAt(i)<='9'){
                num += expression.charAt(i);
            }else{
                numList.add(Long.parseLong(num));
                num = "";
                opList.add(expression.charAt(i));
            }
        }
        numList.add(Long.parseLong(num));
        dfs(0,new char[3]);
        
        return answer;
    }
    public static void dfs(int cnt, char[] p){
        if(cnt==3){
            List<Long> cNum = new ArrayList<>(numList);
            List<Character> cOp = new ArrayList<>(opList);
            
            for(int i=0; i<p.length; i++){
                for(int j=0; j<cOp.size(); j++){
                    if(p[i] == cOp.get(j)){
                        Long result = calc(cNum.remove(j),cNum.remove(j),p[i]);
                        cNum.add(j,result);
                        cOp.remove(j);
                        j--;
                    }
                }
            }
            
            answer = Math.max(answer,Math.abs(cNum.get(0)));
            return;
        }
        
        for(int i=0; i<3; i++){
            if(!visited[i]){
                p[cnt] = op[i];
                visited[i] = true;
                dfs(cnt+1,p);
                visited[i] = false;
            }
        }
    }
    public static long calc(long num1,long num2,char op){
        long num = 0;
        
        if(op=='*'){
            return num1 * num2;
        }else if(op =='+'){
            return num1 + num2;
        }else if(op == '-'){
            return num1 - num2;
        }
        
        return num;
    }

}
