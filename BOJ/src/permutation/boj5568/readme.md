## BOJ 5568 ์นด๋ ๋๊ธฐ 
- Permutation, HashSet
- ๐ฅ Silver5
- ๐[์นด๋ ๋๊ธฐ ๋ฌธ์  ๋ฐ๋ก๊ฐ๊ธฐ](https://www.acmicpc.net/problem/1068)



## ํ์ด

์ด ๋ฌธ์ ๋ ์์ด์ ์ด์ฉํด์ ๊ตฌํ  ์ ์๋ ์กฐํฉ์ ์ซ์๋ฅผ ๊ตฌํ๊ณ ,
์ค๋ณต์ฒ๋ฆฌ๋ฅผ ์ํด hashset์ ์ฌ์ฉํ์ฌ ๊ตฌํ  ์ ์๋ ์์ด์ ๊ฐ์๋ฅผ ๊ตฌํด์ฃผ์๋ค.


## ์์ค์ฝ๋
~~~java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5568_S5_์นด๋_๋๊ธฐ {
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

## ๊ฒฐ๊ณผ 

| ๋ฉ๋ชจ๋ฆฌ  | ์๊ฐ |
|----|----|
| 12820kb| 116ms|
