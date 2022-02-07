package 위클리_챌린지.모음사전;

public class 모음사전 {

	public int solution(String word) {
        int answer = 0;
        String str = "AEIOU";
        int[] x = {781,156,31,6,1};
        for(int i=0; i<word.length(); i++){
            int idx = str.indexOf(word.charAt(i));
            answer += x[i]*idx;
        }
        answer += word.length();
        return answer;
    }

}
