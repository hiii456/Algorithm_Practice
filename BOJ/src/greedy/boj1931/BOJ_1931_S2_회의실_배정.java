package greedy.boj1931;

import java.io.*;
import java.util.*;

public class BOJ_1931_S2_회의실_배정 {
	static class Time implements Comparable<Time>{
		int start;
		int end;
		public Time(int start,int end){
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(Time o) {
			if(this.end == o.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Time> list = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.add(new Time(start,end));
		}
		
		Collections.sort(list);
		
		int meetingStart = 0;
		int meetingEnd = 0;
		int cnt = 0;
		for(int i=0; i<list.size(); i++) {
			int start = list.get(i).start;
			int end = list.get(i).end;
			
			if(meetingEnd <= end && meetingStart <= start && meetingEnd <= start){
				cnt++;
				meetingStart = start;
				meetingEnd = end;
			}
			
		}
		
		System.out.println(cnt);

	}

}
