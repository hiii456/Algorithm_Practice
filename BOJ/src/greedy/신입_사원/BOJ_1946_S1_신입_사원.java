package greedy.신입_사원;

import java.io.*;
import java.util.*;

public class BOJ_1946_S1_신입_사원 {
	static class Grade implements Comparable<Grade>{
		int document;
		int interview;
		public Grade(int document,int interview) {
			this.document = document;
			this.interview = interview;
		}
		@Override
		public int compareTo(Grade o) {
			// TODO Auto-generated method stub
			return this.document - o.document;
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			List<Grade> list = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list.add(new Grade(a,b));
			}
			
			Collections.sort(list);
			
			int ans = 1;
			int tmp = list.get(0).interview;
			for(int i=1; i<n; i++) {
				if(tmp>list.get(i).interview) {
					tmp = list.get(i).interview;
					ans++;
				}
			}
			
			System.out.println(ans);
			
		}

	}

}
