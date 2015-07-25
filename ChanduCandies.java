package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChanduCandies {

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int Q = Integer.parseInt(reader.readLine());
		StringBuilder output = new StringBuilder(Q);
		while (Q != 0) {
			Q--;
			String[] tempInt = reader.readLine().split(" ");
			long N = Long.parseLong(tempInt[0]);
			int T = Integer.parseInt(tempInt[1]);
			long leftCandies = getLeftCandies(N, T);
			output.append(leftCandies);
			output.append("\n");
		}
		System.out.println(output);
	}

	private static long getLeftCandies(long n, int t) {
		if (n == 0 || t == 0)
			return n;
		for (int i = 0; i < t; i++) {
			n = (n & 1) == 1 ? ((n + 1) >> 1) : n >> 1;
			n >>= 2;
		}
		return n;
	}
}