package greedy.섬_연결하기;

import java.util.*;

public class 섬_연결하기 {
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
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[2]-o2[2];
            }
        });
        
        parents = new int[n];
        
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            int n1 = costs[i][0];
            int n2 = costs[i][1];
            if(find(n1)==find(n2)){
                continue;
            }else{
                union(n1,n2);
                answer += costs[i][2];
            }
            
        }
    
        
        return answer;
    }
	

}
