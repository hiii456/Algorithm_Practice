package 카카오_2022.주차_요금_계산;
import java.util.*;
public class 주차_요금_계산 {
	public int[] solution(int[] fees, String[] records) {
        HashMap<String,Integer> in_car = new HashMap<>();
        HashMap<String,Integer> total_car = new HashMap<>();
        for(int i=0; i<records.length; i++){
            String s = records[i];
            String[] record = s.split(" ");
            String[] timeArr = record[0].split(":");
            int time = Integer.valueOf(timeArr[0])*60 + Integer.valueOf(timeArr[1]);
            String carNum = record[1];
            String state = record[2];
            // 차가 주차장에 없을 경우 
            if(!in_car.containsKey(carNum) || in_car.get(carNum)==-1){
                in_car.put(carNum, time);
            }
            // 차가 주차장에 있을 경우 
            else{
                int in_time = in_car.get(carNum);
                int total_time = time - in_time;
                total_car.put(carNum, total_car.getOrDefault(carNum,0) + total_time);
                in_car.put(carNum,-1);
            }
            
        }
        
        // 입차된 후에 출차된 내역이 없는 차를 23:59에 출차시킨다.
        for(String key : in_car.keySet()) {
        	if(in_car.get(key)!=-1) {
        		int total_time = 1439 - in_car.get(key);
        		total_car.put(key, total_car.getOrDefault(key,0) + total_time);
        	}
        }
        
        Object[] carArr = total_car.keySet().toArray();
		Arrays.sort(carArr);
        
        int[] answer = new int[carArr.length];
        
        int idx = 0;
        for(int i=0; i<carArr.length; i++){
        	String carNum = (String) carArr[i];
        	// 기본시간보다 적다면 기본요금 저장 
            if(total_car.get(carNum)<=fees[0]) {
            	answer[idx++] = fees[1];
            }else {
            	answer[idx++] = fees[1] + (int) Math.ceil((double)(total_car.get(carNum)-fees[0])/fees[2]) * fees[3];
            }
        }
        
        return answer;
    }

}
