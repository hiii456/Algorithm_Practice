package FloydWarshall.boj11404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_11404_플로이드 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		// 도시의 개수 
		int N = Integer.parseInt(br.readLine());
		// 버스의 개수 
		int M = Integer.parseInt(br.readLine());
		
		int[][] adjMatrix = new int[N+1][N+1];
		
		for (int[] arr : adjMatrix) {
			Arrays.fill(arr, 100001);
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(adjMatrix[a][b]>c) {
				adjMatrix[a][b] = c;
			}
			
		}
		
		
		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				if(i==k)	continue;
				for(int j=1; j<N+1; j++) {
					if(i==j || j==k)	continue;
					if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
					}
				}
			}
		}
		
		
		for(int i=1; i<N+1; i++) {
			for(int j=1; j<N+1; j++) {
				if(adjMatrix[i][j]==100001) {
					System.out.print("0 ");
				}else {
					System.out.print(adjMatrix[i][j] + " ");
				}
			}
			System.out.println();
		}


	}

}
