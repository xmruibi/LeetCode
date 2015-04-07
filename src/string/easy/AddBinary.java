package string.easy;

public class AddBinary {
	public static String addBinary(String a, String b) {

		int lenA = a.length() - 1;
		int lenB = b.length() - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (lenA >= 0 || lenB >= 0 || carry > 0) {
			int sum = 0;
			if (lenA >= 0) {
				sum += Character.getNumericValue(a.charAt(lenA));
				lenA--;
			}
			if (lenB >= 0) {
				sum += Character.getNumericValue(b.charAt(lenB));
				lenB--;
			}
			sum += carry;
			if (sum >= 2) {
				sum = sum - 2;
				carry = 1;
			} else
				carry = 0;
			sb.insert(0,sum);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("111", "110"));
	}
}
