package test_h;

public class test_1 {
	static int[] numbers = {-1,-2,1,2};
	static int[] tgt;
	static boolean[] selected;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<numbers.length; i++) {
			tgt = new int[i];
			selected = new boolean[numbers.length];
			comb(0,0,i);
		}
		
		System.out.println(answer);
		
	}
	private static void comb(int tgtIdx, int srcIdx,int len) {
		if(tgtIdx==len) {
			int sum1 = 0;
			for(int i=0; i<tgt.length; i++) {
				sum1 += tgt[i];
			}
			int sum2 = 0;
			for(int i=0; i<numbers.length; i++) {
				if(!selected[i]) {
					sum2 += numbers[i];
				}
			}
			answer = Math.min(Math.abs(sum2-sum1),answer);
			return;
		}
		
		for(int i=srcIdx; i<numbers.length; i++) {
			tgt[tgtIdx] = numbers[i];
			selected[i] = true;
			comb(tgtIdx+1,i+1,len);
			selected[i] = false;
		}
		
	}

}
