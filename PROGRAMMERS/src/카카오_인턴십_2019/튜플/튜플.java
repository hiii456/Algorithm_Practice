package 카카오_인턴십_2019.튜플;

import java.util.*;
import java.util.Map.Entry;

public class 튜플 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		s = s.replaceAll("[{}]"," ").trim();
		String[] str = s.split(" , ");

		HashMap<Integer,Integer> hm = new HashMap<>();

		for(int i=0; i<str.length; i++) {
			String[] tmp = str[i].split(",");
			for(int j=0; j<tmp.length; j++) {
				int num = Integer.parseInt(tmp[j]);
				hm.put(num, hm.getOrDefault(num,0)+1);
			}	
		}

		List<Integer> list = new ArrayList<>(hm.keySet());
		Collections.sort(list, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return hm.get(o2) - hm.get(o1);
			}	
		});
		
		int[] answer = new int[list.size()];
		int idx = 0;
		for(int i : list) {
			answer[idx++] = i;
		}
		System.out.println(Arrays.toString(answer));

	}

}
