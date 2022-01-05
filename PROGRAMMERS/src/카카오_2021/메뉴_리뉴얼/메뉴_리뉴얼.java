package 카카오_2021.메뉴_리뉴얼;
import java.util.*;
public class 메뉴_리뉴얼 {
	static HashMap<String,Integer> hm;
    static char[] tgt;
    public List<String> solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<course.length; i++){
            hm = new HashMap<>();
		    tgt = new char[course[i]];
		    // 코스 종류를 오름차순 해주는 작업 
		    for(int j=0; j<orders.length; j++){
		        char[] tmp = orders[j].toCharArray();
		        Arrays.sort(tmp);
		        orders[j] = String.valueOf(tmp); 
		        // 각 course 길이 만큼의 조합을 구한다.
		        comb(0,0,tmp);
		    }
            int max = Integer.MIN_VALUE;
            // 많이 주문한 코스의 주문 수를 구한다.
            for(String key : hm.keySet()){
                max = Math.max(max,hm.get(key));
            }
            // 미리 구한 max만큼 주문 수가 들어왔으면서 주문 수가 2 이상인 코스를 answer에 저장한다.
            for(String key : hm.keySet()){
                if(hm.get(key)==max && hm.get(key)>=2){
                    answer.add(key);
                }
            }
            
		}
     
        Collections.sort(answer);
        
        return answer;
    }
    public static void comb(int srcIdx,int tgtIdx,char[] tmp){
        if(tgtIdx == tgt.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<tgt.length; i++){
                sb.append(tgt[i]);
            }
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i=srcIdx; i<tmp.length; i++){
            tgt[tgtIdx] = tmp[i];
            comb(i+1,tgtIdx+1,tmp);
        }
    }

}
