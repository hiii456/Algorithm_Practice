package simulation.boj2116;

import java.io.*;
import java.util.*;

public class BOJ_2116_G4_주사위_쌓기 {
	static int[][] dice;
	static int n,ans,max = Integer.MIN_VALUE;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dice = new int[n][6];
		
		/*
		 * 서로 마주보는 면은 A-F, B-D, C-E 
		 * 따라서 i번째 면이 (i+3)%6 번째 면에 대응할 수 있도록 깂을 배열에 저장 
		 * 나누기 6을 하는 이유는 주사위를 0~i	번째까지 굴려볼때 D, E, F에도 대응하기 위함 
		 */
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
			dice[i][2] = Integer.parseInt(st.nextToken());
			dice[i][4] = Integer.parseInt(st.nextToken());
			dice[i][5] = Integer.parseInt(st.nextToken());
			dice[i][3] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<6; i++) {
			int top = dice[0][i];
			int bottom = dice[0][(i+3)%6];
			ans = getMax(top,bottom);
			for(int j=1; j<n; j++) {
				for(int k=0; k<6; k++) {
					if(top==dice[j][k]) {
						bottom = dice[j][k];
						top = dice[j][(k+3)%6];
						ans += getMax(top,bottom);
						// 윗면과 아랫면을 찾았으면 더 이상 탐색하지 않아도 됨.
						break;
					}
				}
			}
			max = Math.max(max, ans);	
		}
		
		System.out.println(max);
		
	}
	private static int getMax(int top, int bottom) {
		if((top==6 && bottom ==5 )|| (top == 5 && bottom == 6))
			return 4;
		else if(top<6 && bottom < 6)
			return 6;
		else if(top ==6 || bottom == 6)
			return 5;
		return 0;
	}

}
