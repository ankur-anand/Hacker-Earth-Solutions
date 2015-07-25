package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ankur on 20/7/15.
 */
public class StringAndPrimes {

    private static boolean[] isComposite = generatePrime();

    public static void main(String...strings) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noTestCase = Integer.parseInt(reader.readLine());
        StringBuffer result = new StringBuffer(noTestCase);
        for (int i = 0; i < noTestCase ; i++){
            char[] inputArray = (reader.readLine()).trim().toCharArray();
            String res = removePrimeChar(inputArray);
            result.append(res);
            result.append("\n");
        }
        System.out.println(result);
    }

    private static String removePrimeChar(char[] inputChar){
        int len = inputChar.length;
        StringBuffer result = new StringBuffer(len);
        for (int i = 0; i < len; i++){
            char temp = inputChar[i];
            if (isComposite[(int)temp])
                result.append(temp);
        }
        if (result.length() == 0) return "NULL";
        return result.toString();
    }

    private static boolean[] generatePrime(){
        int root = 12;
        int limit = 123;
        boolean[] isComposite = new boolean[limit+1];
        for( int i = 2 ;i <= root; i++){
            if(!isComposite[i]){
                for(int j = i+i; j <= limit; j += i){
                    isComposite[j] = true;
                }
            }
        }
        return isComposite;
    }
}
