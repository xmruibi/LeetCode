package string.medium;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {

		if(s==null||s.length()==0)
			return "";
		int len =s.length();
		int maxLen = 0;
		int maxIdx = 0;
		for(int idx =0; idx<len;idx++){
			if(isPalindrome(s, idx-maxLen, idx)){ // odd: abba
				maxLen++;
				maxIdx = idx;
			}else if(idx-maxLen-1>=0&&isPalindrome(s, idx-maxLen-1, idx)){ // even: aba
				maxLen+=2;
				maxIdx = idx;
			}
		}
		maxIdx++;
		return s.substring(maxIdx-maxLen, maxIdx);
	}

	public boolean isPalindrome(String s, int startIndex, int endIndex) {
		for (int i = startIndex, j = endIndex; i <= j; i++, j--)
			if (s.charAt(i) != s.charAt(j))
				return false;
		return true;
	}
}
