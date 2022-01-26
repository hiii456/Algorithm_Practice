package 카카오_2022.k진수에서_소수_개수_구하기;

public class k진수에서_소수_개수_구하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 110011;
		int k= 10;
		int answer = 0;
        String prime = "";
        
        while(n>0){
            prime = (n%k) + prime;
            n/=k;
        }
        
        int i,j;
        for(i=0; i<prime.length(); i=j+1){
            for(j=i; j<prime.length(); j++){
                if(prime.charAt(j)=='0' && i!=j){
                    String str = prime.substring(i,j);
                    if(isPrime(Long.parseLong(str))){
                        answer++;
                    }
                    break;
                }
                if(j==prime.length()-1) {
                	String str = prime.substring(i,prime.length());
                    if(isPrime(Long.parseLong(str))){
                        answer++;
                    }
                }
            }
            
        }
        
        System.out.println(answer);

	}
	// 에라토스체네스의 체를 이용하여 소수 판별 
    public static boolean isPrime(long num){
        if(num<=1){
            return false;
        }

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i ==0) return false;
        }
        
        return true;
    }

}
