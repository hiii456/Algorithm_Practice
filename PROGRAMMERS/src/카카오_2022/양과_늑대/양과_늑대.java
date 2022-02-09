package 카카오_2022.양과_늑대;
import java.util.*;
public class 양과_늑대 {
	static List<Integer>[] childs;
    static int max = 0;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        // 해당 index의 자식노드를 담는다. 
        childs = new ArrayList[info.length];
        for(int[] e : edges){
            int parent = e[0];
            int child = e[1];
            if(childs[parent]==null){
                childs[parent] = new ArrayList<>();
            }
            childs[parent].add(child);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        // root 위치(0)에서부터 탐색 시작 
        dfs(0,0,0,list,info);
        
        answer = max;
        
        return answer;
    }
    public static void dfs(int idx,int sheep,int wolf,List<Integer> nextPos,int[] info){
        // 양, 늑대 갯수 count
        if(info[idx]==0)    sheep++;
        else    wolf++;
        // 만약 양의 갯수가 늑대의 갯수보다 적다면 return 
        if(wolf>=sheep) return;
        max = Math.max(max,sheep);
        
        List<Integer> list = new ArrayList<>();
        list.addAll(nextPos);
        list.remove(Integer.valueOf(idx));
        if(childs[idx]!=null){
            for(int child : childs[idx]){
                list.add(child);
            }
        }
        
        for(int next : list){
            dfs(next, sheep, wolf, list, info);
        }
    } 

}
