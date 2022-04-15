package 월간_코드_챌린지_시즌1.쿼드압축_후_개수_세기;

public class 쿼드압축_후_개수_세기 {
	static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        div(0,0,arr.length,arr);
        return answer;
    }
    public static void div(int startr,int startc,int size,int[][] arr){
        if(check(startr,startc,size,arr)){
            answer[arr[startr][startc]]++;
            return;
        }
        
        div(startr, startc, size/2, arr);
        div(startr + size/2 , startc , size/2, arr);
        div(startr, startc + size/2 , size/2, arr);
        div(startr + size/2,startc + size/2,size/2,arr);
        
    }
    public static boolean check(int r,int c,int size,int[][] arr){
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(arr[r][c] != arr[i][j])  return false;
            }
        }
        return true;
    }
}
