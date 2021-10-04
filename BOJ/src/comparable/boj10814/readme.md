## BOJ 10814 나이순 정렬 
- Sort 
- 🥈 Silver5 
- 🔗[나이순 정렬 문제 바로가기](https://www.acmicpc.net/problem/10814)



## 풀이

Comparator을 이용하여 문제를 풀었다.
그리고 System.out.println를 썼을 땐 2268ms의 시간이 걸렸는데 StringBuilder를 씀으로 600ms로 시간을 거의 3배 넘게 줄일 수 있었다..

## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10814_S5_나이순_정렬 {
	static List<Info> list = new ArrayList<>();
	static class Info {
		int age;
		String name;
		public Info(int age,String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Info(age,name));
		}
		
		Collections.sort(list, new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				// TODO Auto-generated method stub
				return o1.age - o2.age;
			}			
		});
		
		for(int i=0; i<N; i++) {
			sb.append(list.get(i).age + " " + list.get(i).name + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 62684kb| 600ms|
