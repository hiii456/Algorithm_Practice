package dfs_bfs_1;

import java.util.*;

public class 네트워크 {
	static int[] parents;
    static int find(int a){
        if(parents[a]==a){
            return a;
        }
        
        return parents[a] = find(parents[a]);
    }
    static void union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot!=bRoot){
            parents[bRoot] = aRoot;
        }
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        parents = new int[n];
        
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j]==1){
                    union(i,j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<n; i++){
            set.add(find(parents[i]));
        }
        
        answer = set.size();
        return answer;
    }

}
