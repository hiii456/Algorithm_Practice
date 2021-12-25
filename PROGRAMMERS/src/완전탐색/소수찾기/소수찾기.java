package 완전탐색.소수찾기;
import java.util.*;
public class 소수찾기 {
	static char[] src;
    static boolean[] selected;
    static char[] tgt;
    static HashSet<Integer> hs = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        src = numbers.toCharArray();
        selected = new boolean[src.length];
        
        for(int i=1; i<=src.length; i++){
            tgt = new char[i];
            perm(0);
        }
        
        answer = hs.size();
        
        return answer;
    }
    public static void perm(int tgtIdx){
        if(tgtIdx == tgt.length){
            // 맨 앞에 0이 오면 return
            if(tgt[0]=='0') return;
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<tgt.length; i++){
                sb.append(tgt[i]);
            }
            int num = Integer.parseInt(sb.toString());
            
            if(isPrime(num)){
                hs.add(num);
            }
            
            
            return;
        }
        
        for(int i=0; i<src.length; i++){
            if(selected[i]) continue;
            
            tgt[tgtIdx] = src[i];
            selected[i] = true;
            perm(tgtIdx+1);
            selected[i] = false;
        }

    }
    // 에라토스테네스의 체 알고리즘 이용 
	private static boolean isPrime(int num) {
		// 1은 소수가 아니므로 false 
		if(num==1)	return false;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num%i==0) 	return false;
		}

		return true;
	}

}
