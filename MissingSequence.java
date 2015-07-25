package hackerEarth;

public class MissingSequence {

	public static void main(String... strings) {
		String seq = "2426";
		String seq1 = "999899991000110002";
		// this fuction gets the digits length of the sequence
		int digit = getFirstDigitLength(seq1);
		System.out.println(digit);
	}

	private static int getFirstDigitLength(String seq) {
		int seqLength = seq.length();
		//System.out.println(seqLength);
		for (int i = 1; i <= 5; i++) {
			int failureCount = 0;
			int successCount = 0;
			int nextExpectedDigit = 0;
			for (int j = 0; j < seqLength; j += i) {
				int digit = Integer.parseInt(seq.substring(j, i + j));
				nextExpectedDigit = digit + 1;
				int nDL = String.valueOf(nextExpectedDigit).length();
				int nextDigit = Integer.parseInt(seq.substring(j + i, i + j
						+ nDL));
				if ((nextDigit - digit) == 1 || (nextDigit - digit) == 2) {
					successCount++;

					if (successCount == 3 || (i + j + nDL) >= seqLength) {
						return i;
					}
				} else {
					failureCount++;

					if (failureCount == 3 || (i + j + nDL) >= seqLength) {
						break;
					}
				}

			}

		}
		return 0;
	}
}
