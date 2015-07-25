package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KaranAndPrime {
	private  static final int MAX=1000000;
	private static final boolean[] isPrime=sievedPrime();
    public static void main(String args[] ) throws Exception {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(reader.readLine());
		for(int i = 0; i < T ; i++){
			String[] tempInt=reader.readLine().split(" ");
			int n=Integer.parseInt(tempInt[0]);
			int m=Integer.parseInt(tempInt[1]);
			int primeSum=primeSumInRange(n,m);
			System.out.println(primeSum);
			
		}
		
	}

	private static int primeSumInRange(int n, int m) {
		int sum;
		if(n>0 && n<=2){
			sum=2;
			n=n+2;
		}else
			sum=0;
		for( int i = (n-3)/2; i <= (m-3)/2 ; i++){
			if(isPrime[i]){
				sum=sum+2*i+3;
			}
		}
		return sum;
	}
	
	private static boolean[] sievedPrime(){
		int root=(int) Math.sqrt(MAX)+1;
		int limit=(MAX-1)/2;
		boolean[] isPrime=new boolean[limit];
		Arrays.fill(isPrime, true);
		root = root/2 -1;
		for(int i = 0; i < root ; i++){
			if(isPrime[i]){
				for( int j = 2*i*(i+3)+3 , p = 2*i+3; j < limit ; j=j+p ){
					isPrime[j]=false;
				}
			}
		}
		
		return isPrime;
		//http://ideone.com/igwgF2
	}
	

}


