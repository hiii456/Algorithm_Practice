package 카카오_2018;

public class 다트게임 {

	public int solution(String dartResult) {
        int answer = 0;
        int[] cnt = new int[3];        
        int seq = -1;
        
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);
            if(ch>='0' && ch<='9'){
                seq++;
                if(ch == '1' && dartResult.charAt(i+1) == '0'){
                    cnt[seq] = 10;
                    i++;
                }else{
                    cnt[seq] = ch - '0';
                }
            }
            
            if(ch == 'D'){
                cnt[seq] *= cnt[seq];
            }else if(ch == 'T'){
                cnt[seq] *= cnt[seq] * cnt[seq];
            }
            
            if(ch == '*'){
                if(seq==0){
                    cnt[seq] *= 2;
                }else{
                    cnt[seq-1] *= 2;
                    cnt[seq] *= 2;
                }
            }
            
            if(ch == '#'){
                cnt[seq] *= -1;
            }
        }
        
        for(int i=0; i<3; i++){
            answer += cnt[i];
        }
  
        return answer;
    }

}
