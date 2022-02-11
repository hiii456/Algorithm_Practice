package 카카오_2020.문자열_압축;
import java.util.*; 
public class 문자열_압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a";
		int answer = s.length();
        for(int i=1; i<=s.length()/2; i++){
            int len = compression(i,s);
            answer = Math.min(answer,len);
        }
        System.out.println(answer);

	}
	public static int compression(int size,String s){
        StringBuilder sb = new StringBuilder();
        String pattern = "";
        String comp = "";
        int cnt = 1;
        for(int i=0; i<=s.length()-size; i+=size){
            if(pattern.equals(s.substring(i,i+size))){
                cnt++;
                continue;
            }
            
            if(cnt>1){
                sb.append(cnt + pattern);
                cnt = 1;
            }else{
                sb.append(pattern);
            }
            pattern = s.substring(i,i+size);
            
        }
        if(cnt>1){
        	sb.append(cnt + pattern);
        }else{
            sb.append(pattern);
        }
        
        sb.append(s.substring(s.length() - s.length()%size , s.length()));
        return sb.length();
    }

}
