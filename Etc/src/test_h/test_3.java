package test_h;

import java.util.*;

public class test_3 {
		//static String[][] friends = {{"david","frank"},{"demi","david"},{"frank","james"},{"demi","james"},{"claire","frank"}};
		static String[][] friends = {{"david","demi"},{"frank","demi"},{"demi","james"}};
		static String user_id = "frank";
		public static void main(String[] args) {
			
			HashMap<String,List<String>> relation = new HashMap<>();
			
			for(int i=0; i<friends.length; i++){
	            String a = friends[i][0];
	            String b = friends[i][1];
	            // 주소값을 가지고 와서 얕은 복사 
	            List<String> relationA = relation.get(a);
	            if(relationA == null){
	                relationA = new ArrayList<>();
	                relation.put(a,relationA);
	            }

	            List<String> relationB = relation.get(b);
	            if(relationB == null){
	                relationB = new ArrayList<>();
	                relation.put(b,relationB);
	            }

	            relationA.add(b);
	            relationB.add(a);
	        }
			
			
			int max = 0;
			HashMap<String,Integer> mutualCnt = new HashMap<>();
			for (String friend: relation.get(user_id)) {
				
				for (String mutualFriend : relation.get(friend)) {
					if(!relation.get(user_id).contains(mutualFriend) && mutualFriend!=user_id){
						mutualCnt.put(mutualFriend, mutualCnt.getOrDefault(mutualFriend, 0)+1);
						max = Math.max(max, mutualCnt.get(mutualFriend));
					}
				}
			}
			
			List<String> list = new ArrayList<>();
			
			for (String cnt : mutualCnt.keySet()) {
				if(mutualCnt.get(cnt)==max) {
					list.add(cnt);
				}
			}
			
			Collections.sort(list);
			
			String[] answer = list.toArray(new String[list.size()]);
			System.out.println(Arrays.toString(answer));
			

		}

}
