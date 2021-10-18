## BOJ 1405 미친로봇 
- BackTracking 
- 🥇 Gold5
- 🔗[미친로봇 문제 바로가기](https://www.acmicpc.net/problem/1405)



## 풀이

코딩테스트에서 자주나오는 유형인 백트래킹 + 완탐 유형을 뽀개기 위해 풀었다!
여기서 주의할점은 시작점 위치 -> N이 14보다 크면 안되므로 map 크기를 30으로 잡아주었다.
각 방향으로 이동할 확률 -> 처음에 두자릿수로 입력받으므로 /100 또는 * 0.01 을 해주어야한다.
탐색방향은 동서남북!



## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1405_G5_미친로봇 {
	// 동 서 남 북 
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	static double[] direction = new double[4];
	static boolean[][] visited = new boolean[30][30];
	static int N;
	static double answer;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<4; i++) {
			direction[i] = Double.parseDouble(st.nextToken()) / 100;
		}
		
		// 시작점은 (15,15)로 고정 
		visited[15][15] = true;
		
		backTracking(15,15,1.0,0);
		
		System.out.println(answer);
		
		
	}
	private static void backTracking(int r, int c, double result, int cnt) {
		if(cnt == N) {
			answer += result;
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nc<0 || nr>=30 || nc>=30)	continue;

			if(!visited[nr][nc] && direction[i]>0) {
				visited[nr][nc] = true;
				backTracking(nr,nc,result*direction[i],cnt+1);
				visited[nr][nc] = false;
			}

		}
		
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 12504kb| 136ms|