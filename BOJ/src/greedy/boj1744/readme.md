## BOJ - μ λ¬ΆκΈ° 
- Gold 4 
- greedy 
π[μ λ¬ΆκΈ° λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/1744)



## νμ΄

μ΄ λ¬Έμ λ μ«μκ° 1,μμ,μμ,0 μΌ κ²½μ°λ₯Ό λλμ΄μ κ³μ°ν΄μ£Όμ΄μΌ νλ€.

#### 1μΈ κ²½μ° 
ν΄λΉ μ«μκ° 1μΈκ²½μ° λ€λ₯Έ μ«μμ λ¬Άμ΄μ κ³±νλ κ²λ³΄λ€ λνλκ²μ΄ λμ± ν° μλ₯Ό λ§λ€ μ μλ€. λ°λΌμ 1μΈ κ²½μ° listμ λ΄μ§ μκ³  λν΄μ£Όμλ€.

~~~java
			if(num == 1) {
				ans += 1;
			}
~~~

#### μμμΈ κ²½μ°
μμμΈ κ²½μ° λ΄λ¦Όμ°¨μμΌλ‘ μ λ ¬ν λ€ ν° λ μ«μλΌλ¦¬ λ¬Άλ κ²μ΄ μ λ¦¬νλ€. λ°λΌμ μμλ§ λ΄μ(1μ μ μΈν) λ¦¬μ€νΈλ₯Ό λ΄λ¦Όμ°¨μ μ λ ¬ν λ€, ν° μλΌλ¦¬ λ¬Άμ΄μ κ³±ν΄μ€λ€. λ§μ½ μμμ κ°―μκ° νμμΈ κ²½μ° μ € μμ μ«μλ λ¬ΆμΌ μ μμΌλ―λ‘ λν΄μ€λ€.

~~~java
		for(int i=0; i<list1.size(); i+=2) {
			if(i==list1.size()-1) {
				ans += list1.get(i);
			}else {
				ans += list1.get(i) * list1.get(i+1);
			}
			
		}
~~~

#### μμμΈ κ²½μ° μ 0 
μμμΈ κ²½μ°μλ μμμ λ°λλ‘ μ«μκ° ν΄μλ‘ λ μλ€. λ°λΌμ λ¦¬μ€νΈμ μμλ₯Ό λ΄μ λ€ μ€λ¦μ°¨μ μ λ ¬μ ν΄μ£Όμ΄ μ € μμ λμ«μλ₯Ό κ³±νλ€. μμμ κ°―μλ νμκ°μΈ κ²½μ° λλ¨Έμ§ νλλ λ¬Άμ μ μλ€. μ΄ κ²½μ°μλ μμμ λ°λλ‘ λνλ©΄ μλ₯Ό λ μκ² λ§λλ―λ‘ 0μ΄ μλ€λ©΄ 0κ³Ό κ³±νμ¬ μμλ₯Ό 0μΌλ‘ λ§λ€ μ μλ€. λ°λΌμ 0μ΄ μλ κ²½μ°μλ μλ¬΄ κ°λ λνμ§ μκ³  (0κ³Ό κ³±νλ©΄ 0μ΄λ―λ‘ λν νμκ° μλ€) 0μ΄ μμΌλ©΄ μ΄μ© μ μμ΄ μμλ₯Ό λν΄μ€λ€.

~~~java
		for(int i=0; i<list2.size(); i+=2) {
			if(i==list2.size()-1) {
				// 0μ΄ μ‘΄μ¬νλ©΄ νλ λ¨μ μμλ₯Ό 0μΌλ‘ λ§λ€ μ μλ€.
				if(!isZero) {
					ans += list2.get(i);
				}
			}else {
				ans += list2.get(i) * list2.get(i+1);
			}
		}
~~~



## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class BOJ_1744_G4_μ_λ¬ΆκΈ° {

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
			// 1μ κ³±νλ κ²λ³΄λ€ λνλκ² μ λ¦¬νλ―λ‘ 	listμ λ£μ§ μλλ€.
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
				// 0μ΄ μ‘΄μ¬νλ©΄ νλ λ¨μ μμλ₯Ό 0μΌλ‘ λ§λ€ μ μλ€.
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

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|11556KB	|80ms|