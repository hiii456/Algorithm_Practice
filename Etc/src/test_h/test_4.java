package test_h;

import java.util.*;

public class test_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
	    List<Integer> dragon = new ArrayList<>();
	    List<Integer> egg = new ArrayList<>();
	    egg.add(0);
	    
	    HashMap<Integer,Integer> dragonMap = new HashMap<>();
	    List<Integer> notEggMap = new ArrayList<>();
	    HashMap<Integer,Integer> eggMap = new HashMap<>();
	    eggMap.put(0, 0);
	    
	    int dragonCnt = 0;
	    // set -> 배열의 index값 대체 
	    for(int i=1; i<=n; i++) {
//	    	System.out.println(i);
//	    	for (Integer integer : dragon) {
//	    		dragon.set(integer, dragon.get(integer)+1);
//	    		// 더 이상 알을 낳지 않으면 알을 낳지 않는 리스트로 이동 
//	    		if(dragon.get(integer)==4) {
//	    			continue;
//	    		}
//	    		egg.add(0);
//	    		
//			}
//	    	// 알의 날짜를 계산해주고 이틀된 알은 부화 
//	    	for (Integer integer : egg) {
//	    		egg.set(integer, egg.get(integer)+1);
//	    		System.out.println(1);
//				if(egg.get(integer)==2) {
//					System.out.println("--");
//					egg.remove(integer);
//					dragon.add(0);
//				}
//			}
	    	
	    	for(int j=0; j<egg.size(); j++) {
	    		egg.set(j, egg.get(j)+1);
	    	}
	    	
	        while(!egg.isEmpty() && egg.get(0) == 2) {
	        	dragon.add(0);
	            egg.remove(0);
	        }
	    	
	    	for(int j=0; j<dragon.size(); j++) {
	    		if(dragon.get(j)<4) {
	    			egg.add(0);
	    		}
	    		
	    		dragon.set(j, dragon.get(j)+1);

	    	}
	    	System.out.println(egg.size()+dragon.size());
	    	
	    }


	}

}
