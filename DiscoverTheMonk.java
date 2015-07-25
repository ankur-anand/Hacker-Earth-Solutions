package hackerEarth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ankur on 25/7/15.
 */
public class DiscoverTheMonk {

    public static void main(String...strings) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]);
        int Q = Integer.parseInt(input[1]);
        int[] A = new int[N];
        String[] nInput = reader.readLine().trim().split(" ");
        for (int i = 0; i < N; i++){

            A[i] = Integer.parseInt(nInput[i]);
        }
        StringBuffer output = new StringBuffer(Q);
        Arrays.sort(A);
        for (int j = 0; j < Q; j++){
            int searchQueryX = Integer.parseInt(reader.readLine().trim());
            boolean found = searchTheQuery(A, searchQueryX);
            if (found)
                output.append("YES");
            else
                output.append("NO");
            output.append("\n");
        }
        System.out.println(output);

    }

    private static boolean searchTheQuery(int[] A, int data){
        int len = A.length;
        int low = 0, high = len - 1;
        while (low <= high){
            int mid = low + ( high - low ) / 2;
            if (A[mid] == data)
                return true;
            else if (A[mid] < data)
                low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}
