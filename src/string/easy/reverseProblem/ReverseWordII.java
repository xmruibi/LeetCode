package string.easy.reverseProblem;

public class ReverseWordII {
	/**
	 * Step one is reverse entire string;
	 * Step twp is reverse each word;
	 * Main idea is use two pointer to mark the head and tail indices of a word
	 * @param s
	 * @return
	 */
	public static String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return "";
		char[] chars = s.toCharArray();
		reverse(chars, 0, s.length() - 1);
		int pre = 0;
		int idx = 0;
		while (idx < s.length()) {
			while (idx < s.length() && chars[idx] == ' ')
				idx++;
			if(idx>=s.length())
				break;
			pre = idx;
			while(idx < s.length() && chars[idx]!=' ')
				idx++;
			reverse(chars, pre, idx-1);
			idx++;
		}
		
		return new String(chars).trim();
	}

	private static void reverse(char[] s, int start, int end) {
		int l = start;
		int r = end;
		while (l < r) {
			char tmp = s[l];
			s[l] = s[r];
			s[r] = tmp;
			l++;
			r--;
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println(reverseWords("  abc  bsc  sdf  er  "));
	}
}
