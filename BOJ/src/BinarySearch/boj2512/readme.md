## BOJ 2512 예산 
- BinarySearch
- 🥈 Silver 3

## 풀이

이 문제는 이분탐색을 이용하여 풀었다. 예산은 최솟값은 1, 최댓값은 지방의 예산요청 중 가장 높은 예산이므로 arr 배열을 정렬후, arr[N-1]로 두었다. 

그 다음 start과 end의 중간값 mid를 두어 arr의 값이 mid보다 작거나 같다면 arr값 그대로, mid보다 크면 mid값을 sum에 누적합 시켜주어 M과 비교하였다. 만일 sum이 M보다 작거나 같다면 mid는 더 커도 되므로 start의 값을 mid + 1으로 바꾸어주고, 만약 M보다 크다면 mid는 더 작은 범위에서 찾아야 하므로 end의 값을 mid - 1로 바꾸어준다. 그래서 구한 범위 중 최대값은 end에 저장되어 있으므로 end를 출력한다.


~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2512_예산 {
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		
		int start = 1;
		int end= arr[N-1];
		
		while(start<=end) {
			int mid = (start + end) / 2;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(arr[i]<=mid) {
					sum += arr[i];
				}else {
					sum += mid;
				}
			}
			
			if(sum<=M) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);

	}

}
~~~


|메모리 | 시간 |
|-----|-----|
|14052kb|128ms|