## BOJ 3584 최소 공통 조상 
- LCA
- 🥇 Gold4
- 🔗[최소 공통 조상 문제 바로가기](https://www.acmicpc.net/problem/3584)



## 풀이

최소 공통 조상 알고리즘이라는 것을 처음 알았다..
먼저 각 부모노드 정보를 저장하는 배열에 각 인덱스의 부모노드 값을 저장해주었다.
그리고 최소 공통 조상을 구할 두 노드의 깊이를 구하여
두 노드의 깊이가 다르다면 같게 해준뒤 공통 조상이 나타날때까지 현재 노드값을 부모노드 값으로 갱신해주어 같은 값이 되면 그 값을 출력하였다.


## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_3584_G4_가장_가까운_공통_조상 {
	static int T;
	static int[] parent;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer>[] adjList = new LinkedList[N+1];
			parent = new int[N+1];

			for(int i=0; i<=N; i++) {
				adjList[i] = new LinkedList<>();
			}
			
			for(int i=0; i<N-1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				parent[b] = a;
				
				adjList[a].add(b);
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int aDepth = getDepth(a);
			int bDepth = getDepth(b);

			int sameParent = lca(a,aDepth,b,bDepth);

			System.out.println(sameParent);
		}

	}
	private static int lca(int a, int aDepth, int b, int bDepth) {
		// 두 노드의 깊이가 같지 않다면 같게해주는 작업 필요 
		if(aDepth>bDepth) {
			while(aDepth!=bDepth) {
				aDepth--;
				a = parent[a];
			}
		}else if(aDepth<bDepth) {
			while(aDepth!=bDepth) {
				bDepth--;
				b = parent[b];
			}
		}
		// 공통 조상이 나타날때까지 부모노드 갱신 
		while(a!=b) {
			a = parent[a];
			b = parent[b];
		}
		return a;
	}
	private static int getDepth(int node) {
		int depth = 0;
		int current = node;
		while(current!=0) {
			depth++;
			current = parent[current];
		}
		return depth-1;
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 25176kb| 224ms|
