/**
 * This Solution is bacially generating Generate as many 
 * distinct primes P such that reverse (P) is also prime and is not equal to P.
 * */
import java.util.Arrays;
 
class TestClass {
    
    final static int MAX = 100000000;
    final static long MAXLISTSIZE = 1000000;
	final static int BASE = 10;
 
	final static boolean[] isPrime = generatePrime();
    
    public static void main(String args[] ) throws Exception {
       int listCount = 0;
    	int isPrimeLength = isPrime.length;
		StringBuilder outputResult = new StringBuilder();
		for (int i = 0; i < isPrimeLength; i++) {
			if (isPrime[i]) {
				long prime = (i << 1) + 3;
				long reverse = reversePrime(prime);
				int j = (int) ((reverse - 3) >> 1);
				if ((prime < reverse && isPrime[j])) {
					listCount++;
					outputResult.append(prime);
					outputResult.append("\n");
				}
				if ( listCount == MAXLISTSIZE) {
					break;
				}
			}
		}
		
		System.out.println(outputResult);
	}
 
	private static long reversePrime(long prime) {
		long result = 0;
		long rem = 0;
		if ( ((((String.valueOf(prime)).toCharArray())[0] ) & 1) == 0 ){
			return 0;
		}
		while (prime != 0) {
			long temp = prime / BASE;
			rem = prime - (BASE * temp);
			prime = temp;
			result = result * BASE + rem;
		}
		return result;
	}
 
	private static boolean[] generatePrime() {
		int root = (int) Math.sqrt(MAX) + 1;
		root = (root >> 1) - 1;
		int limit = (int) ((MAX - 1) >> 1);
		boolean[] isPrime = new boolean[limit];
		Arrays.fill(isPrime, true);
		for (int i = 0; i < root; i++) {
			if (isPrime[i]) {
				for (int j = ((i * (i + 3)) << 1) + 3, p = (i << 1) + 3; j < limit; j = j
						+ p) {
					isPrime[j] = false;
				}
			}
 
		}
		return isPrime;
	}
}
