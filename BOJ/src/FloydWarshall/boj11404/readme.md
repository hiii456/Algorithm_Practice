## BOJ 11404 플로이드 
- FloydWarshall
- 🥇 Gold 4

## 풀이

플로이드 워샬 기본적인 문제!! 처음에는 틀렸다고 나왔는데 인접행렬에 채워주는 값을 너무 적게해서 값을 더 큰값으로 넣어줬더니 정답이라고 나왔다. 100개의 도시가 있고 100000개의 버스가 있어서 이론적으로 최대 10000000 까지 값이 존재하기 때문에 더 큰 수를 넣어줘야했다.


~~~java
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

~~~


|메모리 | 시간 |
|-----|-----|
|43836kb|704ms|