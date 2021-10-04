package comparable.boj10814;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10814_S5_나이순_정렬 {
	static List<Info> list = new ArrayList<>();
	static class Info {
		int age;
		String name;
		public Info(int age,String name) {
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			list.add(new Info(age,name));
		}
		
		Collections.sort(list, new Comparator<Info>() {
			@Override
			public int compare(Info o1, Info o2) {
				// TODO Auto-generated method stub
				return o1.age - o2.age;
			}			
		});
		
		for(int i=0; i<N; i++) {
			sb.append(list.get(i).age + " " + list.get(i).name + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
