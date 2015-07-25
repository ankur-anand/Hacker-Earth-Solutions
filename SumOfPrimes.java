package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by ankur on 20/7/15.
 */
public class SumOfPrimes {
    private static int MAX = 1000000;
    private static boolean[] isComposite = generatePrime();

    public static void main(String...strings) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noTestCase = Integer.parseInt(reader.readLine());
        StringBuffer result = new StringBuffer(noTestCase);
        for (int i = 0; i < noTestCase ; i++) {
            String[] inputArray = (reader.readLine()).trim().split(" ");
            int lower = Integer.parseInt(inputArray[0]);
            int higher = Integer.parseInt(inputArray[1]);
            boolean res = isSumPrime(lower, higher);
            if (res) {
                result.append("YES");
            } else {
                result.append("NO");
            }
        }

            System.out.println(result);
    }

    private static boolean isSumPrime(int lower, int higher) {
        int sum = 0;
        for(int i = lower; i <= higher; i++) {
            if( !isComposite[i]){
                sum += i;
            }

        }
        BigInteger n = new BigInteger(sum+"");

        if(n.isProbablePrime(sum))
            return true;
        else
            return  false;
    }

    private static boolean[] generatePrime(){
        boolean[] isComposite = new boolean[MAX + 1];
        isComposite[0] = true;
        isComposite[1] = true;
        for( int i = 2; i <= MAX; i++){
            if(!isComposite[i]){
                for(int j = i+i; j <= MAX; j += i){
                    isComposite[j] = true;
                }
            }
        }
        return isComposite;
    }
}
