package array.easy;

public class PlusOne {
	/**
	 * Only need to consider each digit if it is less than 10 then end the loop or check next one;
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0)
			return digits;

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 < 10) {
				digits[i]++;
				break;
			} else {
				digits[i] = 0;
			}
		}
		int[] newDigits = digits;
		if (digits[0] == 0) {
			newDigits = new int[digits.length + 1];
			newDigits[0] = 1;
		}

		return newDigits;
	}
}
