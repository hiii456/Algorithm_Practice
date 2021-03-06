package UnionFind.boj1717;

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
