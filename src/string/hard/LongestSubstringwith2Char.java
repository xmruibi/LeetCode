package string.hard;

import java.util.HashMap;

public class LongestSubstringwith2Char {
	// 最优的解法应该是维护一个sliding window，指针变量i指向sliding window的起始位置，j指向另个一个字符在sliding
	// window的最后一个，用于定位i的下一个跳转位置。内部逻辑就是
	// 1）如果当前字符跟前一个字符是一样的，直接继续。
	// 2）如果不一样，则需要判断当前字符跟j是不是一样的
	// a）一样的话sliding window左边不变，右边继续增加，但是j的位置需要调整到k-1。
	// b）不一样的话，sliding window的左侧变为j的下一个字符（也就是去掉包含j指向的字符的区间），j的位置也需要调整到k-1。

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int pLeft = 0, ptRgh = -1, maxLen = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1))
				continue;
			if (ptRgh > 0 && s.charAt(ptRgh) != s.charAt(i)) {
				maxLen = Math.max(maxLen, i - pLeft);
				pLeft = ptRgh + 1;// update left ptr
			}
			ptRgh = i - 1;// update right ptr any time;
		}
		return Math.max(s.length() - pLeft, maxLen); 
		// CURRENT window is between current left and last index
		// compare the previous maxLen
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringTwoDistinct("ab"));
	}
}
