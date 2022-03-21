## BOJ - 신입 사원 
- Silver 1 
- greedy 
🔗[신입 사원 문제 바로가기](https://www.acmicpc.net/problem/1946)



## 풀이

처음에 풀이방식은 입력이 최대 10만개이므로 N^2의 시간복잡도를 가지게되면서 시간초과 오류가 나게 되었다.(밑의 틀린풀이 참고)

따라서 이중for문을 사용하지 않고 문제를 해결할 수 있는 방법을 찾아야했다.
이를 위해 서류 결과 순서대로 오름차순 정렬을 한 list를 1번째 값부터 탐색한다. (0번째 값은 서류 결과 1등이므로 다른사람의 서류결과보다 항상 높다.)
그리고 탐색할 사람의 서류 결과는 정렬 기준으로 앞 사람보다 항상 서류결과가 낮은 순위이므로 면접 순위가 높아야한다. 
따라서 면접 순위가 높다면, 사람 수를 count 해주고 면접결과 최고 순위를 갱신해준다.

## 소스코드

#### 틀린 풀이 

~~~java
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
			
			int ans = n;
			for(int i=0; i<n; i++) {
				for(int j=0; j<i; j++) {
					if(list.get(i).interview>list.get(j).interview) {
						ans--;
						break;
					}
				}
			}
			
			System.out.println(ans);
			
		}

	}

}
~~~

#### 옳은 풀이 

~~~java
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
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|300892KB	|1500ms|