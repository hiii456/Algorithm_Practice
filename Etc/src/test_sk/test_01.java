package test_sk;

import java.util.*;

public class test_01 {
	// 생산 단가 
	static int[] costs = {2, 11, 20, 100, 200, 600};
	static int money = 1999;
	static int[] unit = {1,5,10,50,100,500};
	// 기존에 compareTo 메소드에서 double형 변수를 직접 계산하여 오름차순 정렬을 해주었는데 제대로 정렬이 되지 않았다.
	// 따라서 CoinInfo 객체에 double 타입을 가지는 1원당 생산비용을 추가해주었다.
	static class CoinInfo implements Comparable<CoinInfo>{
		int price;
		int unitPrice;
		double perPrice;
		public CoinInfo(int price,int unitPrice,double perPrice) {
			this.price = price;
			this.unitPrice = unitPrice;
			this.perPrice = perPrice;
		}
		@Override
		public int compareTo(CoinInfo o) {
			if(this.perPrice > o.perPrice){
				return 1;
			}
			return -1;
		}
	}
	public static void main(String[] args) {
		List<CoinInfo> list = new ArrayList<>();
		
		for(int i=0; i<6; i++) {
			list.add(new CoinInfo(costs[i],unit[i],(double)costs[i]/unit[i]));
		}
		// 1인당 생산비용이 적은 순서대로 정렬 
		Collections.sort(list);
		
		int ans = 0;
		// 1원당 생산비용이 적은 순대로 최대 가질 수 있는 숫자를 구한다.
		// 이를 위해 현재 money에 단위를 나누면 최대로 가질 수 있는 동전의 수를 구할 수 있다.
		for(int i=0; i<6; i++) {
			int price = list.get(i).unitPrice;
			int unit = money / price;
			money -= price*unit;
			ans += unit*list.get(i).price;
			// money가 0dl 되었을 경우 탐색을 더 안해봐도 된다.
			if(money==0)break;
			
		}
		
		System.out.println(ans);

	}

}
