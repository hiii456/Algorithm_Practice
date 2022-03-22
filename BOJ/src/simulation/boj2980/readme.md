## BOJ - 도로와 신호등 
- Silver 4 
- simulation 
🔗[도로와 신호등 문제 바로가기](https://www.acmicpc.net/problem/2980)



## 풀이

신호등의 위치, 빨간불 시간, 초록불 시간을 담은 Light 클래스를 만든다.
이를 신호등의 개수 크기인 배열에 차례대로 담는다.

~~~java
	static class Light{
		int pos;
		int red;
		int green;
		public Light(int pos,int red,int green) {
			this.pos = pos;
			this.red = red;
			this.green = green;
		}
	}
~~~

~~~java
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			lights[i] = new Light(d,r,g);
		}
~~~

그리고 신호등 개수만큼 반복문을 돌린다. 
이때 처음 신호등일 경우 이전에 온 거리가 없으므로 현재 시간에 바로 첫 신호등의 위치를 더한다.
만약 첫 신호등이 아니라면 현재 신호등 위치에서 이전 신호등 위치를 뺀만큼(이동거리)를 현재시간에 더한다.

~~~java
			if(i==0) {
				time += lights[i].pos;
			}else {
				time += (lights[i].pos - lights[i-1].pos);
			}
~~~

그 다음, 현재 신호등의 주기를 구한다. 빨간불이 들어오는 시간 + 초록불이 들어오는 시간이 총 신호등이 켜지는 시간이라면, 
현재 시간 % 총 신호등이 켜지는 시간을 나누어 빨간불이 들어오는 시간보다 작다면 현재 빨간불이고, 같거나 크다면 초록불임을 알 수 있다.

~~~java
			if(time%cycle < lights[i].red) {
				time += (lights[i].red - (time%cycle));
			}else {
				continue;
			}
~~~


## 소스코드
~~~java
import java.io.*;
import java.util.*;

public class BOJ_2980_S4_도로와_신호등 {
	static class Light{
		int pos;
		int red;
		int green;
		public Light(int pos,int red,int green) {
			this.pos = pos;
			this.red = red;
			this.green = green;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Light[] lights = new Light[n+1];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			lights[i] = new Light(d,r,g);
		}
		
		int time = 0;
		for(int i=0; i<n; i++) {
			if(i==0) {
				time += lights[i].pos;
			}else {
				time += (lights[i].pos - lights[i-1].pos);
			}
			
			int cycle = lights[i].red + lights[i].green;
			
			if(time%cycle < lights[i].red) {
				time += (lights[i].red - (time%cycle));
			}else {
				continue;
			}
		}
		time += (l-lights[n-1].pos);
		
		System.out.println(time);

	}

}
~~~

## 결과 

| 메모리  | 시간 |
|----|----|
|11576KB	|80ms|