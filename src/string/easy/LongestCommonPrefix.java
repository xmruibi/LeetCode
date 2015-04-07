package string.easy;

public class LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null||strs.length==0)
			return "";
		if(strs.length==1)
		    return strs[0];
		String str = strs[0];
		int len = Integer.MAX_VALUE;
		for (int i = 1; i < strs.length; i++) {
			int idx = 0;
			while (idx < str.length() && idx < strs[i].length()
					&& str.charAt(idx) == strs[i].charAt(idx)) {
				idx++;
			}
			len=Math.min(len, idx);
		}
		return str.substring(0, len);
	}
	
	public static void main(String[] args) {
		String[] strs = {"abcd","abc","ab"};
		System.out.println(longestCommonPrefix(strs));
	}
}
