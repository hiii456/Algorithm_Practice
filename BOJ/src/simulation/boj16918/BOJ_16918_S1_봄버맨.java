package simulation.boj16918;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16918_S1_봄버맨 {
	static int R,C,N;
	static char[][] arr;
	static boolean[][] check;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];

		
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			for(int c=0; c<C; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		if(N%2==0) {
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					arr[r][c] = 'O';
				}
			}
		}else {
			for(int i=1; i<=N; i++) {
				boolean bomb = false;
				// 아무것도 하지 않는다 
				if(i==1)	continue;
				// N이 2인경우는 위에서 답을 출력하므로 continue 
				if(i%2==0)	continue;

				bomb();
				
				for(int r=0; r<R; r++) {
					for(int c=0; c<C; c++) {
						if(!check[r][c]) {
							arr[r][c] = 'O';
						}else {
							arr[r][c] = '.';
						}
					}
				}
				
			}
		}

		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(arr[r][c]);
			}
			System.out.println();
		}
		

	}
	private static void bomb() {
		
		check = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 'O') {
					check[i][j] = true;
					
					for(int d=0; d<4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if(nr>=0 && nc>=0 && nr<R && nc<C) {
							check[nr][nc] = true;
						}
					}
				}
			}
		}
		
		
	}

}
