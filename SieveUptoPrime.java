package hackerEarth;

import java.util.BitSet;
import java.util.List;

public class SieveUptoPrime {

	final static int MAX=100;
	final static List<Boolean> primeList=primeList();
	
	public static void main(String[] args) {
		int lower=20,higher=100;
		getPrimeList(lower, higher);

	}
	
	private static void getPrimeList(int lower, int higher) {
		for(int i=lower;i<=higher;i++){
			if(primeList.get(i)){
				System.out.println(i);
			}
		}
		
	}
	
	private static List<Boolean> primeList() {
		int size=(MAX-1);
		int root=(int) Math.sqrt(size);
		BitSet isPrime=new BitSet(size);
		int lenGth=isPrime.size();
		isPrime.set(0, lenGth, true);
		int p=3;
		
		
		for(int i=0;i<size;i++){
			System.out.println(isPrime.get(i));
			if(isPrime.get(i))
			System.out.println(i);
		}
		return null;
	}

}
