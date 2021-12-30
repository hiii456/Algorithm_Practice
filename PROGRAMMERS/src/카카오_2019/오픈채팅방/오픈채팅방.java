package 카카오_2019.오픈채팅방;
import java.util.*;

public class 오픈채팅방 {
	public String[] solution(String[] record) {
        List<String> list = new ArrayList<>();
        HashMap<String, String> hm = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] str = record[i].split(" ");
            if(str[0].equals("Enter")){
                hm.put(str[1],str[2]);
                list.add(str[1]+"님이 들어왔습니다.");
            }else if(str[0].equals("Leave")){
                list.add(str[1]+"님이 나갔습니다.");
            }else if(str[0].equals("Change")){
                hm.put(str[1],str[2]);
            }            
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            int idx = list.get(i).indexOf("님");
            String uid = list.get(i).substring(0,idx);
            String log = list.get(i).substring(idx,list.get(i).length());     
            String nickname = hm.get(uid);
            String newlog = nickname + log;
            answer[i] = newlog;
        }

        return answer;
    }

}
