package 카카오_겨울_인턴십_2019.불량_사용자;
import java.util.*;
public class 불량_사용자 {
	static HashSet<String> hs = new HashSet<>();
    static boolean[] visited;
    static String[] tmp;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        tmp = new String[banned_id.length];
        // 불량사용자 아이디중 '*'를 '.'로 바꾸어준다.
        for(int i=0; i<banned_id.length; i++){
            tmp[i] = banned_id[i].replace("*",".");
        }
        
        visited = new boolean[user_id.length];
        backtracking(0,user_id);
        answer = hs.size();
        return answer;
    }
    public static void backtracking(int cnt,String[] user_id){
        if(cnt == tmp.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    sb.append(user_id[i]);
                }
            }
            hs.add(sb.toString());
            return;
        }
        
        for(int i=0; i<user_id.length; i++){
            if(!visited[i] && user_id[i].matches(tmp[cnt])){
                visited[i] = true;
                backtracking(cnt+1,user_id);
                visited[i] = false;
            }
        }
    }

}
