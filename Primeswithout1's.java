/* Important Note : This java solution takes around 2 sec which is not acceptable so same algorithm when coded in c language gets accepted

for this question java is really handicapped on hackers earth */

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
 
class TestClass {
	
	final static int BASE = 10;
    static boolean[] isPrime;
 
    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                    System.in));
        int noOfTestCaseT = Integer.parseInt(reader.readLine().trim());
        StringBuilder output = new StringBuilder(noOfTestCaseT);
        int [][] testCases = new int[noOfTestCaseT][2];
        int maxNum = 0;
 
        for (int i=0;i<noOfTestCaseT;i++) {
            String[] tempInt = reader.readLine().split(" ");
            testCases[i][0] = Integer.parseInt(tempInt[0].trim());
            testCases[i][1] = Integer.parseInt(tempInt[1].trim());
            if (testCases[i][1] > maxNum)
                maxNum = testCases[i][1];
        }
 
        isPrime = generatePrime(maxNum+1);
 
        int [] cumulativeCount = new int[maxNum+1];
        int count = 1;
        cumulativeCount[2] = 1;
        for (int i=3;i<=maxNum;i++) {
            if (((i&1) == 1) && isPrime[i] && !isDigitOnePresent(i))
                count++;
            cumulativeCount[i] = count;
        }
 
        for (int i=0;i<noOfTestCaseT;i++) {
            int n = testCases[i][0];
            int m = testCases[i][1];
            if (n > 0)
                n--;
            int primesWithoutOnes = cumulativeCount[m] - cumulativeCount[n];
            if (primesWithoutOnes == 0) {
                output.append("-1\n");
            } else {
                output.append(primesWithoutOnes);
                output.append("\n");
            }
        }
        System.out.print(output);
    }
 
    private static boolean isDigitOnePresent(int i) {
        while(i !=0 ){
            int temp = i % BASE;
            if( temp == 1)
                return true;
            i /= BASE;
        }
        return false;
    }
 
    private static boolean[] generatePrime(int maxNum) {
        int root = (int) Math.sqrt(maxNum)+1;
        boolean[] isPrime = new boolean[maxNum];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        for (int i = 3; i < root; i+=2) {
            if (isPrime[i]) {
                int increment = i+i;
                for (int j = i * i ; j < maxNum; j = j + increment) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}