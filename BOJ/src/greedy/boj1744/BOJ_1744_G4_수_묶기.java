package greedy.boj1744;

import java.io.*;
import java.util.*;

public class BOJ_1744_G4_수_묶기 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		boolean isZero = false;
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			// 1은 곱하는 것보다 더하는게 유리하므로 	list에 넣지 않는다.
			if(num == 1) {
				ans += 1;
			}else if(num>0) {
				list1.add(num);
			}else if(num<0) {
				list2.add(num);
			}else {
				isZero = true;
			}
		}
		
		Collections.sort(list1, Comparator.reverseOrder());
		Collections.sort(list2);

		for(int i=0; i<list1.size(); i+=2) {
			if(i==list1.size()-1) {
				ans += list1.get(i);
			}else {
				ans += list1.get(i) * list1.get(i+1);
			}
			
		}
		
		for(int i=0; i<list2.size(); i+=2) {
			if(i==list2.size()-1) {
				// 0이 존재하면 하나 남은 음수를 0으로 만들 수 있다.
				if(!isZero) {
					ans += list2.get(i);
				}
			}else {
				ans += list2.get(i) * list2.get(i+1);
			}
		}
		
		System.out.println(ans);
	}

}
