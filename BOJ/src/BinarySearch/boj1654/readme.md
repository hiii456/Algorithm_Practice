## BOJ - 랜선 자르기 
- Silver 3 
- BinarySearch
🔗[랜선 자르기 문제 바로가기](https://www.acmicpc.net/problem/1654)



## 풀이

각 랜선의 길이를 배열에 담아 정렬을 먼저 시킨다.

~~~java
		int[] arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
~~~

이분탐색을 위해 초기 left값은 1, right값은 배열의 마지막 값으로 설정한다.

~~~java
		long left = 1;
		long right = arr[k-1];
~~~

mid값은 left,right을 더한값을 나누기 2한 값으로 설정해준다.
그리고 n개의 최대의 랜선 길이를 구하기 위해 배열에 저장된 랜선의 길이를 mid로 나눈 값(랜선길이가 mid일때 랜선의 갯수)와 n을 비교한다.
만약 n이 더 크다면 길이의 범위를 즐이고, n이 더 작다면 길이의 범위를 늘린다.
이분탐색은 left가 right보다 작거나 같을동안 실행되므로 값은 right에 저장된 값을 출력해준다.

~~~java
		while(left<=right) {
			long mid = (left + right)/2;
			int cnt = 0;
			for(int i=0; i<k; i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt<n) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1654_S3_랜선_자르기 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[k];
		for(int i=0; i<k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long left = 1;
		long right = arr[k-1];
		
		while(left<=right) {
			long mid = (left + right)/2;
			int cnt = 0;
			for(int i=0; i<k; i++) {
				cnt += arr[i]/mid;
			}
			
			if(cnt<n) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		System.out.println(right);

	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|15444KB	|160ms|