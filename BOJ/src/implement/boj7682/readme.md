## BOJ - ν±νν  
- Gold 5
- Implement
π[ν±νν  λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/7682)



## νμ΄

μ΄ λ¬Έμ λ κ΅¬νλ¬Έμ λ‘, 3*3 λ°°μ΄μ κ° μλ ₯ λ¬Έμμ΄μ λ£μ΄μ£Όκ³  
ν±νν κ° μ ν¨νμ§μ x λλ o μ€μ λκ° μ΄κΈ°λμ§ νλ³νλ λ‘μ§μ μΆκ°ν΄ λ΅μ κ΅¬νμλ€.


## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class BOJ_7682_G5_ν±νν  {
	static char[][] arr;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			
			if(str.equals("end"))	break;
			
			arr = new char[3][3];
			int xcnt = 0, ocnt = 0;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					arr[i][j] = str.charAt(3*i + j);
					if(arr[i][j] == 'X')	xcnt++;
					else if(arr[i][j] == 'O') ocnt++;					
				}
			}
			
			if(tictactoc(xcnt,ocnt)) {
				System.out.println("valid");
			}else {
				System.out.println("invalid");
			}
			
			
		}

	}

	public static boolean tictactoc(int xcnt, int ocnt) {
		// XλΆν° μμνλ―λ‘ Oμ κ°―μκ° λ§μΌλ©΄ return false.
		if(xcnt<ocnt) {
			return false;
		}

		// κ²μ νμ΄ κ°λμ°¬ κ²½μ°, Xκ° μ΄κΈ΄μνλ‘ λλκ±°λ λ¬΄μΉλΆλ‘ λλμΌ νλ€.
		if(xcnt+ocnt == 9 && xcnt == ocnt+1) {
			if(isWin('X') && !isWin('O')) {
				return true;
			}else if(!isWin('X') && !isWin('O')) {
				return true;
			}
		}
		// κ²μ νμ΄ κ°λ μ°¨μ§ μμμ λ 
		else {
			// Xκ° μ΄κΈ΄κ²½μ°, Xμ κ°―μκ° Oλ³΄λ€ 1λ λ§μμΌ νλ€.
			if(xcnt+ocnt < 9 && xcnt == ocnt+1) {
				if(isWin('X') && !isWin('O')) {
					return true;
				}
			}
			// Oκ° μ΄κΈ΄κ²½μ°, Xμ κ°―μμ Oμ κ°―μκ° λμΌν΄μΌ νλ€. 
			else if(xcnt+ocnt < 9 && xcnt == ocnt){
				if(isWin('O') && !isWin('X')) {
					return true;
				}
			}
			
		}
		return false;
	}

	private static boolean isWin(char c) {
		// κ°λ‘λ‘ 3μΉΈμ μλλ° μ±κ³΅ν κ²½μ° 
		for(int i=0; i<3; i++) {
			if(arr[i][0] == c && arr[i][1]  == c && arr[i][2] == c)	return true;
		}
		// μΈλ‘λ‘ 3μΉΈμ μλλ° μ±κ³΅ν κ²½μ° 
		for(int i=0; i<3; i++) {
			if(arr[0][i] == c && arr[1][i] == c && arr[2][i] == c)	return true;
		}
		// λκ°μ μΌλ‘ 3μΉΈμ μλλ° μ±κ³΅ν κ²½μ° 
		if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c)	return true;	
		if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c)	return true;	

		return false;
	}

}
~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|11324KB	|80ms|