## BOJ - 수 묶기 
- Gold 4 
- greedy 
🔗[수 묶기 문제 바로가기](https://www.acmicpc.net/problem/1744)



## 풀이

이 문제는 숫자가 1,양수,음수,0 일 경우를 나누어서 계산해주어야 한다.

#### 1인 경우 
해당 숫자가 1인경우 다른 숫자와 묶어서 곱하는 것보다 더하는것이 더욱 큰 수를 만들 수 있다. 따라서 1인 경우 list에 담지 않고 더해주었다.

~~~java
			if(num == 1) {
				ans += 1;
			}
~~~

#### 양수인 경우
양수인 경우 내림차순으로 정렬한 뒤 큰 두 숫자끼리 묶는 것이 유리하다. 따라서 양수만 담은(1을 제외한) 리스트를 내림차순 정렬한 뒤, 큰 수끼리 묶어서 곱해준다. 만약 양수의 갯수가 홀수인 경우 젤 작은 숫자는 묶일 수 없으므로 더해준다.

~~~java
		for(int i=0; i<list1.size(); i+=2) {
			if(i==list1.size()-1) {
				ans += list1.get(i);
			}else {
				ans += list1.get(i) * list1.get(i+1);
			}
			
		}
~~~

#### 음수인 경우 와 0 
음수인 경우에는 양수와 반대로 숫자가 클수록 더 작다. 따라서 리스트에 음수를 담은 뒤 오름차순 정렬을 해주어 젤 작은 두숫자를 곱한다. 음수의 갯수도 홀수개인 경우 나머지 하나는 묶을 수 없다. 이 경우에는 양수와 반대로 더하면 수를 더 작게 만드므로 0이 있다면 0과 곱하여 음수를 0으로 만들 수 있다. 따라서 0이 있는 경우에는 아무 값도 더하지 않고 (0과 곱하면 0이므로 더할필요가 없다) 0이 없으면 어쩔 수 없이 음수를 더해준다.

~~~java
		for(int i=0; i<list2.size(); i+=2) {
			if(i==list2.size()-1) {
				// 0이 존재하면 하나 남은 음수를 0으로 만들 수 있다.
				if(!isZero) {
					ans += list2.get(i);
				}
			}else {
				ans += list2.get(i) * list2.get(i+1);
			}
		}
~~~



## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1744_G4_수_묶기 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		boolean isZero = false;
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			// 1은 곱하는 것보다 더하는게 유리하므로 	list에 넣지 않는다.
			if(num == 1) {
				ans += 1;
			}else if(num>0) {
				list1.add(num);
			}else if(num<0) {
				list2.add(num);
			}else {
				isZero = true;
			}
		}
		
		Collections.sort(list1, Comparator.reverseOrder());
		Collections.sort(list2);

		for(int i=0; i<list1.size(); i+=2) {
			if(i==list1.size()-1) {
				ans += list1.get(i);
			}else {
				ans += list1.get(i) * list1.get(i+1);
			}
			
		}
		
		for(int i=0; i<list2.size(); i+=2) {
			if(i==list2.size()-1) {
				// 0이 존재하면 하나 남은 음수를 0으로 만들 수 있다.
				if(!isZero) {
					ans += list2.get(i);
				}
			}else {
				ans += list2.get(i) * list2.get(i+1);
			}
		}
		
		System.out.println(ans);
	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11556KB	|80ms|