## BOJ - 강의실 배정 
- Gold 5  
- greedy 
🔗[강의실 배정 문제 바로가기](https://www.acmicpc.net/problem/11000)



## 풀이

먼저 시작시간을 기준으로 오름차순 정렬을 하고 시작시간이 같다면 종료시간을 기준으로 오름차순 정렬을 하는 class 객체를 만들었다.

~~~java
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
~~~

그리고 class 객체를 담는 list를 만들어 정렬을 해주고 수업의 종료시간을 담는 우선순위큐를 생성한다. 
(우선순위큐의 타입이 Integer인 이유는 종료시간만을 비교해즈면 되기 때문이다.)
그리고 우선순위큐가 비어있지 않을 경우, 우선순의 큐의 젤 위에있는 시간과 그 다음으로 들어올 수 있는 시간의 시작시간을 비교해준 뒤 우선순위 큐의 사이즈를 구하면 된다.

~~~java
		for(int i=0; i<list.size(); i++) {
			if(!pq.isEmpty() && pq.peek()<=list.get(i).s) {
				pq.poll();
			}
			pq.add(list.get(i).t);
		}
~~~




## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|74976KB	|652ms|