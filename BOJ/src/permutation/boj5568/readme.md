## BOJ 5568 카드 놓기 
- Permutation, HashSet
- 🥈 Silver5
- 🔗[카드 놓기 문제 바로가기](https://www.acmicpc.net/problem/1068)



## 풀이

이 문제는 순열을 이용해서 구할 수 있는 조합의 숫자를 구하고,
중복처리를 위해 hashset을 사용하여 구할 수 있는 순열의 개수를 구해주었다.


## 소스코드
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5568_S5_카드_놓기 {
	static int n,k;
	static int[] src;
	static int[] tgt;
	static boolean[] selected;
	static HashSet<Integer> hs = new HashSet<>();
	public static void main(String[] args)throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		
		src = new int[n];
		selected = new boolean[n];
		tgt = new int[k];
		
		for(int i=0; i<n; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}
		
		perm(0);
		
		System.out.println(hs.size());
		

	}
	private static void perm(int tgtIdx) {
		if(tgtIdx == k) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<tgt.length; i++) {
				sb.append(tgt[i]);
			}
			int tmp = Integer.parseInt(sb.toString());
			hs.add(tmp);
			return;
		}
		
		for(int i=0; i<src.length; i++) {
			if(selected[i])	continue;
			
			tgt[tgtIdx] = src[i];
			selected[i] = true;
			perm(tgtIdx+1);
			selected[i] = false;
		}
		
	}

}

~~~

## 결과 

| 메모리  | 시간 |
|----|----|
| 12820kb| 116ms|
