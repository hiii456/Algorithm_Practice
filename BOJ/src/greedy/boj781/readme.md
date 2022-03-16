## BOJ - 컵라면 
- Gold 2
- greedy
🔗[컵라면 문제 바로가기](https://www.acmicpc.net/problem/1781)



## 풀이

이 문제는 정렬을 이용하여 문제를 해결하였다.
먼저 데드라인은 오름차순, 데드라인이 같은 경우 라면의 갯수를 내림차순으로 정렬하는 Problem 클래스를 만들었다.

~~~java
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
~~~

여기서 주의할 점은, 이 정렬대로만 구하게 되는 경우 데드라인이 다 차지 않았을 때, 데드라인 정렬이 우선이기 때문에 데드라인은 빠르지만 라면의 갯수는 적은 문제를 풀어야한다. 따라서 이를 위해 우선순위 큐의 size를 단위시간으로 설정한다.(문제푸는데 단위시간이 1 걸리므로) 그리고 우선순위큐 size와 정렬된 문제의 데드라인을 비교한다. 만일, 데드라인이 우선순위 큐의 size와 같거나 크다면 라면 크기를 비교하여 우선순위 큐에 라면의 값이 더 많은 문제를 넣어준다.

~~~java
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
~~~


## 소스코드
~~~java
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

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|76556KB	|1064ms|