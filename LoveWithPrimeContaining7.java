package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankur on 21/7/15.
 */
public class LoveWithPrimeContaining7 {

    private static boolean[] primeWithSeven = generatePrime();
    public static void main(String...strings) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int noTestCase = Integer.parseInt(reader.readLine());
        StringBuffer result = new StringBuffer(noTestCase);
        for (int i = 0; i < noTestCase ; i++){
            String[] inputArray = (reader.readLine()).trim().split(" ");
            int lower = Integer.parseInt(inputArray[0]);
            int higher = Integer.parseInt(inputArray[1]);
            int res = getPrimeWithSevenCount(lower, higher);
            if (res != 0)
                result.append(res);
            else
                result.append(-1);
            result.append("\n");
        }
        System.out.println(result);
    }

    private static int getPrimeWithSevenCount(int lower, int higher){
        int count = 0;
        if (higher < 7 ) return 0;
        else if (higher == 7) return 1;
        for (int i = lower; i <= higher; i++){
            if(!primeWithSeven[i]){
               count++;
            }
        }
        return count;
    }

    private static boolean[] generatePrime(){
        int MAX = 1000000;
        boolean[] isComposite = new boolean[MAX + 1];
        isComposite[0] = true;
        isComposite[1] = true;
        for (int i = 2; i <= MAX; i++){
            if(!isComposite[i]){
                if(!isContainingSeven(i)){
                    isComposite[i] = true;
                }
                for (int j = i+i; j <= MAX; j += i){
                    isComposite[j] = true;
                }
            }
        }

        return  isComposite;
    }

    private static boolean isContainingSeven(int prime){
        if (prime < 7){
            return false;
        }
        else if (prime == 7) return true;
        while(prime != 0){
            if(prime % 10 == 7){
                return true;
            }
            prime /= 10;
        }
        return false;
    }
}
