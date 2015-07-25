/* time 1.0955 sec */ 

package hackerEarth;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
 
class PalindromicNumber {
	
	private static final int BASE = 0xa;
	private static boolean[] arePalindrome = generatePalindrome();

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int totalTestCase = Integer.parseInt(reader.readLine());
		StringBuilder outputPalindromeCount = new StringBuilder();
		for (int i = 0; i < totalTestCase; i++) {
			String[] input = reader.readLine().split(" ");
			int startNo = Integer.parseInt(input[0]);
			int endNo = Integer.parseInt(input[1]);
			int totalFoundPalindrome = getPalindromeCount(startNo, endNo);
			outputPalindromeCount.append(totalFoundPalindrome + "\n");
		}
		System.out.println(outputPalindromeCount);

	}

	private static int getPalindromeCount(int startNo, int endNo) {
		int totalPalindrome = 0;
		for (int i = startNo; i <= endNo; i++) {
			if (arePalindrome[i]) {
				totalPalindrome++;
			}
		}
		return totalPalindrome;
	}

	private static boolean[] generatePalindrome() {
		boolean[] isPalindrome = new boolean[100001];
		Arrays.fill(isPalindrome, 0, 10, true);
		for (int i = 10; i <= 100000; i++) {

			isPalindrome[i] = isPalindrome(i);

		}
		return isPalindrome;
	}

	private static boolean isPalindrome(int digit) {

		if (digit % BASE == 0) {
			return digit == 0;
		}

		int reversedDigit = 0;
		while (digit > reversedDigit) {
			int currentDigit = digit % BASE;
			digit /= BASE;

			if (reversedDigit == digit) {
				return true;
			}

			reversedDigit = BASE * reversedDigit + currentDigit;
		}

		return reversedDigit == digit;

	}
}