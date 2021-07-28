package BOJ.FloydWarshall;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_2458_G4_키_순서 {
	static int N,M;
	static final int INF = 9999999;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] matrix = new int[N+1][N+1];
		
		// 배열의 모든 값을 INF로 채운다. 이것은 인접하지 않는 경우를 구분하기 위함이다.
		for (int[] arr : matrix) {
			Arrays.fill(arr, INF);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 서로 키를 비교할 수 있으면 1을 넣는다.
			matrix[a][b] = 1;
			
		}
		
		// 경유지 
		for(int k=1; k<=N; k++) {
			// 출발지 
			for(int i=1; i<=N; i++) {
				// 만약 경유지와 출발지가 같다면 continue
				if(k==i)	continue;
				// 도착지 
				for(int j=1; j<=N; j++) {
					// 도착지가 경유지나 출발지와 같다면 continue
					if(j==i || k==j)	continue;
					// 만약 경유지를 거쳐서 가는 것보다 가중치가 더 크다면 값을 갱신 
					if(matrix[i][j]>matrix[i][k] + matrix[k][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
					}
					
				}
				
			}
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			boolean isTrue = true;
			for(int j=1; j<=N; j++) {
				if(i==j)	continue;
				if(matrix[i][j]==INF && matrix[j][i]==INF) {
					isTrue = false;
					break;
				}
			}
			
			if(isTrue) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
		
		

	}

}
