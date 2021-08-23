## BOJ 2003 수들의 합2 
- Two Pointers
- 🥈 Silver 3

## 풀이

이 문제는 Two Pointers를 이해할 수 있는 기본적인 문제이기 때문에 Two Pointers를 사용하여 문제를 풀었다. Two Pointers에서 중요한 것은 먼저 포인터 두개를 준비하고, 맨 처음에 0으로 설정해준다. 저는 처음에 s,e로 설정을 해놨는데 여기서 s<=e여야 한다.

그다음 s<N일 동안 만약 현재 부분합이 M 이상이거나 e=N이면 s++, 그렇지 않다면 e++, 현재 부분합 M과 같다면 result++를 해주어 결과를 구하였다.


~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2003_수_들의_합2 {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = 0;
		int e = 0;
		int result = 0;
		int sum = 0;
		
		while(true) {
			if(sum>=M) {
				sum -= arr[s++];
			}else if(e == N) {
				break;
			}else {
				sum += arr[e++];
			}
			
			if(sum==M) {
				result++;
			}
		}
		
		System.out.println(result);

	}

}
~~~



|메모리 | 시간 |
|-----|-----|
|14420kb|124ms|