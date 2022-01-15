package 카카오_2022.신고_결과_받기;
import java.util.*;
import java.util.Map.Entry;
public class test {
	static String[] id_list = {"muzi", "frodo", "apeach", "neo"};
	static String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
	static int k = 2;
	public static void main(String[] args) {
		int[] answer = new int[id_list.length];
		HashMap<String, HashSet<String>> hm = new HashMap<>();
		
		for(String id : id_list) {
			hm.put(id, new HashSet<>());
		}
		
		for(String s : report) {
			String[] arr = s.split(" ");
			String name1 = arr[0];
			String name2 = arr[1];
			Set<String> reportList = hm.get(name2);
			reportList.add(name1);
		}
		
		for(String key : hm.keySet()) {
			HashSet<String> set = hm.get(key);
			if(set.size()>=k) {
				for(String str : set) {
					answer[Arrays.asList(id_list).indexOf(str)] += 1;
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));

	}

}
