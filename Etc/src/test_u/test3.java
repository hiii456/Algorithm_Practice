package test_u;
import java.util.*;

public class test3 {
	static String[] arr1 = {"()", "(()", ")()", "()"};
	static String[] arr2 = {")()", "()", "(()"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long answer = 0;
        List<String> list = new ArrayList<>();

        for(int i=0; i<arr1.length; i++){
            for(int j=0; j<arr2.length; j++){
                String str = arr1[i] + arr2[j];
                list.add(str);
            }
        }

        for(String s : list){
            if(isCorrect(s)){
                answer++;
            }
        }
        
        String str = "Monday 11";
        System.out.println(str.substring(7,9));
        System.out.println(answer);


	}
	public static boolean isCorrect(String p){
        int right = 0, left = 0;
        for(int i=0; i<p.length(); i++){
            if(p.charAt(i)=='(')    left++;
            else if(p.charAt(i)==')')   right++;
            
            if(right>left)  return false;
        }
        if(left!=right)	return false;
        return true;
    }

}
