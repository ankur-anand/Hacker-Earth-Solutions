/* Time (sec)
2.093 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int noOfTestCaseT = Integer.parseInt(reader.readLine().trim());
		StringBuilder output = new StringBuilder(noOfTestCaseT);
 
		while (noOfTestCaseT != 0) {
			noOfTestCaseT--;
 
			String[] tempInt = reader.readLine().split(" ");
			long p = Long.parseLong(tempInt[0].trim());
			long q = Long.parseLong(tempInt[1].trim());
			boolean isCoprime = isCoprime(p, q);
			if (isCoprime)
				output.append("Is a Co-Prime");
			else
				output.append("Not a Co-Prime");
			output.append("\n");
 
		}
 
		System.out.println(output);
 
	}
 
	private static boolean isCoprime(long u, long v) {
		if (((u | v) & 1) == 0)
			return false;
 
		while ((u & 1) == 0)
			u >>= 1;
		if (u == 1)
			return true;
 
		do {
			while ((v & 1) == 0)
				v >>= 1;
			if (v == 1)
				return true;
 
			if (u > v) {
				long t = v;
				v = u;
				u = t;
			}
			v -= u;
		} while (v != 0);
 
		return false;
	}
 
}