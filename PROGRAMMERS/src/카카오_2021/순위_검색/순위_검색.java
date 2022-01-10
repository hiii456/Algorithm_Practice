package 카카오_2021.순위_검색;
import java.util.*;

public class 순위_검색 {
	class Solution {
	    static HashMap<String,List<Integer>> hm = new HashMap<>();
	    public int[] solution(String[] info, String[] query) {
	        int[] answer = new int[query.length];
	        
	        for(int i=0; i<info.length; i++){
	            String[] applicant = info[i].split(" ");
	            dfs(applicant,"",0);
	        }
	        
	        for(String key : hm.keySet()){
	            // 각 key에 맞는 코딩테스트 점수를 오름차순 정렬 
	            Collections.sort(hm.get(key));
	        }

	        for(int i=0; i<query.length; i++){
	            query[i] = query[i].replaceAll(" and ","");
	            // 조건에 해당하는 지원자 정보와 코딩테스트 점수 분리 
	            String[] arr = query[i].split(" ");
	            answer[i] = binarySearch(arr[0],Integer.parseInt(arr[1]));
	        }
	        return answer;
	    }
	    public static int binarySearch(String info, int score){
	        if(!hm.containsKey(info)){
	            return 0;
	        }
	        
	        List<Integer> list = hm.get(info);
	        
	        int left = 0;
	        int right = list.size()-1;
	        
	        while(left<=right){
	            int mid = (left+right)/2;
	            
	            if(score>list.get(mid)){
	                left = mid + 1;
	            }else{
	                right = mid - 1;
	            }
	        }
	        
	        return list.size() - left;
	    }
	    public static void dfs(String[] applicant,String str,int cnt){
	        if(cnt == 4){
	            if(!hm.containsKey(str)){
	                List<Integer> list = new ArrayList<>();               
	                hm.put(str,list);
	            }
	            // info의 맨마지막에 해당하는 코딩테스트 점수는 해당하는 info의 list에 넣는다.
	            hm.get(str).add(Integer.parseInt(applicant[4]));
	            return;
	        }
	        
	        dfs(applicant, str + "-" , cnt+1);
	        dfs(applicant, str + applicant[cnt], cnt+1);
	    }
	}

}
