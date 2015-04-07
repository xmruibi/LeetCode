package string.medium;

public class MultiplyString {
	public static String multiply(String num1, String num2) {
			if (num1.length() == 0 || num2.length() == 0)
				return null;
			if(num1.equals("0")||num2.equals("0"))
				return "0";
			int offset = -1;
			int[] res = new int[num1.length() + num2.length()];
			for (int i = num2.length() - 1; i >= 0; i--) {
					for (int j = num1.length() - 1; j >= 0; j--) {
							res[i + j - offset] += Character.getNumericValue(num1
									.charAt(j))
									* Character.getNumericValue(num2.charAt(i));
					}
			}
			int carry = 0;
			StringBuilder sb = new StringBuilder();
			for (int i = res.length - 1; i >= 0; i--) {
				int rest = (res[i] + carry) / 10;
				res[i] = (res[i] + carry) % 10;
				carry = rest;
				if (i == 0 && res[i] == 0)
					break;
				sb.insert(0, res[i]);
			}
			return sb.toString();
	}

	private static boolean isNumeric(char c) {
		if (c - '0' >= 0 && c - '0' <= 9)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(multiply("1", "99"));
	}
}
