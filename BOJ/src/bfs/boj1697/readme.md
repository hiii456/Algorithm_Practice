## BOJ - μ¨λ°κΌ­μ§ 
- Silver 1
- bfs
π[μ¨λ°κΌ­μ§ λ¬Έμ  λ°λ‘κ°κΈ°](https://www.acmicpc.net/problem/1697)



## νμ΄

μ΄ λ¬Έμ λ μμΌλ‘λ§ κ°λ κ²μ΄ μλ, μμΌλ‘ κ°λ€κ° λ€μ λ€λ‘λ μ΄λν  μ μκΈ° λλ¬Έμ λ°©λ¬Έμ²λ¦¬λ₯Ό ν΄μ£Όμ΄μΌ νλ€.
λ°λΌμ μ¨λ°κΌ­μ§μ ν  μ μλ λ²μμ ν¬κΈ°λ§νΌ int νμμ λ°°μ΄μ λ§λ€μ΄μ£Όμλ€.

κ·Έλ¦¬κ³  xμ λ²μμ λ°©λ¬Ένμ§ μμ κ³³μ bfs νμμ μ§νν΄μ£Όμλ€.

μ¬κΈ°μ λ§νλ μ μ, νμΌλ ν΅κ³Όνλλ° νλ Έμ΅λλ€ κ° λμ¨λ€λ μ μ΄μλ€.
μ΄ λΆλΆμ n,kκ° κ°μ κ°μ λ μμΈμ²λ¦¬λ₯Ό ν΄μ£Όμ§ μμ μκΈ΄ λ¬Έμ μλ€.

~~~java
        if(n==k){
            System.out.println(0);
        }else{
            bfs(n);
		    System.out.println(visited[k]);
        }
~~~


## μμ€μ½λ
~~~java
import java.io.*;
import java.util.*;

public class Main {
	static int n,k,ans;
	static int[] visited;
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// μ¨λ°κΌ­μ§μ ν  μ μλ λ²μλ 0~100000 
		visited = new int[100001];
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
        if(n==k){
            System.out.println(0);
        }else{
            bfs(n);
		    System.out.println(visited[k]);
        }
		

	}
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(cur);
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			
			// 0μ΄ μλκ²½μ° μ΅μκ°μ μ°Ύμκ²μ΄λ―λ‘ break 
			if(visited[k]!=0)	break;
			
			if(x-1>=0 && visited[x-1]==0) {
				queue.add(x-1);
				visited[x-1] = visited[x]+1;
			}
			
			if(x+1<=100000 && visited[x+1]==0) {
				queue.add(x+1);
				visited[x+1] = visited[x]+1;
			}
			
			if(x*2<100001 && visited[x*2]==0) {
				queue.add(x*2);
				visited[x*2] = visited[x]+1;
			}
		}
		
	}

}
~~~

## κ²°κ³Ό 

| λ©λͺ¨λ¦¬  | μκ° |
|----|----|
|16104KB	|112ms|