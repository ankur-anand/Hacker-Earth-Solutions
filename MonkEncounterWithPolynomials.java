package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ankur on 26/7/15.
 */
public class MonkEncounterWithPolynomials {

    public static void main(String...strings) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(reader.readLine().trim());
        StringBuffer output = new StringBuffer(testCase);
        while (testCase > 0){
            testCase--;
            String[] input = reader.readLine().trim().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int k = Integer.parseInt(input[3]);
            long result = getLowestX(a, b, c, k);
            output.append(result);
            output.append("\n");
        }
        System.out.println(output);
    }

    private static long getLowestX(int a, int b, int c, int k){
        long low = 0; long high = 100000;
        if (c >= k) return 0;
        long answer = -1;
        while (low <= high){
            long mid = low + (high - low) / 2;
            long leftSideExp = (a * (mid * mid)) + (b * mid) + c;
            if (leftSideExp >= k){
                answer = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }

        return answer;
    }
}
