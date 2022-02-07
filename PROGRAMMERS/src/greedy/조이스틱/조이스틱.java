package greedy.조이스틱;

public class 조이스틱 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "ABAA";
		int answer = 0;
        int min = name.length()-1;
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);
            
            // 상하 이동 
            if(ch - 'A' > 'Z' - ch){
                answer += 'Z' - ch + 1;
            }else{
                answer += ch - 'A';
            }
            
            // 좌우 이동
            int next = i+1;
            while(next<name.length() && name.charAt(next)=='A'){
                next++;
            }
            min = Math.min(min, (i*2)+name.length()-next);
        }
        answer += min;
        System.out.println(answer);
	}

}
