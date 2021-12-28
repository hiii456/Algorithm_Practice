package 카카오_2019.실패율;
import java.util.*;

public class 실패율 {
	static class Stage implements Comparable<Stage>{
        // 스테이지 번호, 실패율  
        int num;
        double fail;
        public Stage(int num,double fail){
            this.num = num;
            this.fail = fail;
        }
        @Override
        public int compareTo(Stage o){
            if(o.fail - this.fail > 0)
                return 1;
            else if(o.fail == this.fail)
                return this.num - o.num;
            else
                return -1;
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] user = new int[N+1];
        List<Stage> list = new ArrayList<>();
        for(int i=0; i<stages.length; i++){
            user[stages[i]-1]++;
        }
        
        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<N+1; j++){
                sum += user[j];
            }
            if(user[i]==0){
                list.add(new Stage(i+1,0.0));
            }else{
                double fail = (double) user[i]/sum;
                list.add(new Stage(i+1,fail));
            }
            
        }
        
        Collections.sort(list);
        
        for(int i=0; i<N; i++){
            answer[i] = list.get(i).num;
        }
        
        return answer;
    }

}
