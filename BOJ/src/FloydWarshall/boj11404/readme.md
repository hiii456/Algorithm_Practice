## BOJ 11404 νλ‘μ΄λ 
- FloydWarshall
- π₯ Gold 4

## νμ΄

νλ‘μ΄λ μμ¬ κΈ°λ³Έμ μΈ λ¬Έμ !! μ²μμλ νλ Έλ€κ³  λμλλ° μΈμ νλ ¬μ μ±μμ£Όλ κ°μ λλ¬΄ μ κ²ν΄μ κ°μ λ ν°κ°μΌλ‘ λ£μ΄μ€¬λλ μ λ΅μ΄λΌκ³  λμλ€. 100κ°μ λμκ° μκ³  100000κ°μ λ²μ€κ° μμ΄μ μ΄λ‘ μ μΌλ‘ μ΅λ 10000000 κΉμ§ κ°μ΄ μ‘΄μ¬νκΈ° λλ¬Έμ λ ν° μλ₯Ό λ£μ΄μ€μΌνλ€.


~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_11404_νλ‘μ΄λ {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		// λμμ κ°μ 
		int N = Integer.parseInt(br.readLine());
		// λ²μ€μ κ°μ 
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


|λ©λͺ¨λ¦¬ | μκ° |
|-----|-----|
|43836kb|704ms|