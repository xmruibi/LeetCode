package string.easy;

public class ValidPalindrome {
	/**
	 * Be careful number and letter case insensible  
	 * @param s
	 * @return
	 */
	public boolean isPalindrome(String s) {
		if (s == null)
			return false;
		if (s.length() == 0)
			return true;
		int l = 0;
		int r = s.length() - 1;
		while (l < r) {
			while (l < r && !isAlphabet(s.charAt(l)))
				l++;
			while (l < r && !isAlphabet(s.charAt(r)))
				r--;
			if (!equalAlphabet(s.charAt(l), s.charAt(r)))
				return false;
			l++;
			r--;
		}
		return true;
	}

	private boolean isAlphabet(char c) {
		if ((c>=48&&c<=57)||(c - 'A' <= 26 && c - 'A' >= 0) || (c - 'a' <= 26 && c - 'a' >= 0))
			return true;
		else
			return false;
	}

	private boolean equalAlphabet(char a, char b) {
		if ((a - 'A' == b - 'a') || (a - 'a' == b - 'A'))
			return true;
		else
			return a == b;
	}
}
