package test_s;
import java.util.*;

public class test01 {
	static int[] play_list = {1,2,3,4};
	static int listen_time = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		List<Integer> musicList = new ArrayList<>();
		
		for(int i=0; i<play_list.length*2; i++) {
			if(i<play_list.length) {
				for(int j=0; j<play_list[i]; j++) {
					musicList.add(i);
				}
			}else {
				for(int j=0; j<play_list[i-play_list.length]; j++) {
					musicList.add(i-play_list.length);
				}
			}
		}
		
		for(int i=0; i<musicList.size(); i++) {
			HashSet<Integer> hs = new HashSet<>();
			for(int j=i; j<listen_time+i; j++) {
				hs.add(musicList.get(j));
			}
			result = Math.max(result, hs.size());
			// 최댓값은 play_list.length을 넘을 수 없다.
			if(result >= play_list.length)	break;
		}
		
		System.out.println(result);

	}

}
