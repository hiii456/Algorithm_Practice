## BOJ 16918 ๋ด๋ฒ๋งจ 
- Simulation 
- ๐ฅ Silver1 
- ๐[๋ด๋ฒ๋งจ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/16918)



## ํ์ด

ํฟ O์ด ๋๋ฌธ์o๊ฐ ์๋๋ผ 0์ธ์ค ์๊ณ  ๊ณ์ ํ๋ฆผ ใ

## ์์ค์ฝ๋
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16918_S5_๋ด๋ฒ๋งจ {
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
				// ์๋ฌด๊ฒ๋ ํ์ง ์๋๋ค 
				if(i==1)	continue;
				// N์ด 2์ธ๊ฒฝ์ฐ๋ ์์์ ๋ต์ ์ถ๋ ฅํ๋ฏ๋ก continue 
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

~~~

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
| 20892kb| 536ms|