## BOJ 1717 집합의 표현 
- Union-Find
- 🥇 Gold4
- 🔗[집합의 표현 문제 바로가기](https://www.acmicpc.net/problem/1717)



## 풀이

Union-Find의 개념을 익히기 좋은 문제였다.

각각 a와 b를 같은 집합으로 합치는 Union 함수와 부모노드를 찾는 Find 함수를 통해 값을 구하였다.


## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1717_집합의_표현 {
	static int m,n;
	static int[] parents;
	static int find(int a) {
		if(parents[a]==a)
			return a;
		
		return parents[a] = find(parents[a]);
	}
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot!=bRoot) {
			parents[bRoot] = aRoot;
		}
	}
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int set = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(set==0) {
				union(a,b);
			}else if(set==1) {
				int aRoot = find(a);
				int bRoot = find(b);
				
				if(aRoot==bRoot) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}

	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 55444kb| 1728ms|