package bfs.boj4963;

import java.io.*;
import java.util.*;

public class BOJ_4963_S2_섬의_개수 {
	static int w,h;
	static int[][] arr;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0)	break;
			
			arr = new int[h][w];
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println("======");
			
		}

	}

}
