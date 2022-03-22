package simulation.boj2980;

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
