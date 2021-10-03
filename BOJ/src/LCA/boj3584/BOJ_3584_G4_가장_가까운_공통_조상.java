package LCA.boj3584;

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
