package test_u;
import java.util.*;

public class test4 {
	static int[][] tower = {{0,2},{2,3},{3,2},{5,3},{6,2},{7,3},{9,4},{10,2},{11,2},{12,4},{14,2},{15,3},{16,2}};
	static int k =3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = 0;
		HashMap<Integer,List<Integer>> hm = new HashMap<>();

        for(int i=0; i<tower.length; i++){
            int idx = tower[i][0];
            int height = tower[i][1];

            if(hm.containsKey(height)){
            	List list = hm.get(height);
            	list.add(idx);
            	hm.put(height, list);
            }else {
            	List<Integer> list= new ArrayList<>();
            	list.add(idx);
            	hm.put(height, list);
            }
        }

        for(Integer key : hm.keySet()) {
        	List list = hm.get(key);
            int cnt = 0;
            boolean group = false;
            for(int i=1; i<list.size(); i++){
                // 송전 선로를 연결할 수 있는 경우 
                if((Integer)list.get(i)-(Integer)list.get(i-1)<=k){
                	continue;
                }else{
	                 cnt++;                  
                }
               
            }
            cnt++;
            System.out.println(cnt);
            answer += cnt;
        }


	}

}
