package implement.boj7682;

import java.io.*;
import java.util.*;

public class BOJ_7682_G5_틱택토 {
	static char[][] arr;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("end"))	break;
			
			arr = new char[3][3];
			int xcnt = 0, ocnt = 0;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					arr[i][j] = str.charAt(3*i + j);
					if(arr[i][j] == 'X')	xcnt++;
					else if(arr[i][j] == 'O') ocnt++;					
				}
			}
			
			if(tictactoc(xcnt,ocnt)) {
				System.out.println("valid");
			}else {
				System.out.println("invalid");
			}
			
			
		}

	}

	public static boolean tictactoc(int xcnt, int ocnt) {
		// X부터 시작하므로 O의 갯수가 많으면 return false.
		if(xcnt<ocnt) {
			return false;
		}

		// 게임 판이 가득찬 경우, X가 이긴상태로 끝나거나 무승부로 끝나야 한다.
		if(xcnt+ocnt == 9 && xcnt == ocnt+1) {
			if(isWin('X') && !isWin('O')) {
				return true;
			}else if(!isWin('X') && !isWin('O')) {
				return true;
			}
		}
		// 게임 판이 가득 차지 않았을 때 
		else {
			// X가 이긴경우, X의 갯수가 O보다 1더 많아야 한다.
			if(xcnt+ocnt < 9 && xcnt == ocnt+1) {
				if(isWin('X') && !isWin('O')) {
					return true;
				}
			}
			// O가 이긴경우, X의 갯수와 O의 갯수가 동일해야 한다. 
			else if(xcnt+ocnt < 9 && xcnt == ocnt){
				if(isWin('O') && !isWin('X')) {
					return true;
				}
			}
			
		}
		return false;
	}

	private static boolean isWin(char c) {
		// 가로로 3칸을 잇는데 성공한 경우 
		for(int i=0; i<3; i++) {
			if(arr[i][0] == c && arr[i][1]  == c && arr[i][2] == c)	return true;
		}
		// 세로로 3칸을 잇는데 성공한 경우 
		for(int i=0; i<3; i++) {
			if(arr[0][i] == c && arr[1][i] == c && arr[2][i] == c)	return true;
		}
		// 대각선으로 3칸을 잇는데 성공한 경우 
		if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c)	return true;	
		if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c)	return true;	

		return false;
	}

}
