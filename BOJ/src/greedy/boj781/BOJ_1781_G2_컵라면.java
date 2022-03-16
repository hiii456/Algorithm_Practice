package greedy.boj781;

import java.io.*;
import java.util.*;

public class BOJ_1781_G2_컵라면 {
	static class Problem implements Comparable<Problem>{
		int deadline;
		int ramen;
		public Problem(int deadline,int ramen) {
			this.deadline = deadline;
			this.ramen = ramen;
		}
		@Override
		public int compareTo(Problem o) {
			if(this.deadline == o.deadline) {
				return o.ramen - this.ramen;
			}
			return this.deadline - o.deadline;
		}
		
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Problem[] arr = new Problem[n];
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Problem(a,b);
		}
		
		long ans = 0;
		Arrays.sort(arr);
		
		for(Problem p : arr) {
			if(pq.size()<p.deadline) {
				pq.add(p.ramen);
			}else {
				if(pq.peek()<p.ramen) {
					pq.poll();
					pq.add(p.ramen);
				}
			}
		}
		while(!pq.isEmpty()) {
			ans += pq.poll();
		}
		
		System.out.println(ans);

	}

}
