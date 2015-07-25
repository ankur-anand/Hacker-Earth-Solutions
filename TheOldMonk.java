package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ankur on 26/7/15.
 */
public class TheOldMonk {
    public static void main(String...strings) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine().trim());
        StringBuffer output = new StringBuffer(testCase);
        while (testCase > 0){
            int arraySize = Integer.parseInt(reader.readLine().trim());
            long[] inputArrayA = new long[arraySize];
            long[] inputArrayB = new long[arraySize];
            testCase--;
            String[] inputA = reader.readLine().trim().split(" ");
            String[] inputB = reader.readLine().trim().split(" ");
            for (int i = 0; i < arraySize; i++){
                inputArrayA[i] = Long.parseLong(inputA[i]);
                inputArrayB[i] = Long.parseLong(inputB[i]);
            }
            int result = getMonkiness(inputArrayA, inputArrayB, arraySize);
            output.append(result);
            output.append("\n");
        }
        System.out.println(output);
    }

    private static int getMonkiness(long[] arrayA, long[] arrayB, int size){

        int position = 0;
        int max = 0;
        for (int i = 0; i < size; i++){
            int low = 0, high = size - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arrayB[mid] >= arrayA[i]) {
                    position = mid;
                    low = mid + 1;
                }
                else
                    high = mid - 1;


            }
            if (max < position - i)
                max = position - i;
        }
        return max;
    }
}
