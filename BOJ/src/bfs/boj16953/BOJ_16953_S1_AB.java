package bfs.boj16953;

import java.io.*;
import java.util.*;

public class BOJ_16953_S1_AB {
	static int a,b,ans;
	static class Pair{
		long num;
		int cnt;
		public Pair(long num,int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		bfs(a,1);
		
		System.out.println(ans);
		
	}
	public static void bfs(int a,int cnt) {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(a,cnt));
		
		while(!queue.isEmpty()) {
			Pair p = queue.poll();
			if(p.num == b) {
				ans = p.cnt;
				return;
			}
			
			if(p.num*2<=b) {
				queue.add(new Pair(p.num*2,p.cnt+1));
			}
			
			if(p.num*10+1<=b) {
				queue.add(new Pair(p.num*10+1,p.cnt+1));
			}
		}
		ans = -1;
	}

}
