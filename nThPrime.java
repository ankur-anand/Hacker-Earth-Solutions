package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ankur on 19/7/15.
 */
public class nThPrime {

    //private static boolean[] isPrime = generatePrime();
    private static int[] nthPrime = generatePrime();;

    public static void main(String...strings) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noTestCase = Integer.parseInt(reader.readLine());
        StringBuffer result = new StringBuffer(noTestCase);
        for (int i = 0; i < noTestCase ; i++){
            int nThPrime = Integer.parseInt(reader.readLine());
            int res = nthPrime[nThPrime];
            result.append(res);
            result.append("\n");
        }
        System.out.println(result);
    }

    private static int[] generatePrime(){

        int limit = 1000000;

        int[] primeAre = new int[664581];
        boolean[] isComposite = new boolean[limit+1];
        for( int i = 2, index = 1; i <= limit; i++){
            if(!isComposite[i]){
                primeAre[index++] = i;
                for(int j = i+i; j <= limit; j += i){
                    isComposite[j] = true;
                }
            }
        }
        return primeAre;
    }
}
