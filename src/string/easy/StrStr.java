package string.easy;

public class StrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0)
			return 0;
		if (haystack == null || haystack.length() == 0
				|| needle.length() > haystack.length())
			return -1;

		int hPtr = 0;
		while (hPtr < haystack.length()) {
			int nPtr = 0;
			while (hPtr < haystack.length()
					&& haystack.charAt(hPtr) == needle.charAt(nPtr)) {
				if (nPtr == needle.length() - 1)
					return hPtr - nPtr;
				hPtr++;
				nPtr++;
			}
			hPtr -= nPtr;
			hPtr++;
		}
		return -1;
	}
}
