## BOJ - 회의실 배정 
- Silver 2
- greedy 
🔗[회의실 배정 문제 바로가기](https://www.acmicpc.net/problem/1931)



## 풀이

이 문제는 정렬을 이용한 그리디 문제였다. 
먼저, 회의 시작시간과 끝시간을 담은 Time 클래스를 만들어주고, 끝나는 시간 오름차순, 끝나는 시간이 같으면 시작하는 시간 오름차순 정렬을 해주었다.

~~~java
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
~~~


그리고 정렬시킨 회의시간 정보가 담긴 list를 출력하여 앞의 회의시간과 비교해주어 겹치지 않는 회의시간을 카운트하였다.

~~~Java
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
~~~


## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|43748KB	|484ms|