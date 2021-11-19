package test_h;

import java.util.*;

// for문 여러번 사용 -> 안좋은지 
public class test_2 {
	//static String[][] freinds = {{"david","frank"},{"demi","david"},{"frank","james"},{"demi","james"},{"claire","frank"}};
	static String[][] freinds = {{"david","demi"},{"frank","demi"},{"demi","james"}};
	static String user_id = "frank";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> hm = new HashSet<>();
		List<String> mutual_freinds = new ArrayList<>();
		List<String> no_freinds = new ArrayList<>();
		for(int i=0; i<freinds.length; i++) {
			String a = freinds[i][0];
			String b = freinds[i][1];
			hm.add(a);
			hm.add(b);
			
			if(a.equals(user_id)) {
				mutual_freinds.add(b);
			}else if(b.equals(user_id)) {
				mutual_freinds.add(a);
			}
		}
		
		
		// 안친한 친구 리스트 만들어쥼..
		for(String s : hm) {
			boolean isSame = false;
			for(int i=0; i<mutual_freinds.size(); i++) {
				String a = mutual_freinds.get(i);
				if(s.equals(a)) {
					isSame = true;
					break;
				}	
			}
			if(!isSame) {
				no_freinds.add(s);
			}
		}
		
		int max = 0;
		HashMap<String,Integer> hs = new HashMap<>();
		for(int i=0; i<no_freinds.size(); i++) {
			String no = no_freinds.get(i);
			int cnt = 0;
			for(int j=0; j<freinds.length; j++) {
				String a = freinds[j][0];
				String b = freinds[j][1];
				if(a==user_id || b==user_id)	continue;
				if(a.equals(no)) {
					if(mutual_freinds.contains(b)) {
						cnt++;
					}
				}else if(b.equals(no)) {
					if(mutual_freinds.contains(a)) {
						cnt++;
					}
				}
			}
			hs.put(no, cnt);
			max = Math.max(max, cnt);
			
		}

		List<String> list = new ArrayList<>();
		
		for (String s : hs.keySet()) {
			if(hs.get(s)==max) {
				list.add(s);
			}
		}
		
		Collections.sort(list);
		
		String[] answer = list.toArray(new String[list.size()]);
		System.out.println(Arrays.toString(answer));
//		System.out.println(max);
		
//		for (String string : no_freinds) {
//			System.out.println(string);
//		}
	}

}
