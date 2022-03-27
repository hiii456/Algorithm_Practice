package greedy.boj11000;

import java.io.*;
import java.util.*;

public class BOJ_11000_G5_강의실_배정 {
	static class Class implements Comparable<Class>{
		int s;
		int t;
		public Class(int s,int t) {
			this.s = s;
			this.t = t;
		}
		@Override
		public int compareTo(Class o) {
			if(s == o.s) {
				return this.t - o.t;
			}
			return this.s - o.s;
		}
		
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<Class> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			list.add(new Class(S,T));
		}
		
		Collections.sort(list);
		PriorityQueue<Integer> pq = new PriorityQueue<>();		
		
		for(int i=0; i<list.size(); i++) {
			if(!pq.isEmpty() && pq.peek()<=list.get(i).s) {
				pq.poll();
			}
			pq.add(list.get(i).t);
		}
		
		System.out.println(pq.size());

	}

}
